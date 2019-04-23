import br.com.galaxyware.financas.modelo.Conta;
import br.com.galaxyware.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class BuscaBanco {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);

        conta.setTitular("Joao");

        em.getTransaction().commit();
    }
}
