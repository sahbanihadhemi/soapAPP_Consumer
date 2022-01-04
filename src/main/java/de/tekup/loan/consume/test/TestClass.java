package de.tekup.loan.consume.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.loan.consume.SoapClient;
import de.tekup.loan.consume.loaneligibilty.CustomerRequest;
import de.tekup.loan.consume.loaneligibilty.WsResponse;

@RestController
public class TestClass {
	
	@Autowired
	private SoapClient client;
	
	@GetMapping("/getLoanStatus")
	public WsResponse invokeSoapClient() {
		CustomerRequest request = new CustomerRequest();
		request.setCustomerName("Test");
		request.setAge(36);
		request.setCibilScore(650);
		request.setYearlyIncome(26000);
		request.setEmploymentMode("Full Time");
		
		return client.getLoanStatus(request);
	}

}
