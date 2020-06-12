package com.ds.service;

import com.ds.pojo.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {

    private List<Product> sandwichList;

    private List<Product> drinks;

    private List<Product> sideDishes;

    public ProductService() {
        sandwichList = Arrays.asList(
                new Product(1,"X-Burger", new BigDecimal("6.60")),
                new Product(2, "X-Salada", new BigDecimal("5.20")),
                new Product(3, "X-Bacon", new BigDecimal("8.90"))
        );

        drinks = Arrays.asList(
                new Product(4, "Coke 300ml", new BigDecimal("5.60")),
                new Product(5, "Pepsi 300ml", new BigDecimal("4.80")),
                new Product(6, "Guarana 300ml", new BigDecimal("4.50")),
                new Product(7, "Sprite 300ml", new BigDecimal("5.00"))
        );

        sideDishes = Arrays.asList(
                new Product(8, "Fries", new BigDecimal("6.00")),
                new Product(9, "Onion rings", new BigDecimal("6.80"))
        );
    }

    public Product findProductById(int id) {
        var productList = combineProductLists(sandwichList, drinks, sideDishes);
        return productList.stream()
                .filter(product -> id == product.getId())
                .findFirst()
                .orElse(new Product());
    }

    @SafeVarargs
    public final List<Product> combineProductLists(List<Product>... products) {
        return Stream.of(products)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public BigDecimal getTotal(List<Product> products) {
        return products.stream()
                .map(product -> product.getQuantity().multiply(product.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Product> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichList(List<Product> sandwichList) {
        this.sandwichList = sandwichList;
    }

    public List<Product> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Product> drinks) {
        this.drinks = drinks;
    }

    public List<Product> getSideDishes() {
        return sideDishes;
    }

    public void setSideDishes(List<Product> sideDishes) {
        this.sideDishes = sideDishes;
    }

    @Override
    public String toString() {
        return "ProductService{" +
                "sandwichList=" + sandwichList +
                ", drinks=" + drinks +
                ", sideDishes=" + sideDishes +
                '}';
    }

}
