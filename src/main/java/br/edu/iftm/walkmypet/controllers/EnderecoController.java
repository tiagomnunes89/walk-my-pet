package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.EnderecoVO;
import br.edu.iftm.walkmypet.services.EnderecoService;
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
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;
    @Operation(
            operationId = "postEndereco",
            summary = "Cria um novo endereço",
            tags = { "endereco" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoVO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/enderecos",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<EnderecoVO> post(@RequestBody EnderecoVO enderecoVO) {
        return ResponseEntity.ok(enderecoService.save(enderecoVO));
    }

    @Operation(
            operationId = "getByIdEnderecos",
            summary = "Retorna um endereco",
            tags = { "endereco" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EnderecoVO.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/enderecos/{id}",
            produces = { "application/json" }
    )
    public ResponseEntity<EnderecoVO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @Operation(
            operationId = "getAllEnderecos",
            summary = "Retorna uma lista de endereços",
            tags = { "endereco" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EnderecoVO.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/enderecos",
            produces = { "application/json" }
    )
    public ResponseEntity<List<EnderecoVO>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @Operation(
            operationId = "pachByIdEndereco",
            summary = "Cria um novo endereco",
            tags = { "endereco" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = EnderecoVO.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/enderecos/{id}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<EnderecoVO> patch(@PathVariable Long id, @RequestBody EnderecoVO enderecoVO ) {
        return ResponseEntity.ok(enderecoService.update(id,enderecoVO));
    }

    @Operation(
            operationId = "deleteByIdEndereco",
            summary = "Cria um novo endereco",
            tags = { "endereco" },
            responses = {
                    @ApiResponse(responseCode = "400", description = "Invalid pet value")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/enderecos/{id}"
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
