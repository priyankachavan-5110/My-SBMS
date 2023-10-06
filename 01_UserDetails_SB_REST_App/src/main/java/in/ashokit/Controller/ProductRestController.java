package in.ashokit.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.Model.Product;

@RestController
public class ProductRestController {
	
	
	@PostMapping("/product")//to insert data
	public String saveProduct(@RequestBody Product p)//saved data through request body in json formaet
	{
		System.out.println(p);
		return "Product saved";
		
	}
	@GetMapping("/product/{pid}")//return product based on id
	public Product getProduct(@PathVariable Integer pid)//whatever id we get that id represent as pathvariable
	{ Product p=null;
		if(pid==100)
		{
			p=new Product(100,"Mouse",345.00);
		}
		else if(pid==101)
		{
			p=new Product(101,"HD",945.00);
		}
		return p;//return product based on given id
	}
	@GetMapping("/products")
	public List<Product>getProducts()//this method return data in collection form
									//but we receive data n JSON format
	{
		Product p1=new Product(100,"Mouse",345.00);
		Product p2=new Product(101,"HD",945.00);
		List<Product> products=Arrays.asList(p1,p2);//it gives list of products
		return products;
		
	}
}
