import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Inventory
        Inventory inventory = new Inventory();
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Add some initial products to the inventory
        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 1200.00));
        inventory.addProduct(new Product("P002", "Smartphone", "Electronics", 800.00));
        inventory.addProduct(new Product("P003", "Table", "Furniture", 150.00));
        inventory.addProduct(new Product("P004", "Banana", "Fruits", 2.50));

        // Main loop to process user commands
        while (true) {
            // Display command options to the user
            System.out.println("Enter command word:");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. View");
            System.out.println("5. Search");
            System.out.println("6. Exit");
            // Read user command
            String command = scanner.nextLine().trim().toLowerCase();
            switch (command.toLowerCase()) {
                case "add":
                    try {
                        // Prompt user for product details
                        System.out.print("Product ID: ");
                        String productId = scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        // Create and add new product to inventory
                        Product product = new Product(productId, name, category, price);
                        inventory.addProduct(product);
                        System.out.println("Product added successfully.");
                    } catch (NumberFormatException e) {
                        // Handle invalid price input
                        System.out.println("Invalid input. Please enter correct data types.");
                    }
                    break;
                case "update":
                    // Prompt user for product ID to update
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    // Prompt user for new product details
                    System.out.print("New Name (leave blank to skip): ");
                    String newName = scanner.nextLine();
                    System.out.print("New Category (leave blank to skip): ");
                    String newCategory = scanner.nextLine();
                    System.out.print("New Price (leave blank to skip): ");
                    String priceInput = scanner.nextLine();
                    Double newPrice = null;
                    if (!priceInput.isEmpty()) {
                        try {
                            newPrice = Double.parseDouble(priceInput);
                        } catch (NumberFormatException e) {
                            // Handle invalid price input
                            System.out.println("Invalid price input.");
                            break;
                        }
                    }
                    // Update product in inventory
                    boolean updated = inventory.updateProduct(updateId,
                            newName.isEmpty() ? null : newName,
                            newCategory.isEmpty() ? null : newCategory,
                            newPrice);
                    System.out.println(updated ? "Product updated." : "Product not found.");
                    break;
                case "delete":
                    // Prompt user for product ID to delete
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    // Delete product from inventory
                    boolean deleted = inventory.deleteProduct(deleteId);
                    System.out.println(deleted ? "Product deleted." : "Product not found.");
                    break;
                case "view":
                    // Display inventory header
                    System.out.println();
                    System.out.println("ID         Name          Category      Price");
                    System.out.println("---------------------------------------------------");
                    // Display all products in inventory
                    for (Product p : inventory.viewInventory()) {
                        System.out.printf("%-10s %-13s %-13s $%.2f%n", p.getProductId(), p.getName(), p.getCategory(),
                                p.getPrice());
                    }
                    System.out.println();
                    break;
                case "search":
                    while (true) {
                        // Prompt user for product name to search
                        System.out.print("Enter Name of Product: ");
                        String keyword = scanner.nextLine();

                        // If the user enters an empty input
                        if (keyword.isEmpty()) {
                            System.out.print("Incorrect input. Try again or enter x to exit: ");
                            keyword = scanner.nextLine();
                            if (keyword.equals("x")) {
                                break;
                            }
                            continue; // Prompt for input again if it's empty
                        }

                        // Search for the product
                        List<Product> results = inventory.searchProduct(keyword);
                        if (results.isEmpty()) {
                            // Product not found, prompt to try again or exit
                            System.out.print("Product not found. Try again by hitting enter or type x to exit:");
                            keyword = scanner.nextLine();
                            if (keyword.equals("x")) {
                                break;
                            }
                        } else {
                            // Product found, display the results
                            for (Product p : results) {
                                System.out.println("ID: " + p.getProductId() + ", Name: " + p.getName() +
                                        ", Category: " + p.getCategory() + ", Price: " + p.getPrice());
                            }
                            break; // Exit after displaying the results
                        }
                    }
                    break;
                case "exit":
                    // Exit the application
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0);
                default:
                    // Handle invalid command
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}