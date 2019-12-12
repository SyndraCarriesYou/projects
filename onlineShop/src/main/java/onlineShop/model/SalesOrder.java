package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salesorder")
public class SalesOrder implements Serializable {

	private static final long serialVersionUID = -6571020025726257848L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Cart cart;

	@OneToOne
	private Customer customer;

	@OneToOne
	private ShippingAddress shippingAddress;

	@OneToOne
	private BillingAddress billingAddress;

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
}
