package webproduct.service.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webproduct.service.com.entity.Produto;
import webproduct.service.com.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produto;
	
	
	public String findByCodigo(Produto produto) {
		
		
		
		return null;
				
		
	}
	
	

}
