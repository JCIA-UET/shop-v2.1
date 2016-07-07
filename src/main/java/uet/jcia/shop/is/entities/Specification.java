package uet.jcia.shop.is.entities;

import java.util.Set;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Specification implements Serializable{
    private Integer specId;
    private String name;
    private Set<ProductSpecification> productSpecs;

    @XmlTransient
	public Set<ProductSpecification> getProductSpecs() {
		return productSpecs;
	}

	public void setProductSpecs(Set<ProductSpecification> products) {
		this.productSpecs = products;
	}

	public Specification(String name) {
        super();
        this.name = name;
    }
    
    public Specification() {
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specification [specId=" + specId + ", name=" + name + "]";
    }

}