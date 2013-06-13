package com.blogspot.symfonyworld.tictactoegs.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import java.io.File;
import org.ini4j.Ini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blogspot.symfonyworld.tictactoegs.thrift.generated.GameService;

public class Server {

    private Logger logger;

    private Server() {
        logger = LoggerFactory.getLogger("Server");
    }

    private void start() {
        try {
            Ini ini = new Ini(new File("./src/main/resources/config.ini"));
            int port = Integer.parseInt(ini.get("server", "port")),
                max_threads = Integer.parseInt(ini.get("server", "port"));
            TProcessor processor = new GameService.Processor<>(new GameServiceHandler());
            TServerTransport serverTransport = new TServerSocket(port);
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport)
                .processor(processor)
                .maxWorkerThreads(max_threads);
            TServer server = new TThreadPoolServer(args);
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
