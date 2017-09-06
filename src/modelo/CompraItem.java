package modelo;

import java.io.Serializable;
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
    @JoinColumn(name = "compra", nullable = false, referencedColumnName = "numeroNota")
    @ForeignKey(name = "compraFKcompra_item")
    Compra compra;
}
