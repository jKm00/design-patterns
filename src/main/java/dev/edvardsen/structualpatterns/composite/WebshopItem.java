package dev.edvardsen.structualpatterns.composite;

import java.util.Iterator;
import java.util.Set;

/**
 * The component in the composite design pattern. Represents an item that is
 * sold in the webshop. This can be both a standalone product or a composite of
 * multiple products.
 */
public abstract class WebshopItem {

  private String name;
  // Number between 0 and 1. E.g. 0.2 beging 20% of
  private double discount;

  protected Set<WebshopItem> children = null;

  public WebshopItem(String name, double discount) {
    this.name = name;
    this.discount = discount;
  }

  public String getName() {
    return this.name;
  }

  public abstract double getOriginalPrice();

  public abstract double getPrice();

  public double getDiscount() {
    return this.discount;
  }

  public void addProduct(WebshopItem item) throws IllegalAccessException {
    throw new IllegalAccessException("A webshop item does not allow children by default");
  }

  public void removeProduct(WebshopItem item) throws IllegalAccessException {
    throw new IllegalAccessException("A webshop item does not allow children by default");
  }

  public Iterator<WebshopItem> getIterator() {
    return null;
  }

}
