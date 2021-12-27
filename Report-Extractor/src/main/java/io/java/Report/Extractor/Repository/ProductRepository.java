package io.java.Report.Extractor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.java.Report.Extractor.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value ="select * from product",nativeQuery = true)
	public List<Product> getAllProducts();
}
