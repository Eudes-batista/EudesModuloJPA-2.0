package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Table(name = "tipo_endereco")
public class TipoEndereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @Length(max = 20, message = "Campo descrição só poder receber apenas {max} caracteres")
    @NotBlank(message = "Campo descricao não ser vazio")
    @NotNull(message = "Campo descricao não pode ser nulo")
    @Column(length = 20, nullable = false)
    String descricao;
}
