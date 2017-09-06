package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable{
    
    @Column()
    String nome;
    @Column()
    String descricao;
    
}
