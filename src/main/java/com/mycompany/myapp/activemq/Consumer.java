package com.mycompany.myapp.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.myapp.domain.Pay;


import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


@Component

public class Consumer {

	@Autowired
	private MessageStorage customerStorage;
    @Autowired
    private KieSession session;

	@JmsListener(destination = "netsurfingzone-queue", containerFactory="jsaFactory")
	public void receive(Pay customer){
        session.insert(customer);
        session.fireAllRules();
        System.out.println("###############################################################################");
        System.out.println("###############################################################################");
		System.out.println("Recieved Message: " + customer);
        System.out.println("###############################################################################");
        System.out.println("###############################################################################");
		customerStorage.add(customer);
	}

}
