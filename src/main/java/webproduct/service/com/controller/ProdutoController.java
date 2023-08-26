package webproduct.service.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import webproduct.service.com.entity.Produto;
import webproduct.service.com.repository.ProdutoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/product/")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public List<Produto> findAll() {

		return produtoRepository.findAll();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduto(@RequestBody Produto produto) {

		this.produtoRepository.save(produto);
		
		return "Dados Salvos";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Produto updatePessoaFisica(@PathVariable Integer id,
			@RequestBody Produto produto) {

		Produto prod = this.produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto não existe com o id:" + id));

		produto.setNome(prod.getNome());
		produto.setProductcode(prod.getProductcode());
		produto.setFornecedor(prod.getFornecedor());
		produto.setValor(prod.getValor());

		Produto updateProduto = this.produtoRepository.save(produto);

		return updateProduto;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Produto removeProduto(@PathVariable("id") Integer id) {
		
		Produto pessoa=produtoRepository.findById(id).orElseThrow(()
    			-> new ResourceNotFoundException("Produto não existe com o id :" + id) );
		
		this.produtoRepository.deleteById(id);
		
		return pessoa;
	}
	
	

}
