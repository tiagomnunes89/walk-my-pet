package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.EnderecoVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @PostMapping
    public ResponseEntity<?> post(@RequestBody EnderecoVO enderecoVO) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody EnderecoVO enderecoVO) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }
}
