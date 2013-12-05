#!/usr/bin/python
import MySQLdb


class Transaction:
    def __init__(self, transactionid, customername, fromdestination, todestination, date):
        self.transactionId = transactionid
        self.fromdestination = fromdestination
        self.todestination = todestination
        self.date = date
        self.customername = customername
        self.connection = None

    def setConnection(self, host, username, password, dbname):
        self.connection = MySQLdb.connect(host, username, password, dbname)

    def getConnection(self):
        return self.connection

    def getTransactionId(self):
        return self.transactionId

    def getFromDesti(self):
        return self.fromdestination

    def getToDesti(self):
        return self.todestination

    def getDate(self):
        return self.date

    def getCustomerName(self):
        return self.customername
