package in.ashokit.service;

import java.util.List;

import in.ashokit.Entity.Product;

public interface ProductService {
	public Product addProduct(Product product);
	public List<Product> getAllProduct(); 
	public Product getProductById(Integer pid);

}
