from core.participant import Participant
from thriftgen.coordination.ttypes import ServiceResponse

__author__ = 'Pirinthapan'


class CoordinationServiceHandler:
    def __init__(self, participant):
        self.log = {}
        self.participant = participant


    def commit(self, identifier, isOnePhase):
        print ('commit called')
        self.res = self.participant.commit(identifier, isOnePhase)

        if self.res == 'true':
            return ServiceResponse.committed
        else:
            return ServiceResponse.aborted


    def prepare(self, identifier):
        print ('prepare called')
        self.res = self.participant.prepare(identifier)
        if self.res == 'true':
            return ServiceResponse.prepared
        else:
            return ServiceResponse.readOnly


    def abort(self, identifier):
        print ('abort called')
        return ServiceResponse.aborted


    def rollback(self, identifier):
        print ('rollback called')
        self.res = self.participant.rollback()

        return ServiceResponse.aborted
