#!/usr/bin/env python
import os
import code
import ConfigParser

filepath = os.path.realpath(__file__ + '/../../resources/config.ini')
config = ConfigParser.ConfigParser()
config.read(filepath)

def start_shell():
    from thrift import Thrift
    from thrift.transport import TSocket
    from thrift.transport import TTransport
    from thrift.protocol import TBinaryProtocol

    from SymfonyWorld.TicTacToeGS import GameService
    from SymfonyWorld.TicTacToeGS.ttypes import *
    from SymfonyWorld.TicTacToeGS.constants import *

    # Make socket
    transport = TSocket.TSocket('localhost', config.get('server', 'port'))

    # Buffering is critical. Raw sockets are very slow
    transport = TTransport.TBufferedTransport(transport)

    # Wrap in a protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)

    # Create a client to use the protocol encoder
    client = GameService.Client(protocol)

    transport.open()
    code.interact(local=locals())
    transport.close()

start_shell()
