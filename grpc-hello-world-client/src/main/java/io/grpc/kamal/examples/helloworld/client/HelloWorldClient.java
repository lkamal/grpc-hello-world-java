package io.grpc.kamal.examples.helloworld.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.kamal.examples.helloworld.HelloReply;
import io.grpc.kamal.examples.helloworld.HelloRequest;
import io.grpc.kamal.examples.helloworld.HelloWorldServiceGrpc;

public class HelloWorldClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost",6060)
                .usePlaintext().build();

        HelloRequest helloRequest = HelloRequest
                .newBuilder().setName("Kamal").build();

        final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub
                = HelloWorldServiceGrpc.newBlockingStub(channel);

        final HelloReply helloReply = blockingStub.sayHello(helloRequest);

        System.out.println("Response from server received");
        System.out.println(helloReply.getMessage());
        System.out.println("------------------------------");

        final HelloReply helloAgainReply = blockingStub.sayHelloAgain(helloRequest);

        System.out.println("Response (#2) from server received");
        System.out.println(helloAgainReply.getMessage());
        System.out.println("------------------------------");
    }
}
