package com.blogspot.symfonyworld.tictactoegs.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blogspot.symfonyworld.tictactoegs.thrift.generated.GameService;

public class Server {

    private Logger logger;

    private Server() {
        logger = LoggerFactory.getLogger("GameServiceHandler");
    }

    private void start() {
        try {
            TProcessor processor = new GameService.Processor<>(new GameServiceHandler());
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            logger.info("Starting multi thread server");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
