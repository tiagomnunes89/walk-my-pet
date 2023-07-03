package br.edu.iftm.walkmypet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "endereco_table")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoID;
    @Column(name = "tipo_de_logradouro", nullable = false)
    private String tipo;
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "cep", nullable = false)
    private String cep;

    public Endereco(Long enderecoID, String tipo, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String pais, String cep) {
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

    public Endereco() {

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

        Endereco endereco = (Endereco) o;

        if (!Objects.equals(enderecoID, endereco.enderecoID)) return false;
        if (!Objects.equals(tipo, endereco.tipo)) return false;
        if (!Objects.equals(logradouro, endereco.logradouro)) return false;
        if (!Objects.equals(numero, endereco.numero)) return false;
        if (!Objects.equals(complemento, endereco.complemento))
            return false;
        if (!Objects.equals(bairro, endereco.bairro)) return false;
        if (!Objects.equals(cidade, endereco.cidade)) return false;
        if (!Objects.equals(estado, endereco.estado)) return false;
        if (!Objects.equals(pais, endereco.pais)) return false;
        return Objects.equals(cep, endereco.cep);
    }

    @Override
    public int hashCode() {
        int result = enderecoID != null ? enderecoID.hashCode() : 0;
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
        return "Endereco{" +
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
