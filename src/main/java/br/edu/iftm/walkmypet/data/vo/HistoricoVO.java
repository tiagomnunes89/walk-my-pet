package br.edu.iftm.walkmypet.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class HistoricoVO extends RepresentationModel<ClienteVO> implements Serializable {
    private Long historicoID;
    private ServicoVO servicoVO;
    private PetVO petVO;
    private String descricao;

    public HistoricoVO(Long historicoID, ServicoVO servicoVO, PetVO petVO, String descricao) {
        this.historicoID = historicoID;
        this.servicoVO = servicoVO;
        this.petVO = petVO;
        this.descricao = descricao;
    }

    public Long getHistoricoID() {
        return historicoID;
    }

    public void setHistoricoID(Long historicoID) {
        this.historicoID = historicoID;
    }

    public ServicoVO getServicoVO() {
        return servicoVO;
    }

    public void setServicoVO(ServicoVO servicoVO) {
        this.servicoVO = servicoVO;
    }

    public PetVO getPetVO() {
        return petVO;
    }

    public void setPetVO(PetVO petVO) {
        this.petVO = petVO;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        HistoricoVO that = (HistoricoVO) o;

        if (!Objects.equals(historicoID, that.historicoID)) return false;
        if (!Objects.equals(servicoVO, that.servicoVO)) return false;
        if (!Objects.equals(petVO, that.petVO)) return false;
        return Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (historicoID != null ? historicoID.hashCode() : 0);
        result = 31 * result + (servicoVO != null ? servicoVO.hashCode() : 0);
        result = 31 * result + (petVO != null ? petVO.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HistoricoVO{" +
                "historicoID=" + historicoID +
                ", servicoVO=" + servicoVO +
                ", petVO=" + petVO +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
