package com.epam.server;

import com.epam.secondservicetask.PingPongServiceGrpc;
import com.epam.secondservicetask.PingPongServiceOuterClass;
import com.google.protobuf.MessageOrBuilder;
import io.grpc.stub.StreamObserver;

import static com.epam.secondservicetask.PingPongServiceOuterClass.PongResponse;
import static com.epam.secondservicetask.PingPongServiceOuterClass.PingRequest;
import static com.epam.secondservicetask.PingPongServiceOuterClass.Billy;

public class PingPongServiceImpl extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void respondWithPong(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println(message);
        System.out.println(request.getTimeMillis());
        PongResponse pongResponse = PongResponse.newBuilder()
                .setGachi(Billy.newBuilder().setSurname("Herringten").build())
                .setId(1L)
                .setMessage("Pong").build();
        responseObserver.onNext(pongResponse);
        responseObserver.onCompleted();
    }
}
