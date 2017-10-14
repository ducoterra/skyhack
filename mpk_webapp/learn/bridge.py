'''
Author: Reese Wells
Copyright 2017

Is the bridge between views and the sql database
'''
import pymysql

class Connection:
    connection = pymysql.connect(host='18.216.33.2',
                                 user='skyhack',
                                 password='eacss',
                                 db='mpkdb',
                                 charset='utf8mb4',
                                 cursorclass=pymysql.cursors.DictCursor)

def cityToAirport(city):
    connection = Connection.connection
    try:
        with connection.cursor() as cursor:
            # Read a single record
            sql = "SELECT `AirportCode` FROM `Airport` WHERE `City`=%s"
            cursor.execute(sql, (city,))
            result = cursor.fetchone()
            return result['AirportCode']
    except:
        return None

def airportToCity(airport):
    connection = Connection.connection
    try:
        with connection.cursor() as cursor:
            # Read a single record
            sql = "SELECT `City` FROM `Airport` WHERE `AirportCode`=%s"
            cursor.execute(sql, (airport,))
            result = cursor.fetchone()
            return result['City']
    except:
        return None

def close():
    connection = Connection.connection
    connection.close()
