package com.example.client.service;

import com.example.client.grpcclient.AddressRequest;
import com.example.client.grpcclient.AddressResponse;
import com.example.client.grpcclient.CepServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

@Service
public class AddressClientService {

    @GrpcClient("grpc-server")
    private CepServiceGrpc.CepServiceBlockingStub stub;

    public AddressResponse getAddress(String cep) {
        AddressResponse addressResponse = stub.getAddress(AddressRequest.newBuilder()
                .setCep(cep)
                .build());
        return addressResponse;
    }
}