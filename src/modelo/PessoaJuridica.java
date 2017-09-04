package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {

    @Length(max = 10, message = "Campo inscrição estadual so pode ter {max} caracteres")
    @NotBlank(message = "Campo inscrição estadual não pode ser vazio")
    @NotNull(message = "Campo inscrição estadual não pode ser nulo")
    @Column(name = "inscricao_estadual", length = 10)
    String inscricaoEstadual;

    @Length(max = 20, message = "Campo inscricao Municipal so pode ter {max} caracteres")
    @NotBlank(message = "Campo inscricao Municipal não pode ser vazio")
    @NotNull(message = "Campo inscricao Municipal não pode ser nulo")
    @Column(name = "inscricao_municipal", length = 20)
    String inscricaoMunicipal;

    @Length(max = 20, message = "Campo cnpj so pode ter {max} caracteres")
    @NotBlank(message = "Campo inscricao Municipal não pode ser vazio")
    @NotNull(message = "Campo inscricao Municipal não pode ser nulo")
    @CNPJ(message = "informe um cnpj valido")
    @Column(name = "cnpj", length = 20)
    String cnpj;

    @Length(max = 30, message = "Campo nome fantasia so pode ter {max} caracteres")
    @NotBlank(message = "Campo nome fantasia não pode ser vazio")
    @NotNull(message = "Campo nome fantasia não pode ser nulo")
    @Column(name = "nome_fantasia", length = 30)
    String nomeFantasia;

    @Length(max = 20, message = "Campo regime Tributario so pode ter {max} caracteres")
    @NotBlank(message = "Campo regime Tributario não pode ser vazio")
    @NotNull(message = "Campo regime Tributario não pode ser nulo")
    @Column(name = "regime_tributario", length = 20)
    String regimeTributario;

    @Length(max = 10, message = "Campo cnae so pode ter {max} caracteres")
    @NotBlank(message = "Campo cnae não pode ser vazio")
    @NotNull(message = "Campo cnae não pode ser nulo")
    @Column(name = "cnae", length = 10)
    String cnae;

}
