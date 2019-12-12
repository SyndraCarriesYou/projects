package onlineShop.dao;

import java.io.IOException;

import onlineShop.model.Cart;

/**
 * The functions that a Cart should have to interact with Database 
 * 
 * @author Wenwen Zheng 
 */
public interface CartDao {

	/**
	 * Get the cart with given cart id 
	 * 
	 * @param CartId the ID of the cart 
	 * @return the cart with given cart id 
	 */
    Cart getCartById(int CartId);
    
    /**
     * Check if the cart is valid with given cart id 
     * If it is not valid, then throw an exception 
     * 
     * @param cartId the ID of the cart 
     * @return the cart with given cart id 
     * @throws IOException
     */
    Cart validate(int cartId) throws IOException;
    
    /**
     * Update the information of the given cart 
     * 
     * @param cart the cart that needs to be updated 
     */
    void update(Cart cart);
}
