package onlineShop.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

	private static final long serialVersionUID = 8734140534986494039L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String emailId;

	private String authorities;

	/**
	 * Get the id 
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the id to the given id 
	 *  
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the email id 
	 * 
	 * @return email id 
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Set the email id to the given email id 
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Get the authorities
	 * 
	 * @return
	 */
	public String getAuthorities() {
		return authorities;
	}

	/**
	 * Set the authorities to the given authorities 
	 * 
	 * @param authorities
	 */
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
}
