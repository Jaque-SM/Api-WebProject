package webproduct.service.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import webproduct.service.com.entity.Produto;
import webproduct.service.com.repository.ProdutoRepository;
import webproduct.service.com.service.ProdutoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/product/")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public List<Produto> findAll() {

		return produtoRepository.findAll();
	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public Produto findById(@PathVariable("id") Integer id) {
		Produto prod=produtoService.findByProdutoId(id);
		if (prod!=null) {
			return prod;			
		}
		return null;	
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduto(@RequestBody Produto produto) {

		this.produtoRepository.save(produto);
		return "Dados Salvos";
	}
	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Produto updateProduto(@PathVariable Integer id, @RequestBody Produto produto) {

		Produto prod = this.produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto não existe com o id:" + id));
		
		prod.setNome(produto.getNome());
		prod.setProductcode(produto.getProductcode());
		prod.setFornecedor(produto.getFornecedor());
		prod.setValor(produto.getValor());

		Produto updateProduto = this.produtoRepository.save(prod);
		
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
