import coordinationserver.CoordinationServer
from putserver.PutService import PutServer

__author__ = 'pirinthapan'

from core.participant import *

particip = Participant.get_instance()

coordinationServer = coordinationserver.CoordinationServer.CoordinationServer(particip)
putServer = PutServer(particip)

putServer.start()
coordinationServer.start()

