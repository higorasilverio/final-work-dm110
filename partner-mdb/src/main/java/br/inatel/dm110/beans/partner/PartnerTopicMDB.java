package br.inatel.dm110.beans.partner;

import java.util.logging.Logger;

import javax.jms.Message;
import javax.jms.MessageListener;

//TODO: implement it

public class PartnerTopicMDB implements MessageListener {
	
	private static Logger log = Logger.getLogger(PartnerTopicMDB.class.getName());

	@Override
	public void onMessage(Message message) {
		//processamento da mensagem
		//TODO: implement it
	}
}
