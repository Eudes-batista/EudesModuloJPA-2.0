package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;

    @NotNull(message = "O preço deve ser informado")
    @Column(name = "preco", nullable = false, columnDefinition = "decimal(12,2)")
    private Double preco;

    @Min(message = "O estoque não pode ser negativo", value = 0)
    @NotNull(message = "A quantidade em estoque deve ser informada")
    @Column(name = "quantidade_estoque", nullable = false, columnDefinition = "decimal(12,2)")
    private Double quantidadeEstoque;

    @NotNull(message = "A categoria deve ser informada")
    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_categoria")
    private Categoria categoria;

    @NotNull(message = "A marca deve ser informada")
    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_marca")
    private Marca marca;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produto_pessoa_fisica",
             joinColumns
            = @JoinColumn(name = "produto", nullable = false, referencedColumnName = "codigo"),
            inverseJoinColumns
            = @JoinColumn(name = "pessoa_fisica", referencedColumnName = "codigo", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {"pessoa_fisica", "produto"})})
    private List<PessoaFisica> pessoasFisicais = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Foto> fotos = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Arquivo> arquivos = new ArrayList<>();

    public Produto() {
    }

    public void adicionarFoto(Foto obj) {
        obj.setProduto(this);
        this.fotos.add(obj);
    }

    public void removerFoto(int index) {
        this.fotos.remove(index);
    }

    public void adicionarArquivo(Arquivo obj) {
        obj.setProduto(this);
        this.arquivos.add(obj);
    }

    public void removerArquivo(int index) {
        this.arquivos.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final Produto other = (Produto) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

}
