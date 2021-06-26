package Service;

import Dao.*;
import entity.*;

import java.util.List;
import java.util.Scanner;

public class Service implements IService {

    static StoreDao storeDao = new StoreDao();
    static ClientDao clientDao = new ClientDao();
    static ProductDao productDao = new ProductDao();
    static CategoryDao categoryDao = new CategoryDao();
    static OrderDao orderDao = new OrderDao();

    Scanner in = new Scanner(System.in);

    @Override
    public void editType(Product product, String newType) {
        productDao.editType(product,newType);
    }

    public void editName(Product product, String newName)
    {
        productDao.editName(product, newName);
    }

    @Override
    public void editBrand(Product product, String newBrand) {

        productDao.editBrand(product, newBrand);
    }

    @Override
    public void editColor(Product product, String newColor) {

        productDao.editColor(product, newColor);
    }

    @Override
    public void editPrice(Product product, double newPrice) {

        productDao.editPrice(product, newPrice);
    }

    @Override
    public void editSize(Product product, double newSize) {

        productDao.editSize(product,newSize);
    }

    @Override
    public void editQuantity(Product product, int newQuantity) {

        productDao.editQuantity(product,newQuantity);
    }

    @Override
    public ProductType getType(String type) {
        return productDao.getType(type);
    }

    @Override
    public void addStore(List<Store> stores, Store store) {
        storeDao.addStore(stores, store);
    }

    @Override
    public void deleteStore(List<Store> stores, Store store) {

        storeDao.deleteStore(stores, store);
    }

    @Override
    public void addProduct(Store store, Product product) {

        storeDao.addProduct(store, product);
    }

    @Override
    public void deleteProduct(Store store, Product product) {

        storeDao.deleteProduct(store, product);
    }

    @Override
    public void addCategory(Store store, Category category) {

        storeDao.addCategory(store, category);
    }

    @Override
    public void deleteCategory(Store store, Category category) {

        storeDao.deleteCategory(store, category);
    }

    @Override
    public void editName(Store store, String name) {

        storeDao.editName(store, name);
    }

    @Override
    public void buyProduct(Store store, Product product) {

        storeDao.buyProduct(store, product);
    }

    @Override
    public Store getStoreByName(List<Store> stores, String name) {
        return storeDao.getStoreByName(stores, name);
    }

    @Override
    public List<Store> getAll() {
        return storeDao.getAll();
    }

    @Override
    public Product getByNameAndSize(Store store, String name, double size) {
        return storeDao.getByNameAndSize(store, name, size);
    }

    @Override
    public Product getProduct(Store store, int id) {
        return storeDao.getProduct(store,id);
    }

    @Override
    public List<Product> getProductsByCategory(Store store, String name) {
        return storeDao.getProductsByCategory(store, name);
    }


    @Override
    public List<Product> getByPrice(Store store, double price) {
        return storeDao.getByPrice(store, price);
    }

    @Override
    public List<Product> getByName(Store store, String name) {
        return storeDao.getByName(store,name);
    }

    @Override
    public List<Product> getByType(Store store, String type) {
        return storeDao.getByType(store, type);
    }

    @Override
    public List<Product> getByTypeAndPrice(Store store, String type, double price) {
        return storeDao.getByTypeAndPrice(store, type, price);
    }

    @Override
    public List<Product> getByTypePriceAndCategory(Store store, double price, String type, String category) {
        return storeDao.getByTypePriceAndCategory(store, price, type, category);
    }

    @Override
    public List<Product> sortProducts(Store store) {
        return storeDao.sortProducts(store);
    }

    @Override
    public Category getCategoryByName(Store store, String name) {
        return storeDao.getCategoryByName(store, name);
    }

    @Override
    public void changeType(Store store, Product product, ProductType productType) {
        storeDao.changeType(store, product, productType);
    }

    @Override
    public void changeName(Store store, Product product, String name) {
        storeDao.changeName(store, product, name);
    }

    @Override
    public void changeBrand(Store store, Product product, String brand) {

        storeDao.changeBrand(store, product, brand);
    }

    @Override
    public void changeColor(Store store, Product product, String color) {

        storeDao.changeColor(store, product, color);
    }

    @Override
    public void changePrice(Store store, Product product, Double price) {

        storeDao.changePrice(store, product, price);
    }

    @Override
    public void changeSize(Store store, Product product, Double size) {

        storeDao.changeSize(store, product, size);
    }

    @Override
    public void changeQuantity(Store store, Product product, int quantity) {

        storeDao.changeQuantity(store, product, quantity);
    }

    @Override
    public void addProduct(Category category, Product product) {
        categoryDao.addProduct(category,product);
    }

    @Override
    public void deleteProduct(Category category, Product product) {

        categoryDao.deleteProduct(category, product);
    }

    @Override
    public void editName(Category category, String newName) {

        categoryDao.editName(category, newName);
    }

    @Override
    public List<Product> getProducts(Category category) {
        return categoryDao.getProducts(category);
    }

    @Override
    public void addClient(List<Client> clients,Client client) {

        clientDao.addClient(clients,client);
    }

    @Override
    public void deleteClient(List<Client> clients, Client client) {
        clientDao.deleteClient(clients, client);
    }

    @Override
    public void editName(Client client, String newName) {
        clientDao.editName(client, newName);
    }

    @Override
    public void editAddress(Client client, String newAddress) {

        clientDao.editAddress(client, newAddress);
    }

    @Override
    public void editEmail(Client client, String newEmail) {

        clientDao.editEmail(client, newEmail);
    }

    @Override
    public void editIndex(Client client, int newIndex) {

        clientDao.editIndex(client, newIndex);
    }

    @Override
    public void editPhone(Client client, String newPhone) {

        clientDao.editPhone(client, newPhone);
    }

    @Override
    public Client getClient(List<Client> clients,String name) {
        return clientDao.getClient(clients, name);
    }

    @Override
    public void add(List<Order> orders, Order order) {
        orderDao.add(orders,order);
    }

    @Override
    public void delete(List<Order> orders, Order order) {
        orderDao.delete(orders, order);
    }

    @Override
    public void editNumber(Order order, int newNumber) {
        orderDao.editNumber(order, newNumber);
    }

    @Override
    public void editClientName(Order order, String newName) {
        orderDao.editClientName(order, newName);
    }

    @Override
    public void editClientPhone(Order order, String newPhone) {
        orderDao.editClientPhone(order,newPhone);
    }

    @Override
    public void editStoreName(Order order, String newStoreName) {

        orderDao.editStoreName(order, newStoreName);
    }

    @Override
    public Order get(List<Order> orders, int number) {
        return orderDao.get(orders, number);
    }

    @Override
    public Order makeOrder(Store store, Client client, Product product, int quantity, int number) {
        return orderDao.makeOrder(store, client, product, quantity, number);
    }

    @Override
    public void reduceQuantity(Product product, int count) {
        storeDao.reduceQuantity(product, count);
    }

}
