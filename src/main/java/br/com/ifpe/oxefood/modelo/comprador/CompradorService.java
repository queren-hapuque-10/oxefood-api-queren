package br.com.ifpe.oxefood.modelo.comprador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class CompradorService extends GenericService {

   @Autowired
   private CompradorRepository repository;

   @Transactional
   public Comprador save(Comprador comprador) {

       super.preencherCamposAuditoria(comprador);
       return repository.save(comprador);
   }

   public List<Comprador> listarTodos() {
  
    return repository.findAll();
}

public Comprador obterPorID(Long id) {

    return repository.findById(id).get();
}

@Transactional
   public void update(Long id, Comprador compradorAlterado) {

    Comprador comprador = repository.findById(id).get();
    comprador.setNome(compradorAlterado.getNome());
    comprador.setEnderecoComercial(compradorAlterado.getEnderecoComercial());
    comprador.setEnderecoResidencial(compradorAlterado.getEnderecoResidencial());
    comprador.setComissao(compradorAlterado.getComissao());
    comprador.setQtdComprasMediasMes(comprador.getQtdComprasMediasMes());
    comprador.setContratadoEm(compradorAlterado.getContratadoEm());
	    
      super.preencherCamposAuditoria(comprador);
      repository.save(comprador);
  }
  
  @Transactional
  public void delete(Long id) {

    Comprador comprador = repository.findById(id).get();
    comprador.setHabilitado(Boolean.FALSE);
      super.preencherCamposAuditoria(comprador);

      repository.save(comprador);
  }


}
