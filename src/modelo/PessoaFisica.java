package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable {

    @Length(max = 9, message = "Campo rg não pode ser main que {max}")
    @NotBlank(message = "Campo rg não pode ser vazio")
    @NotNull(message = "Campo rg não foi informado nenhum valor")
    @Column(length = 9, nullable = false)
    String rg;

    @Length(max = 14, message = "Campo cpf não pode ser main que {max}")
    @NotBlank(message = "Campo cpf não pode ser vazio")
    @NotNull(message = "Campo cpf não foi informado nenhum valor")
    @CPF(message = "CPF invalido")
    @Column(length = 14, nullable = false)
    String cpf;

    @NotNull(message = "A data de nascimento de ser infomada")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Calendar nacimento;

    @Length(max = 10, message = "Campo usuario não pode ser main que {max}")
    @NotBlank(message = "Campo usuario não pode ser vazio")
    @NotNull(message = "Campo usuario não foi informado nenhum valor")
    @Column(length = 10, nullable = false, unique = true)
    String usuario;

    @Length(max = 10, message = "Campo senha não pode ser main que {max}")
    @NotBlank(message = "Campo senha não pode ser vazio")
    @NotNull(message = "Campo senha não foi informado nenhum valor")
    @Column(length = 10, nullable = false)
    String senha;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produto_pessoa_fisica",
            joinColumns
            = @JoinColumn(name = "pessoa_fisica", nullable = false, referencedColumnName = "codigo"),
            inverseJoinColumns
            = @JoinColumn(name = "produto", referencedColumnName = "codigo", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"pessoa_fisica", "produto"})})
    List<Produto> produtos = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "permissoes",
            joinColumns = @JoinColumn(name = "usuario", nullable = false, referencedColumnName = "usuario"),
            inverseJoinColumns = @JoinColumn(name = "permissao", nullable = false, referencedColumnName = "nome"),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"usuario", "permissao"})})
    List<Permissao> permissaos = new ArrayList<>();

    public void addPermissao(Permissao permissao) {
        permissaos.add(permissao);
    }

    public void removerPermissao(Permissao permissao) {
        permissaos.remove(permissao);
    }

}
