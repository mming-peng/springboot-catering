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
import catering.respository.DishDuplicatedException;
import catering.respository.DishJdbcRepository;
import catering.respository.DishNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api("This a dish RESTful Controller")
@RestController
@RequestMapping("/api/v1")
public class DishRestController {
	@Autowired
	private DishJdbcRepository repo;
	
	@ApiOperation("Show all Dishs")
	@GetMapping("/dish")
	public Iterable<Dish> getDishs(){
		return repo.findAll();
	}
	
	@ApiOperation("find Dish by number")
	@GetMapping("/dish/{dish_number}")
	public Dish getDishByFid(@PathVariable("dish_number") int dish_number) throws DishNotFoundException{
		return repo.findByNumber(dish_number);
	}
	
	@ApiOperation("find Dish by name")
	@GetMapping("/dishName/{name}")
	public Iterable<Dish> getDishByName(@PathVariable String name) throws DishNotFoundException{
		return repo.findByName("%" +name+"%");
	}
	
	@ApiOperation("add Dish")
	@PostMapping("/dish")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addDish(@RequestBody Dish dish) throws DishDuplicatedException{
		repo.add(dish);
	}
	
	@ApiOperation("delete Dish by fid")
	@DeleteMapping("/dish/{dish_number}")
	public void deleteDish(@PathVariable("dish_number") int dish_number) throws DishNotFoundException{
		repo.delete(dish_number);
	}
	
	@ApiOperation("delete all Dishs")
	@DeleteMapping("/dish/")
	public void deleteAllDish() throws DishNotFoundException{
		repo.deleteAll();
	}
	
	@ApiOperation("update Dish")
	@PutMapping("/dish")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateDish(@RequestBody Dish Dish) throws DishDuplicatedException{
		repo.update(Dish);
	}

}
