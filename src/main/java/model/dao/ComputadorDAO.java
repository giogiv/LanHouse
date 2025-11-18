package model.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Computador;

public class ComputadorDAO extends PersistenciaJPA {

    public List<Computador> listaComputadores() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Computador> query
                    = em.createQuery("SELECT v FROM Computador v", Computador.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Computador> buscarPorMaquina(String maquina) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Computador> query = em.createQuery("SELECT v FROM Computador v WHERE v.numeroMaquina = :maquina", Computador.class);
            query.setParameter("maquina", maquina);
            return query.getResultList().stream().findFirst();
        } finally {
            em.close();
        }
    }
    
}
