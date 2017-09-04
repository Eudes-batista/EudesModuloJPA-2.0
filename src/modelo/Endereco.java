package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;

    @Length(max = 50,message = "Campo endereço pode ter apenas {max} caractes")
    @NotBlank(message = "Campo endereço não pode ser vazio")
    @NotNull(message = "Campo endereço tem que ser preenchido")
    @Column(length = 50,nullable = false)
    String endereco;
    
    @NotNull(message = "Campo numero não pode ser vazio")
    @Column(length = 10,nullable = false)
    Integer numero;
    
    @Length(max = 40,message = "Campo bairro pode ter apenas {max} caractes")
    @NotBlank(message = "Campo bairro não pode ser vazio")
    @NotNull(message = "Campo bairro tem que ser preenchido")
    @Column(length = 40,nullable = false)
    String bairro;
    
    @Length(max = 30,message = "Campo camplemento pode ter apenas {max} caractes")
    @Column(length = 30)
    String camplemento;
    
    @Length(max = 9,message = "Campo cep pode ter apenas {max} caractes")
    @NotBlank(message = "Campo cep não pode ser vazio")
    @NotNull(message = "Campo cep tem que ser preenchido")
    @Column(length = 9,nullable = false)
    String cep;
    
    @NotNull(message = "campo cidade não pode ser nulo")
    @ManyToOne
    @JoinColumn(nullable = false,name = "cidade",referencedColumnName = "codigo")  
    @ForeignKey(name = "enderecoFKcidade")        
    Cidade cidade;
    
    @NotNull(message = "campo tipo de endereco não pode ser nulo")
    @ManyToOne
    @JoinColumn(nullable = false,name = "tipo_endereco",referencedColumnName = "codigo")  
    @ForeignKey(name = "enderecoFKtipo_endereco")        
    TipoEndereco tipoEndereco;
    
    @NotNull(message = "campo pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(nullable = false,name = "pessoa",referencedColumnName = "codigo")  
    @ForeignKey(name = "enderecoFKpessoa")        
    Pessoa pessoa;
    
}
