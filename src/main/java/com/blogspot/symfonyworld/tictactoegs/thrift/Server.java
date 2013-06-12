package com.blogspot.symfonyworld.tictactoegs.thrift;

import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;

import com.blogspot.symfonyworld.tictactoegs.thrift.generated.GameService;

public class Server {

    public static void StartsimpleServer(GameService.Processor<GameServiceHandler> processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(
                    new Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StartsimpleServer(new GameService.Processor<>(
                new GameServiceHandler()));
    }
}
