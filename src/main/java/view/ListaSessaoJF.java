package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Sessao;
import model.dao.SessaoDAO;

public class ListaSessaoJF extends javax.swing.JFrame {

    SessaoDAO dao;

    public ListaSessaoJF() {
        initComponents();
        
        dao = new SessaoDAO();
        loadSessao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSessao = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblSessao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cliente", "Computador", "Valor Total", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSessao.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblSessao);
        tblSessao.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnInfo.setText("Mais Informações");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jLabel1.setText("Tabela de Sessões");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNovo)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditar)
                            .addGap(18, 18, 18)
                            .addComponent(btnRemover)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInfo))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnInfo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroSessaoJD telaCadastro = new CadastroSessaoJD(this, rootPaneCheckingEnabled);
        telaCadastro.setVisible(true);
        
        Sessao novaSessao = telaCadastro.getSessao();
        try {
            dao.persist(novaSessao);
        } catch (Exception ex) {
            System.out.println("Erro ao iniciar a sessão "+novaSessao.toString()+" \n Erro: "+ex);
        }
        loadSessao();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        if(tblSessao.getSelectedRow() != -1){
            Sessao obj = (Sessao) tblSessao.getModel().getValueAt(tblSessao.getSelectedRow(), 0);
            
            JOptionPane.showMessageDialog(rootPane, obj.exibirDados());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma sessão");
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if(tblSessao.getSelectedRow() != -1){
            Sessao obj = (Sessao) tblSessao.getModel().getValueAt(tblSessao.getSelectedRow(), 0);
            int op_remover = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover "+obj+"?");
            if(op_remover == JOptionPane.YES_OPTION){
                try {
                    dao.remover(obj);
                } catch (Exception ex) {
                    System.out.println("Erro ao remover sessão "+obj+"\n Erro: "+ex);
                }
                JOptionPane.showMessageDialog(rootPane, "Sessão removida com sucesso... ");
                loadSessao();
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma sessão");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tblSessao.getSelectedRow() != -1){
            Sessao obj = (Sessao) tblSessao.getModel().getValueAt(tblSessao.getSelectedRow(), 0);
            CadastroSessaoJD telaEdicao = new CadastroSessaoJD(this, rootPaneCheckingEnabled);
            telaEdicao.setSessao(obj);
            
            telaEdicao.setVisible(true);
            
            try {
                dao.persist(telaEdicao.getSessao());
            } catch (Exception ex) {
                System.err.println("Erro ao editar a sessão\n Erro: "+ex);
            }
            
            loadSessao();
            
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma sessão");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaSessaoJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaSessaoJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaSessaoJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaSessaoJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaSessaoJF().setVisible(true);
            }
        });
    }
    
    public void loadSessao(){
        
        // Obtém o modelo da tabela - vincular o que definimos no Desing
        DefaultTableModel modelo = (DefaultTableModel) tblSessao.getModel();
        //limpar as linhas e popular 
        modelo.setNumRows(0);
        
        for(Sessao obj: dao.listaSessoes()){
            Object[] linha = {
                obj.getCliente(), 
                    obj.getComputador(), 
                    obj.getHoraInicio(), 
                    obj.getHoraFinal(),
                    obj.getStatus()
                            };
            modelo.addRow(linha);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSessao;
    // End of variables declaration//GEN-END:variables
}
