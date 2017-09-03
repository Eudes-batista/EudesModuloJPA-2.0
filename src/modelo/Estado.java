package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Length(max = 50, message = "Campo so pode receber apenas {max} caracteres")
    @NotBlank(message = "Campo Nome não pode ser vazio")
    @NotNull(message = "Campo nome não foi informado nenhum valor")
    @Column(nullable = false, length = 50)
    String nome;
    @Length(max = 2, message = " O campo uf so pode receber apenas {max} caracteres")
    @NotBlank(message = "Campo uf não pode ser vazio")
    @NotNull(message = "Campo uf não foi informado nenhum valor")
    @Column(nullable = false, length = 2)
    String uf;
    @NotNull(message = "Campo pais não foi informado nenhum valor")
    @ManyToOne
    @JoinColumn(name = "id_pais", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "estadoFKpais")        
    Pais pais;

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Estado other = (Estado) obj;
        return Objects.equals(this.id, other.id);
    }

}
