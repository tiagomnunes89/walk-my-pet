package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.PagamentoVO;
import br.edu.iftm.walkmypet.services.PagamentoService;
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
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @Operation(
            operationId = "postPagamento",
            summary = "Cria um novo pagamento",
            tags = { "pagamento" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PagamentoVO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/pagamentos",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<PagamentoVO> post(@RequestBody PagamentoVO pagamentoVO) {
        return ResponseEntity.ok(pagamentoService.save(pagamentoVO));
    }

    @Operation(
            operationId = "getByIdPagamentos",
            summary = "Retorna um pagamento",
            tags = { "pagamento" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PagamentoVO.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/pagamentos/{id}",
            produces = { "application/json" }
    )
    public ResponseEntity<PagamentoVO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoService.findById(id));
    }

    @Operation(
            operationId = "getAllPagamentos",
            summary = "Retorna uma lista de pagamentos",
            tags = { "pagamento" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PagamentoVO.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/pagamentos",
            produces = { "application/json" }
    )
    public ResponseEntity<List<PagamentoVO>> findAll() {
        return ResponseEntity.ok(pagamentoService.findAll());
    }

    @Operation(
            operationId = "pachByIdPagamento",
            summary = "Cria um novo pagamento",
            tags = { "pagamento" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PagamentoVO.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/pagamentos/{id}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<PagamentoVO> patch(@PathVariable Long id, @RequestBody PagamentoVO pagamentoVO ) {
        return ResponseEntity.ok(pagamentoService.update(id,pagamentoVO));
    }

    @Operation(
            operationId = "deleteByIdPagamento",
            summary = "Cria um novo pagamento",
            tags = { "pagamento" },
            responses = {
                    @ApiResponse(responseCode = "400", description = "Invalid pet value")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/pagamentos/{id}"
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pagamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
