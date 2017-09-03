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
@Table(name = "estado")
public class Estado implements Serializable {

    @Id
    @NotNull(message = "Campo codigo do estado precisa ser informado algum valor")
    @Column(length = 2, nullable = false, unique = true)
    Integer codigo;

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
    @JoinColumn(name = "id_pais", referencedColumnName = "codigo", nullable = false)
    @ForeignKey(name = "estadoFKpais")
    Pais pais;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codigo);
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
        return Objects.equals(this.codigo, other.codigo);
    }

    
}
