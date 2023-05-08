package dev.edvardsen.structualpatterns.composite;

import java.util.HashSet;
import java.util.Iterator;

/**
 * The compiste in the composite design pattern. Represents a combination of
 * leaf and/or other composite making up a complete set
 */
public class ProductSet extends WebshopItem {

  public ProductSet(String name, double discount) {
    super(name, discount);

    this.children = new HashSet<>();
  }

  @Override
  public double getOriginalPrice() {
    var it = this.getIterator();

    double originalPrice = 0;
    while (it.hasNext()) {
      var item = it.next();
      originalPrice += item.getPrice();
    }

    return originalPrice;
  }

  @Override
  public double getPrice() {
    return this.getOriginalPrice() * (1 - this.getDiscount());
  }

  @Override
  public void addProduct(WebshopItem item) {
    this.children.add(item);
  }

  @Override
  public void removeProduct(WebshopItem item) {
    this.children.remove(item);
  }

  @Override
  public Iterator<WebshopItem> getIterator() {
    return this.children.iterator();
  }

}
