package onlineShop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 8436097833452420298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(mappedBy = "cart")
	@JsonIgnore
	private Customer customer;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<CartItem> cartItem;
	
	private double totalPrice;

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
	 * Get all the cart item 
	 * 
	 * @return
	 */
	public List<CartItem> getCartItem() {
		return cartItem;
	}

	/**
	 * Set the cart item 
	 * 
	 * @param cartItem
	 */
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	/**
	 * Get the total price 
	 * 
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Set the total price 
	 * 
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Get the Customer 
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Set the Customer 
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
