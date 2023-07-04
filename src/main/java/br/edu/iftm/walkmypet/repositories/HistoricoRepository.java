package br.edu.iftm.walkmypet.repositories;

import br.edu.iftm.walkmypet.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
