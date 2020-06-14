package catering.service;

import catering.entity.Order;

public interface OrderService {
	public Iterable<Order> findByUnStatus();
	public Iterable<Order> findByStatus();
	public void updateStatus(int order_number);
	public Order findByTableNumberAndTime(int table_number,int time);
	public void add(Order order);

}
