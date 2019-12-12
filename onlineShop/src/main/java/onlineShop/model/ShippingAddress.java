package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shippingAddress")
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = 7551999649936522523L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	@OneToOne(mappedBy = "shippingAddress")
	private Customer customer;

	/**
	 * Get the id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id 
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the address 
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the address 
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the city 
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city 
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get the state 
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state 
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get the zipcode 
	 * 
	 * @return
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * Set the zipcode 
	 * 
	 * @param zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * get the country 
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Set the country 
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Get the customer 
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Set the customer 
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
}
