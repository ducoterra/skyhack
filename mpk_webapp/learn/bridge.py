'''
Author: Reese Wells
Copyright 2017

Is the bridge between views and the sql database
'''
import pymysql

# Connect to the database
connection = pymysql.connect(host='18.216.33.2',
                             user='skyhack',
                             password='eacss',
                             db='mpkdb',
                             charset='utf8mb4',
                             cursorclass=pymysql.cursors.DictCursor)

try:
    with connection.cursor() as cursor:
        # Read a single record
        sql = "SELECT `AirportCode` FROM `Airport` WHERE `City`=%s"
        cursor.execute(sql, ('Charlotte',))
        result = cursor.fetchall()
        print(result)
finally:
    connection.close()
