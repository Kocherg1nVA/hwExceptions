package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(7, "T-shirt", 1650);
    Product product2 = new Product(8, "Book", 380);
    Product product3 = new Product(12, "Laptop", 69_999);

    @BeforeEach
    public void setup(){
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
    }

    @Test
    public void shouldFindById () {

        Product expected = product1;
        Product actual = repo.findById(7);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNotFindByNotExistId() {

        Product expected = null;
        Product actual = repo.findById(13);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        repo.remove(7);

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveProductWhenIdNotFound(){

        Assertions.assertThrows(NotFoundException.class, () -> {repo.remove(16);} );
    }
    @Test
    public void shouldNotAddProductWithAlreadyExistsId(){
        Product product4 = new Product(7, "Shoes", 6700);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {repo.add(product4);});
    }

    @Test
    public void shouldAddProduct(){

        Product product4 = new Product(22, "Shoes", 6700);

        repo.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
