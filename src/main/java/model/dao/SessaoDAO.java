package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Sessao;

public class SessaoDAO extends PersistenciaJPA {

    public List<Sessao> listaSessoes() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Sessao> query
                    = em.createQuery("SELECT v FROM Sessao v", Sessao.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
