package uet.jcia.shop.is.entities;

public class ProductSpecification {
    private Integer productSpecId;
    private Integer productId;
    private Integer specId;
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
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
        return "ProductSpecification [productSpecId=" + productSpecId + ", productId=" + productId + ", specId="
                + specId + ", value=" + value + ", product=" + product + ", spec=" + spec + "]";
    }
    
}