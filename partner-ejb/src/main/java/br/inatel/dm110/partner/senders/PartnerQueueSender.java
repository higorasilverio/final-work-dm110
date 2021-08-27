package br.inatel.dm110.partner.senders;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import br.inatel.dm110.api.partner.AuditTO;

@Stateless
public class PartnerQueueSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:/jms/queue/dm110queue")
	private Queue queue;
	
	private static Logger log = Logger.getLogger(
			PartnerQueueSender.class.getName()
	);

	public void sendObjectMessage(AuditTO audit) {
		try {
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession();
			MessageProducer msgProducer = session.createProducer(queue);
			ObjectMessage objMsg = session.createObjectMessage(audit);
			msgProducer.send(objMsg);
			log.info("Sending message: " + objMsg.toString());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
