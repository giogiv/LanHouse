package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa implements Serializable{

    @Id
    @Column(name = "cli_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "cli_dataCad")
    private LocalDate DataCadastro;
     
    // 1 cliente -> várias vendas
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
    
    public List<Venda> getVendas() { return vendas; }
    public void setVendas(List<Venda> vendas) { this.vendas = vendas; }
        
   public Cliente(){
        vendas = new ArrayList<>();
    }

    public LocalDate getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(LocalDate DataCadastro) {
        this.DataCadastro = DataCadastro;
    }
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
