package dev.edvardsen.structualpatterns.composite;

/**
 * The leaf of the composite design pattern. Represents a single standalone
 * product
 */
public class Product extends WebshopItem {

  private double price;

  public Product(String name, double price, double discount) {
    super(name, discount);

    this.price = price;
  }

  @Override
  public double getOriginalPrice() {
    return this.price;
  }

  @Override
  public double getPrice() {
    return this.price * (1 - this.getDiscount());
  }

}
