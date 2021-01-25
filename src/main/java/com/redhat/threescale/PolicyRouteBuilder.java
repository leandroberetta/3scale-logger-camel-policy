package com.redhat.threescale;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PolicyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty4-http:proxy://0.0.0.0:8080")
                .log("${body}")
                .toD("netty4-http:"
                        + "${headers." + Exchange.HTTP_SCHEME + "}://"
                        + "${headers." + Exchange.HTTP_HOST + "}:"
                        + "${headers." + Exchange.HTTP_PORT + "}"
                        + "${headers." + Exchange.HTTP_PATH + "}");
    }
}
