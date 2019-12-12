package onlineShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 2681531852204068105L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String password;
	private boolean enabled;

	@OneToOne(mappedBy = "user")
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
	 * Get the email id 
	 * 
	 * @return
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Set the email id 
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Get the password 
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password 
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * check if the user is enabled 
	 * 
	 * @return
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Set if the user is enabled 
	 * 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
