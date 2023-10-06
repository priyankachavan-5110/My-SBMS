package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Product;
import in.ashokit.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo repo;
	
	@Override
	public Product addProduct(Product product) {
		Product save = repo.save(product);
		
		return save;
	}

	@Override
	public List<Product> getAllProduct() {
		 
		return repo.findAll();
	}

	@Override
	public Product getProductById(Integer pid) {
		Optional<Product> findById = repo.findById(pid);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

}
