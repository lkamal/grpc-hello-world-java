# Simple Information

## 1. Create this grpc-hello-world-java project

    Simple empty project

## 2. Create this grpc-hello-world maven project under above project (but do not make the about project as it's parent)

    This has a proto/helloworld.proto file with one service and two messages.

    Generate the stubs and generate the jar file.

    $mvn clean install

    This will create a jar file and push to nexus (grpc-hello-world-1.0-SNAPSHOT.jar).

## 3. Create a module (grpc-hello-world-server) inside initial project (but do not make the about project as it's parent)

    This project pom must have a dependency for above project.

    Then create the HelloWorldImpl and Server (with a port say 6060) classes.

    Now, run the Server class which has a main, it will be listening on 6060.

## 4. Create another module (grpc-hello-world-client) inside initial project (but do not make the about project as it's parent)

   This project pom must have a dependency for above project.

   Then create the HelloWorldClient which invokes the server on localhost:6060

   Now, run the Client class which has a main, it will send the messages to server.