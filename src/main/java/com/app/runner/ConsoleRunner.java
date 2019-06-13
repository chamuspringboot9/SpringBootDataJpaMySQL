package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		// 1. To insert records
		
		repo.save(new Product(10,"AAA",1.1));
		repo.save(new Product(11,"BBB",2.1));
		repo.save(new Product(12,"CCC",3.1));
		repo.save(new Product(13,"DDD",4.1));
		
		//2. To Update records
		
		repo.save(new Product(10,"XXX",5.1));
		
		//3. for Bulk insert
		
		List<Product> prs=Arrays.asList(
				new Product(100,"Hello",9.9),
				new Product(101,"How",8.9),
				new Product(102,"Are",7.9),
				new Product(103,"You",6.9));
		
		repo.saveAll(prs);
		
		//4. Fetch one row
		
		Optional<Product> p=repo.findById(18);
		if(p.isPresent()) {
			Product pr=p.get();
			System.out.println(pr.getProdCode());
		}else
		{
			System.out.println("Row not Found");
		}
		
		//5. Fetch all Rows
		
		List<Product> list=repo.findAll();
		list.forEach(System.out::println);
		
		//6. Delete a row
		
		repo.deleteById(10);
		
		//7. Delete all rows
		
		repo.deleteAll();
		repo.deleteAllInBatch();
	}
}
