package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List <Product> list = new ArrayList<>();
		
		System.out.print("Entre com o numero de produtos: ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Produto #" + i + " data: ");
		//	System.out.println();
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			
			if(ch == 'c') {
				list.add(new Product(name, price));
			}
			
			else if(ch == 'u') {
				System.out.print("Data de fabricação (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				list.add(new UsedProduct(name, price, date));
			}
			
			else {
				System.out.print("Taxa de importação: ");
				double customsFee = sc.nextDouble();
				
				list.add(new ImportedProduct(name, price, customsFee));
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Etiquetas de Preço: ");
		
		
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		
		sc.close();
	}

}
