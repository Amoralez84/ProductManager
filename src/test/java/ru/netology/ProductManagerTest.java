package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Тестирование dot com", 1121, "Роман Савин");
    private Book book2 = new Book(2, "Tom Clancy's The Division 2. Фальшивый рассвет", 337, "Алекс Ирвин");
    private Book book3 = new Book(3, "Цифровая крепость", 286, "Дэн Браун");
    private Book book4 = new Book(4, "Код да Винчи", 1130, "Дэн Браун");
    private Book book5 = new Book(5, "Фантастические твари и где они обитают", 459, "Дж.К.Роулинг");
    private Smartphone smartphone1 = new Smartphone(6, "iPhone 12 Pro Max 256GB", 119980, "Apple");
    private Smartphone smartphone2 = new Smartphone(7, "iPhone 11 128GB", 59980, "Apple");
    private Smartphone smartphone3 = new Smartphone(8, "Galaxy S21 8/128GB", 74980, "Samsung");
    private Smartphone smartphone4 = new Smartphone(9, "P30 pro 6/128GB", 41575, "Huawei");
    private Smartphone smartphone5 = new Smartphone(10, "Mi 10T pro 8/256GB", 45980, "Xiaomi");


    @BeforeEach
    public void shouldAdd() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("Цифровая крепость");
        Product[] expected = new Product[]{book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorMoreThatOne() {
        Product[] actual = manager.searchBy("Дэн Браун");
        Product[] expected = new Product[]{book3, book4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("Mi 10T pro 8/256GB");
        Product[] expected = new Product[]{smartphone5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNonExistedProduct() {
        Product[] actual = manager.searchBy("Пауло Коэльо");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}