package webproduct.service.com.repository;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webproduct.service.com.entity.Produto;

@ComponentScan("webproduct.service.com.entity")
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	
	List<Produto> findByproductcode (String codProduto);
	

}
