package org.colak.server;

import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

public class ReactiveHttpNettyServer {

    // http://localhost:8080/greeting/john
    public static void main(String[] args) {
        HttpServer.create()
                .port(8080)
                .route(routes ->
                        routes.get("/greeting/{name}", (request, response) ->
                                response.sendString(Mono.just("Hello, " + request.param("name") + "!"))
                        )
                )
                .bindNow()
                .onDispose()
                .block();
    }
}
