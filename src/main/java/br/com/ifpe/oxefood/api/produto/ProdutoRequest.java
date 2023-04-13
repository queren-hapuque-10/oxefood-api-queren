package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private String codigo;

   private String titulo;

   private String descricao;

   private Double valorUnitario;

   private Integer tempoEntregaMinimo;

   private Integer tempoEntregaMaximo;

   public Produto build() {

       return Produto.builder()
               .codigo(codigo)
               .titulo(titulo)
               .descricao(descricao)
               .valorUnitario(valorUnitario)
               .tempoEntregaMinimo(tempoEntregaMinimo)
               .tempoEntregaMaximo(tempoEntregaMaximo)
               .build();
   }
}
