from BaseHTTPServer import HTTPServer
import threading

from soaplib.pysimplesoap.server import SoapDispatcher, SOAPHandler
from core import participant
from registrationclient.RegisterParticipant import *
from util.Constants import *
from thriftgen.registration.ttypes import *


class PutServer(threading.Thread):
    def __init__(self, participant):
        threading.Thread.__init__(self)
        self.participant = participant

    def put(self, name, destinationFrom, destinationTo, date, hotelName, stayHotel, identifier, coordinationType,
            expires, coordinatorUrl, coordinatorPort):
        print ("Put service called")
        print("data ......... " + name + destinationFrom + destinationTo + date)

        particip = self.participant
        particip.putTravel(identifier, name, destinationFrom, destinationTo, date)

        endPointReference = EndPointReference()
        endPointReference.address = coordinatorUrl
        endPointReference.privateInstance = coordinatorPort

        coordinationContext = CoordinationContext()
        coordinationContext.identifier = identifier
        coordinationContext.coordination_type = coordinationType
        coordinationContext.registrationEPR = endPointReference
        coordinationContext.expires = expires

        registerParticipant = RegisterParticipant()
        registrationResult = registerParticipant.register(coordinationContext, Constants.coordinationServerAddress,
                                                          Constants.coordinationServerPort)
        print (registrationResult)
        return registrationResult

    def server(self):
        dispatcher = SoapDispatcher('PutDispatcher',
                                    location="http://10.42.0.1:8008",
                                    action='http://10.42.0.1:8008', # SOAPAction
                                    namespace="http://10.42.0.1:8008/put.wsdl", prefix="ns0",
                                    trace=True,
                                    ns=True)

        # register the user function
        dispatcher.register_function('Put', self.put, returns={'PutResult': bool},
                                     args={'name': str, 'destinationFrom': str, 'destinationTo': str, 'date': str,
                                           'hotelName': str, 'stayHotel': int, 'identifier': str,
                                           'coordinationType': str, 'expires': int, 'coordinatorUrl': str,
                                           'coordinatorPort': int})

        print ("PutServer Successfully Published")
        httpd = HTTPServer(("", 8008), SOAPHandler)
        httpd.dispatcher = dispatcher
        httpd.serve_forever()

    def run(self):
        self.server()


 

