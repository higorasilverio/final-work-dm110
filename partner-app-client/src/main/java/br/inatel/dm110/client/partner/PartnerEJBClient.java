package br.inatel.dm110.client.partner;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.inatel.dm110.api.partner.PartnerTO;
import br.inatel.dm110.interfaces.partner.PartnerRemote;

public class PartnerEJBClient {

	public static void main(String[] args) throws Exception {
		invokeStatelessBean();
	}

	private static void invokeStatelessBean() throws NamingException {

		final PartnerRemote statelessPartner = lookupStatelessPartner();
		if (statelessPartner != null) {
			List<PartnerTO> partnerList = statelessPartner.listAllPartners();
			System.out.println(
					"Result from stateless call: " 
					+ partnerList
			);
		} else {
			System.out.println("Remote stateless object not found!");
		}
	}

	private static PartnerRemote lookupStatelessPartner() 
			throws NamingException {
		String appName = "partner-ear-1.0";
		String moduleName = "partner-ejb-1.0";
		String beanName = "PartnerBean";
		String interfaceName = PartnerRemote.class.getName();
		
		String jndiName = 
				"ejb:" + appName + "/" + moduleName + "/" 
				+ beanName + "!" + interfaceName;
		System.out.println("JNDI Name: " + jndiName);
		
		Context context = createInitialContext();
		return (PartnerRemote) context.lookup(jndiName);
	}

	private static Context createInitialContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(
				Context.INITIAL_CONTEXT_FACTORY, 
				"org.wildfly.naming.client.WildFlyInitialContextFactory"
		);
		jndiProperties.put(
				Context.PROVIDER_URL, 
				"remote+http://localhost:8080"
		);
		return new InitialContext(jndiProperties);
	}

}
