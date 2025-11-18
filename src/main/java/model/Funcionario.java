package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "func_id")
    private int id;
    
    @Column(name = "func_sal", columnDefinition = "numeric(12,2)")
    private double salario;
    
    public Funcionario(){
        vendas = new ArrayList<>();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
      
    public String exibirDados(){
        String aux = super.exibirDados()+"\n";
        aux += "Salário" + salario + "\n";
    
        return aux;
    }
    
    // 1 func -> várias vendas
    @OneToMany(mappedBy = "funcionario")
    private List<Venda> vendas;
    
    public List<Venda> getVendas() { return vendas; }
    public void setVendas(List<Venda> vendas) { this.vendas = vendas; }

}
