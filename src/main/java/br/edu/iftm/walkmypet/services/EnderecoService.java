package br.edu.iftm.walkmypet.services;

import br.edu.iftm.walkmypet.controllers.EnderecoController;
import br.edu.iftm.walkmypet.data.vo.EnderecoVO;
import br.edu.iftm.walkmypet.mapper.DozerMapper;
import br.edu.iftm.walkmypet.model.Endereco;
import br.edu.iftm.walkmypet.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<EnderecoVO> findAll() {
        var enderecoDbList = repository.findAll();
        var enderecos = DozerMapper.parseListObject(enderecoDbList, EnderecoVO.class);
        enderecos.forEach(endereco -> endereco.add(linkTo(methodOn(EnderecoController.class).findById(endereco.getEnderecoID()))
                .withSelfRel()
        ));
        return enderecos;
    }

    public EnderecoVO findById(Long id) {
        Optional<Endereco> enderecoDb = repository.findById(id);
        if (enderecoDb.isPresent()) {
            var endereco = DozerMapper.parseObject(enderecoDb.get(), EnderecoVO.class);
            endereco.add(linkTo(methodOn(EnderecoController.class).findById(id)).withSelfRel());
            return endereco;
        }
        return null;
    }

    public EnderecoVO save(EnderecoVO enderecoVO) {
        if (verifyEndereco(enderecoVO)) {
            var endereco = repository.save(DozerMapper.parseObject(enderecoVO, Endereco.class));
            enderecoVO = DozerMapper.parseObject(endereco, EnderecoVO.class);
            enderecoVO.add(linkTo(methodOn(EnderecoController.class).findById(enderecoVO.getEnderecoID())).withSelfRel());
            return enderecoVO;
        }
        return null;
    }

    public EnderecoVO update(EnderecoVO enderecoVO) {
        var dbEndereco = repository.findById(enderecoVO.getEnderecoID());
        if (dbEndereco.isPresent() && verifyEndereco(enderecoVO)) {
            var endereco = repository.save(DozerMapper.parseObject(enderecoVO, Endereco.class));
            enderecoVO = DozerMapper.parseObject(endereco, EnderecoVO.class);
            enderecoVO.add(linkTo(methodOn(EnderecoController.class).findById(enderecoVO.getEnderecoID())).withSelfRel());
            return enderecoVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbEndereco = repository.findById(id);
        if (dbEndereco.isPresent()) {
            repository.deleteById(id);
            return "Endereco with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyEndereco(EnderecoVO enderecoVO) {
        return !enderecoVO.getLogradouro().isBlank() && !enderecoVO.getLogradouro().isEmpty() &&
                !enderecoVO.getCep().isBlank() && !enderecoVO.getCep().isEmpty() &&
                !enderecoVO.getCidade().isBlank() && !enderecoVO.getCidade().isEmpty() &&
                !enderecoVO.getEstado().isBlank() && !enderecoVO.getEstado().isEmpty() &&
                !enderecoVO.getPais().isBlank() && !enderecoVO.getPais().isEmpty() &&
                !enderecoVO.getNumero().isBlank() && !enderecoVO.getNumero().isEmpty() &&
                !enderecoVO.getBairro().isBlank() && !enderecoVO.getBairro().isEmpty();
    }
}

