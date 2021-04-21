package com.imooc.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

@Configuration
public class myconfig {
    String ipAdd="192.168.47.129";
    @Bean
    public TransportClient client() throws UnknownHostException {
        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName(ipAdd),9300
        );
        Settings settins = Settings.builder()
                .put("cluster.name", "wali")
                .build();
        TransportClient client = new PreBuiltTransportClient(settins);
        client.addTransportAddress(node);
        return client;
    }
}
