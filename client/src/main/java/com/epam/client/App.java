package com.epam.client;

import com.epam.client.config.Client;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();
        Client client = new Client(channel);
        for (int i = 0; i < 10; i++) {
            client.writeMessage();
            Thread.sleep(1000);
        }
    }
}
