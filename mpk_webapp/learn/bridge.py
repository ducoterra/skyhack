'''
Author: Reese Wells
Copyright 2017

Is the bridge between views and the sql database
'''
import pymysql

def cityToAirport(city):
    connection = pymysql.connect(host='18.216.33.2',
                                     user='skyhack',
                                     password='eacss',
                                     db='mpkdb',
                                     charset='utf8mb4',
                                     cursorclass=pymysql.cursors.DictCursor)
    with connection.cursor() as cursor:
        # Read a single record
        sql = "SELECT `AirportCode` FROM `Airport` WHERE `City`=%s"
        params = (city,)
        cursor.execute(sql, params)
        result = cursor.fetchone()
        connection.close()
        return result['AirportCode']

def airportToCity(airport):
    '''not being implemented'''

def getFlightTime(startId, endId):
    connection = pymysql.connect(host='18.216.33.2',
                                     user='skyhack',
                                     password='eacss',
                                     db='mpkdb',
                                     charset='utf8mb4',
                                     cursorclass=pymysql.cursors.DictCursor)
    with connection.cursor() as cursor:
        # Read a single record
        sql = "SELECT Time FROM Flight WHERE `StartCode` LIKE %s\
                                            AND `EndCode` LIKE %s\
                                            OR `StartCode` LIKE %s\
                                            AND `EndCode` LIKE %s;"
        params = (startId, endId, endId, startId)
        cursor.execute(sql, params)
        result = cursor.fetchone()
        connection.close()
        return result['Time']

def test():
    assert(cityToAirport('houston') == "HOU")
    assert(cityToAirport('atlanta') == "ATL")
    assert(getFlightTime('BOS','SEA') == getFlightTime('SEA','BOS'))
