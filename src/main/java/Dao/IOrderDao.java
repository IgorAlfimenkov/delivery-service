package Dao;

import entity.Client;
import entity.Order;
import entity.Product;
import entity.Store;

import java.util.List;

public interface IOrderDao {

    void add(List<Order> orders, Order order);
    void delete(List<Order> orders, Order order);
    void editNumber(Order order, int newNumber);
    void editClientName(Order order, String newName);
    void editClientPhone(Order order, String newPhone);
    void editStoreName(Order order, String newStoreName);
    Order makeOrder(Store store, Client client, Product product,int quantity, int number);
    Order get(List<Order> orders, int number);


}
