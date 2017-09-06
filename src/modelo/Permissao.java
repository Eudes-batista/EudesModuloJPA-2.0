package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable{
    
    @Id
    @Length(max = 10,message = "campo usuario so aceita no maximo {max} caracteres")
    @NotBlank(message = "campo usuario não pode ser vazio")
    @NotNull(message = "campo usuario não pode ser null")
    @Column(length = 10)
    String nome;
    
    @Length(max = 50,message = "campo descricao so aceita no maximo {max} caracteres")
    @NotBlank(message = "campo descricao não pode ser vazio")
    @NotNull(message = "campo descricao não pode ser null")
    @Column(length = 50)
    String descricao;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nome);
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
        final Permissao other = (Permissao) obj;
        return Objects.equals(this.nome, other.nome);
    }
    
    
    
}
