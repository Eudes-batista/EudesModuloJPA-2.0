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
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @NotNull(message = "Campo codigo da cidade precisa ser informado algum valor")
    @Column(length = 7, nullable = false, unique = true)
    Integer codigo;

    @Length(max = 20, message = "Campo cidade é Apenas {max} caracteres")
    @NotBlank(message = "Campo cidade não de ser vazio")
    @NotNull(message = "Campo cidade precisa ser informado algum valor")
    @Column(length = 20, nullable = false)
    String nome;

    @NotNull(message = "Campo estado tem ser informado")
    @ManyToOne
    @JoinColumn(name = "estado", nullable = false, referencedColumnName = "codigo")
    @ForeignKey(name = "cidadeFKestado")
    Estado estado;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final Cidade other = (Cidade) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    
    
}
