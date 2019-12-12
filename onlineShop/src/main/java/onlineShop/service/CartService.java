package onlineShop.service;

import onlineShop.model.Cart;

public interface CartService {
	/**
	 * Get the cart by the given cart id 
	 * @param CartId
	 * @return
	 */
    Cart getCartById(int CartId);
}
