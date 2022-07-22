package com.fiap.drone.integration.commons.rabbitmq.impl;

import com.fiap.drone.integration.commons.rabbitmq.RabbitMQ;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component //Assim que a aplicação for iniciada o programa entrará nesta classe
public class RabbitMQImpl implements RabbitMQ {
    private static final String NOME_EXCHANGE = "amq.direct";
    private static final String FILA_DRONE = "DRONE";
    private AmqpAdmin amqpAdmin;

    public RabbitMQImpl(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    @Override
    public Queue fila(String nomeFila) {
        return new Queue(nomeFila, true,false,false);
    }

    @Override
    public DirectExchange trocaDireta() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    @Override
    public Binding relacionamento(Queue fila, DirectExchange trocaDireta) {
        return new Binding(fila.getName(),Binding.DestinationType.QUEUE, trocaDireta.getName(),fila.getName(),null);
    }

    @PostConstruct //Assim que a aplicação for iniciada o programa entrará neste método
    @Bean
    public void adicione(){
        Queue filaDrone = this.fila(FILA_DRONE);
        DirectExchange troca = this.trocaDireta();

        Binding ligacao = this.relacionamento(filaDrone,troca);

        this.amqpAdmin.declareQueue(filaDrone);
        this.amqpAdmin.declareExchange(troca);
        this.amqpAdmin.declareBinding(ligacao);
    }
}
