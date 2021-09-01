package br.inatel.dm110.interfaces.partner;

import br.inatel.dm110.api.partner.AuditTO;

public interface Audit {

	public void saveRegister(AuditTO audit);
	
}
