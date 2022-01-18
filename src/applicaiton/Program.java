package applicaiton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import entities.Product;
import model.services.ProductService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Notbook", 1200.00));
		list.add(new Product("Table", 350.00));
		list.add(new Product("HD Case", 80.90));
		list.add(new Product("Açúcar", 5.0));

		ProductService ps = new ProductService();
		// usando Predicate-  função que retorna se a primeira letra de um nome é igual a  M
		double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'M');
		System.out.println("Predicate : ");
		System.out.println("Sum = " + String.format("%.2f", sum));

		// usando Function - função que pega um preço de um produto
		System.out.println("\nFunction : ");
		List<Double> prices = ps.listProductType(list, p -> p.getPrice());
		prices.forEach(System.out::println);
		
		// usando Function 2 -função que pega o nome  de um produto
		System.out.println("\nFunction  2: ");
		List<String> names = ps.listProductType(list, p -> p.getName());
		names.forEach(System.out::println);

		// usando Consumer- função que aumenta o preço de um produto
		System.out.println("\nConsumer : ");
		Product product = list.get(0);
		ps.addTax(product, p -> p.setPrice(Math.floor(p.getPrice() * 1.1)));
		System.out.println(product);

		// usando Comparator - função que compara um produto com o outro com base no nome
		System.out.println("\nComparator : ");
		ps.sortProducts(list, (p1,p2)->p1.getName().compareTo(p2.getName()));
		
	  
		 

	}

}
