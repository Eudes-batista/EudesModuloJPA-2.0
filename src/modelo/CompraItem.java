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

@Data
@Entity
@Table(name = "compra_item")
public class CompraItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @NotNull(message = "Campo quantidade não pode ser vazio")
    @Column(nullable = false, precision = 10, scale = 5)
    Double quantidade;

    @NotNull(message = "Campo valor Unitario não pode ser vazio")
    @Column(name = "valor_unitario", nullable = false, precision = 10, scale = 5)
    Double valorUnitario;

    @NotNull(message = "Campo valor total não pode ser vazio")
    @Column(name = "valor_total", nullable = false, precision = 10, scale = 5)
    Double valorTotal;

    @NotNull(message = "Campo compra não pode ser vazio")
    @ManyToOne
    @ForeignKey(name = "compraFKcompra_item")
    Compra compra;
    
    @NotNull(message = "produto não pode ser vazio")
    @ManyToOne
    @JoinColumn(name = "produto",referencedColumnName = "codigo",nullable = false)        
    @ForeignKey(name = "produtoFKcompra_item")        
    Produto produto;

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
        final CompraItem other = (CompraItem) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    
}
