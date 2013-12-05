#!/usr/bin/python
from dbhandler import *
from transaction import *
from participant import *
import MySQLdb

parti=Participant()
ress=parti.put(1,"tesss","lala","la","lalal")
parti.prepare(1)
res=parti.commit()
print res
