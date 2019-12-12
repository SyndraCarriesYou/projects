package onlineShop.dao;

import java.util.List;

import onlineShop.model.Product;

/**
 * The functions that a product should have to interact with Database 
 * 
 * @author Wenwen Zheng 
 *
 */
public interface ProductDao {
    
	/**
	 * Get the product with given id 
	 * 
	 * @param productId
	 * @return the product with given id. If the product with given id
	 *         does not exist, return null.
	 */
    Product getProductById(int productId);

    /**
     * Delete the product with given id 
     * 
     * @param productId
     */
    void deleteProduct(int productId);
    
    /**
     * Add the product into database 
     * 
     * @param product
     */
    void addProduct(Product product);
    
    /**
     * Update the information of Product in database 
     * 
     * @param product
     */
    void updateProduct(Product product);
    
    /**
     * Get all the products stored in the database
     * 
     * @return all the products stored in the database. If there
     * 		   is no product, return an empty list. 
     */
    List<Product> getAllProducts();
}
