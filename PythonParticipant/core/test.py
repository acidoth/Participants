#!/usr/bin/python

import MySQLdb

# Open database connection
db = MySQLdb.connect("localhost","root","1234","test" )

# prepare a cursor object using cursor() method
cursor = db.cursor()

# Drop table if it already exist using execute() method.
cursor.execute("DROP TABLE IF EXISTS EMPLOYEE")

# Create table as per requirement
sql = """CREATE TABLE Passenger (
         FIRST_NAME  CHAR(20) NOT NULL,
         FROM_DESTINATION  CHAR(20),
         TO_DESTINATION CHAR(20),  
         DATE CHAR(20))"""

cursor.execute(sql)

# disconnect from coordinationserver
db.close()
