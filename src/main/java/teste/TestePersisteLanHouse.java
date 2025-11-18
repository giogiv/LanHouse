/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import model.Computador;
import model.Status;
import model.dao.PersistenciaJPA;

/**
 *
 * @author vanessalagomachado
 */
public class TestePersisteLanHouse {
    public static void main(String[] args) {
        PersistenciaJPA jpa = new PersistenciaJPA();

        if (jpa.conexaoAberta()) {
            System.out.println("✅ Conexão aberta com sucesso!");
            
            Computador v = new Computador();
            v.setEspecificacoes("ABC1234");
            v.setNumeroMaquina(1323);
            v.setStatus(Status.LIVRE);

            try {
                jpa.persist(v);
                System.out.println("🚗 Computador salvo no banco!");
            } catch (Exception e) {
                System.out.println("❌ Erro ao salvar: " + e.getMessage());
            }

            jpa.fecharConexao();
        } else {
            System.out.println("❌ Falha ao abrir conexão.");
        }
    }
}
