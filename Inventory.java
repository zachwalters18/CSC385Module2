import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        // Constructor to initialize the inventory
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        // Add a product to the inventory
        products.add(product);
    }

    public boolean updateProduct(String productId, String name, String category, Double price) {
        // Update a product in the inventory using mulitple checking conditions
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                if (name != null && !name.isEmpty()) {
                    product.setName(name);
                }
                if (category != null && !category.isEmpty()) {
                    product.setCategory(category);
                }
                if (price != null) {
                    product.setPrice(price);
                }
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(String productId) {
        // Remove a product from the inventory
        return products.removeIf(product -> product.getProductId().equals(productId));
    }

    public List<Product> viewInventory() {
        // Return a copy of the list to prevent direct modification of the inventory
        return products;
    }

    public List<Product> searchProduct(String keyword) {
        // Search for products based on the keyword in the name or category
        List<Product> results = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(lowerKeyword)
                    || p.getCategory().toLowerCase().contains(lowerKeyword)) {
                results.add(p);
            }
        }
        return results;
    }
}
