package com.example.server.service;

import com.example.server.grpcserver.AddressRequest;
import com.example.server.grpcserver.AddressResponse;
import com.example.server.grpcserver.CepServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.HashMap;
import java.util.Map;

@GrpcService
public class CepServiceImp extends CepServiceGrpc.CepServiceImplBase {

    @Override
    public void getAddress(AddressRequest request, StreamObserver<AddressResponse> responseObserver) {
        String cep = request.getCep();
        Map<String, String> addressMap = new HashMap<>();
        addressMap.put("13960000", "Socorro");
        addressMap.put("01422001", "São Paulo");
        String cidade = addressMap.get(cep);
        AddressResponse response = AddressResponse.newBuilder()
                .setCep(cep)
                .setCidade(cidade)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}