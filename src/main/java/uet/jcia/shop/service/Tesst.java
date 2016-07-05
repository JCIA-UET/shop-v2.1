package uet.jcia.shop.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Tesst {
	@WebMethod public String getName(String name){
		return name;
	}
}
