package com.fiap.drone.integration.commons.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;

public interface RabbitMQ {
    Queue fila(String nomeFila);
    DirectExchange trocaDireta();
    Binding relacionamento(Queue fila, DirectExchange trocaDireta);

}
