package com.example.server.service;

import com.example.common.grpc.AddressRequest;
import com.example.common.grpc.AddressResponse;
import com.example.common.grpc.CepServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import java.util.HashMap;
import java.util.Map;

@GrpcService
//@ConditionalOnBean(annotation = GrpcService.class)
public class CepServiceImp extends CepServiceGrpc.CepServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger("logger");

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
        logger.info(String.format("client sent this cep: %1s", cep));
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}