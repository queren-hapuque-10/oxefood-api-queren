package br.com.ifpe.oxefood.modelo.comprador;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import java.time.LocalDate;
    
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Where;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comprador")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comprador extends EntidadeAuditavel{
    
       @Column
       private String nome;
    
       @Column
       private String enderecoComercial;
    
       @Column
       private String enderecoResidencial;
    
       @Column
       private Double comissao;
    
       @Column
       private Boolean trabalhoHomeOffice;

       @Column
       private Integer qtdComprasMediasMes;

       @Column
       private LocalDate contratadoEm;
    
    }
      

