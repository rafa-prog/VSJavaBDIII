package JavaBDIII;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ddd;
    private int num;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "Cliente", nullable = false)
    @ForeignKey(name = "cliente_fk")
    private Cliente cliente = new Cliente();

    Telefone(){}

    Telefone(int ddd, int num, String tipo){
        this.ddd = ddd;
        this.num = num;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
