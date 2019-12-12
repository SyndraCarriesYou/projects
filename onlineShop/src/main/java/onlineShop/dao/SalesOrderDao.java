package onlineShop.dao;

import onlineShop.model.SalesOrder;

/**
 * The functions that a sales order should have to interact with Database 
 * 
 * @author Wenwen Zheng 
 *
 */
public interface SalesOrderDao {
	/**
	 * Add the sale order into database
	 * 
	 * @param SalesOrder
	 */
    void addSalesOrder(SalesOrder SalesOrder);
}
