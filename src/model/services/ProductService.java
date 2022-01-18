package model.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {

	public double filteredSum(List<Product> list, Predicate<Product> condition) {
		/*
		 * recebe uma lista de produtos e soma apenas as que o predicate passado seja
		 * verdadeiro
		 */
		double sum = 0.0;

		for (Product product : list) {
			if (condition.test(product)) {
				sum += product.getPrice();
			}
		}
		return sum;
	}

	public void addTax(Product product, Consumer<Product> consumer) {
		// recebe um produto e aplica um consumer nesse produto
		consumer.accept(product);
	}

	public <T> List<T> listProductType(List<Product> listProduct, Function<Product, T> func) {
		/*
		 * recebe uma lista de produto e retorna um tipo T a partir da Function passada
		 * como parametro
		 */
		List<T> names = new ArrayList<>();
		for (Product p : listProduct) {
			names.add(func.apply(p));
		}

		return names;

	}

	public void sortProducts(List<Product> list, Comparator<Product> comparator) {
		/*
		 * recebe uma lista de produto e utiliza o metodo sort com base em um comparator
		 * passado como parametro
		 */
        
		list.sort(comparator);
	}

}
