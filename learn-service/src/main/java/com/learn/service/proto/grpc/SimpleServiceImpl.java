package com.learn.service.proto.grpc;

import com.learn.service.proto.generate.simple.SimpleRequest;
import com.learn.service.proto.generate.simple.SimpleResponse;
import com.learn.service.proto.generate.simple.SimpleServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SimpleServiceImpl extends SimpleServiceGrpc.SimpleServiceImplBase {

    @Override
    public void unaryRpc(SimpleRequest request, StreamObserver<SimpleResponse> responseObserver) {
        super.unaryRpc(request, responseObserver);
    }

    @Override
    public StreamObserver<SimpleRequest> clientStreamingRpc(StreamObserver<SimpleResponse> responseObserver) {
        return super.clientStreamingRpc(responseObserver);
    }

    @Override
    public void serverStreamingRpc(SimpleRequest request, StreamObserver<SimpleResponse> responseObserver) {
        super.serverStreamingRpc(request, responseObserver);
    }

    @Override
    public StreamObserver<SimpleRequest> bidiStreamingRpc(StreamObserver<SimpleResponse> responseObserver) {
        return super.bidiStreamingRpc(responseObserver);
    }

}
