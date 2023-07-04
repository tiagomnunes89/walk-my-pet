package br.edu.iftm.walkmypet.services;

import br.edu.iftm.walkmypet.controllers.ClienteController;
import br.edu.iftm.walkmypet.data.vo.ClienteVO;
import br.edu.iftm.walkmypet.mapper.DozerMapper;
import br.edu.iftm.walkmypet.model.Cliente;
import br.edu.iftm.walkmypet.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<ClienteVO> findAll() {
        var clienteDbList = repository.findAll();
        var clientes = DozerMapper.parseListObject(clienteDbList, ClienteVO.class);
        clientes.forEach(cliente -> cliente.add(linkTo(methodOn(ClienteController.class).findById(cliente.getClienteID()))
                .withSelfRel()
        ));
        return clientes;
    }

    public ClienteVO findById(Long id) {
        Optional<Cliente> clienteDb = repository.findById(id);
        if (clienteDb.isPresent()) {
            var cliente = DozerMapper.parseObject(clienteDb.get(), ClienteVO.class);
            cliente.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
            return cliente;
        }
        return null;
    }

    public ClienteVO save(ClienteVO clienteVO) {
        if (verifyCliente(clienteVO)) {
            Cliente cliente = DozerMapper.parseObject(clienteVO, Cliente.class);
            var clienteDb = repository.save(cliente);
            clienteVO = DozerMapper.parseObject(clienteDb, ClienteVO.class);
            clienteVO.add(linkTo(methodOn(ClienteController.class)
                    .findById(clienteVO.getClienteID())).withSelfRel());
            return clienteVO;
        }
        return null;
    }

    public ClienteVO update(ClienteVO clienteVO) {
        Optional<Cliente> dbCliente = repository.findById(clienteVO.getClienteID());
        if (dbCliente.isPresent() && verifyCliente(clienteVO)) {
            Cliente cliente = DozerMapper.parseObject(clienteVO, Cliente.class);
            cliente = repository.save(cliente);
            clienteVO = DozerMapper.parseObject(cliente, ClienteVO.class);
            clienteVO.add(linkTo(methodOn(ClienteController.class)
                    .findById(clienteVO.getClienteID())).withSelfRel());
            return clienteVO;
        }
        return null;
    }

    public String delete(Long id) {
        var dbCliente = repository.findById(id);
        if (dbCliente.isPresent()) {
            repository.deleteById(id);

            return "Cliente with id " + id + " has been deleted!";
        } else
            return "ID " + id + " not found!";
    }

    private boolean verifyCliente(ClienteVO clienteVO) {
        return !clienteVO.getPrimeiro_nome().isBlank() && !clienteVO.getPrimeiro_nome().isEmpty() &&
                !clienteVO.getSobrenome().isBlank() && !clienteVO.getSobrenome().isEmpty() &&
                !clienteVO.getDocumento().isBlank() && !clienteVO.getDocumento().isEmpty() &&
                !clienteVO.getTelefone().isBlank() && !clienteVO.getTelefone().isEmpty() &&
                !clienteVO.getUsername().isBlank() && !clienteVO.getUsername().isEmpty() &&
                clienteVO.getEnderecoVO() != null && clienteVO.getDataNascimento() != null
                && !clienteVO.getSenha().isBlank() && !clienteVO.getSenha().isEmpty();
    }
}
