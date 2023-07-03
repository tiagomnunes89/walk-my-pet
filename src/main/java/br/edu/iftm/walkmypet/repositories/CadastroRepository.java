package br.edu.iftm.walkmypet.repositories;

import br.edu.iftm.walkmypet.models.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    @Query("SELECT u FROM Cliente u WHERE u.primeiro_nome LIKE %:nome% OR u.sobrenome LIKE %:nome%")
    List<Cadastro> findCadastroByName(@Param("nome") String nome);

    @Query("SELECT u FROM Cadastro u WHERE u.cliente.username LIKE %:username%")
    List<Cadastro> findCadastroByUsername(@Param("username") String username);
}
