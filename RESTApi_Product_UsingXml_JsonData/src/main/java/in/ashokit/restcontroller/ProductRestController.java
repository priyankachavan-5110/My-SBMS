package in.ashokit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.Entity.Product;
import in.ashokit.service.ProductService;
import jakarta.websocket.server.PathParam;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	/*
	 * if we don't write Consume & produce then default it support JSON format.now XMl format is out-dated 
	 */
	
	@PostMapping(path="product",consumes= {"application/xml","application/json"},
								produces={"application/xml","application/json"})//in which format consumer take the input data from body
	public ResponseEntity<Product>addProduct(@RequestBody Product product)
	{
		Product saveProduct= service.addProduct(product);
		return new ResponseEntity<>(saveProduct,HttpStatus.CREATED);
		
	}
	
	@GetMapping(path="/products",produces={"application/xml","application/json"})//in which format provider give output data
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> products = service.getAllProduct();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping(path="/product/{pid}",produces={"application/xml","application/json"})
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid)
	{
		Product productById = service.getProductById(pid);
		return new ResponseEntity<Product>(productById,HttpStatus.OK) ;
	}
	

}
