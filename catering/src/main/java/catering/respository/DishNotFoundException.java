package catering.respository;

public class DishNotFoundException extends DishException{
	
	public DishNotFoundException(){
		code=101;
		message="food not found..…";
	}

}
