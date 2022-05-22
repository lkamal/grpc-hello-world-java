package io.grpc.kamal.examples.helloworld.server;

import io.grpc.kamal.examples.helloworld.HelloReply;
import io.grpc.kamal.examples.helloworld.HelloRequest;
import io.grpc.kamal.examples.helloworld.HelloWorldServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloWorldImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("Say Hello - Request name : " + request.getName());

        final HelloReply helloReply = HelloReply.newBuilder()
                .setMessage("Hi " + request.getName() + "! Hello there")
                .build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("Say Hello Again - Request name : " + request.getName());

        final HelloReply helloReply = HelloReply.newBuilder()
                .setMessage("Hi " + request.getName() + "! Hello there (again)...")
                .build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }
}
