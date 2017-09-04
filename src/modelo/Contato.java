package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="contato")
public class Contato implements Serializable{
    
    @Id
    @NotNull(message = "Campo pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa",referencedColumnName = "codigo",nullable = false)        
    @ForeignKey(name = "contatoFKpessoa")        
    Pessoa pessoa;
    
    @Length(max=10,message = "Campo tipo de contato não pode ser maior que {max} caracteres")
    @NotBlank(message = "Campo tipo de contato não pode ser vazio")
    @NotNull(message = "Campo tipo de contato não pode ser nulo")
    @Column(name="tipo_contato",nullable=false,length = 10)
    String tipoCOntado;
    
    @Length(max=10,message = "Campo descrição não pode ser maior que {max} caracteres")
    @NotBlank(message = "Campo descrição não pode ser vazio")
    @NotNull(message = "Campo descrição não pode ser nulo")
    @Column(name="descricao",nullable=false,length = 10)
    String descricao;
    
}
