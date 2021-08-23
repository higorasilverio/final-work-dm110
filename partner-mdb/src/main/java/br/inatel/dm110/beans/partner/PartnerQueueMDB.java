package br.inatel.dm110.beans.partner;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", 
								  propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", 
								  propertyValue = "java:/jms/queue/dm110queue") })

public class PartnerQueueMDB implements MessageListener {

	private static Logger log = Logger.getLogger(PartnerQueueMDB.class.getName());

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMessage = (TextMessage) message;
				String text = txtMessage.getText();
				log.info("Message received from queue: " + text);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
