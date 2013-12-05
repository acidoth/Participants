from thriftgen.registration.RegistrationService import *
from thriftlib.Thrift import TException
from thriftlib.transport import *
from thriftlib.protocol import TBinaryProtocol


class RegistrationClient:
    def __init__(self, serverUrl, port):
        self.registrationServerUrl = serverUrl
        self.registrationPort = port


    def register(self, coordinationContext, protocolIdentifier, participantEPR):
        try:
            transport = TSocket.TSocket(self.registrationServerUrl, self.registrationPort)
            protocol = TBinaryProtocol.TBinaryProtocol(transport)
            registrationClient = Client(protocol)
            print "register called."

            transport.open()
            print "open "
            result = registrationClient.registerParticipant(coordinationContext, protocolIdentifier, participantEPR);

            transport.close()
            print ("registration finished...")

        except TException as tx:
            print ("%s" % tx.message)

        return result
