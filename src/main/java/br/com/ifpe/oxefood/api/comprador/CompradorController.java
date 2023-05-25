package br.com.ifpe.oxefood.api.comprador;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import br.com.ifpe.oxefood.modelo.comprador.CompradorService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/comprador")
public class CompradorController extends GenericController {

   @Autowired
   private CompradorService compradorService;

   @PostMapping
   public ResponseEntity<Comprador> save(@RequestBody @Valid CompradorRequest request) {

    Comprador comprador = compradorService.save(request.build());
       return new ResponseEntity<Comprador>(comprador, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Comprador> listarTodos() {
  
       return compradorService.listarTodos();
   }

   @GetMapping("/{id}")
   public Comprador obterPorID(@PathVariable Long id) {

       return compradorService.obterPorID(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Comprador> update(@PathVariable("id") Long id, @RequestBody CompradorRequest request) {

    compradorService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

    compradorService.delete(id);
      return ResponseEntity.ok().build();
   }
}

