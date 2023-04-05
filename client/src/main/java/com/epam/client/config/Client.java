package com.epam.client.config;

import com.epam.secondservicetask.PingPongServiceGrpc;
import com.epam.secondservicetask.PingPongServiceOuterClass;
import io.grpc.Channel;

import static com.epam.secondservicetask.PingPongServiceGrpc.PingPongServiceBlockingStub;
import static com.epam.secondservicetask.PingPongServiceOuterClass.PingRequest;
import static com.epam.secondservicetask.PingPongServiceOuterClass.PongResponse;

public class Client {
    private final PingPongServiceBlockingStub stub;

    public Client(Channel channel) {
        this.stub = PingPongServiceGrpc.newBlockingStub(channel);
    }

    public void writeMessage() {
        PingRequest request = PingRequest.newBuilder().setMessage("Ping").setId(2L).setTimeMillis(System.currentTimeMillis()).build();
        PongResponse pongResponse = stub.respondWithPong(request);
        System.out.println(pongResponse.getMessage());
    }
}
