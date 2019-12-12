package onlineShop.service;

import java.util.List;

import onlineShop.model.Product;

public interface ProductService {
    
	/**
	 * Get all products 
	 * 
	 * @return
	 */
    List<Product> getAllProducts();
    
    /**
     * Get the product by the given product id 
     * 
     * @param productId
     * @return
     */
    Product getProductById(int productId);

    /**
     * Delete the product with the given product id
     * 
     * @param productId
     */
    void deleteProduct(int productId);
    
    /**
     * Add the product 
     * 
     * @param product
     */
    void addProduct(Product product);
    
    /**
     * Update the given product 
     * 
     * @param product
     */
    void updateProduct(Product product);
}
