package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.ServicoVO;
import br.edu.iftm.walkmypet.services.ServicoService;
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
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @Operation(
            operationId = "postServico",
            summary = "Cria um novo serviço",
            tags = { "servico" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.ServicoVO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/servicos",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<ServicoVO> post(@RequestBody ServicoVO servicoVO) {
        return ResponseEntity.ok(servicoService.save(servicoVO));
    }

    @Operation(
            operationId = "getByIdServicos",
            summary = "Retorna um servico",
            tags = { "servico" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.ServicoVO.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/servicos/{id}",
            produces = { "application/json" }
    )
    public ResponseEntity<ServicoVO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(servicoService.findById(id));
    }

    @Operation(
            operationId = "getAllServicos",
            summary = "Retorna uma lista de serviços",
            tags = { "servico" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.ServicoVO.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/servicos",
            produces = { "application/json" }
    )
    public ResponseEntity<List<ServicoVO>> findAll() {
        return ResponseEntity.ok(servicoService.findAll());
    }

    @Operation(
            operationId = "pachByIdServico",
            summary = "Cria um novo servico",
            tags = { "servico" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = br.edu.iftm.walkmypet.vo.ServicoVO.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/servicos/{id}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<ServicoVO> patch(@PathVariable Long id, @RequestBody ServicoVO servicoVO ) {
        return ResponseEntity.ok(servicoService.update(id,servicoVO));
    }

    @Operation(
            operationId = "deleteByIdServico",
            summary = "Cria um novo servico",
            tags = { "servico" },
            responses = {
                    @ApiResponse(responseCode = "400", description = "Invalid pet value")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/servicos/{id}"
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
