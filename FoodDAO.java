package com;

import java.sql.*;

public class FoodDAO {

    // ADD FOOD
    public void addFood(FoodItem food) {
        String sql = "INSERT INTO food_items1(name, price) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, food.getName());
            ps.setDouble(2, food.getPrice());
            ps.executeUpdate();

            System.out.println("Food item added successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW FOOD
    public void viewFoods() {
        String sql = "SELECT * FROM food_items1";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nID\tName\tPrice");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("food_id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET FOOD PRICE
    public double getFoodPrice(int foodId) {
        String sql = "SELECT price FROM food_items1 WHERE food_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, foodId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("price");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
