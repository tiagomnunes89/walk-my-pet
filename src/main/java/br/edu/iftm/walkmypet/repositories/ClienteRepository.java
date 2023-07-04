package br.edu.iftm.walkmypet.repositories;

import br.edu.iftm.walkmypet.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
