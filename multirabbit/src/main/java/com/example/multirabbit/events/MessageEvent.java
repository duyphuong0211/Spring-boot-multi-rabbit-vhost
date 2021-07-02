package com.example.multirabbit.events;

public interface MessageEvent {

    String getClientId();
    String getExchange();
    String getRoutingKey();
    String getMessage();
}
