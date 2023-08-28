package webproduct.service.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webproduct.service.com.entity.Produto;
import webproduct.service.com.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto findByProdutoId(Integer id) {
		Optional<Produto> prod=this.produtoRepository.findById(id);
		
		if (prod.isPresent()&&!prod.isEmpty()) {
			Produto produto=prod.get();
			return produto;
		}	
		return null;			
		
	}
	
	

}
