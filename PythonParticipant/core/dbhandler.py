#!/usr/bin/python

import MySQLdb


class DBHandler:
    def __init__(self, connection):
        self.connection = connection

    def commit(self):
        print ('commit called from dbhandler')
        try:
            # Commit your changes in the database
            self.connection.commit()
        except:
            return 'false'
        else:
            return 'ture'

    def rollback(self):
        print ('rollback called from dbhandler')
        try:
            self.connection.rollback()
        except:
            return 'false'
        else:
            return 'true'

    def setConnection(self, connection):
        self.connection = connection

    def createTable(self):
        self.sql = "CREATE TABLE Passenger (FIRST_NAME  CHAR(20) NOT NULL,FROM_DESTINATION CHAR(30),TO_DESTINATION 			CHAR (30),DATE CHAR(20))"
        self.cursor = self.connection.cursor()
        self.cursor.execute(self.sql)

    def insertValues(self, name, fromdestination, todestination, date):
        print ("data in dbhandler " + "..." + name + "...." + fromdestination + "...." + todestination + "....." + date)
        #self.sql="INSERT INTO Passenger(FIRST_NAME, FROM_DESTINATION, TO_DESTINATION, DATE) VALUES ('Tac', '20', 'M', '1000')"

        self.sql = "INSERT INTO Passenger(FIRST_NAME, FROM_DESTINATION, TO_DESTINATION, DATE) VALUES ('" + date + "','" + todestination + "','" + name + "','" + fromdestination + "')"
        self.cursor = self.connection.cursor()
        try:
            print ("prepare called from dbhandler")
            self.cursor.execute(self.sql)
            print ("prepare finished from dbhandler")

        except:
            return 'false'
        else:
            return 'true'
