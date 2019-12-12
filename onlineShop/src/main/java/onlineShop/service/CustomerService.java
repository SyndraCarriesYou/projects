package onlineShop.service;

import onlineShop.model.Customer;

public interface CustomerService {

	/**
	 * Add a new customer 
	 * 
	 * @param customer
	 */
    void addCustomer(Customer customer);

    /**
     * Get the customer by the given user name 
     * @param userName
     * @return
     */
    Customer getCustomerByUserName(String userName);
}
