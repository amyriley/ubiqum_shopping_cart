import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CartTest {

    private Cart cartUnderTest = new Cart();

    @Test
    public void add_AddsProductToCart() {
        Product product = new Product("test-product-1", 2);

        cartUnderTest.add(product);

        List<Product> resultProducts = cartUnderTest.getProducts();

        assertEquals(1, resultProducts.size());
        assertEquals(product, resultProducts.get(0));
    }

    @Test
    public void remove_RemovesProductFromCart() {
        Product product = new Product("test-product-1", 5);

        cartUnderTest.add(product);
        cartUnderTest.remove(product);

        List<Product> resultProducts = cartUnderTest.getProducts();

        assertEquals(0, resultProducts.size());
    }

    @Test
    public void totalPrice_WhenNoDiscountsApplied_CalculatesCorrectTotalPrice() {
        Product product1 = new Product("product1", 5);
        Product product2 = new Product("product2", 10);
        Product product3 = new Product("product3", 20);
        Product product4 = new Product("product4", 30);

        cartUnderTest.add(product1);
        cartUnderTest.add(product2);
        cartUnderTest.add(product3);
        cartUnderTest.add(product4);

        float totalPrice = cartUnderTest.totalPrice();

        assertEquals(65, totalPrice, 0);
    }

    @Test
    public void totalPrice_WhenMoreThanFourProducts_TenPercentDiscountApplied() {
        Product product1 = new Product("product1", 5);
        Product product2 = new Product("product2", 5);
        Product product3 = new Product("product3", 5);
        Product product4 = new Product("product4", 5);
        Product product5 = new Product("product5", 5);

        cartUnderTest.add(product1);
        cartUnderTest.add(product2);
        cartUnderTest.add(product3);
        cartUnderTest.add(product4);
        cartUnderTest.add(product5);

        float totalPrice = cartUnderTest.totalPrice();

        assertEquals(22.50, totalPrice, 0);
    }

    @Test
    public void totalPrice_WhenFourOfTheSameProduct_TotalPriceIsEqualToThree() {
        Product product1 = new Product("product1", 5);

        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);

        float totalPrice = cartUnderTest.totalPrice();

        assertEquals(15, totalPrice, 0);
    }

    @Test
    public void totalPrice_WhenFiveOfTheSameProduct_TotalPriceIsEqualToFourMinusTenPerecent() {
        Product product1 = new Product("product1", 5);

        float expectedPrice = (5 * 4) * 0.9f;

        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);

        float totalPrice = cartUnderTest.totalPrice();

        assertEquals(expectedPrice, totalPrice, 0);
    }

    @Test
    public void totalPrice_WhenEightOfTheSameProduct_TotalPriceIsEqualToSixMinusTenPercent() {
        Product product1 = new Product("product1", 5);

        float expectedPrice = (5 * 6) * 0.9f;

        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);
        cartUnderTest.add(product1);

        float totalPrice = cartUnderTest.totalPrice();

        assertEquals(expectedPrice, totalPrice, 0);
    }

    @Test
    public void replaceProduct_ReplacesAProductInCartWithADifferentProduct() {
        Product productToBeReplaced = new Product("product-to-be-replaced", 2);
        Product replacementProduct = new Product("replacement-product", 2);

        cartUnderTest.add(productToBeReplaced);
        cartUnderTest.replaceProduct(productToBeReplaced, replacementProduct);

        List<Product> resultProducts = cartUnderTest.getProducts();

        assertEquals(replacementProduct, resultProducts.get(0));
    }


}