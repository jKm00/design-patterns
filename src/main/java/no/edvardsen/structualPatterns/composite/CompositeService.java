package no.edvardsen.structualPatterns.composite;

/**
 * Entry point for the composite design pattern
 * 
 * In this example I try to implement a webshop acrhitecture where a product
 * can be a standalone hardware component like a pc mouse, keyboard, monitor,
 * etc...
 * However, the store should also be able to combine products to create set,
 * like a gaming set consisting of a computer, monitor, mouse and keyboard.
 */
public class CompositeService {

  public static void runExample() {
    System.out.println("Creating some products...\n");

    WebshopItem mouse = new Product("Logitech G Pro", 699, 0.2);
    WebshopItem keyboard = new Product("Steelseries Apex Pro", 2299, 0);
    WebshopItem monitor = new Product("Samsung 32\" gamingskjerm", 3490, 0.1);
    WebshopItem pc = new Product("Komplett-PC a196 EPic Gaming RGB", 28999, 0.15);

    System.out.println(String.format("Name: %s, original price: %.2f, price: %.2f", mouse.getName(),
        mouse.getOriginalPrice(), mouse.getPrice()));
    System.out.println(String.format("Name: %s, original price: %.2f, price: %.2f", keyboard.getName(),
        keyboard.getOriginalPrice(), keyboard.getPrice()));
    System.out.println(String.format("Name: %s, original price: %.2f, price: %.2f", monitor.getName(),
        monitor.getOriginalPrice(), monitor.getPrice()));
    System.out.println(
        String.format("Name: %s, original price: %.2f, price: %.2f", pc.getName(), pc.getOriginalPrice(),
            pc.getPrice()));

    System.out.println("\nCreating a gaming set...\n");

    WebshopItem pcSet = new ProductSet("Full gaming setup", 0.3);
    try {
      pcSet.addProduct(mouse);
      pcSet.addProduct(keyboard);
      pcSet.addProduct(monitor);
      pcSet.addProduct(pc);
    } catch (IllegalAccessException e) {
      System.out.println("Error: " + e.getMessage());
    }

    System.out.println(
        String.format("Name: %s, original price: %.2f, price: %.2f", pcSet.getName(), pcSet.getOriginalPrice(),
            pcSet.getPrice()));

  }

}
