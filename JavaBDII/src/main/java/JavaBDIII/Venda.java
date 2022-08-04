package JavaBDIII;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    @OneToOne
    private Cliente cliente;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<Produto>();
    private double valorTotal;

    public Venda() {}

    public Venda(String codigo, Cliente cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
        valorTotal = 0.0;
    }

    public Long getId() {
        return id;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        this.setValorTotal(valorTotal);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        for(Produto p : produtos){
            valorTotal += p.getValor();
        }
        this.valorTotal = valorTotal;
    }
}
