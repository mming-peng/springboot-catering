package catering.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import catering.entity.Order;
import catering.service.OrderService;
@Repository
public class OrderJdbcRepository implements OrderService{
	@Autowired
	private JdbcTemplate jt;
		
	public Iterable<Order> findByUnStatus(){	
			return jt.query("select * from Orders where status=0", new BeanPropertyRowMapper(Order.class));
	}
	
	public Iterable<Order> findByStatus(){	
		return jt.query("select * from Orders where status=1", new BeanPropertyRowMapper(Order.class));
}
	
	
	public void updateStatus(int order_number) {	
			jt.update("update Orders set status=1 where Order_number=?",order_number);			
	}
	
	public Order findByTableNumberAndTime(int table_number,int time){	
		return (Order)jt.queryForObject("select * from Orders where table_number=? and time=?", new BeanPropertyRowMapper(Order.class),table_number,time);
	}
	
	public void add(Order order){
			jt.update("insert into Orders (table_number,status,time,price) values(?,?,?,?)",order.getTable_number(),order.getStatus(),order.getTime(),order.getPrice());			
	}
	
	

}
