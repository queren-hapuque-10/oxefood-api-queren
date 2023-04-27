package br.com.ifpe.oxefood.api.produto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends GenericController {

   @Autowired
   private ProdutoService produtoService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

    Produto produto = produtoService.save(request.build());
       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Produto> listarTodos() {
  
       return produtoService.listarTodos();
   }

   @GetMapping("/{id}")
   public Produto obterPorID(@PathVariable Long id) {

       return produtoService.obterPorID(id);
   }
}
