package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.EnderecoVO;
import br.edu.iftm.walkmypet.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;
    @PostMapping
    public ResponseEntity<?> post(@RequestBody EnderecoVO enderecoVO) {
        return ResponseEntity.ok(enderecoService.save(enderecoVO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody EnderecoVO enderecoVO ) {
        return ResponseEntity.ok(enderecoService.update(id,enderecoVO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
