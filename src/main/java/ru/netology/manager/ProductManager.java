package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.Repository;

public class ProductManager {
    private Repository repository;

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
        System.out.println("manager done");
    }

}
