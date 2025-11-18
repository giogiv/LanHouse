package view;

public class PrincipalJF extends javax.swing.JFrame {


    public PrincipalJF() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miVendedor = new javax.swing.JMenuItem();
        miCliente = new javax.swing.JMenuItem();
        miSessao = new javax.swing.JMenuItem();
        miComputador = new javax.swing.JMenuItem();
        miVenda = new javax.swing.JMenu();
        miTelaVenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Cadastro");

        miVendedor.setText("Funcionario");
        miVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVendedorActionPerformed(evt);
            }
        });
        jMenu1.add(miVendedor);

        miCliente.setText("Cliente");
        miCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClienteActionPerformed(evt);
            }
        });
        jMenu1.add(miCliente);

        miSessao.setText("Sessao");
        miSessao.setActionCommand("Sessao");
        miSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSessaoActionPerformed(evt);
            }
        });
        jMenu1.add(miSessao);

        miComputador.setText("Computador");
        miComputador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miComputadorActionPerformed(evt);
            }
        });
        jMenu1.add(miComputador);

        jMenuBar1.add(jMenu1);

        miVenda.setText("Venda");
        miVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVendaActionPerformed(evt);
            }
        });

        miTelaVenda.setText("Realizar Venda");
        miTelaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTelaVendaActionPerformed(evt);
            }
        });
        miVenda.add(miTelaVenda);

        jMenuBar1.add(miVenda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 406, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVendedorActionPerformed
        ListaFuncionariosJF telaVendedor = new ListaFuncionariosJF();
        telaVendedor.setVisible(true);
    }//GEN-LAST:event_miVendedorActionPerformed

    private void miClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClienteActionPerformed
        ListaClienteJF telaCliente = new ListaClienteJF();
        telaCliente.setVisible(true);
    }//GEN-LAST:event_miClienteActionPerformed

    private void miSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSessaoActionPerformed
        ListaSessaoJF telaSessaoJF = new ListaSessaoJF();
        telaSessaoJF.setVisible(true);
    }//GEN-LAST:event_miSessaoActionPerformed

    private void miVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVendaActionPerformed
        
    }//GEN-LAST:event_miVendaActionPerformed

    private void miTelaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTelaVendaActionPerformed
        ListaVendas telaVendas = new ListaVendas();
        telaVendas.setVisible(true);
    }//GEN-LAST:event_miTelaVendaActionPerformed

    private void miComputadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miComputadorActionPerformed
        ListaComputadoresJF telaComputador = new ListaComputadoresJF();
        telaComputador.setVisible(true);
    }//GEN-LAST:event_miComputadorActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem miCliente;
    private javax.swing.JMenuItem miComputador;
    private javax.swing.JMenuItem miSessao;
    private javax.swing.JMenuItem miTelaVenda;
    private javax.swing.JMenu miVenda;
    private javax.swing.JMenuItem miVendedor;
    // End of variables declaration//GEN-END:variables
}
