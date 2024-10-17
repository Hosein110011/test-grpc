package com.example.demo.config;

import com.example.demo.service.AddressClientService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@GrpcClientBean(
//        clazz = AddressClientService.class,
//        beanName = "blockingStub",
//        client = @GrpcClient("grpc-server")
//)
public class GrpcConfig {

//    @Bean
//    AddressClientService fooServiceBean(@Autowired CepServiceGrpc.CepServiceBlockingStub blockingStub) {
//        return new AddressClientService(blockingStub);
//    }

}
