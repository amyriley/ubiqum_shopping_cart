import java.util.*;

public class Cart {

    private List<Product> products = new ArrayList<>();

    public Cart() {
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public float totalPrice() {

        float discountTotal = 0;
        float total = 0;

        Map<String, Integer> countsByProductName = new HashMap<>();

        for (Product product : products) {
            total += product.getPrice();

            int existingProductCount = countsByProductName.getOrDefault(product.getName(), 0);
            int newProductCount = existingProductCount + 1;

            if (newProductCount % 4 == 0) {
                discountTotal += product.getPrice();
            }

            countsByProductName.put(product.getName(), newProductCount);
        }

        total -= discountTotal;

        if (products.size() > 4) {
            float discount = (total / 100) * 10;
            total = total - discount;
        }

        return total;
    }

    public void replaceProduct(Product productToBeReplaced, Product replacementProduct) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName() == productToBeReplaced.getName()) {
                products.set(i, replacementProduct);
            }
        }
    }

    @Override
    public String toString() {
        return "cart with: " + products;
    }
}
