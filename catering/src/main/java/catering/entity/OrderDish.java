package catering.entity;

public class OrderDish {
    private int order_number;
    private int dish_number;
    private int amount;
    
    public OrderDish() {
    }

    public OrderDish(int order_number, int dish_number, int amount) {
        this.order_number = order_number;
        this.dish_number = dish_number;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDish{" +
                "order_number=" + order_number +
                ", dish_number=" + dish_number +
                ", amount=" + amount +
                '}';
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getDish_number() {
        return dish_number;
    }

    public void setDish_number(int dish_number) {
        this.dish_number = dish_number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
}
