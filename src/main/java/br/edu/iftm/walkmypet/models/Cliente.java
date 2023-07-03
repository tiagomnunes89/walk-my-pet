package br.edu.iftm.walkmypet.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente_table")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteID;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "primeiro_nome", nullable = false)
    private String primeiro_nome;
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;
    @Column(name = "documento", nullable = false)
    private String documento;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "enderecoID")
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Cliente(Long clienteID, String username, String senha, String primeiro_nome, String sobrenome, Date dataNascimento, 
                   String documento, String telefone, String email, Endereco endereco, List<Pet> pets, List<Pagamento> pagamentos) {
        this.clienteID = clienteID;
        this.username = username;
        this.senha = senha;
        this.primeiro_nome = primeiro_nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.pets = pets;
        this.pagamentos = pagamentos;
    }

    public Cliente() {

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (!Objects.equals(clienteID, cliente.clienteID)) return false;
        if (!Objects.equals(username, cliente.username)) return false;
        if (!Objects.equals(senha, cliente.senha)) return false;
        if (!Objects.equals(primeiro_nome, cliente.primeiro_nome))
            return false;
        if (!Objects.equals(sobrenome, cliente.sobrenome)) return false;
        if (!Objects.equals(dataNascimento, cliente.dataNascimento))
            return false;
        if (!Objects.equals(documento, cliente.documento)) return false;
        if (!Objects.equals(telefone, cliente.telefone)) return false;
        if (!Objects.equals(email, cliente.email)) return false;
        if (!Objects.equals(endereco, cliente.endereco)) return false;
        if (!Objects.equals(pets, cliente.pets)) return false;
        return Objects.equals(pagamentos, cliente.pagamentos);
    }

    @Override
    public int hashCode() {
        int result = clienteID != null ? clienteID.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (primeiro_nome != null ? primeiro_nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        result = 31 * result + (documento != null ? documento.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (pets != null ? pets.hashCode() : 0);
        result = 31 * result + (pagamentos != null ? pagamentos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteID=" + clienteID +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", primeiro_nome='" + primeiro_nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", pets=" + pets +
                ", pagamentos=" + pagamentos +
                '}';
    }
}
