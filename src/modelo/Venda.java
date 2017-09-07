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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "numero da venda não pode ser nulo")
    Integer codigo;

    @NotNull(message = "Campo data não pode receber valor nulo")
    @Temporal(TemporalType.DATE)
    Calendar data;

    @NotNull(message = "Campo valor total não pode receber valor nulo")
    @Column(name = "valor_total", precision = 15, scale = 6)
    Double valorTotal;

    @NotNull(message = "Campo quantidade não pode ser vazio")
    @Column(name = "quant_parcela", nullable = false, length = 3)
    Integer quantidadeParcela;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<VendaItem> listaItens = new ArrayList<>();

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Parcela> listaParcelas = new ArrayList<>();

    public void addItem(VendaItem vendaItem) {
        vendaItem.setVenda(this);
        listaItens.add(vendaItem);
    }

    public void removerItem(VendaItem vendaItem) {
        listaItens.remove(vendaItem);
    }

    public void addParcela(Parcela parcela) {
        parcela.setVenda(this);
        listaParcelas.add(parcela);
    }

    public void removerParcela(Parcela parcela) {
        listaParcelas.remove(parcela);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.codigo);
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
        final Venda other = (Venda) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

}
