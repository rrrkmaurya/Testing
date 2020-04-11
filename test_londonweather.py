from londonweather import LondonWeather
import pytest

lw = LondonWeather()
API_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22"
wData = lw.get_API_response(API_URL)

def test_check_status_code():
    assert lw.check_status_code(wData) == 200

def test_contains_4Days_Records():
    assert lw.contains_4days_records(wData) == 24*4

def test_find_time_diff():
    total_res, unique_val, time_diff = lw.find_time_diff(wData)
    assert total_res == 24*4-1 and unique_val == 1 and time_diff == 3600

def test_verify_temp_with_ref():
    assert lw.verify_temp_with_ref(wData) == 24*4

def test_verify_description_id500():
    bdict={500:'light rain'}
    assert lw.verify_description(wData, bdict) == True

def test_verify_description_id800():
    bdict={800:'clear sky'}
    assert lw.verify_description(wData, bdict) == True
