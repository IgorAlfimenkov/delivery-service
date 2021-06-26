package Dao;

import entity.Category;
import entity.Product;
import entity.ProductType;
import entity.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreDao implements IStoreDao {

    static Database db = Database.getInstance();

    public void addStore(List<Store> stores,Store store)
    {
        db.addStore(stores, store);
    }

    public void deleteStore(List<Store> stores, Store store)
    {
        db.deleteStore(stores, store);
    }
    public void addProduct(Store store, Product product)
    {
        db.addProduct(store,product);
    }

    public void deleteProduct(Store store, Product product)
    {
        db.deleteProduct(store, product);
    }

    public  void addCategory(Store store, Category category)
    {
        db.addCategory(store, category);
    }

    public void deleteCategory(Store store, Category category)
    {
        db.deleteCategory(store, category);
    }

    public List<Product> getProductsByCategory(Store store, String category)
    {
        for (Category c : store.getCategories()) {

            if(c.getName().toLowerCase().equals(category.toLowerCase()))
            {
                return c.getProducts();
            }
        }
        return null;
    }

    public void editName(Store store, String name)
    {
        store.setName(name);
    }

    @Override
    public void buyProduct(Store store, Product product) {

        for (Product p : store.getProducts()) {
            if(p.getName().toLowerCase().equals(product.getName().toLowerCase()) && p.getPrice() == product.getPrice())
            {
                int num = p.getQuantity();
                int count = product.getQuantity();
                int newQuantity = num - count;
                p.setQuantity(newQuantity);
            }
        }
    }

    @Override
    public Store getStoreByName(List<Store> stores, String name) {

        for (Store store : stores) {
            if(store.getName().equals(name))
            {
                return store;
            }
        }

        return null;
    }

    @Override
    public List<Store> getAll() {
        return db.getAllStores();
    }

    @Override
    public Product getByNameAndSize(Store store, String name, double size) {

        for (Product product : store.getProducts()) {
            if(product.getName().equals(name) && product.getSize() == size)
            {
                return product;
            }
        }
        return null;
    }

    @Override
    public Category getCategoryByName(Store store, String name) {
        for (Category category : store.getCategories()) {
            if(category.getName().equalsIgnoreCase(name)) return category;
        }
        return null;
    }

    public List<Product> sortProducts (Store store)
    {
        List<Product> productList = store.getProducts();
        Collections.sort(productList);
        return productList;
    }

    @Override
    public void changeType(Store store, Product product, ProductType productType) {
        for (Category category : store.getCategories()) {
            for (Product p : category.getProducts()) {
                if(p.equals(product))
                {
                    p.setType(productType);
                }
            }
        }
    }

    @Override
    public void changeName(Store store, Product product, String name) {
        for (Category category : store.getCategories()) {
            for (Product p : category.getProducts()) {
                if(p.equals(product))
                {
                    p.setName(name);
                }
            }
        }
    }

    @Override
    public void changeBrand(Store store, Product product, String brand) {

        for (Category category : store.getCategories()) {
            for (Product p : category.getProducts()) {
                if(p.equals(product))
                {
                    p.setBrand(brand);
                }
            }
        }
    }

    @Override
    public void changeColor(Store store, Product product, String color) {

        for (Category category : store.getCategories()) {
            for (Product p : category.getProducts()) {
                if(p.equals(product))
                {
                    p.setColor(color);
                }
            }
        }
    }

    @Override
    public void changePrice(Store store, Product product, Double price) {

        for (Category category : store.getCategories()) {
            for (Product p : category.getProducts()) {
                if(p.equals(product))
                {
                    p.setPrice(price);
                }
            }
        }
    }

    @Override
    public void changeSize(Store store, Product product, Double size) {

        for (Category category : store.getCategories()) {
            for (Product p : category.getProducts()) {
                if(p.equals(product))
                {
                    p.setSize(size);
                }
            }
        }
    }

    @Override
    public void changeQuantity(Store store, Product product, int quantity) {

        for (Category category : store.getCategories()) {
            for (Product p : category.getProducts()) {
                if(p.equals(product))
                {
                    p.setQuantity(quantity);
                }
            }
        }
    }

    @Override
    public void reduceQuantity(Product product, int count) {
        product.setQuantity(product.getQuantity() - count);
    }

    public List<Product> getByPrice(Store store, double price)
    {
        List<Product> productList = new ArrayList<Product>();

        for (Product p: store.getProducts()) {
            if(p.getPrice() == price)
            {
                productList.add(p);
            }
        }

        return productList;
    }

    public List<Product> getByName(Store store, String name)// this method returns List of because they may have the same name
    {
        List<Product> productList = new ArrayList<Product>();

        for (Product p: store.getProducts()) {
            if(p.getName().equalsIgnoreCase(name))
            {
                productList.add(p);
            }
        }

        return productList;
    }

    public List<Product> getByType(Store store, String type)
    {
        List<Product> productList = new ArrayList<Product>();

        for (Product p: store.getProducts()) {
            if(p.getType().toString().equalsIgnoreCase(type))
            {
                productList.add(p);
            }
        }

        return productList;
    }

    public List<Product> getByTypeAndPrice(Store store, String type, double price)
    {
        List<Product> productList = new ArrayList<Product>();

        for (Product p: store.getProducts()) {
            if(p.getType().toString().equalsIgnoreCase(type) && p.getPrice() == price)
            {
                productList.add(p);
            }
        }

        return productList;
    }

    public  List<Product> getByTypePriceAndCategory(Store store, double price, String type, String category)
    {
        List<Product> resultList = new ArrayList<Product>();
        List<Product> sortList = new ArrayList<Product>();
        for (Category c : store.getCategories()) {
            if(c.getName().equalsIgnoreCase(category)) sortList = c.getProducts();
        }

        for (Product p : sortList) {
            if(p.getType().toString().equalsIgnoreCase(type) && p.getPrice() == price)
            {
                resultList.add(p);
            }
        }

        return resultList;
    }

    public Product getProduct(Store store, int id)
    {
        for (Product product : store.getProducts()) {
            if(product.getId() == id) return product;
        }
        return null;
    }


}
