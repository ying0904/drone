/**
 * 
 */
package com.gome.cloud.compile.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author blaiu
 *
 */
public class QueueOneLitener implements MessageListener {
	
	@Override
    public void onMessage(Message message) {
        System.out.println("data :" + message.getBody());
    }
}
