'''
Author: Reese Wells
Copyright 2017

Contains the methods for dealing with flightaware api data
'''
import requests

username = "ducoterra"
apiKey = "5602c42a00d7b60e21ee8af46c59ec72daec436c"
fxmlUrl = "https://flightxml.flightaware.com/json/FlightXML3/"

payload = {'airport_code':'KSFO', 'type':'enroute',
    'howMany':'10'}
response = requests.get(fxmlUrl + "AirportBoards",
    params=payload, auth=(username, apiKey))

if response.status_code == 200:
    print(response.json())
else:
    print("Error executing request")
