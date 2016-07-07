package uet.jcia.shop.service;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

import uet.jcia.shop.is.entities.Product;

@WebService
public interface Transaction {
	@WebMethod public boolean doBuy(int customerId , Set<Product> list);
}
