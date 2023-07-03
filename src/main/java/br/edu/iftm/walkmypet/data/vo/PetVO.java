package br.edu.iftm.walkmypet.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PetVO extends RepresentationModel<ClienteVO> implements Serializable {
    private Long petID;
    private String especie;
    private String nome;
    private Integer idade;
    private String raca;
    private String porte;
    private String informacoesAdicionais;
    private ClienteVO clienteVO;
    private List<ServicoVO> servicosVO;

    public PetVO(Long petID, String especie, String nome, Integer idade, String raca, String porte, String informacoesAdicionais, ClienteVO clienteVO, List<ServicoVO> servicosVO) {
        this.petID = petID;
        this.especie = especie;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.porte = porte;
        this.informacoesAdicionais = informacoesAdicionais;
        this.clienteVO = clienteVO;
        this.servicosVO = servicosVO;
    }

    public Long getPetID() {
        return petID;
    }

    public void setPetID(Long petID) {
        this.petID = petID;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PetVO petVO = (PetVO) o;

        if (!Objects.equals(petID, petVO.petID)) return false;
        if (!Objects.equals(especie, petVO.especie)) return false;
        if (!Objects.equals(nome, petVO.nome)) return false;
        if (!Objects.equals(idade, petVO.idade)) return false;
        if (!Objects.equals(raca, petVO.raca)) return false;
        if (!Objects.equals(porte, petVO.porte)) return false;
        if (!Objects.equals(informacoesAdicionais, petVO.informacoesAdicionais))
            return false;
        if (!Objects.equals(clienteVO, petVO.clienteVO)) return false;
        return Objects.equals(servicosVO, petVO.servicosVO);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (petID != null ? petID.hashCode() : 0);
        result = 31 * result + (especie != null ? especie.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idade != null ? idade.hashCode() : 0);
        result = 31 * result + (raca != null ? raca.hashCode() : 0);
        result = 31 * result + (porte != null ? porte.hashCode() : 0);
        result = 31 * result + (informacoesAdicionais != null ? informacoesAdicionais.hashCode() : 0);
        result = 31 * result + (clienteVO != null ? clienteVO.hashCode() : 0);
        result = 31 * result + (servicosVO != null ? servicosVO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PetVO{" +
                "petID=" + petID +
                ", especie='" + especie + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", raca='" + raca + '\'' +
                ", porte='" + porte + '\'' +
                ", informacoesAdicionais='" + informacoesAdicionais + '\'' +
                ", clienteVO=" + clienteVO +
                ", servicosVO=" + servicosVO +
                '}';
    }
}
