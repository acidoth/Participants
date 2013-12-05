from thriftlib.protocol import TBinaryProtocol
from util.Constants import *;
from coordinationserver.CoordinationServiceHandler import CoordinationServiceHandler
from thriftgen.coordination import CoordinationService
from thriftlib.server import *
from thriftlib.transport import TSocket, TTransport
import threading

__author__ = 'Pirinthapan'

class CoordinationServer(threading.Thread):

    def __init__(self, participant):
        threading.Thread.__init__(self)
        self.participant = participant

    def run(self):

        coordinationServiceHandler = CoordinationServiceHandler(self.participant)

        processor = CoordinationService.Processor(coordinationServiceHandler)

        transport = TSocket.TServerSocket(port=Constants.coordinationServerPort)

        # transportfactory = TTransport.TBufferedTransportFactory()
        #
        # protocolfactory = TBinaryProtocol.TBinaryProtocolFactory()

        server = TNonblockingServer.TNonblockingServer(processor, transport)

        # server = TServer.TSimpleServer(processor, transport, transportfactory, protocolfactory)

        print ("Starting Coordination Server...")
        server.serve()
