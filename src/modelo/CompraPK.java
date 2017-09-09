package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ForeignKey;

@Embeddable
@Data
@EqualsAndHashCode
public class CompraPK implements Serializable {

    @Column(nullable = false)
    Integer numeroNota;

     @Id
    @NotNull(message = "Campo pessoa não pode receber valor nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa_jurica", nullable = false, referencedColumnName = "codigo")
    @ForeignKey(name = "pessoa_juridicaFKcompra")
    PessoaJuridica pessoaJuridica;
    
}
