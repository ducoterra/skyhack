'''
Author: Reese Wells
Copyright 2017

Contains the methods for dealing with flightaware api data
'''
import requests, time

username = "ducoterra"
apiKey = "5602c42a00d7b60e21ee8af46c59ec72daec436c"
fxmlUrl = "https://flightxml.flightaware.com/json/FlightXML3/"

def getFlightInfo(startCity = None, endCity = None,
                    startId = None, endId = None):
    '''
    takes a startCity and endCity
    -or-
    startId and endId

    returns the flight time in minutes
    '''
    # calculate times
    now = int(time.time())
    nextWeek = now + 604800
    lastWeek = now - 604800

    # api payload
    payload = {'start_date' : lastWeek,
                'end_date' : nextWeek,
                'origin' : startId,
                'destination' : endId,
                'howMany' : 1}

    # get request for data
    response = requests.get(fxmlUrl + "AirlineFlightSchedules",
        params=payload, auth=(username, apiKey))

    if response.status_code == 200:
        # parse through json
        data = response.json()['AirlineFlightSchedulesResult']
        flightInfo = data['flights'][0]
        flightTime = flightInfo['arrivaltime'] - flightInfo['departuretime']
        return flightTime // 60 # to minutes
    else:
        # if None is returned, no flighs found
        return None
