package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Table(name="contato")
public class Contato implements Serializable{
    
    @Id
    @NotNull(message = "Campo pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa",referencedColumnName = "codigo",nullable = false)        
    @ForeignKey(name = "contatoFKpessoa")        
    Pessoa pessoa;
    
    @Length(max=10,message = "Campo tipo de contato não pode ser maior que {max} caracteres")
    @NotBlank(message = "Campo tipo de contato não pode ser vazio")
    @NotNull(message = "Campo tipo de contato não pode ser nulo")
    @Column(name="tipo_contato",nullable=false,length = 10)
    String tipoCOntado;
    
    @Length(max=10,message = "Campo descrição não pode ser maior que {max} caracteres")
    @NotBlank(message = "Campo descrição não pode ser vazio")
    @NotNull(message = "Campo descrição não pode ser nulo")
    @Column(name="descricao",nullable=false,length = 10)
    String descricao;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        return Objects.equals(this.pessoa, other.pessoa);
    }
    
    
    
}
