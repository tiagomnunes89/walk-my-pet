package br.edu.iftm.walkmypet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/historicos")
public class HistoricoController {

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object object){
        return  ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return  ResponseEntity.ok(null);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return  ResponseEntity.ok(null);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable Long id){
        return  ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return  ResponseEntity.ok(null);
    }
}
