package uet.jcia.shop.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;


@WebService(endpointInterface = "uet.jcia.shop.service.Transaction")
public class TransactionImplementation implements Transaction {

	@Override
	@WebMethod
	public boolean doBuy(Customer customer, Order order) {
		
		return false;
	}

	@Override
	@WebMethod
	public String sayhello() {
		// TODO Auto-generated method stub
		return "xin chao";
	}

}
