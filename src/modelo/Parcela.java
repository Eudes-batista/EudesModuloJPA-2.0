package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "parcela")
public class Parcela implements Serializable {

    @EmbeddedId
    ParcelaPK parcelaPK;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.parcelaPK);
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
        return Objects.equals(this.parcelaPK, other.parcelaPK);
    }

}
