package com.example.client.config;

import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import net.devh.boot.grpc.client.channelfactory.GrpcChannelConfigurer;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.devh.boot.grpc.client.inject.*;

import java.util.concurrent.TimeUnit;

//@Configuration
//@GrpcClientBean(
//        clazz = TestServiceBlockingStub.class,
//        beanName = "blockingStub",
//        client = @GrpcClient("test")
//)
//@GrpcClientBean(
//        clazz = FactoryMethodAccessibleStub.class,
//        beanName = "accessibleStub",
//        client = @GrpcClient("test"))
//public class ClientConfig {
//
//    @Bean
//    public GrpcChannelConfigurer keepAliveClientConfigurer() {
//        return (channelBuilder, name) -> {
//            if (channelBuilder instanceof NettyChannelBuilder) {
//                ((NettyChannelBuilder) channelBuilder)
//                        .keepAliveTime(30, TimeUnit.SECONDS)
//                        .keepAliveTimeout(5, TimeUnit.SECONDS);
//            }
//        };
//    }
//
//}

