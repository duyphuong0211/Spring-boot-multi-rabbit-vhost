package com.example.multirabbit.service;

import com.example.multirabbit.events.MessageEvent;

public interface PublisherService {
    void publish(MessageEvent event);
}
