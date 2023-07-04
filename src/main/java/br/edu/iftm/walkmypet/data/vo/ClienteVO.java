package br.edu.iftm.walkmypet.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ClienteVO extends RepresentationModel<ClienteVO> implements Serializable {
    private Long clienteID;
    private String username;
    private String senha;
    private String primeiro_nome;
    private String sobrenome;
    private Date dataNascimento;
    private String documento;
    private String telefone;
    private String email;
    private EnderecoVO enderecoVO;
    private List<PetVO> petsVO = new ArrayList<>();
    private List<PagamentoVO> pagamentosVO = new ArrayList<>();

    public ClienteVO(Long clienteID, String username, String senha, String primeiro_nome, String sobrenome,
                     Date dataNascimento, String documento, String telefone, String email, EnderecoVO enderecoVO, List<PetVO> petsVO, List<PagamentoVO> pagamentosVO) {
        this.clienteID = clienteID;
        this.username = username;
        this.senha = senha;
        this.primeiro_nome = primeiro_nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.enderecoVO = enderecoVO;
        this.petsVO = petsVO;
        this.pagamentosVO = pagamentosVO;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoVO getEnderecoVO() {
        return enderecoVO;
    }

    public void setEnderecoVO(EnderecoVO enderecoVO) {
        this.enderecoVO = enderecoVO;
    }

    public List<PetVO> getPetsVO() {
        return petsVO;
    }

    public void setPetsVO(List<PetVO> petsVO) {
        this.petsVO = petsVO;
    }

    public List<PagamentoVO> getPagamentosVO() {
        return pagamentosVO;
    }

    public void setPagamentosVO(List<PagamentoVO> pagamentosVO) {
        this.pagamentosVO = pagamentosVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ClienteVO clienteVO = (ClienteVO) o;

        if (!Objects.equals(clienteID, clienteVO.clienteID)) return false;
        if (!Objects.equals(username, clienteVO.username)) return false;
        if (!Objects.equals(senha, clienteVO.senha)) return false;
        if (!Objects.equals(primeiro_nome, clienteVO.primeiro_nome))
            return false;
        if (!Objects.equals(sobrenome, clienteVO.sobrenome)) return false;
        if (!Objects.equals(dataNascimento, clienteVO.dataNascimento))
            return false;
        if (!Objects.equals(documento, clienteVO.documento)) return false;
        if (!Objects.equals(telefone, clienteVO.telefone)) return false;
        if (!Objects.equals(email, clienteVO.email)) return false;
        if (!Objects.equals(enderecoVO, clienteVO.enderecoVO)) return false;
        if (!Objects.equals(petsVO, clienteVO.petsVO)) return false;
        return Objects.equals(pagamentosVO, clienteVO.pagamentosVO);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (clienteID != null ? clienteID.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (primeiro_nome != null ? primeiro_nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (enderecoVO != null ? enderecoVO.hashCode() : 0);
        result = 31 * result + (petsVO != null ? petsVO.hashCode() : 0);
        result = 31 * result + (pagamentosVO != null ? pagamentosVO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ClienteVO{" +
                "clienteID=" + clienteID +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", primeiro_nome='" + primeiro_nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", enderecoVO=" + enderecoVO +
                ", petsVO=" + petsVO +
                ", pagamentosVO=" + pagamentosVO +
                '}';
    }
}
