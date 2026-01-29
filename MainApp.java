package com;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FoodDAO foodDAO = new FoodDAO();

        while (true) {
            MenuUtil.mainMenu();
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    MenuUtil.adminMenu();
                    int adminChoice = sc.nextInt();

                    if (adminChoice == 1) {
                        sc.nextLine();
                        System.out.print("Food Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        foodDAO.addFood(new FoodItem(name, price));
                    }
                    else if (adminChoice == 2) {
                        foodDAO.viewFoods();
                    }
                    break;

                case 2:
                    foodDAO.viewFoods();

                    System.out.print("Enter Food ID to order: ");
                    int foodId = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    OrderDAO orderDAO = new OrderDAO();

                    double price = foodDAO.getFoodPrice(foodId);
                    double total = price * quantity;

                    int orderId = orderDAO.createOrder(total);
                    orderDAO.addOrderDetails(orderId, foodId, quantity);

                    System.out.println("\nOrder Placed Successfully!");
                    System.out.println("Total Bill: ₹" + total);
                    break;


                case 3:
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}
