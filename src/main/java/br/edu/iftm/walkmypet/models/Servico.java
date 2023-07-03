package br.edu.iftm.walkmypet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "servico_table")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long servicoID;
    @Column(name = "preco", nullable = false)
    private Float preco;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "status", nullable = false)
    private String status;
    @OneToOne
    @JoinColumn(name = "historicoID")
    private Historico historico;

    public Servico(Long servicoID, Float preco, String tipo, String status, Historico historico) {
        this.servicoID = servicoID;
        this.preco = preco;
        this.tipo = tipo;
        this.status = status;
        this.historico = historico;
    }


    public Servico() {

    }

    public Long getServicoID() {
        return servicoID;
    }

    public void setServicoID(Long servicoID) {
        this.servicoID = servicoID;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servico servico = (Servico) o;

        if (!Objects.equals(servicoID, servico.servicoID)) return false;
        if (!Objects.equals(preco, servico.preco)) return false;
        if (!Objects.equals(tipo, servico.tipo)) return false;
        if (!Objects.equals(status, servico.status)) return false;
        return Objects.equals(historico, servico.historico);
    }

    @Override
    public int hashCode() {
        int result = servicoID != null ? servicoID.hashCode() : 0;
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (historico != null ? historico.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "servicoID=" + servicoID +
                ", preco=" + preco +
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                ", historico=" + historico +
                '}';
    }
}
