package catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import catering.entity.Dish;
import catering.entity.Order;
import catering.respository.DishDuplicatedException;
import catering.respository.DishJdbcRepository;
import catering.respository.DishNotFoundException;
import catering.respository.OrderJdbcRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api("This a order RESTful Controller")
@RestController
@RequestMapping("/api/v1")
public class OrderRestController {
	@Autowired
	private OrderJdbcRepository repo;
	
	@ApiOperation("Show all undoneorder")
	@GetMapping("/undoneorder")
	public Iterable<Order> getUndoneOrder(){
		return repo.findByUnStatus();
	}
	
	@ApiOperation("Show all doneorder")
	@GetMapping("/doneorder")
	public Iterable<Order> getdoneOrder(){
		return repo.findByStatus();
	}
	
	@ApiOperation("update order by number")
	@PutMapping("/order/{order_number}")
	public void updateOrderByNumber(@PathVariable("order_number") int order_number){
		repo.updateStatus(order_number);
	}
	
	@ApiOperation("find order by TableNumberAndTime")
	@GetMapping("/order/{tableNumber}/{time}")
	public Order getOrderByTableNumberAndTime(@PathVariable("tableNumber") int tableNumber, @PathVariable("time") int time){
		return repo.findByTableNumberAndTime(tableNumber, time);
	}
	
	@ApiOperation("add order")
	@PostMapping("/order")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addOrder(@RequestBody Order order){
		order.setStatus(0);
        repo.add(order);
	}
	

}
