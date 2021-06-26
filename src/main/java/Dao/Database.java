package Dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sun.org.apache.xpath.internal.operations.Or;
import entity.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Database {

    static Database instance;
    public static String filename;
    public static String clientsFile;
    public  List<ProductType> productTypeList = Arrays.asList(ProductType.values());
    public List<Store> stores = new ArrayList<Store>();
    public List<Client> clients = new ArrayList<Client>();
    public List<Order> orders = new ArrayList<>();


    public Database(String filename,String clientsFile)
    {
        if(filename == null)
        {
            filename = "stores.json";
            clientsFile = "clients.json";
        }
        else
        {
            stores = new ArrayList<>();
            clients = new ArrayList<>();
            getStores(filename);
            getClients(clientsFile);
            getOrders();

        }
    }

    public static Database getInstance()
    {
        if (instance == null) return new Database(filename,clientsFile);
        return instance;
    }

    public  void getStores(String filePath)
    {

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list
            stores = mapper.readValue(Paths.get(filePath).toFile(), new TypeReference<List<Store>>() {
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void getOrders()
    {

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list
            orders = mapper.readValue(Paths.get("orders.json").toFile(), new TypeReference<List<Order>>() {
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public  void getClients(String filePath)
    {

        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON array to list
            clients = mapper.readValue(Paths.get(filePath).toFile(), new TypeReference<List<Client>>() {
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addStore(List<Store> stores,Store store)
    {
        stores.add(store);
    }

    public void deleteStore(List<Store> stores, Store store)
    {
        stores.remove(store);
    }

    public List<Store> getAllStores()
    {
        return this.stores;
    }

    public void addProduct(Store store, Product product)
    {
        if(store.getProducts().contains(product))
        {
            System.out.println("This product already exists!");
        }
        store.getProducts().add(product);
    }

    public void deleteProduct(Store store, Product product)
    {
        for (Category category : store.getCategories()) {

            if(category.getProducts().contains(product))
            {
                category.getProducts().remove(product);
            }
        }
        store.getProducts().remove(product);
    }

    public void addCategory(Store store, Category category)
    {
        if(store.getCategories().contains(category))
        {
            System.out.println("This category already exists!");
        }
        else {
            store.getCategories().add(category);
        }

    }

    public void deleteCategory(Store store, Category category)
    {
        store.getCategories().remove(category);
    }

    public void addClient(List<Client> clients,Client client)
    {
        clients.add(client);
    }

    public void deleteClient(List<Client> clients,Client client) {

        clients.remove(client);
    }

    public Client getClient(List<Client> clients,String name)
    {
        for (Client client : clients) {

            if(client.getName().equalsIgnoreCase(name))
            {
                return client;
            }
        }
        return null;
    }

    public List<Client> getAllClients()
    {
        return this.clients;
    }

    public void addOrder(List<Order> orders, Order order)
    {
        orders.add(order);
    }

    public void deleteOrder(List<Order> orders, Order order)
    {
        orders.remove(order);
    }


    public List<Order> getAllOrders()
    {
        return this.orders;
    }

    public void saveStores(String filePath )
    {
        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        // convert  object to JSON file
        try {
            writer.writeValue(Paths.get(filePath).toFile(), this.stores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveClients(String filename)
    {

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        // convert  object to JSON file
        try {
            writer.writeValue(Paths.get(filename).toFile(), this.clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveOrders()
    {
        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        // convert  object to JSON file
        try {
            writer.writeValue(Paths.get("orders.json").toFile(), this.orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String storesFile, String clientsFile)
    {
        this.saveStores(storesFile);
        this.saveClients(clientsFile);
        this.saveOrders();
    }


}
