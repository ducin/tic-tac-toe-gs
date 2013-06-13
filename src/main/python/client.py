#!/usr/bin/env python

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

from SymfonyWorld.TicTacToeGS import GameService
from SymfonyWorld.TicTacToeGS.ttypes import *
from SymfonyWorld.TicTacToeGS.constants import *

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

  games = client.listGames()
  print "listGames()"
  print games

  transport.close()

except Thrift.TException, tx:
  print "%s" % (tx.message)
