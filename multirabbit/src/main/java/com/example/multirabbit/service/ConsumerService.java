package com.example.multirabbit.service;

public interface ConsumerService {
    void dmmReceiveSignMessage(String message);

    void pgaReceiveSignMessage(String message);
}
