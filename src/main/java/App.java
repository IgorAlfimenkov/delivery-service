import Dao.*;
import Service.Service;
import entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Database database = new Database("stores.json","clients.json");
        Service service = new Service();

        int exit = 1;
        while(exit == 1)
        {
            System.out.println("1 - View Stores list.\n" +
                    "2 - View Client List.\n" +
                    "3 - View Order List.\n" +
                    "4 - Register new Client.\n" +
                    "5 - Register new Store.\n" +
                    "6 - Edit Store.\n" +
                    "7 - Edit Client.\n" +
                    "8 - Make Order.\n" +
                    "0 - Exit.");
            System.out.println("Enter number:");
            int num = Integer.parseInt(in.nextLine());
            switch (num)
            {
                case (1) :
                    for (Store store : database.stores) {
                        System.out.println(store.toString());
                    }
                    System.out.println("1 - Sort by price.\n" +
                            "2 - Products by Category.\n" +
                            "3 - Products By name.\n" +
                            "4 - Products By Type.\n" +
                            "5 - Products By Price.\n" +
                            "6 - Products By Type and Price.\n" +
                            "7 - Products By Type and Price and Category.\n" +
                            "8 - Search product.\n" +
                            "0 - Return.");
                    int exit2 = 1;
                    while(exit2 == 1) {

                        int num4 = Integer.parseInt(in.nextLine());
                        switch (num4)
                        {
                            case (1):
                                System.out.println("Enter Store name: ");
                                String storeName = in.nextLine();
                                Store viewStore = service.getStoreByName(database.stores, storeName);
                                List<Product> sortProducts = service.sortProducts(viewStore);
                                for (Product product : sortProducts) {
                                    System.out.println(product.toString());
                                }
                                break;
                            case (2):
                                System.out.println("Enter Store name: ");
                                String storeName1 = in.nextLine();
                                Store viewStore1 = service.getStoreByName(database.stores, storeName1);
                                for (Category category : viewStore1.getCategories()) {
                                    System.out.println(category.getName());
                                }
                                System.out.println("Enter Category name: ");
                                String categoryName = in.nextLine();
                                List<Product> list = service.getProductsByCategory(viewStore1, categoryName);
                                for (Product product : list) {
                                    System.out.println(product.toString());
                                }
                                break;
                            case (3):
                                System.out.println("Enter Store name: ");
                                String storeName2 = in.nextLine();
                                Store viewStore2 = service.getStoreByName(database.stores, storeName2);
                                System.out.println("Enter Product name: ");
                                String productName = in.nextLine();
                                List<Product> products = service.getByName(viewStore2, productName);
                                for (Product p : products) {
                                    System.out.println(p.toString());
                                }
                                break;
                            case (4):
                                System.out.println("Enter Store name: ");
                                String storeName3 = in.nextLine();
                                Store viewStore3 = service.getStoreByName(database.stores, storeName3);
                                System.out.println("Available product types:");
                                for (ProductType type : ProductType.values()) {
                                    System.out.println(type.toString());
                                }
                                System.out.println("Enter Type name: ");
                                String typeName = in.nextLine();
                                List<Product> productList = service.getByType(viewStore3,typeName);
                                for (Product p : productList) {
                                    System.out.println(p.toString());
                                }
                                break;
                            case (5):
                                System.out.println("Enter Store name: ");
                                String storeName4 = in.nextLine();
                                Store viewStore4 = service.getStoreByName(database.stores, storeName4);
                                System.out.println("Enter Product price: ");
                                double productPrice = Double.parseDouble(in.nextLine());
                                List<Product> productList1 = service.getByPrice(viewStore4, productPrice);
                                for (Product p : productList1) {
                                    System.out.println(p.toString());
                                }
                                break;
                            case(6):
                                System.out.println("Enter Store name: ");
                                String storeName5 = in.nextLine();
                                Store store = service.getStoreByName(database.stores, storeName5);
                                System.out.println("Available product types:");
                                for (ProductType type : ProductType.values()) {
                                    System.out.println(type.toString());
                                }
                                System.out.println("Enter Product type: ");
                                String type = in.nextLine();
                                System.out.println("Enter Product price: ");
                                double price = Double.parseDouble(in.nextLine());
                                List<Product> productList2 = service.getByTypeAndPrice(store, type, price);
                                for (Product p : productList2) {
                                    System.out.println(p.toString());
                                }
                                break;
                            case (7):
                                System.out.println("Enter Store name: ");
                                String storeName6 = in.nextLine();
                                Store store1 = service.getStoreByName(database.stores, storeName6);
                                System.out.println("Available product types:");
                                for (ProductType type1 : ProductType.values()) {
                                    System.out.println(type1.toString());
                                }
                                System.out.println("Enter Product type: ");
                                String type1 = in.nextLine();
                                System.out.println("Enter Product price: ");
                                double price1 = Double.parseDouble(in.nextLine());
                                System.out.println("Enter Category: ");
                                String category = in.nextLine();
                                List<Product> pList = service.getByTypePriceAndCategory(store1,price1,type1, category);
                                for (Product p : pList) {
                                    System.out.println(p.toString());
                                }
                                break;
                            case (0):
                                System.out.println("Back...");
                                exit2 = 0;
                                break;
                        }
                        System.out.println("1 - Sort by price.\n" +
                                "2 - Products by Category.\n" +
                                "3 - Products By name.\n" +
                                "4 - Products By Type.\n" +
                                "5 - Products By Price.\n" +
                                "6 - Products By Type and Price.\n" +
                                "7 - Products By Type and Price and Category.\n" +
                                "8 - Search product.\n" +
                                "0 - Return.");
                    }
                    break;
                case (2):
                    for (Client client: database.clients) {
                        System.out.println(client.toString());
                    }
                    break;
                case (3):
                    for (Order order: database.orders) {
                        System.out.println(order.toString());
                    }
                    break;
                case (4):
                    System.out.println("Enter client name: ");
                    String name = in.nextLine();
                    System.out.println("Enter client address: ");
                    String address = in.nextLine();
                    System.out.println("Enter client email: ");
                    String email = in.nextLine();
                    System.out.println("Enter client index: ");
                    int index = Integer.parseInt(in.nextLine());
                    System.out.println("Enter client phone: ");
                    String phone = in.nextLine();
                    Client client = new Client(name,address,email,index, phone);
                    service.addClient(database.clients, client);
                    break;
                case (5):
                    System.out.println("Enter Store name: ");
                    String storeName = in.nextLine();
                    Store store = new Store(storeName);
                    service.addStore(database.stores, store);
                    break;
                case (6) :

                    for (Store s: database.stores) {
                        System.out.println(s.getName());
                    }
                    System.out.println(" ");
                    System.out.println("Enter Store name for edit:");
                    String storeName1 = in.nextLine();
                    Store store1 = service.getStoreByName(database.stores, storeName1);

                    int exit1 = 1;
                    while (exit1 == 1)
                    {
                        System.out.println("1 - Add product.\n" +
                                "2 - Add category\n" +
                                "3 - Edit Store name.\n" +
                                "4 - Edit category.\n" +
                                "5 - Edit Product.\n" +
                                "6 - Delete Category.\n" +
                                "7 - Delete Product.\n" +
                                "8 - Delete this Store.\n" +
                                "9 - Return");
                         int num1 = Integer.parseInt(in.nextLine());
                        switch (num1)
                        {
                            case (1):
                                System.out.println("Available types: ");
                                for (ProductType type : ProductType.values() ) {
                                    System.out.println(type.toString());
                                }
                                System.out.println("Enter product type: ");
                                ProductType type = service.getType(in.nextLine());
                                System.out.println("Enter product name:  ");
                                String productName = in.nextLine();
                                System.out.println("Enter brand: ");
                                String brand = in.nextLine();
                                System.out.println("Enter color: ");
                                String color = in.nextLine();
                                System.out.println("Enter product price: ");
                                double price = Double.parseDouble(in.nextLine());
                                System.out.println("Enter product size: ");
                                double size = Double.parseDouble(in.nextLine());
                                System.out.println("Enter quantity: ");
                                int quantity = Integer.parseInt(in.nextLine());
                                Product product = new Product(type, productName, brand, color, price, size, quantity);
                                service.addProduct(store1,product);
                                break;

                            case (2):
                                System.out.println("Enter category name:");
                                String categoryName = in.nextLine();
                                Category category = new Category(categoryName);
                                service.addCategory(store1, category);
                                break;
                            case (3):
                                System.out.println("Enter new store name : ");
                                String newName = in.nextLine();
                                service.editName(store1, newName);
                                break;
                            case (4):
                                for (Category c: store1.getCategories()) {
                                    System.out.println(c.getName());
                                }
                                System.out.println("Enter category name");
                                String categoryName1 = in.nextLine();
                                Category category2 = service.getCategoryByName(store1,categoryName1);
                                int flag = 1;
                                while (flag == 1)
                                {
                                    int choice = Integer.parseInt(in.nextLine());
                                    switch (choice)
                                    {
                                        case (1):
                                            for (Product p : store1.getProducts()) {
                                                System.out.println(p.getName() + "  Size:" + p.getSize() + "  Product id: " + p.getId());
                                            }
                                            System.out.println("Enter product id :");
                                            int productId = Integer.parseInt(in.nextLine());
                                            Product addProduct = service.getProduct(store1,productId);
                                            service.addProduct(category2, addProduct);
                                            break;
                                        case (2):
                                            for (Product p : category2.getProducts()) {
                                                System.out.println(p.getName() + "  Size:" + p.getSize() + "  Product id: " + p.getId());
                                            }
                                            System.out.println("Enter product id :");
                                            int productId2 = Integer.parseInt(in.nextLine());
                                            Product removeProduct = service.getProduct(store1,productId2);
                                            service.deleteProduct(category2, removeProduct);
                                            break;
                                        case (3):
                                            System.out.println("Back...");
                                            flag = 0;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            case (5):

                                for (Product p : store1.getProducts()) {
                                    System.out.println(p.getName() + "  Size: " + p.getSize() + "  Color: " + p.getColor() + "  Quantity: " +p.getQuantity() + " id: " + p.getId());
                                }
                                System.out.println("Enter product id: ");
                                int id = Integer.parseInt(in.nextLine());
                                Product editProduct = service.getProduct(store1,id);
                                System.out.println("1 - Edit product type.\n" +
                                        "2 - Edit product name.\n" +
                                        "3 - Edit product brand.\n" +
                                        "4 - Edit product color.\n" +
                                        "5 - Edit product price.\n" +
                                        "6 - Edit product size.\n" +
                                        "7 - Edit product quantity.\n" +
                                        "0 - Return");

                                int exit3 = 1;
                                while (exit3 == 1) {

                                    System.out.println("1 - Edit product type.\n" +
                                            "2 - Edit product name.\n" +
                                            "3 - Edit product brand.\n" +
                                            "4 - Edit product color.\n" +
                                            "5 - Edit product price.\n" +
                                            "6 - Edit product size.\n" +
                                            "7 - Edit product quantity.\n" +
                                            "0 - Return");
                                    int num3 = Integer.parseInt(in.nextLine());
                                    switch(num3)
                                    {
                                        case(1):
                                            System.out.println("Available types: ");
                                            for (ProductType t : ProductType.values() ) {
                                                System.out.println(t.toString());
                                            }
                                            System.out.println("Enter new type:");
                                            String editType = in.nextLine();
                                            ProductType productType = service.getType(editType);
                                            service.changeType(store1,editProduct,productType);
                                            service.editType(editProduct,editType);
                                            break;
                                        case (2):
                                        {
                                            System.out.println("Enter new product name:");
                                            String editName = in.nextLine();
                                            service.changeName(store1,editProduct,editName);
                                            service.editName(editProduct,editName);
                                            break;
                                        }
                                        case(3):
                                            System.out.println("Enter new product brand:");
                                            String editBrand = in.nextLine();
                                            service.changeBrand(store1,editProduct,editBrand);
                                            service.editBrand(editProduct,editBrand);
                                            break;
                                        case (4):
                                            System.out.println("Enter new product color:");
                                            String editColor = in.nextLine();
                                            service.changeColor(store1,editProduct,editColor);
                                            service.editColor(editProduct,editColor);
                                            break;
                                        case (5):
                                            System.out.println("Enter new product price:");
                                            double editPrice = Double.parseDouble(in.nextLine());
                                            service.changePrice(store1,editProduct,editPrice);
                                            service.editPrice(editProduct,editPrice);
                                            break;
                                        case (6):
                                            System.out.println("Enter new product size:");
                                            double editSize = Double.parseDouble(in.nextLine());
                                            service.changeSize(store1,editProduct,editSize);
                                            service.editSize(editProduct,editSize);
                                            break;
                                        case (7):
                                            System.out.println("Enter new product quantity:");
                                            int editQuantity = Integer.parseInt(in.nextLine());
                                            service.changeQuantity(store1,editProduct,editQuantity);
                                            service.editQuantity(editProduct,editQuantity);
                                            break;
                                        case(0):
                                            exit3 = 0;
                                            break;
                                    }
                                }
                                break;

                            case (6):
                                for (Category c : store1.getCategories()) {
                                    System.out.println(c.getName());
                                }
                                System.out.println("Enter the name of the category to remove: ");
                                String deleteName = in.nextLine();
                                Category deleteCategory = service.getCategoryByName(store1, deleteName);
                                service.deleteCategory(store1, deleteCategory);
                                break;
                            case (7):
                                System.out.println("Enter product id: ");
                                int deleteId = Integer.parseInt(in.nextLine());
                                Product deleteProduct = service.getProduct(store1,deleteId);
                                service.deleteProduct(store1,deleteProduct);
                                break;
                            case (8):
                                service.deleteStore(database.stores,store1);
                                System.out.println("Store has been deleted.");
                                exit1 -=1;
                            case (9):
                                System.out.println("Back...");
                                exit1 = 0;
                            default:
                                break;
                        }
                    }
                    break;
                case (7):
                    for (Client c: database.clients) {
                        System.out.println(c.getName());
                    }
                    System.out.println(" ");
                    System.out.println("Enter Client Name name for edit:");
                    String clientName = in.nextLine();
                    Client editClient = service.getClient(database.clients,clientName);

                    int flag = 1;
                    while (flag == 1)
                    {
                        System.out.println("1 - Edit Client name.\n" +
                                "2 - Edit Client address.\n" +
                                "3 - Edit Client email.\n" +
                                "4 - Edit Client index.\n" +
                                "5 - Edit Client phone number.\n" +
                                "6 - Delete this client.\n" +
                                "0 - Return.");
                        int choice = Integer.parseInt(in.nextLine());
                        switch (choice)
                        {
                            case(1):
                               System.out.println("Enter new Client name");
                               String newName = in.nextLine();
                               service.editName(editClient,newName);
                               break;
                            case (2):
                                System.out.println("Enter new  address: ");
                                String newAddress = in.nextLine();
                                service.editAddress(editClient, newAddress);
                                break;
                            case (3):
                                System.out.println("Enter new email: ");
                                String newEmail = in.nextLine();
                                service.editEmail(editClient,newEmail);
                                break;
                            case (4):
                                System.out.println("Enter new index: ");
                                int newIndex = Integer.parseInt(in.nextLine());
                                service.editIndex(editClient,newIndex);
                                break;
                            case(5):
                                System.out.println("Enter new phone number: ");
                                String newPhone = in.nextLine();
                                service.editPhone(editClient,newPhone);
                                break;
                            case (6):
                                service.deleteClient(database.clients,editClient);
                                flag = 0;
                                break;
                            case (0):
                                System.out.println("Back...");
                                flag = 0;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case (8):
                    for (Store store2 : database.stores) {
                        System.out.println(store2.getName());
                    }
                    System.out.println("Enter store name: ");
                    String storeName2 = in.nextLine();
                    Store store2 = service.getStoreByName(database.stores,storeName2);
                    for (Client client1 : database.clients) {
                        System.out.println(client1.getName());
                    }
                    System.out.println("Enter client name: ");
                    String clientName1 = in.nextLine();
                    Client client1 = service.getClient(database.clients, clientName1);
                    for (Product product : store2.getProducts()) {
                        System.out.println(product.getName() + "  Size: " + product.getSize() + "  Color: " + product.getColor() + "  Quantity: " +product.getQuantity() + " id: " + product.getId());
                    }
                    System.out.println("Enter product id to order: ");
                    int id = Integer.parseInt(in.nextLine());
                    System.out.println("Enter quantity of product you want to order: ");
                    int quantity = Integer.parseInt(in.nextLine());
                    Product product = new Product();
                    product = service.getProduct(store2, id);
                    System.out.println("Enter number of order: ");
                    int number = Integer.parseInt(in.nextLine());
                    service.reduceQuantity(product,quantity);
                    Order order = service.makeOrder(store2, client1, product, quantity, number);
                    service.add(database.orders,order);
                    break;
                case (0):
                    System.out.println("Exit...");
                    exit -=1;
                    break;
                default:
                    break;
            }
        }
        database.save("stores.json","clients.json");
    }
}
