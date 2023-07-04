package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.HistoricoVO;
import br.edu.iftm.walkmypet.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historicos")
public class HistoricoController {
    
    @Autowired
    private HistoricoService historicoService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody HistoricoVO historicoVO) {
        return ResponseEntity.ok(historicoService.save(historicoVO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(historicoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(historicoService.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody HistoricoVO historicoVO ) {
        return ResponseEntity.ok(historicoService.update(id,historicoVO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        historicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
