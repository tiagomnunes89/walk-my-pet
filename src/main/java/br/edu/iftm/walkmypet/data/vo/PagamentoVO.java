package br.edu.iftm.walkmypet.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PagamentoVO extends RepresentationModel<ClienteVO> implements Serializable {
    private Long pagamentoID;
    private ClienteVO clienteVO;
    private List<ServicoVO> servicosVO;
    private Float total;
    private String statusPagto;
    private String tipoPagto;

    public PagamentoVO(Long pagamentoID, ClienteVO clienteVO, List<ServicoVO> servicosVO, Float total, String statusPagto, String tipoPagto) {
        this.pagamentoID = pagamentoID;
        this.clienteVO = clienteVO;
        this.servicosVO = servicosVO;
        this.total = total;
        this.statusPagto = statusPagto;
        this.tipoPagto = tipoPagto;
    }

    public Long getPagamentoID() {
        return pagamentoID;
    }

    public void setPagamentoID(Long pagamentoID) {
        this.pagamentoID = pagamentoID;
    }

    public ClienteVO getClienteVO() {
        return clienteVO;
    }

    public void setClienteVO(ClienteVO clienteVO) {
        this.clienteVO = clienteVO;
    }

    public List<ServicoVO> getServicosVO() {
        return servicosVO;
    }

    public void setServicosVO(List<ServicoVO> servicosVO) {
        this.servicosVO = servicosVO;
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
        if (!super.equals(o)) return false;

        PagamentoVO that = (PagamentoVO) o;

        if (!Objects.equals(pagamentoID, that.pagamentoID)) return false;
        if (!Objects.equals(clienteVO, that.clienteVO)) return false;
        if (!Objects.equals(servicosVO, that.servicosVO)) return false;
        if (!Objects.equals(total, that.total)) return false;
        if (!Objects.equals(statusPagto, that.statusPagto)) return false;
        return Objects.equals(tipoPagto, that.tipoPagto);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (pagamentoID != null ? pagamentoID.hashCode() : 0);
        result = 31 * result + (clienteVO != null ? clienteVO.hashCode() : 0);
        result = 31 * result + (servicosVO != null ? servicosVO.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (statusPagto != null ? statusPagto.hashCode() : 0);
        result = 31 * result + (tipoPagto != null ? tipoPagto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PagamentoVO{" +
                "pagamentoID=" + pagamentoID +
                ", clienteVO=" + clienteVO +
                ", servicosVO=" + servicosVO +
                ", total=" + total +
                ", statusPagto='" + statusPagto + '\'' +
                ", tipoPagto='" + tipoPagto + '\'' +
                '}';
    }
}
