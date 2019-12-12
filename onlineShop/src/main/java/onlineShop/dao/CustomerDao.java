package onlineShop.dao;

import onlineShop.model.Customer;

/**
 * The functions that a Customer should have to interact with Database 
 * 
 * @author wenwenzheng
 *
 */
public interface CustomerDao {
    
	/**
	 * Add a customer into database with normal user authority 
	 * 
	 * @param customer
	 */
    void addCustomer(Customer customer);

    /**
     * Get the customer with given username 
     * 
     * @param userName
     * @return the customer with given username. 
     *         If the customer with given username does not exsit, return null
     */
    Customer getCustomerByUserName(String userName);
}
