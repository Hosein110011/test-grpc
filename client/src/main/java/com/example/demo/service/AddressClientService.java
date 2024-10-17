package com.example.demo.service;


import com.example.common.grpc.AddressRequest;
import com.example.common.grpc.AddressResponse;
import com.example.common.grpc.CepServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AddressClientService {

    @GrpcClient("grpc-server")
    private CepServiceGrpc.CepServiceStub stub;

//    public AddressClientService(CepServiceGrpc.CepServiceBlockingStub stub) {
//        this.stub = stub;
//    }

    @EventListener(ContextRefreshedEvent.class)
    public void getAddresss() {
        String cep = "13960000";
        System.out.println("before");

        final StreamObserver<AddressResponse> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(AddressResponse response) {
                System.out.printf("onNext: %s%n", response);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.printf("onError: %s%n", throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };

        AddressRequest request = AddressRequest.newBuilder().setCep(cep).build();
        stub.getAddress(request, responseObserver);
        System.out.println("after");
        //TODO write response
        //return addressResponse.getCidade();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exp) {
            exp.printStackTrace();
            throw new RuntimeException(exp);
        }
    }
}
