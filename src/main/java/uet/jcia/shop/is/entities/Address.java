package uet.jcia.shop.is.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Address implements Serializable{
	private Integer addressId;
	private String firstName;
	private String lastName;
	private String address;
	
	private Customer customer;
	
	public Address() {
		
	}
	
	public Address(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public Address(String firstName, String lastName, String address, Customer customer) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.customer = customer;
    }

    public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@XmlTransient
	public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
	public String toString() {
		return "Address [getAddressId()=" + getAddressId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAddress()=" + getAddress() + "]";
	}
	
	
	
}
