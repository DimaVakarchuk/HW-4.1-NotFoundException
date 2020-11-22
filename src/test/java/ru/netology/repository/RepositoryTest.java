package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryTest {
    private final Repository repository = new Repository();

    private final Product first = new Book(1, "Super book", 1, "Super Author");
    private final Product second = new Book(2, "Great book", 2, "Great Author");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
    }

    @Test
    void removeById() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(3));
    }
}