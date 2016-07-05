package uet.jcia.shop.service;

import javax.jws.WebService;

import uet.jcia.shop.is.entities.Product;

@WebService(endpointInterface = "uet.jcia.shop.service.Repository")
public class RepositoryImpl implements Repository {

    @Override
    public Product getProduct(String productId) {
        Product p = new Product();
        p.setProductId(1);
        p.setName("asus 402");
        return p;
    }

}
