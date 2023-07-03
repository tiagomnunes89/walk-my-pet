package br.edu.iftm.walkmypet.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pet_table")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petID;
    @Column(name = "especie", nullable = false)
    private String especie;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "raca", nullable = false)
    private String raca;
    @Column(name = "porte", nullable = false)
    private String porte;
    @Column(name = "informacoes_adicionais")
    private String informacoesAdicionais;
    @ManyToOne
    @JoinColumn(name = "clienteID")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "Pet_Servico",
            joinColumns = @JoinColumn(name = "petID"),
            inverseJoinColumns = @JoinColumn(name = "servicoID")
    )
    private List<Servico> servicos;

    public Pet(Long petID, String especie, String nome, Integer idade, String raca, String porte, String informacoesAdicionais, Cliente cliente, List<Servico> servicos) {
        this.petID = petID;
        this.especie = especie;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.porte = porte;
        this.informacoesAdicionais = informacoesAdicionais;
        this.cliente = cliente;
        this.servicos = servicos;
    }

    public Pet() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (!Objects.equals(petID, pet.petID)) return false;
        if (!Objects.equals(especie, pet.especie)) return false;
        if (!Objects.equals(nome, pet.nome)) return false;
        if (!Objects.equals(idade, pet.idade)) return false;
        if (!Objects.equals(raca, pet.raca)) return false;
        if (!Objects.equals(porte, pet.porte)) return false;
        if (!Objects.equals(informacoesAdicionais, pet.informacoesAdicionais))
            return false;
        if (!Objects.equals(cliente, pet.cliente)) return false;
        return Objects.equals(servicos, pet.servicos);
    }

    @Override
    public int hashCode() {
        int result = petID != null ? petID.hashCode() : 0;
        result = 31 * result + (especie != null ? especie.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (idade != null ? idade.hashCode() : 0);
        result = 31 * result + (raca != null ? raca.hashCode() : 0);
        result = 31 * result + (porte != null ? porte.hashCode() : 0);
        result = 31 * result + (informacoesAdicionais != null ? informacoesAdicionais.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (servicos != null ? servicos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", especie='" + especie + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", raca='" + raca + '\'' +
                ", porte='" + porte + '\'' +
                ", informacoesAdicionais='" + informacoesAdicionais + '\'' +
                ", cliente=" + cliente +
                ", servicos=" + servicos +
                '}';
    }
}
