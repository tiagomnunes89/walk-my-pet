package br.edu.iftm.walkmypet.services;

import br.edu.iftm.walkmypet.controllers.HistoricoController;
import br.edu.iftm.walkmypet.data.vo.HistoricoVO;
import br.edu.iftm.walkmypet.mapper.DozerMapper;
import br.edu.iftm.walkmypet.models.Historico;
import br.edu.iftm.walkmypet.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository repository;

    public List<HistoricoVO> findAll() {
        var historicoDbList = repository.findAll();
        var historicos = DozerMapper.parseListObject(historicoDbList, HistoricoVO.class);
        historicos.forEach(historico -> historico.add(linkTo(methodOn(HistoricoController.class).findById(historico.getHistoricoID()))
                .withSelfRel()
        ));
        return historicos;
    }

    public HistoricoVO findById(Long id) {
        Optional<Historico> historicoDb = repository.findById(id);
        if (historicoDb.isPresent()) {
            var historico = DozerMapper.parseObject(historicoDb.get(), HistoricoVO.class);
            historico.add(linkTo(methodOn(HistoricoController.class).findById(id)).withSelfRel());
            return historico;
        }
        return null;
    }

    public HistoricoVO save(HistoricoVO historicoVO) {
        if (verifyHistorico(historicoVO)) {
            var historico = repository.save(DozerMapper.parseObject(historicoVO, Historico.class));
            historicoVO = DozerMapper.parseObject(historico, HistoricoVO.class);
            historicoVO.add(linkTo(methodOn(HistoricoController.class).findById(historicoVO.getHistoricoID())).withSelfRel());
            return historicoVO;
        }
        return null;
    }

    public HistoricoVO update(HistoricoVO historicoVO) {
        var dbHistorico = repository.findById(historicoVO.getHistoricoID());
        if (dbHistorico.isPresent() && verifyHistorico(historicoVO)) {
            var historico = repository.save(DozerMapper.parseObject(historicoVO, Historico.class));
            historicoVO = DozerMapper.parseObject(historico, HistoricoVO.class);
            historicoVO.add(linkTo(methodOn(HistoricoController.class).findById(historicoVO.getHistoricoID())).withSelfRel());
            return historicoVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbHistorico = repository.findById(id);
        if (dbHistorico.isPresent()) {
            repository.deleteById(id);
            return "Historico with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyHistorico(HistoricoVO historicoVO) {
        return historicoVO.getServicoVO() != null && historicoVO.getPetVO() != null
                && !historicoVO.getDescricao().isBlank() && !historicoVO.getDescricao().isEmpty();
    }
}

