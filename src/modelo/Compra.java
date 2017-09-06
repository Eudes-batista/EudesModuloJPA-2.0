package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Entity
@Data
@Table(name = "compra")
public class Compra implements Serializable {

    @Id
    @Column(nullable = false)
    Integer numeroNota;

    @NotNull(message = "Campo data não pode receber valor nulo")
    @Temporal(TemporalType.DATE)
    Calendar data;

    @NotNull(message = "Campo valor total não pode receber valor nulo")
    @Column(name = "valor_total", precision = 15, scale = 6)
    Double valorTotal;

    @NotNull(message = "Campo pessoa não pode receber valor nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa_jurica", nullable = false, referencedColumnName = "codigo")
    @ForeignKey(name = "pessoa_juridicaFKcompra")
    PessoaJuridica pessoaJuridica;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<CompraItem> listaItens = new ArrayList<>();

    public void addItem(CompraItem compraItem) {
        compraItem.setCompra(this);
        listaItens.add(compraItem);
    }

    public void removerItem(CompraItem compraItem) {
        listaItens.remove(compraItem);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.numeroNota);
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
        final Compra other = (Compra) obj;
        return Objects.equals(this.numeroNota, other.numeroNota);
    }

}
