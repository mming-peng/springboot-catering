package catering.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import catering.entity.Dish;
import catering.service.DishService;

@Repository
public class DishJdbcRepository implements DishService{
	@Autowired
	private JdbcTemplate jt;
	
	
	public Iterable<Dish> findAll(){
		return jt.query("select * from Dish", new BeanPropertyRowMapper(Dish.class));
	}
	
	public Dish findByNumber(int dish_number) throws DishNotFoundException{
		try {
			return (Dish)jt.queryForObject("select * from Dish where dish_number=?", new BeanPropertyRowMapper(Dish.class),dish_number);
		}catch(DataAccessException dae){
			throw new DishNotFoundException();
		}
	}
	
	public Iterable<Dish> findByName(String name) throws DishNotFoundException{
		try {
			return jt.query("select * from Dish where dish_name like ?", new BeanPropertyRowMapper(Dish.class),name);
		}catch(DataAccessException dae){
			throw new DishNotFoundException();
		}
	}
	
	public void add(Dish Dish) throws DishDuplicatedException{
		try {
			jt.update("insert into Dish (dish_name,discount,price) values(?,?,?)",Dish.getDish_name(),Dish.getDiscount(),Dish.getPrice());			
		}catch(DuplicateKeyException ex) {
			throw new DishDuplicatedException();
		}
	}
	
	public void delete(int dish_number) throws DishNotFoundException{
		try {
			jt.update("delete from Dish where dish_number=?",new Object[]{dish_number});
		}catch(DataAccessException dae){
			throw new DishNotFoundException();
		}
	}
	
	public void deleteAll() throws DishNotFoundException{
		try {
			jt.update("delete from Dish");
		}catch(DataAccessException dae){
			throw new DishNotFoundException();
		}
	}
	
	public void update(Dish Dish) throws DishDuplicatedException{
		try {
			jt.update("update Dish set dish_name=?,discount=?,price=? where dish_number=?",Dish.getDish_name(),Dish.getDiscount(),Dish.getPrice(),Dish.getDish_number());			
		}catch(DuplicateKeyException ex) {
			throw new DishDuplicatedException();
		}
	}
	
}
