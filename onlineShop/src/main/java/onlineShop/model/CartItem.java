package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cartitem")
public class CartItem implements Serializable {
	
	private static final long serialVersionUID = -2455760938054036364L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int quantity;

	private double price;

	@OneToOne
	private Product product;

	@ManyToOne
	@JsonIgnore
	private Cart cart;

	
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
	 * Get the quantity of the cart items
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set the quantity 
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the price 
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the Price 
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the price 
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Set the price
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
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
