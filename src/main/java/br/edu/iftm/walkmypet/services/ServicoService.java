package br.edu.iftm.walkmypet.services;

import br.edu.iftm.walkmypet.controllers.ServicoController;
import br.edu.iftm.walkmypet.data.vo.ServicoVO;
import br.edu.iftm.walkmypet.mapper.DozerMapper;
import br.edu.iftm.walkmypet.model.Servico;
import br.edu.iftm.walkmypet.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;


    public List<ServicoVO> findAll() {
        var servicoDbList = repository.findAll();
        var servicos = DozerMapper.parseListObject(servicoDbList, ServicoVO.class);
        servicos.forEach(servico -> servico.add(linkTo(methodOn(ServicoController.class).findById(servico.getServicoID()))
                .withSelfRel()
        ));
        return servicos;
    }

    public ServicoVO findById(Long id) {
        Optional<Servico> servicoDb = repository.findById(id);
        if (servicoDb.isPresent()) {
            var servico = DozerMapper.parseObject(servicoDb.get(), ServicoVO.class);
            servico.add(linkTo(methodOn(ServicoController.class).findById(id)).withSelfRel());
            return servico;
        }
        return null;
    }

    public ServicoVO save(ServicoVO servicoVO) {
        if (verifyServico(servicoVO)) {
            var servico = repository.save(DozerMapper.parseObject(servicoVO, Servico.class));
            servicoVO = DozerMapper.parseObject(servico, ServicoVO.class);
            servicoVO.add(linkTo(methodOn(ServicoController.class).findById(servicoVO.getServicoID())).withSelfRel());
            return servicoVO;
        }
        return null;
    }

    public ServicoVO update(Long id, ServicoVO servicoVO) {
        var dbServico = repository.findById(id);
        if (dbServico.isPresent() && verifyServico(servicoVO)) {
            var servico = repository.save(DozerMapper.parseObject(servicoVO, Servico.class));
            servicoVO = DozerMapper.parseObject(servico, ServicoVO.class);
            servicoVO.add(linkTo(methodOn(ServicoController.class).findById(servicoVO.getServicoID())).withSelfRel());
            return servicoVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbServico = repository.findById(id);
        if (dbServico.isPresent()) {
            repository.deleteById(id);
            return "Servico with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyServico(ServicoVO servicoVO) {
        return servicoVO.getHistoricoVO() != null && servicoVO.getPreco() != null
                && !servicoVO.getStatus().isBlank() && !servicoVO.getStatus().isEmpty()
                && !servicoVO.getTipo().isBlank() && !servicoVO.getTipo().isEmpty();
    }
}

