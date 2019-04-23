import br.com.galaxyware.financas.modelo.Categoria;
import br.com.galaxyware.financas.modelo.Conta;
import br.com.galaxyware.financas.modelo.Movimentacao;
import br.com.galaxyware.financas.modelo.TipoMovimentacao;
import br.com.galaxyware.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TesteCategorias {

    public static void main(String[] args) {
        Categoria categoria1 = new Categoria();
        categoria1.setNome("viagem");

        Categoria categoria2 = new Categoria();
        categoria2.setNome("negócios");

        Conta conta = new Conta();
        conta.setId(2);

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance()); //hoje
        movimentacao1.setDescricao("Viagem à SP");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(Calendar.getInstance()); // hoje
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(categoria1); // Agora a 'categoria1' é Managed
        em.persist(categoria2);

        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();
        em.close();

    }
}
