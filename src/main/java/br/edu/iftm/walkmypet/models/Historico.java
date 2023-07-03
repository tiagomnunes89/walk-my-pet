package br.edu.iftm.walkmypet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "historico_table")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long historicoID;
    @ManyToOne
    @JoinColumn(name = "servicoID")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "petID")
    private Pet pet;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Historico(Long historicoID, Servico servico, Pet pet, String descricao) {
        this.historicoID = historicoID;
        this.servico = servico;
        this.pet = pet;
        this.descricao = descricao;
    }

    public Historico() {

    }

    public Long getHistoricoID() {
        return historicoID;
    }

    public void setHistoricoID(Long historicoID) {
        this.historicoID = historicoID;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
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

        Historico historico = (Historico) o;

        if (!Objects.equals(historicoID, historico.historicoID))
            return false;
        if (!Objects.equals(servico, historico.servico)) return false;
        if (!Objects.equals(pet, historico.pet)) return false;
        return Objects.equals(descricao, historico.descricao);
    }

    @Override
    public int hashCode() {
        int result = historicoID != null ? historicoID.hashCode() : 0;
        result = 31 * result + (servico != null ? servico.hashCode() : 0);
        result = 31 * result + (pet != null ? pet.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "historicoID=" + historicoID +
                ", servico=" + servico +
                ", pet=" + pet +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
