package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void shouldAddProducts() {
        Product product1 = new Product(7, "T-shirt", 1650);
        Product product2 = new Product(8, "Book", 380);
        Product product3 = new Product(12, "Laptop", 69_999);
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveById() {
        Product product1 = new Product(7, "T-shirt", 1650);
        Product product2 = new Product(8, "Book", 380);
        Product product3 = new Product(12, "Laptop", 69_999);
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(7);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById () {
        Product product1 = new Product(7, "T-shirt", 1650);
        Product product2 = new Product(8, "Book", 380);
        Product product3 = new Product(12, "Laptop", 69_999);

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product expected = product1;
        Product actual = repo.findById(7);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindById() {
        Product product1 = new Product(7, "T-shirt", 1650);
        Product product2 = new Product(8, "Book", 380);
        Product product3 = new Product(12, "Laptop", 69_999);
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product expected = null;
        Product actual = repo.findById(13);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldThrowWhenIdNotFound(){
        Product product1 = new Product(7, "T-shirt", 1650);
        Product product2 = new Product(8, "Book", 380);
        Product product3 = new Product(12, "Laptop", 69_999);

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {repo.remove(16);} );
    }

}
