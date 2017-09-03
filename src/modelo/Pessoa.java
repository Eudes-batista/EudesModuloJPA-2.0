package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Length(max = 50, message = "Campo so pode receber apenas {max} caracteres")
    @NotBlank(message = "Campo Nome não pode ser vazio")
    @NotNull(message = "Campo nome não foi informado nenhum valor")
    @Column(nullable = false, length = 50)
    String nome;
    
    @Length(max = 30, message = "Campo email não mode ter {max}")
    @NotBlank(message = "Email não podeser vazio")
    @Email(message = "informe um email valido")
    @Column(length = 30)
    String email;
   
    @Length(max = 14, message = "Campo email não mode ter {max}")
    @NotBlank(message = "Telefone não podeser vazio")
    @Column(length = 30)
    String telefone;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.id);
    }

}
