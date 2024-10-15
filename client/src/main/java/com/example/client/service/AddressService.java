package com.example.client.service;

import com.example.client.grpcclient.AddressRequest;
import com.example.client.grpcclient.AddressResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class AddressService {

    private AddressClientService addressClientService;

    public AddressService(AddressClientService addressClientService) {
        this.addressClientService = addressClientService;
    }

    public void getAddressClientService(AddressRequest request) {
        addressClientService.getAddress(request.getCep());
    }
}
