package com.redhat.threescale;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PolicyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty4-http:proxy://0.0.0.0:8080")
                .log("${headers.CamelHttpScheme}://${headers.CamelHttpHost}:${headers.CamelHttpPort}${headers.CamelHttpPath}")
                .toD("netty4-http:${headers.CamelHttpScheme}://${headers.CamelHttpHost}:${headers.CamelHttpPort}${headers.CamelHttpPath}");
    }
}
