package catering.service;

import catering.entity.OrderDish;
import catering.entity.OrderDishRank;

public interface OrderDishService {
	public void add(OrderDish orderdish);
	public Iterable<OrderDishRank> findByOrder_number(int order_number);
	public Iterable<OrderDishRank> selectOrderDishRank();

}
