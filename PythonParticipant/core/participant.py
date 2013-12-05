#!/usr/bin/python

from core.transactionmanager import *
from core.dbhandler import *
from core.transaction import *
from core.participant import *


class Participant(object):
    INSTANCE = None

    def __init__(self):
        if self.INSTANCE is not None:
            raise ValueError("An instantiation already exists!")

    # do your init stuff

    @classmethod
    def get_instance(cls):
        if cls.INSTANCE is None:
            cls.INSTANCE = Participant()
        return cls.INSTANCE


    def __init__(self):
        self.transactionmanager = TransactionManager()

    def commit(self, transactionid, isOnePhase):
        if isOnePhase:
            self.prepare(transactionid)
        res = self.transactionmanager.commit()
        return res

    def putTravel(self, transactionid, customername, fromdestination, todestination, date):	
        self.transaction = Transaction(transactionid, customername, fromdestination, todestination, date)
        self.transaction.setConnection("localhost", "root", "1234", "test")
        #print "put called tested babe:"+self.transaction.getTransactionId()
        self.resp = self.transactionmanager.putTransaction(self.transaction)
        print ("put Service finished...")
        return self.resp


    def prepare(self, transactionid):
        print ("prepare called..")
        res = self.transactionmanager.popTransaction(transactionid)
        #print "prepare results are out: "+str(res)
        if (res == 'true'):
            response = self.transactionmanager.prepare()
            return response
        else:
            return res

    def rollback(self):
        res = self.transactionmanager.rollback()
        return res

	
