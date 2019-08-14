package com.learn.service.proto.grpc;

import com.learn.service.proto.generate.helloword.HelloReply;
import com.learn.service.proto.generate.helloword.HelloRequest;
import com.learn.service.proto.generate.helloword.HelloWorldGrpc;
import io.grpc.stub.StreamObserver;

public class HelloWorldImpl extends HelloWorldGrpc.HelloWorldImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
