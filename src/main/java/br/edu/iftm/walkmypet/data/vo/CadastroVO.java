package br.edu.iftm.walkmypet.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CadastroVO extends RepresentationModel<ClienteVO> implements Serializable {
    private Long cadastroID;
    private Date dataAbertura;
    private String origem;
    private ClienteVO clienteVO;

    public CadastroVO(Long cadastroID, Date dataAbertura, String origem, ClienteVO clienteVO) {
        this.cadastroID = cadastroID;
        this.dataAbertura = dataAbertura;
        this.origem = origem;
        this.clienteVO = clienteVO;
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

    public ClienteVO getCliente() {
        return clienteVO;
    }

    public void setCliente(ClienteVO clienteVO) {
        this.clienteVO = clienteVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CadastroVO that = (CadastroVO) o;

        if (!Objects.equals(cadastroID, that.cadastroID)) return false;
        if (!Objects.equals(dataAbertura, that.dataAbertura)) return false;
        if (!Objects.equals(origem, that.origem)) return false;
        return Objects.equals(clienteVO, that.clienteVO);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (cadastroID != null ? cadastroID.hashCode() : 0);
        result = 31 * result + (dataAbertura != null ? dataAbertura.hashCode() : 0);
        result = 31 * result + (origem != null ? origem.hashCode() : 0);
        result = 31 * result + (clienteVO != null ? clienteVO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CadastroVO{" +
                "cadastroID=" + cadastroID +
                ", dataAbertura=" + dataAbertura +
                ", origem='" + origem + '\'' +
                ", clienteVO=" + clienteVO +
                '}';
    }
}
