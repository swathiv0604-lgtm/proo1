package com;
import java.time.LocalDate;
public class Order {
	 private int orderId;
	    private LocalDate orderDate;
	    private double totalAmount;

	    public Order(LocalDate orderDate, double totalAmount) {
	        this.orderDate = orderDate;
	        this.totalAmount = totalAmount;
	    }

	    public int getOrderId() { return orderId; }
	    public void setOrderId(int orderId) { this.orderId = orderId; }
}
