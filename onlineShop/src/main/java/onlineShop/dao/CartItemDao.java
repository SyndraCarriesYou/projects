package onlineShop.dao;

import onlineShop.model.Cart;
import onlineShop.model.CartItem;

/**
 * The functions that a Cart item should have to interact with Database 
 * 
 * @author Wenwen Zheng 
 */
public interface CartItemDao {
	/**
	 * Add the cart item into cart 
	 * 
	 * @param cartItem 
	 */
    void addCartItem(CartItem cartItem);
    
    /**
     * Remove the cart item from cart  
     * 
     * @param CartItemId
     */
    void removeCartItem(int CartItemId);
    
    /**
     * Clear the cart 
     * 
     * @param cart
     */
    void removeAllCartItems(Cart cart);
}
