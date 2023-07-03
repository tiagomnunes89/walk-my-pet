package br.edu.iftm.walkmypet.repositories;

import br.edu.iftm.walkmypet.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
