package catering.service;

import catering.entity.Dish;
import catering.respository.DishDuplicatedException;
import catering.respository.DishNotFoundException;

public interface DishService {
	public Iterable<Dish> findAll();
	public Dish findByNumber(int dish_number) throws DishNotFoundException;
	public Iterable<Dish> findByName(String name) throws DishNotFoundException;
	public void add(Dish Dish) throws DishDuplicatedException;
	public void delete(int dish_number) throws DishNotFoundException;
	public void deleteAll() throws DishNotFoundException;
	public void update(Dish Dish) throws DishDuplicatedException;

}
