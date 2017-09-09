package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "compra")
public class Compra implements Serializable {

    @EmbeddedId
    CompraPK compraPK;

    @NotNull(message = "Campo data não pode receber valor nulo")
    @Temporal(TemporalType.DATE)
    Calendar data;

    @NotNull(message = "Campo valor total não pode receber valor nulo")
    @Column(name = "valor_total", precision = 15, scale = 6)
    Double valorTotal;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<CompraItem> listaItens = new ArrayList<>();

    public void addItem(CompraItem compraItem) {
        compraItem.setCompra(this);
        listaItens.add(compraItem);
    }

    public void removerItem(CompraItem compraItem) {
        listaItens.remove(compraItem);
    }
}
