package onlineShop.service;

import onlineShop.model.Cart;
import onlineShop.model.CartItem;

public interface CartItemService {
	/**
	 * Add the cart item to the cart 
	 * 
	 * @param cartItem
	 */
    void addCartItem(CartItem cartItem);

    /**
     * Remove the cart item with given cart item id from the cart 
     * 
     * @param CartItemId
     */
    void removeCartItem(int CartItemId);

    /**
     * Remove all the cart items from the given cart 
     * 
     * @param cart
     */
    void removeAllCartItems(Cart cart);
}
