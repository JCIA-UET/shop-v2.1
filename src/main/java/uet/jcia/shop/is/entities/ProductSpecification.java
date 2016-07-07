package uet.jcia.shop.is.entities;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductSpecification implements Serializable{
    private Integer productSpecId;
 
    private String value;
    private Product product;
    private Specification spec;
    
    private String specName;
    
    public ProductSpecification() {
    }
    
    public ProductSpecification(String value, Product product, Specification spec) {
        super();
        this.value = value;
        this.product = product;
        this.spec = spec;
    }
    
    public String getSpecName() {
        return specName;
    }
    
    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getProductSpecId() {
        return productSpecId;
    }

    public void setProductSpecId(Integer productSpecId) {
        this.productSpecId = productSpecId;
    }

   

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Specification getSpec() {
        return spec;
    }

    public void setSpec(Specification spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "ProductSpecification [productSpecId=" + productSpecId + ", productId="  + ", specId="
                 + ", value=" + value + ", product=" + product + ", spec=" + spec + "]";
    }
    
}