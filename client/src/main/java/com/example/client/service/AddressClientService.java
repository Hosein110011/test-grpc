package com.example.client.service;

import com.example.client.grpcclient.AddressRequest;
import com.example.client.grpcclient.AddressResponse;
import com.example.client.grpcclient.CepServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class AddressClientService {
    public String getAddress(String cep) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        CepServiceGrpc.CepServiceBlockingStub stub = CepServiceGrpc.newBlockingStub(channel);
        AddressResponse addressResponse = stub.getAddress(AddressRequest.newBuilder()
                .setCep(cep)
                .build());
        channel.shutdown();
        return addressResponse.getCidade();
    }
}