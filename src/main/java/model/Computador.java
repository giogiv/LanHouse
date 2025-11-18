package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "computadores")
public class Computador implements Serializable{
    
    @Id
    @Column(name = "pc_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "pc_num")
    private int numeroMaquina;
    
    @Column(name = "pc_esp")
    private String especificacoes;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "pc_status")
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroMaquina() {
        return numeroMaquina;
    }

    public void setNumeroMaquina(int numeroMaquina) {
        this.numeroMaquina = numeroMaquina;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public String exibirDados() {
        String aux = "Dados da Venda:\n";
        aux += "Nº da Máquina: "+getNumeroMaquina()+"\n";
        aux += "Especificações : "+getEspecificacoes()+"\n";
        aux += "Status: "+status+"\n";
        return aux;
    }
    
}
