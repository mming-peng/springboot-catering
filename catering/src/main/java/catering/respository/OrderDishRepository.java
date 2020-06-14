package catering.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import catering.entity.Dish;
import catering.entity.OrderDish;
import catering.entity.OrderDishRank;
import catering.service.OrderDishService;
@Repository
public class OrderDishRepository implements OrderDishService{
	@Autowired
	private JdbcTemplate jt;
	
	public void add(OrderDish orderdish){
			jt.update("insert into order_dish (order_number,dish_number,amount) values(?,?,?)",orderdish.getOrder_number(),orderdish.getDish_number(),orderdish.getAmount());			
	}
	
	public Iterable<OrderDishRank> findByOrder_number(int order_number) {	
			return jt.query("select dish.dish_name,order_dish.amount from order_dish,dish where order_dish.dish_number = dish.dish_number and order_number =?", new BeanPropertyRowMapper(OrderDishRank.class),order_number);	
	}
	
	public Iterable<OrderDishRank> selectOrderDishRank() {	
		return jt.query("select dish.dish_name,SUM( order_dish.amount ) AS amount from order_dish,dish where order_dish.dish_number = dish.dish_number GROUP BY dish.dish_name ORDER BY amount DESC", new BeanPropertyRowMapper(OrderDishRank.class));	
	}

}
