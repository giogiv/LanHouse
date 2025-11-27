package view;

import java.time.*;
import java.time.format.*;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import model.dao.*;

public class CadastroVendaJD extends javax.swing.JDialog {

    ComputadorDAO daoComputador;
    FuncionarioDAO daoFuncionario;
    SessaoDAO daoSessao;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    
    private Venda venda;

    public CadastroVendaJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        daoSessao = new SessaoDAO();
        daoFuncionario = new FuncionarioDAO();
        daoComputador = new ComputadorDAO();
        
        loadFormaPgto();        
        loadFuncionarios();
        loadSessoesAtivas();
        
        txtDataVenda.setText(LocalDateTime.now().format(formatter)); 
    }
    
    public void loadFormaPgto(){
        cmbFormaPgto.removeAllItems();
        for(FormaPgto obj: FormaPgto.values()){
            cmbFormaPgto.addItem(obj);
        }
    }

    public void loadFuncionarios(){
        cmbFuncionario.removeAllItems();
        for(Funcionario obj: daoFuncionario.listaFuncionarios()){
            cmbFuncionario.addItem(obj);
        }
    }

    public void loadSessoesAtivas(){
        cmbSessao.removeAllItems();
        List<Sessao> sessoes = daoSessao.listaSessoes();
        
        if (sessoes != null && !sessoes.isEmpty()) {
            for(Sessao obj: sessoes){
                if(obj.getStatus() == StatusSess.ATIVA){
                    cmbSessao.addItem(obj);
                }
            }
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
        cmbSessao = new javax.swing.JComboBox<>();
        cmbFuncionario = new javax.swing.JComboBox<>();
        lblsessao = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Venda");

        lblDtVenda.setText("Data Venda:");

        lblValor.setText("Valor: ");

        lblFormaPagamento.setText("Forma de Pagamento:");

        cmbSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSessaoActionPerformed(evt);
            }
        });

        lblsessao.setText("Sessão:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblsessao)
                                    .addComponent(lblDtVenda)
                                    .addComponent(lblVendedor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbSessao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDataVenda)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFormaPagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDtVenda)
                    .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsessao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVendedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cmbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            
            if (txtValor.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Calcule o valor antes de salvar!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (cmbSessao.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Selecione uma sessão!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
                        
            double valor = Double.parseDouble(txtValor.getText().replace(",", "."));
            LocalDateTime dataVenda = LocalDateTime.parse(txtDataVenda.getText(), formatter);

            Sessao sessaoSelecionada = (Sessao) cmbSessao.getSelectedItem();
            
            // Atualiza a sessão para INATIVA e salva o valor total
            sessaoSelecionada.setStatus(StatusSess.INATIVA);
            sessaoSelecionada.setValorTotal(valor);
            daoSessao.persist(sessaoSelecionada);
            
            // Libera o computador
            Computador pc = sessaoSelecionada.getComputador();
            pc.setStatus(Status.LIVRE);
            daoComputador.persist(pc);

            venda.setValorVenda(valor);
            venda.setDataVenda(dataVenda);
            venda.setFormaPgto((FormaPgto) cmbFormaPgto.getSelectedItem());
            venda.setSessao((Sessao) cmbSessao.getSelectedItem());
            venda.setFuncionario((Funcionario) cmbFuncionario.getSelectedItem());
            venda.setComputador(sessaoSelecionada.getComputador());
            
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
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cmbSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSessaoActionPerformed
        if (cmbSessao.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma sessão!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Sessao sessaoSelecionada = (Sessao) cmbSessao.getSelectedItem();
        
        // Define a hora final como agora
        LocalTime horaFinal = LocalTime.now();
        sessaoSelecionada.setHoraFinal(horaFinal);
        
        // Calcula o valor total
        double valorCalculado = sessaoSelecionada.calcularValorTotal();
        
        if (valorCalculado > 0) {
            txtValor.setText(String.format("%.2f", valorCalculado));
            
            // Exibe informações da sessão
            long minutos = sessaoSelecionada.calcularDuracaoMinutos();
            String info = String.format(
                "Sessão calculada:\n" +
                "Início: %s\n" +
                "Fim: %s\n" +
                "Duração: %d minutos (%.2f horas)\n" +
                "Valor/hora: R$ %.2f\n" +
                "Valor Total: R$ %.2f",
                sessaoSelecionada.getHoraInicio().format(DateTimeFormatter.ofPattern("HH:mm")),
                horaFinal.format(DateTimeFormatter.ofPattern("HH:mm")),
                minutos,
                minutos / 60.0,
                sessaoSelecionada.getValorHora(),
                valorCalculado
            );
            
            JOptionPane.showMessageDialog(this, info, "Valor Calculado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao calcular o valor da sessão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cmbSessaoActionPerformed

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
    private javax.swing.JComboBox<FormaPgto> cmbFormaPgto;
    private javax.swing.JComboBox<model.Funcionario> cmbFuncionario;
    private javax.swing.JComboBox<Sessao> cmbSessao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDtVenda;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JLabel lblsessao;
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
        cmbSessao.setSelectedItem(venda.getSessao());
        cmbFuncionario.setSelectedItem(venda.getFuncionario());
        cmbFormaPgto.setSelectedItem(venda.getFormaPgto());
    }
}
