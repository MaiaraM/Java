import br.com.galaxyware.financas.modelo.Conta;
import br.com.galaxyware.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class TesteConta {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Leonardo");
        conta.setBanco("Caixa Economica");
        conta.setAgencia("123");
        conta.setNumero("456");

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        em.close();

    }
}
