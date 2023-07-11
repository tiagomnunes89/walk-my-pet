package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.HistoricoVO;
import br.edu.iftm.walkmypet.services.HistoricoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class HistoricoController {
    
    @Autowired
    private HistoricoService historicoService;

    @Operation(
            operationId = "postHistorico",
            summary = "Cria um novo pagamento",
            tags = { "historico" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.HistoricoVO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/historicos",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<HistoricoVO> post(@RequestBody HistoricoVO historicoVO) {
        return ResponseEntity.ok(historicoService.save(historicoVO));
    }

    @Operation(
            operationId = "getById",
            summary = "Retorna um historico",
            tags = { "historico" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.HistoricoVO.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/historicos/{id}",
            produces = { "application/json" }
    )
    public ResponseEntity<HistoricoVO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(historicoService.findById(id));
    }

    @Operation(
            operationId = "getAllHistorico",
            summary = "Retorna uma lista de pagamentos",
            tags = { "historico" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.HistoricoVO.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/historicos",
            produces = { "application/json" }
    )
    public ResponseEntity<List<HistoricoVO>> findAll() {
        return ResponseEntity.ok(historicoService.findAll());
    }

    @Operation(
            operationId = "pachByIdHistorico",
            summary = "Cria um novo historico",
            tags = { "historico" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.HistoricoVO.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/historicos/{id}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<HistoricoVO> patch(@PathVariable Long id, @RequestBody HistoricoVO historicoVO ) {
        return ResponseEntity.ok(historicoService.update(id,historicoVO));
    }

    @Operation(
            operationId = "deleteByIdHistorico",
            summary = "Cria um novo historico",
            tags = { "historico" },
            responses = {
                    @ApiResponse(responseCode = "400", description = "Invalid pet value")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/historicos/{id}"
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        historicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
