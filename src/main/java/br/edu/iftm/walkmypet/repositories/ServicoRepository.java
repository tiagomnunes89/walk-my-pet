package br.edu.iftm.walkmypet.repositories;

import br.edu.iftm.walkmypet.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
