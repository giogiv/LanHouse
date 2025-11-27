package model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.persistence.*;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sessao_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "sessao_cli")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "sessao_pc")
    private Computador computador;

    @Column(name = "sessao_inicio")
    private LocalTime horaInicio;

    @Column(name = "sessao_fim")
    private LocalTime horaFinal;

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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
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
        aux += "Computador: " + getComputador().getNumeroMaquina() + " (" + getComputador().getStatus() + ")\n";
        aux += "Cliente: " + getCliente().getNome() + "\n";

        if (horaInicio != null) {
            aux += "Hora inicio: " + horaInicio.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n";
        }
        if (horaFinal != null) {
            aux += "Hora final: " + horaFinal.format(DateTimeFormatter.ofPattern("HH:mm")) + "\n";
        }
        if (this.status == StatusSess.INATIVA && horaFinal != null) {
            aux += "Valor por Hora: R$ " + String.format("%.2f", valorHora) + "\n";
            aux += "Duração: " + calcularDuracaoMinutos() + " minutos\n";
            aux += "Valor Total Calculado: R$ " + String.format("%.2f", calcularValorTotal()) + "\n";
        }

        aux += "Status: " + status + "\n";
        aux += "Valor total: R$ " + String.format("%.2f", valorTotal) + "\n";

        return aux;
    }

    public long calcularDuracaoMinutos() {
        if (horaInicio != null && horaFinal != null) {
            long minutos = ChronoUnit.MINUTES.between(horaInicio, horaFinal);

            if (minutos < 0) {
                minutos += 24 * 60;
            }

            return minutos;
        }
        return 0;
    }

    public double calcularValorTotal() {
        long duracaoMinutos = calcularDuracaoMinutos();

        if (duracaoMinutos > 0 && valorHora > 0) {
            double valorPorMinuto = valorHora / 60.0;
            double total = duracaoMinutos * valorPorMinuto;

            return total;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("PC %s - Cliente: %s (Início: %s)",
                computador != null ? computador.getNumeroMaquina() : "N/A",
                cliente != null ? cliente.getNome() : "N/A",
                horaInicio != null ? horaInicio.format(DateTimeFormatter.ofPattern("HH:mm")) : "N/A"
        );
    }
}
