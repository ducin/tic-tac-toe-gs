#!/usr/bin/env python

import sys
sys.path.append('../gen-py')

from SymfonyWorld.TicTacToeGS import GameService
from SymfonyWorld.TicTacToeGS.ttypes import *
from SymfonyWorld.TicTacToeGS.constants import *

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

try:
  # Make socket
  transport = TSocket.TSocket('localhost', 9090)

  # Buffering is critical. Raw sockets are very slow
  transport = TTransport.TBufferedTransport(transport)

  # Wrap in a protocol
  protocol = TBinaryProtocol.TBinaryProtocol(transport)

  # Create a client to use the protocol encoder
  client = GameService.Client(protocol)

  # Connect!
  transport.open()

  client.listGames('test123')
  print "listGames()"

  msg = client.sayHello()
  print msg
  msg = client.sayMsg(HELLO_IN_KOREAN)
  print msg

  transport.close()

except Thrift.TException, tx:
  print "%s" % (tx.message)
