package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class EntregadorService extends GenericService {

   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       super.preencherCamposAuditoria(entregador);
       return repository.save(entregador);
   }

   public List<Entregador> listarTodos() {
  
    return repository.findAll();
}

public Entregador obterPorID(Long id) {

    return repository.findById(id).get();
}

@Transactional
public void update(Long id, Entregador entregadorAlterado) {

Entregador entregador = repository.findById(id).get();
    entregador.setNome(entregadorAlterado.getNome());
    entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
    entregador.setCpf(entregadorAlterado.getCpf());
    entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
    entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
    entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
    entregador.setAtivo(entregadorAlterado.getAtivo());
    entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
    entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
    entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
    entregador.setEnderecoComplemento(entregadorAlterado.getEnderecoComplemento());
    entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
    entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
    entregador.setRg(entregadorAlterado.getRg());
    entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
    entregador.setValorFrete(entregadorAlterado.getValorFrete());

    super.preencherCamposAuditoria(entregador);
    repository.save(entregador);
}

@Transactional
public void delete(Long id) {

    Entregador entregador = repository.findById(id).get();
    entregador.setHabilitado(Boolean.FALSE);
    super.preencherCamposAuditoria(entregador);

   repository.save(entregador);
}
}
