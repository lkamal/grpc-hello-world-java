package io.grpc.kamal.examples.helloworld.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelloWorldServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        final Server server = ServerBuilder.forPort(6060)
                .addService(new HelloWorldImpl())
                .build();

        server.start();
        System.out.println("Hello World Server started...");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    System.err.println("*** Shutting down gRPC server since JVM is shutting down");
                    server.awaitTermination(30, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        });

        server.awaitTermination();
    }
}
