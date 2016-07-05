package uet.jcia.shop.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uet.jcia.shop.is.entities.Product;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Repository {

    @WebMethod Product getProduct(String productId);
}
