package catering.entity;

public class Order {
    private int order_number;
    private int table_number;
    private int status;
    private int time;
    private double price;
    
    public Order() {
    }

    public Order(int order_number, int table_number, int status, int time, double price) {
        this.order_number = order_number;
        this.table_number = table_number;
        this.status = status;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_number=" + order_number +
                ", table_number=" + table_number +
                ", status=" + status +
                ", time=" + time +
                ", price=" + price +
                '}';
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}
