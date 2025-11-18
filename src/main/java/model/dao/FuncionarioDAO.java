package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Funcionario;

public class FuncionarioDAO extends PersistenciaJPA{
    
    public List<Funcionario> listaFuncionarios(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Funcionario> query
                    = em.createQuery("SELECT v FROM Funcionario v", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
