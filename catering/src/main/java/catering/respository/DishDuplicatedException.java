package catering.respository;

public class DishDuplicatedException extends DishException{
	public DishDuplicatedException(){
		code=102;
		message="food not Duplicated..…";
	}
}
