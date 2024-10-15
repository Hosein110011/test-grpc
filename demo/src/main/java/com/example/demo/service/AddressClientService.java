package com.example.demo.service;


import com.example.demo.grpcclient.AddressRequest;
import com.example.demo.grpcclient.AddressResponse;
import com.example.demo.grpcclient.CepServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AddressClientService {

//    @GrpcClient("grpc-server")
    private CepServiceGrpc.CepServiceBlockingStub stub;

    public AddressClientService(CepServiceGrpc.CepServiceBlockingStub stub) {
        this.stub = stub;
    }

    public String getAddress(String cep) {
        System.out.println("before");
        AddressResponse addressResponse = this.stub.getAddress(AddressRequest.newBuilder()
                .setCep(cep)
                .build());
        System.out.println("after");
        return addressResponse.getCidade();
    }
}
