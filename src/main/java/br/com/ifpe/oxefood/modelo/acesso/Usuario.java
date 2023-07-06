package br.com.ifpe.oxefood.modelo.acesso;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends EntidadeNegocio implements UserDetails { //userDetails é uma interface do spring security

   private static final long serialVersionUID = -2660334839251150243L;

   public static final String ROLE_CLIENTE = "CLIENTE";
   public static final String ROLE_EMPRESA = "EMPRESA";

   @Column(nullable = false, unique = true)
   private String username;

   @JsonIgnore // o password não é retornado
   @Column(nullable = false)
   private String password;

   @JsonIgnore
   @ElementCollection(fetch = FetchType.EAGER)
   @Builder.Default
   private List<String> roles = new ArrayList<>();

   @JsonIgnore
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
   }

   public boolean isAccountNonExpired() {
       return true;
   }

   public boolean isAccountNonLocked() {
       return true;
   }

   public boolean isCredentialsNonExpired() {
       return true;
   }

   public boolean isEnabled() {
       return getHabilitado();
   }

}