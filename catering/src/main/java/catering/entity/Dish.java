package catering.entity;

public class Dish {
    private int dish_number;
    private String dish_name;
    private int discount;
    private double price;
    
    public Dish(int dish_number, String dish_name, int discount, double price) {
        this.dish_number = dish_number;
        this.dish_name = dish_name;
        this.discount = discount;
        this.price = price;
    }
    
    public Dish() {
    	
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dish_number=" + dish_number +
                ", dish_name='" + dish_name + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }

    public int getDish_number() {
        return dish_number;
    }

    public void setDish_number(int dish_number) {
        this.dish_number = dish_number;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
