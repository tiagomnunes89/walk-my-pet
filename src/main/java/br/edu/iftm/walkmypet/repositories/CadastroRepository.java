package br.edu.iftm.walkmypet.repositories;

import br.edu.iftm.walkmypet.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
