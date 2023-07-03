package br.edu.iftm.walkmypet.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class ServicoVO extends RepresentationModel<ClienteVO> implements Serializable {
    private Long servicoID;
    private Float preco;
    private String tipo;
    private String status;
    private HistoricoVO historicoVO;

    public ServicoVO(Long servicoID, Float preco, String tipo, String status, HistoricoVO historicoVO) {
        this.servicoID = servicoID;
        this.preco = preco;
        this.tipo = tipo;
        this.status = status;
        this.historicoVO = historicoVO;
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

    public HistoricoVO getHistoricoVO() {
        return historicoVO;
    }

    public void setHistoricoVO(HistoricoVO historicoVO) {
        this.historicoVO = historicoVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ServicoVO servicoVO = (ServicoVO) o;

        if (!Objects.equals(servicoID, servicoVO.servicoID)) return false;
        if (!Objects.equals(preco, servicoVO.preco)) return false;
        if (!Objects.equals(tipo, servicoVO.tipo)) return false;
        if (!Objects.equals(status, servicoVO.status)) return false;
        return Objects.equals(historicoVO, servicoVO.historicoVO);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (servicoID != null ? servicoID.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (historicoVO != null ? historicoVO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServicoVO{" +
                "servicoID=" + servicoID +
                ", preco=" + preco +
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                ", historicoVO=" + historicoVO +
                '}';
    }
}
