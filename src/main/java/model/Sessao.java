package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    
    @Column(name = "sessao_valor_hora", columnDefinition = "numeric(12,2)")
    private double valorHora;
    
    @Column(name = "sessao_total")
    private double valorTotal;
    
    @Column(name = "sessao_statusSess")
    private StatusSess status;
    
    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

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
        aux += "Computador: "+getComputador().getNumeroMaquina()+" ("+getComputador().getStatus()+")"+"\n";
        aux += "Cliente: "+getCliente().getNome()+"\n";
        aux += "Hora inicio:"+Util.formatarHora(horaInicio)+"\n";
        aux += "Hora final:"+Util.formatarHora(horaFinal)+"\n";
        
        if (this.status == StatusSess.INATIVA && horaFinal != null) {
             aux += "Valor por Hora: R$ " + String.format("%.2f", valorHora) + "\n";
             aux += "Duração: " + calcularDuracaoMinutos() + " minutos\n";
             aux += "Valor Total Calculado: R$ " + String.format("%.2f", calcularValorTotal()) + "\n";
        }
        aux += "Status: "+status+"\n";
        aux += "Valor total: R$ "+String.format("%.2f", valorTotal)+"\n";
        
        return aux;
    }
    
    public long calcularDuracaoMinutos(){
        if(horaInicio != null && horaFinal !=null){
            return ChronoUnit.MINUTES.between(horaInicio, horaFinal);
        }
        return 0;
    }
    
    public double calcularValorTotal(){
        long duracaoMinutos = calcularDuracaoMinutos();
        
        if(duracaoMinutos > 0 && valorHora > 0){
            double valorPorMinuto = valorHora /60.0;
            double total = duracaoMinutos * valorPorMinuto;
            
            return total;
        }
        return 0.0;
    }
}
