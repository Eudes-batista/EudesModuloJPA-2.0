package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Data
@Entity
@Table(name = "parcela")
public class Parcela implements Serializable {

    @Id
    @NotNull(message = "Campo numero não foi informado nenhum valor")
    @Column(nullable = false)
    Integer numero;

    @Column(precision = 10, scale = 6, nullable = false)
    @NotNull(message = "Campo valor não foi informado nenhum valor")
    Double valor;

    @NotNull(message = "Campo vencimento não foi informado nenhum valor")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Calendar vencimento;

    @NotNull(message = "Campo valor do pagamento não foi informado nenhum valor")
    @Column(precision = 10, scale = 6, name = "valor_pagamento", nullable = false)
    Double valorPagamento;

    @NotNull(message = "Campo valor do pagamento não foi informado nenhum valor")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento", nullable = false)
    Calendar dataPagamento;

    @Id
    @NotNull(message = "Campo venda não pode ser vazio")
    @ManyToOne
    @JoinColumn(name = "venda", nullable = false, referencedColumnName = "codigo")
    @ForeignKey(name = "vendaFKvenda_item")
    Venda venda;

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Parcela other = (Parcela) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return Objects.equals(this.venda, other.venda);
    }

    
    
}
