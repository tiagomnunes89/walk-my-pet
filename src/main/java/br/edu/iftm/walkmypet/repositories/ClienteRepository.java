package br.edu.iftm.walkmypet.repositories;

import br.edu.iftm.walkmypet.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT u FROM Cliente u WHERE u.primeiro_nome LIKE %:nome% OR u.sobrenome LIKE %:nome%")
    List<Cliente> findClienteByName(@Param("nome") String nome);

    @Query("SELECT u FROM Cliente u WHERE u.username LIKE %:username%")
    List<Cliente> findClienteByUsername(@Param("username") String username);
}
