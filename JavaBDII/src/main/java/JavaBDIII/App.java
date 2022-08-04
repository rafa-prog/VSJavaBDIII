package JavaBDIII;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ) {
        @SuppressWarnings("deprecation")
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Endereco e1 = new Endereco("Travessa São Pedro", 624, "Centro", "São Lourenço do Oeste");
        
        session.save(e1);
        
        Telefone t1 = new Telefone(49, 999592907, "celular");
        Telefone t2 = new Telefone(49, 999827531, "celular");
        Cliente c1 = new Cliente("Rafael", "23/04/2003", "Masculino", "123456789012", e1);
        
        t1.setCliente(c1);
        t2.setCliente(c1);

        List<Telefone> telefones = new ArrayList<Telefone>();

        telefones.add(t1);
        telefones.add(t2);

        c1.setTelefones(telefones);

        session.save(c1);
        session.save(t1);
        session.save(t2);
        
        Produto p1 = new Produto("safjka213", "Pão", 3.00);
        Produto p2 = new Produto("adjkqw321", "Bife", 28.00);
        Venda v1 = new Venda("000-x-000", c1);

        p1.setVenda(v1);
        p2.setVenda(v1);

        List<Produto> produtos = new ArrayList<Produto>();

        produtos.add(p1);
        produtos.add(p2);

        v1.setProdutos(produtos);

        session.save(v1);
        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
