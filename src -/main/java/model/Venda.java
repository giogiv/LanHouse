/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.dao.Util;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author vanessalagomachado
 */
@Entity
@Table(name = "vendas")
public class Venda implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "venda_id")
    private int id;
    
    @Column(name = "venda_data_hora", nullable = false)
    private LocalDateTime dataVenda;
    
    @Column(name = "venda_valor", columnDefinition = "numeric(12,2)")
    private double valorVenda;
    
    /*@Enumerated(EnumType.STRING)
    @Column(name = "venda_forma_contrato")
    private FormaContrato formaContrato;*/
    
    @Enumerated(EnumType.STRING)
    @Column(name = "venda_forma_pgto")
    private FormaPgto formaPgto;
    
    @ManyToOne
    @JoinColumn(name = "venda_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "venda_func")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "venda_pc")
    private Computador computador;

    @Override
    public String toString() {
        return Util.formatarDataHora(dataVenda);
    }

    public String exibirDados() {
        String aux = "Dados da Venda:\n";
        aux += "Data|Hora :"+Util.formatarDataHora(dataVenda)+"\n";
        aux += "Computador: "+getComputador().getNumeroMaquina()+"\n";
        aux += "Cliente: "+getCliente().getNome()+"\n";
        aux += "Funcionario: "+getFuncionario().getNome()+"\n";
        aux += "Forma de Pagamento: "+formaPgto+"\n";
        aux += "Valor da Venda: "+valorVenda+"\n";
        return aux;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }
}
