package uet.jcia.shop.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.is.entities.Customer;
import uet.jcia.shop.is.entities.Order;

@WebService
public interface Transaction {
	@WebMethod public boolean doBuy(Customer customer , Order order);
	@WebMethod public String sayhello();
}
