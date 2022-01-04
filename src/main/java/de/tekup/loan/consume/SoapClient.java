package de.tekup.loan.consume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.loan.consume.loaneligibilty.CustomerRequest;
import de.tekup.loan.consume.loaneligibilty.WsResponse;

@Service
public class SoapClient {
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate template;
	
	public WsResponse getLoanStatus(CustomerRequest request) {
		template = new WebServiceTemplate(marshaller);
		WsResponse response = (WsResponse) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		return response;
	}

}
