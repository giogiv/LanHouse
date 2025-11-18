package view;

import java.time.*;
import java.time.format.*;
import javax.swing.JOptionPane;
import model.Cliente;
import model.*;
import model.dao.*;

public class CadastroVendaJD extends javax.swing.JDialog {

    ClienteDAO daoCliente;
    ComputadorDAO daoComputador;
    FuncionarioDAO daoFuncionario;
    SessaoDAO daoSessao;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    
    private Venda venda;

    public CadastroVendaJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        daoCliente = new ClienteDAO();
        daoSessao = new SessaoDAO();
        daoFuncionario = new FuncionarioDAO();
        
        loadFormaPgto();        
        loadClientes();
        loadFuncionarios();
        loadComputador();
        
        txtDataVenda.setText(LocalDateTime.now().format(formatter)); 
    }
    
    public void loadFormaPgto(){
        for(FormaPgto obj: FormaPgto.values()){
            cmbFormaPgto.addItem(obj);
        }
    }
    
    public void loadClientes(){
        for(Cliente obj: daoCliente.listaClientes()){
            cmbCliente.addItem(obj);
        }
    }

    public void loadFuncionarios(){
        for(Funcionario obj: daoFuncionario.listaFuncionarios()){
            cmbFuncionario.addItem(obj);
        }
    }

    public void loadComputador(){
        for(Computador obj: daoComputador.listaComputadores()){
            cmbComputador.addItem(obj);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblDtVenda = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblFormaPagamento = new javax.swing.JLabel();
        cmbFormaPgto = new javax.swing.JComboBox<>();
        cmbCliente = new javax.swing.JComboBox<>();
        cmbComputador = new javax.swing.JComboBox<>();
        cmbFuncionario = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        lblVeiculo = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Venda");

        lblDtVenda.setText("Data Venda:");

        lblValor.setText("Valor: ");

        lblFormaPagamento.setText("Forma de Pagamento:");

        cmbComputador.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbComputadorItemStateChanged(evt);
            }
        });

        lblCliente.setText("Cliente:");

        lblVeiculo.setText("Computador:");

        lblVendedor.setText("Funcionario:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblValor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCliente)
                                .addComponent(lblVeiculo)
                                .addComponent(lblVendedor)
                                .addComponent(lblFormaPagamento))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, 0, 168, Short.MAX_VALUE)
                                .addComponent(cmbComputador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbFormaPgto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(33, 33, 33))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblDtVenda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtVenda)
                    .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cmbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbComputador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVeiculo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVendedor))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        
        try {
            if(venda == null)
                venda = new Venda();
                        
            double valor = Double.parseDouble(txtValor.getText()
                    .replace(",", "."));
            LocalDateTime dataVenda = LocalDateTime.parse(txtDataVenda.getText(), formatter);

            venda.setValorVenda(valor);
            venda.setDataVenda(dataVenda);
            venda.setFormaPgto((FormaPgto) cmbFormaPgto.getSelectedItem());
            venda.setCliente((Cliente) cmbCliente.getSelectedItem());
            venda.setFuncionario((Funcionario) cmbFuncionario.getSelectedItem());
            venda.setComputador((Computador) cmbComputador.getSelectedItem());

            //venda.getComputador().setDisponivel(false);
            
            daoComputador.persist(venda.getComputador());
            
            this.dispose();


        } catch (NumberFormatException e) {
            venda = null;
            JOptionPane.showMessageDialog(this, "Valor inválido. Digite um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException e) {
            venda = null;
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato: dd-MM-yyyy HH:mm", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            venda = null;
            JOptionPane.showMessageDialog(this, "Erro ao salvar venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cmbComputadorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbComputadorItemStateChanged

    }//GEN-LAST:event_cmbComputadorItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroVendaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVendaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVendaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVendaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroVendaJD dialog = new CadastroVendaJD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<model.Computador> cmbComputador;
    private javax.swing.JComboBox<FormaPgto> cmbFormaPgto;
    private javax.swing.JComboBox<model.Funcionario> cmbFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDtVenda;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblVeiculo;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
        txtDataVenda.setText(venda.getDataVenda().format(formatter));
        txtValor.setText(""+venda.getValorVenda());
        cmbCliente.setSelectedItem(venda.getCliente());
        cmbComputador.setSelectedItem(venda.getComputador());
        cmbFuncionario.setSelectedItem(venda.getFuncionario());
        cmbFormaPgto.setSelectedItem(venda.getFormaPgto());
    }
}
