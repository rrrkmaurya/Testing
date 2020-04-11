import json
import pandas as pd
import requests
from pandas import json_normalize

'''
A Class which perform some verification on a API which return the details about
the London weather
'''
class LondonWeather:

    # Method to get the response of the called API
    def get_API_response(self, URL):
        #     URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22"
        df = requests.get(url=URL).json()
        return json_normalize(df).iloc[0]

    # Method to get the response code of the called API
    def check_status_code(self, data):
        return int(data['cod'])

    # method to get No of days for which data is available
    def contains_4days_records(self, data):
        return int(data['cnt'])

    # method to find the diff b/w set of times
    def find_time_diff(self, data):
        tempdata = pd.DataFrame.from_dict(data['list'])
        timedata = list(tempdata['dt'])
        res = [timedata[i + 1] - timedata[i] for i in range(len(timedata) - 1)]
        return len(res), len(set(res)), set(res).pop()

    # method to verify value of temp is in the range of temp_min and temp_max
    def verify_temp_with_ref(self, data):
        tempdata = list(pd.DataFrame.from_dict(data['list'])['main'])
        count = 0
        for tdata in tempdata:
            tdict = dict(tdata)
            if tdict['temp'] <= tdict['temp_max'] and tdict['temp'] >= tdict['temp_min']:
                count += 1
        return count

    # method to verify the destination based on the ID .
    def verify_description(self, data, bdict):
        #     bdict={500:'light rain', 800:'clear sky'}
        tempdata = pd.DataFrame.from_dict(data['list'])['weather']
        status = True
        for row in tempdata:
            tempdict = dict(row[0])
            if tempdict['id'] in bdict.keys() and tempdict['description'] != bdict[tempdict['id']]:
                status = False
        return status
