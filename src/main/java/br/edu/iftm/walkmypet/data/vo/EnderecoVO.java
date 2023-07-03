package br.edu.iftm.walkmypet.data.vo;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class EnderecoVO extends RepresentationModel<ClienteVO> implements Serializable {
    private Long enderecoID;
    private String tipo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    public EnderecoVO(Long enderecoID, String tipo, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String pais, String cep) {
        this.enderecoID = enderecoID;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public Long getEnderecoID() {
        return enderecoID;
    }

    public void setEnderecoID(Long enderecoID) {
        this.enderecoID = enderecoID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        EnderecoVO that = (EnderecoVO) o;

        if (!Objects.equals(enderecoID, that.enderecoID)) return false;
        if (!Objects.equals(tipo, that.tipo)) return false;
        if (!Objects.equals(logradouro, that.logradouro)) return false;
        if (!Objects.equals(numero, that.numero)) return false;
        if (!Objects.equals(complemento, that.complemento)) return false;
        if (!Objects.equals(bairro, that.bairro)) return false;
        if (!Objects.equals(cidade, that.cidade)) return false;
        if (!Objects.equals(estado, that.estado)) return false;
        if (!Objects.equals(pais, that.pais)) return false;
        return Objects.equals(cep, that.cep);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (enderecoID != null ? enderecoID.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (logradouro != null ? logradouro.hashCode() : 0);
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (complemento != null ? complemento.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EnderecoVO{" +
                "enderecoID=" + enderecoID +
                ", tipo='" + tipo + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
