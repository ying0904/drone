/**
 * 
 */
package com.gome.cloud.compile.amqp;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;


/**
 * @author blaiu
 *
 */
public class MyMqGatway {

	@Resource
    private AmqpTemplate amqpTemplate;
     
    public void sendDataToCrQueue(Object obj) {
        amqpTemplate.convertAndSend("queue_one_key", obj);
    }   
	
}
