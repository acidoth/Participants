#
# Autogenerated by Thrift Compiler (0.9.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#
#  options string: py
#

from thriftlib.Thrift import TType, TMessageType, TException, TApplicationException

from thriftlib.transport import TTransport
from thriftlib.protocol import TBinaryProtocol, TProtocol
try:
  from thriftgen.protocol import fastbinary
except:
  fastbinary = None


class ServiceResponse:
  prepared = 0
  aborted = 1
  readOnly = 2
  commited = 3

  _VALUES_TO_NAMES = {
    0: "prepared",
    1: "aborted",
    2: "readOnly",
    3: "commited",
  }

  _NAMES_TO_VALUES = {
    "prepared": 0,
    "aborted": 1,
    "readOnly": 2,
    "commited": 3,
  }

