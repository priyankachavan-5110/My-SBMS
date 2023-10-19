package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
