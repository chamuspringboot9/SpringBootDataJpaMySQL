package com.app.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		repo.save(new Product(13,"DDD",2.1));
		
		//2. To Update records
		
		repo.save(new Product(10,"XXX",5.1));
		
		//3. for Bulk insert
		
		List<Product> prs=Arrays.asList(
				new Product(100,"Hello",9.9),
				new Product(101,"How",2.1),
				new Product(102,"Are",7.9),
				new Product(103,"You",2.1));
		
		repo.saveAll(prs);
		
		/*//4. Fetch one row
		
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
	
		
		// Different types of FindAll() methods
		
		//8. findAll() method
		
		List<Product> list=repo.findAll();
		list.forEach(System.out::println); 
		
		//9. findAll(Sort)
		
		repo.findAll(Sort.by(Direction.DESC, "prodCode")).forEach(System.out::println);

		
		//10. findAll(Pageable)
		
		PageRequest p=PageRequest.of(1, 3);
		repo.findAll(p).forEach(System.out::println);
		
		
		
		//11-a. findAll(Example)
		
		Product p=new Product();
		p.setProdCost(2.1);
		Example<Product> ex1=Example.of(p);
		repo.findAll(ex1).forEach(System.out::println);
		
		
		//11-b. With Sorting
		
		Product p=new Product();
		p.setProdCost(2.1);
		Example<Product> ex2=Example.of(p);
		repo.findAll(ex2, Sort.by(Direction.DESC, "prodCode")).forEach(System.out::println);
		
		
		//11-c. With Pagination
		
		Product p=new Product();
		p.setProdCost(2.1);
		Example<Product> ex3=Example.of(p);
		repo.findAll(ex3, PageRequest.of(0, 2)).forEach(System.out::println);
		*/
		
		//12. findAllById()
		
		repo.findAllById(Arrays.asList(101,103)).forEach(System.out::println);
}
}
