package br.edu.iftm.walkmypet.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pagamento_table")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pagamentoID;

    @ManyToOne
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

    @OneToMany(mappedBy = "pagamento")
    private List<Servico> servicos;
    @Column(name = "total", nullable = false)
    private Float total;
    @Column(name = "status_pagto", nullable = false)
    private String statusPagto;
    @Column(name = "tipo_pagto", nullable = false)
    private String tipoPagto;

    public Pagamento(Long pagamentoID, Cliente cliente, List<Servico> servicos, Float total, String statusPagto, String tipoPagto) {
        this.pagamentoID = pagamentoID;
        this.cliente = cliente;
        this.servicos = servicos;
        this.total = total;
        this.statusPagto = statusPagto;
        this.tipoPagto = tipoPagto;
    }

    public Pagamento() {

    }

    public Long getPagamentoID() {
        return pagamentoID;
    }

    public void setPagamentoID(Long pagamentoID) {
        this.pagamentoID = pagamentoID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getStatusPagto() {
        return statusPagto;
    }

    public void setStatusPagto(String statusPagto) {
        this.statusPagto = statusPagto;
    }

    public String getTipoPagto() {
        return tipoPagto;
    }

    public void setTipoPagto(String tipoPagto) {
        this.tipoPagto = tipoPagto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagamento pagamento = (Pagamento) o;

        if (!Objects.equals(pagamentoID, pagamento.pagamentoID))
            return false;
        if (!Objects.equals(cliente, pagamento.cliente)) return false;
        if (!Objects.equals(servicos, pagamento.servicos)) return false;
        if (!Objects.equals(total, pagamento.total)) return false;
        if (!Objects.equals(statusPagto, pagamento.statusPagto))
            return false;
        return Objects.equals(tipoPagto, pagamento.tipoPagto);
    }

    @Override
    public int hashCode() {
        int result = pagamentoID != null ? pagamentoID.hashCode() : 0;
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (servicos != null ? servicos.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (statusPagto != null ? statusPagto.hashCode() : 0);
        result = 31 * result + (tipoPagto != null ? tipoPagto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "pagamentoID=" + pagamentoID +
                ", cliente=" + cliente +
                ", servicos=" + servicos +
                ", total=" + total +
                ", statusPagto='" + statusPagto + '\'' +
                ", tipoPagto='" + tipoPagto + '\'' +
                '}';
    }
}
