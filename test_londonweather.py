from londonweather import LondonWeather
import pytest

lw = LondonWeather()
API_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22"
wData = lw.get_API_response(API_URL)

# check responce code of API
def test_check_status_code():
    assert lw.check_status_code(wData) == 200

# Is the response contains 4 days of data
def test_contains_4Days_Records():
    assert lw.contains_4days_records(wData) == 24*4

# 2. Is all the forecast in the hourly interval ( no hour should be missed )
def test_find_time_diff():
    total_res, unique_val, time_diff = lw.find_time_diff(wData)
    assert total_res == 24*4-1 and unique_val == 1 and time_diff == 3600

# 3. For all 4 days, the temp should not be less than temp_min and not more than temp_max
def test_verify_temp_with_ref():
    assert lw.verify_temp_with_ref(wData) == 24*4

# 4. If the weather id is 500, the description should be light rain
def test_verify_description_id500():
    bdict={500:'light rain'}
    assert lw.verify_description(wData, bdict) == True

# 5. If the weather id is 800, the description should be a clear sky
def test_verify_description_id800():
    bdict={800:'clear sky'}
    assert lw.verify_description(wData, bdict) == True
