package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Table(name = "pais")
@NamedQueries({
   @NamedQuery(name = "pais.listaTodos",query = "SELECT p FROM Pais p"),
   @NamedQuery(name="pais.listaPorNome",query = "SELECT p FROM Pais p WHERE p.nome= :nome") 
        
})
public class Pais implements Serializable {

    @Id
    @NotNull(message = "Campo codigo do pais precisa ser informado algum valor")
    @Column(length = 4, nullable = false, unique = true)
    Integer codigo;

    @Length(max = 50, message = "tamnho maximo do campo é {max} caracteres")
    @NotBlank(message = "Campo não poder ser vazio")
    @NotNull(message = "Campo Nome não foi informado nenhum valor")
    @Column(length = 50, nullable = false)
    String nome;

    @Length(max = 3, message = "tamnho maximo do campo é {max} caracteres")
    @NotBlank(message = "Campo não poder ser vazio")
    @NotNull(message = "Campo iso não foi informado nenhum valor")
    @Column(length = 3, nullable = false)
    String iso;

   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.codigo);
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
        final Pais other = (Pais) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

}
