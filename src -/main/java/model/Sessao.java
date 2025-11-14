package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import model.dao.Util;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sessao_id")
    private int id;
    
    @Column(name = "sessao_cli")
    private Cliente cliente;
    
    @Column(name = "sessao_pc")
    private Computador computador;
    
    @Column(name = "sessao_inicio")
    private LocalDateTime horaInicio;
    
    @Column(name = "sessao_fim")
    private LocalDateTime horaFinal;
    
    @Column(name = "sessao_total")
    private double valorTotal;
    
    @Column(name = "sessao_statusSess")
    private StatusSess status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalDateTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusSess getStatus() {
        return status;
    }

    public void setStatus(StatusSess status) {
        this.status = status;
    }
    
    public String exibirDados() {
        String aux = "Dados da Sessão:\n";
        aux += "Computador: "+getComputador().getStatus()+"\n";
        aux += "Cliente: "+getCliente().getNome()+"\n";
        aux += "Hora inicio:"+Util.formatarDataHora(horaInicio)+"\n";
        aux += "Hora final:"+Util.formatarDataHora(horaFinal)+"\n";
        aux += "Valor total: "+valorTotal+"\n";
        aux += "Status: "+status+"\n";
        return aux;
    }
}
