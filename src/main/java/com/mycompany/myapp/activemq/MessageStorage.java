package com.mycompany.myapp.activemq;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.myapp.domain.Pay;


public class MessageStorage {
	private List<Pay> customers = new ArrayList<>();
    ;
	public void add(Pay customer) {
		customers.add(customer);
	}

	public void clear(String id) {
		customers.remove(0);
	}

	public List<Pay> getAll(){
		return customers;
	}
}
