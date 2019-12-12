package onlineShop.service;

import onlineShop.model.SalesOrder;

public interface SalesOrderService {
	/**
	 * Add the sales order 
	 * 
	 * @param salesOrder
	 */
    void addSalesOrder(SalesOrder salesOrder);
}
