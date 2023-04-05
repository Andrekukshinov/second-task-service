package com.epam.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8080).addService(new PingPongServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}
