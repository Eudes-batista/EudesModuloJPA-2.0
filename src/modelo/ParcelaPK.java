package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Data
public class ParcelaPK implements Serializable {

    @NotNull(message = "Campo numero da parcela não pode ser nulo")
    @Column(nullable = false)
    Integer numero;

    @NotNull(message = "Campo numero da parcela não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "venda", referencedColumnName = "codigo", nullable = false)
    @ForeignKey(name = "parcela_idFKvenda")
    Venda venda;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.numero);
        hash = 17 * hash + Objects.hashCode(this.venda);
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
        final ParcelaPK other = (ParcelaPK) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.venda, other.venda);
    }

}
