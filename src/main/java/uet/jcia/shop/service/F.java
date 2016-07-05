package uet.jcia.shop.service;

import javax.xml.ws.Endpoint;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://locahost:4848/shop-v2/Tesst", new Tesst());
	}

}
