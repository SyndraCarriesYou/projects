package onlineShop.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 2652327633296064143L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String customerPhone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cart;

	/**
	 * Get the ID 
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the ID 
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Get the first name 
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the first name 
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get the last name 
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the last name 
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Get the phone of the customer 
	 * 
	 * @return
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * Set the phone of the customer 
	 * 
	 * @param customerPhone
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * Get the shipping address 
	 * 
	 * @return
	 */
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Set the shipping address 
	 * 
	 * @param shippingAddress
	 */
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * Get the billing address 
	 * 
	 * @return
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Set the billing address 
	 * 
	 * @param billingAddress
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * Get the user 
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set the user 
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Get the cart 
	 * 
	 * @return
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * Set the cart 
	 * 
	 * @param cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
