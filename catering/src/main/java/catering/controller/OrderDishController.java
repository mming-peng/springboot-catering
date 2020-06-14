package catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import catering.entity.Order;
import catering.entity.OrderDish;
import catering.entity.OrderDishRank;
import catering.respository.OrderDishRepository;
import catering.respository.OrderJdbcRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api("This a orderDish RESTful Controller")
@RestController
@RequestMapping("/api/v1")
public class OrderDishController {
	@Autowired
	private OrderDishRepository repo;
	
		
	@ApiOperation("add orderdish")
	@PostMapping("/orderdish")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addOrderDish(@RequestBody OrderDish orderDish){
        repo.add(orderDish);
	}

	@ApiOperation("Show orderdishByNumber")
	@GetMapping("/orderdish/{number}")
	public Iterable<OrderDishRank> getOrderDish(@PathVariable("number") int number){
		return repo.findByOrder_number(number);
	}
	
	@ApiOperation("Show orderdishrank")
	@GetMapping("/orderdishrank")
	public Iterable<OrderDishRank> getOrderDishRank(){
		return repo.selectOrderDishRank();
	}
}
