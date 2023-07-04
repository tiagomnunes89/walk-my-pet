package br.edu.iftm.walkmypet.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cadastro_table")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cadastroID;

    @Column(name = "data_abertura", nullable = false)
    private Date dataAbertura;

    @Column(name = "origem", nullable = false)
    private String origem;

    @OneToOne
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

    public Cadastro(Long cadastroID, Date dataAbertura, String origem, Cliente cliente) {
        this.cadastroID = cadastroID;
        this.dataAbertura = dataAbertura;
        this.origem = origem;
        this.cliente = cliente;
    }

    public Cadastro() {

    }

    public Long getCadastroID() {
        return cadastroID;
    }

    public void setCadastroID(Long cadastroID) {
        this.cadastroID = cadastroID;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cadastro cadastro = (Cadastro) o;

        if (!Objects.equals(cadastroID, cadastro.cadastroID)) return false;
        if (!Objects.equals(dataAbertura, cadastro.dataAbertura))
            return false;
        if (!Objects.equals(origem, cadastro.origem)) return false;
        return Objects.equals(cliente, cadastro.cliente);
    }

    @Override
    public int hashCode() {
        int result = cadastroID != null ? cadastroID.hashCode() : 0;
        result = 31 * result + (dataAbertura != null ? dataAbertura.hashCode() : 0);
        result = 31 * result + (origem != null ? origem.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cadastro{" +
                "cadastroID=" + cadastroID +
                ", dataAbertura=" + dataAbertura +
                ", origem='" + origem + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
