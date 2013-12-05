from registrationclient.RegistrationClient import *
from thriftgen.registration.ttypes import EndPointReference
from registrationclient.RegistrationAsyncClient import *


class RegisterParticipant:
    def register(self, coordinationContext, participantServerUrl, participantPort):
        participantEPR = EndPointReference()

        participantEPR.address = participantServerUrl
        participantEPR.privateInstance = participantPort

        registrationClient = RegistrationAsyncClient(
            coordinationContext.registrationEPR.address, coordinationContext.registrationEPR.privateInstance)

        return registrationClient.register(coordinationContext, "AtomicTransaction", participantEPR)
