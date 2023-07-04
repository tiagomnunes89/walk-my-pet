package br.edu.iftm.walkmypet.services;

import br.edu.iftm.walkmypet.controllers.PagamentoController;
import br.edu.iftm.walkmypet.data.vo.PagamentoVO;
import br.edu.iftm.walkmypet.mapper.DozerMapper;
import br.edu.iftm.walkmypet.model.Pagamento;
import br.edu.iftm.walkmypet.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public List<PagamentoVO> findAll() {
        var pagamentoDbList = repository.findAll();
        var pagamentos = DozerMapper.parseListObject(pagamentoDbList, PagamentoVO.class);
        pagamentos.forEach(pagamento -> pagamento.add(linkTo(methodOn(PagamentoController.class).findById(pagamento.getPagamentoID()))
                .withSelfRel()
        ));
        return pagamentos;
    }

    public PagamentoVO findById(Long id) {
        Optional<Pagamento> pagamentoDb = repository.findById(id);
        if (pagamentoDb.isPresent()) {
            var pagamento = DozerMapper.parseObject(pagamentoDb.get(), PagamentoVO.class);
            pagamento.add(linkTo(methodOn(PagamentoController.class).findById(id)).withSelfRel());
            return pagamento;
        }
        return null;
    }

    public PagamentoVO save(PagamentoVO pagamentoVO) {
        if (verifyPagamento(pagamentoVO)) {
            var pagamento = repository.save(DozerMapper.parseObject(pagamentoVO, Pagamento.class));
            pagamentoVO = DozerMapper.parseObject(pagamento, PagamentoVO.class);
            pagamentoVO.add(linkTo(methodOn(PagamentoController.class).findById(pagamentoVO.getPagamentoID())).withSelfRel());
            return pagamentoVO;
        }
        return null;
    }

    public PagamentoVO update(PagamentoVO pagamentoVO) {
        var dbPagamento = repository.findById(pagamentoVO.getPagamentoID());
        if (dbPagamento.isPresent() && verifyPagamento(pagamentoVO)) {
            var pagamento = repository.save(DozerMapper.parseObject(pagamentoVO, Pagamento.class));
            pagamentoVO = DozerMapper.parseObject(pagamento, PagamentoVO.class);
            pagamentoVO.add(linkTo(methodOn(PagamentoController.class).findById(pagamentoVO.getPagamentoID())).withSelfRel());
            return pagamentoVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbPagamento = repository.findById(id);
        if (dbPagamento.isPresent()) {
            repository.deleteById(id);
            return "Pagamento with id " + id + " has been deleted!";
        }
        return "ID " + id + " not found!";
    }

    private boolean verifyPagamento(PagamentoVO pagamentoVO) {
        return pagamentoVO.getClienteVO() != null && pagamentoVO.getServicosVO() != null
                && pagamentoVO.getServicosVO().size() >= 1 && pagamentoVO.getTotal() != null
                && !pagamentoVO.getTipoPagto().isBlank() && !pagamentoVO.getTipoPagto().isEmpty()
                && !pagamentoVO.getStatusPagto().isBlank() && !pagamentoVO.getStatusPagto().isEmpty();
    }
}

