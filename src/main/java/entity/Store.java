package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {
    private String name;
    private  List<Product> products = new ArrayList<>();
    private  List<Category> categories = new ArrayList<>();

    public Store() {

    }

    public Store(String name)
    {
        this.name = name;
    }

    public Store(String name, List<Product> products, List<Category> categories) {
        this.name = name;
        this.products = products;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name) &&
                Objects.equals(products, store.products) &&
                Objects.equals(categories, store.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products, categories);
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", products=" + products +
                ", categories=" + categories +
                '}';
    }

}
