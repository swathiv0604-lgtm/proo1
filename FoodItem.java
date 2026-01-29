package com;

public class FoodItem {
	private int foodId;
    private String name;
    private double price;

    public FoodItem() {}

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getFoodId() { return foodId; }
    public void setFoodId(int foodId) { this.foodId = foodId; }

    public String getName() { return name; }
    public double getPrice() { return price; }
}
