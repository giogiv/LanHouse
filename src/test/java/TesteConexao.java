import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;

public class TesteConexao {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteConexao() {
        // Criar o EntityManager antes de cada teste
        emf = Persistence.createEntityManagerFactory("pu-lanhouse");
        em = emf.createEntityManager();
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
}
