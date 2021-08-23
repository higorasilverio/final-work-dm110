package br.inatel.dm110.client.partner;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PartnerTopicClient {
	private static final Logger log = Logger.getLogger(PartnerTopicClient.class.getName());

	private static final String INITIAL_CONTEXT_FACTORY = "org.wildfly.naming.client.WildFlyInitialContextFactory";
	private static final String PROVIDER_URL = "http-remoting://127.0.0.1:8080";
	private static final String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DESTINATION = "jms/topic/dm110topic";
	private static final String USERNAME = "jmsuser";
	private static final String PASSWORD = "senhajms";

	public static void main(String[] args) {
		sendMessage("Olá de Topic Client.");
	}

	public static void sendMessage(String message) {

		Context initialContext = null;

		try {
			initialContext = getContext();

			ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup(CONNECTION_FACTORY);
			System.out.println("ConnectionFactory ok");

			Destination destination = (Destination) initialContext.lookup(DESTINATION);
			log.info("Destination ok");

			try (JMSContext context = connectionFactory.createContext(USERNAME, PASSWORD)) {
				log.info("Context ok");
				
				JMSProducer producer = context.createProducer();
				log.info("Producer ok");

				log.info("Sending message: " + message);
				producer.send(destination, message);
				System.out.println("Message sent successfully");
			}
		} catch (NamingException e) {
			log.log(Level.SEVERE, "Error sending message to topic", e);
		} finally {
			if (initialContext != null) {
				try {
					initialContext.close();
				} catch (NamingException e) {
					log.severe(e.getMessage());
				}
			}
		}
	}

	private static Context getContext() throws NamingException {
		Context initialContext = null;

		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, PROVIDER_URL);
		env.put(Context.SECURITY_PRINCIPAL, USERNAME);
		env.put(Context.SECURITY_CREDENTIALS, PASSWORD);
		
		initialContext = new InitialContext(env);
		return initialContext;
	}
}
