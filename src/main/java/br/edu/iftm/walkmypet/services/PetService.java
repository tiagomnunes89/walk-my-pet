package br.edu.iftm.walkmypet.services;

import br.edu.iftm.walkmypet.controllers.PetController;
import br.edu.iftm.walkmypet.data.vo.PetVO;
import br.edu.iftm.walkmypet.mapper.DozerMapper;
import br.edu.iftm.walkmypet.model.Pet;
import br.edu.iftm.walkmypet.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<PetVO> findAll() {
        var petDbList = repository.findAll();
        var pets = DozerMapper.parseListObject(petDbList, PetVO.class);
        pets.forEach(pet -> pet.add(linkTo(methodOn(PetController.class).findById(pet.getPetID()))
                .withSelfRel()
        ));
        return pets;
    }

    public PetVO findById(Long id) {
        Optional<Pet> petDb = repository.findById(id);
        if (petDb.isPresent()) {
            var pet = DozerMapper.parseObject(petDb.get(), PetVO.class);
            pet.add(linkTo(methodOn(PetController.class).findById(id)).withSelfRel());
            return pet;
        }
        return null;
    }

    public PetVO save(PetVO petVO) {
        if (verifyPet(petVO)) {
            var pet = repository.save(DozerMapper.parseObject(petVO, Pet.class));
            petVO = DozerMapper.parseObject(pet, PetVO.class);
            petVO.add(linkTo(methodOn(PetController.class).findById(petVO.getPetID())).withSelfRel());
            return petVO;
        }
        return null;
    }

    public PetVO update(PetVO petVO) {
        var dbPet = repository.findById(petVO.getPetID());
        if (dbPet.isPresent() && verifyPet(petVO)) {
            var pet = repository.save(DozerMapper.parseObject(petVO, Pet.class));
            petVO = DozerMapper.parseObject(pet, PetVO.class);
            petVO.add(linkTo(methodOn(PetController.class).findById(petVO.getPetID())).withSelfRel());
            return petVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbPet = repository.findById(id);
        if (dbPet.isPresent()) {
            repository.deleteById(id);
            return "Pet with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyPet(PetVO petVO) {
        return petVO.getClienteVO() != null
                && !petVO.getNome().isBlank() && !petVO.getNome().isEmpty()
                && !petVO.getEspecie().isBlank() && !petVO.getEspecie().isEmpty()
                && !petVO.getRaca().isBlank() && !petVO.getRaca().isEmpty()
                && !petVO.getPorte().isBlank() && !petVO.getPorte().isEmpty();
    }
}

