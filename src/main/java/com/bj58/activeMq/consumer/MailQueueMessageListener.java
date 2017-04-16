package com.bj58.activeMq.consumer;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.bj58.api.domain.Mail;

@Component
public class MailQueueMessageListener implements SessionAwareMessageListener<Message>{
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination mailQueue;
	@Autowired
    private MailService mailService;
	
	@Override
	public void onMessage(Message message, Session session)  {
		System.out.println("...........................");
		try {
			TextMessage msg = (TextMessage) message;
			final String ms = msg.getText();
			System.out.println("收到消息：" + ms);
			Mail mail = JSONObject.parseObject(ms, Mail.class);
			if (mail == null) {
				return;
			}
			try {
				mailService.mailSend(mail);
			} catch (Exception e) {
                 e.printStackTrace();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
