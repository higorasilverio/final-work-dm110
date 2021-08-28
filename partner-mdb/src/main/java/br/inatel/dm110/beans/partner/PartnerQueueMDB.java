package br.inatel.dm110.beans.partner;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.api.partner.AuditTO;
import br.inatel.dm110.interfaces.partner.AuditLocal;

//import br.inatel.dm110.interfaces.partner.Audit;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", 
								  propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", 
								  propertyValue = "java:/jms/queue/dm110queue") 
})

public class PartnerQueueMDB implements MessageListener {

	private static Logger log = 
			Logger.getLogger(PartnerQueueMDB.class.getName());
	
	@Resource
	private MessageDrivenContext mdc;
	
	@EJB
	private AuditLocal auditBean;
	
	@PersistenceContext(unitName = "partner_pu")
	private EntityManager em;

	@Override
	public void onMessage(Message message) {
		ObjectMessage msg = null;
		try {
			if (message instanceof ObjectMessage) {
				msg = (ObjectMessage) message;
				AuditTO audit = (AuditTO) msg.getObject();
				log.info("Message received from queue: " + audit.getOperation());
				if (audit.getOperation().equals("create") || 
						audit.getOperation().equals("update")
				) {
					save(audit);
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
			mdc.setRollbackOnly();
		} catch (Throwable te) {
			te.printStackTrace();
		}
	}
	
	public void save(AuditTO audit) {
		auditBean.saveRegister(audit);
	}
}
