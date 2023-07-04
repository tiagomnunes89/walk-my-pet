package br.edu.iftm.walkmypet.services;

import br.edu.iftm.walkmypet.controllers.CadastroController;
import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.mapper.DozerMapper;
import br.edu.iftm.walkmypet.model.Cadastro;
import br.edu.iftm.walkmypet.repositories.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository repository;

    public List<CadastroVO> findAll() {
        var cadastroDbList = repository.findAll();
        var cadastros = DozerMapper.parseListObject(cadastroDbList, CadastroVO.class);
        cadastros.forEach(cadastro -> cadastro.add(linkTo(methodOn(CadastroController.class).findById(cadastro.getCadastroID()))
                .withSelfRel()
        ));
        return cadastros;
    }

    public CadastroVO findById(Long id) {
        Optional<Cadastro> cadastroDb = repository.findById(id);
        if (cadastroDb.isPresent()) {
            var cadastro = DozerMapper.parseObject(cadastroDb.get(), CadastroVO.class);
            cadastro.add(linkTo(methodOn(CadastroController.class).findById(id)).withSelfRel());
            return cadastro;
        }
        return null;
    }

    
    public CadastroVO save(CadastroVO cadastroVO) {
        if (verifyCadastro(cadastroVO)) {
            Cadastro cadastro = DozerMapper.parseObject(cadastroVO, Cadastro.class);
            var cadastroDb = repository.save(cadastro);
            cadastroVO = DozerMapper.parseObject(cadastroDb, CadastroVO.class);
            cadastroVO.add(linkTo(methodOn(CadastroController.class)
                    .findById(cadastroVO.getCadastroID())).withSelfRel());
            return cadastroVO;
        }
        return null;
    }

    public CadastroVO update(CadastroVO cadastroVO) {
        Optional<Cadastro> dbCadastro = repository.findById(cadastroVO.getCadastroID());
        if (dbCadastro.isPresent() && verifyCadastro(cadastroVO)) {
            Cadastro cadastro = DozerMapper.parseObject(cadastroVO, Cadastro.class);
            cadastro = repository.save(cadastro);
            cadastroVO = DozerMapper.parseObject(cadastro, CadastroVO.class);
            cadastroVO.add(linkTo(methodOn(CadastroController.class)
                    .findById(cadastroVO.getCadastroID())).withSelfRel());
            return cadastroVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbCadastro = repository.findById(id);
        if (dbCadastro.isPresent()) {
            repository.deleteById(id);

            return "Cadastro with id " + id + " has been deleted!";
        } else
            return "ID " + id + " not found!";
    }

    private boolean verifyCadastro(CadastroVO cadastroVO) {
        return cadastroVO.getDataAbertura() != null && cadastroVO.getCliente() != null
        &&!cadastroVO.getOrigem().isEmpty() && !cadastroVO.getOrigem().isBlank();
    }
}