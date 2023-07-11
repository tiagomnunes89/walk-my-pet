package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.services.CadastroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @Operation(
            operationId = "postCadastro",
            summary = "Cria um novo cadastro",
            tags = {"cadastro"},
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = CadastroVO.class
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/cadastros"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<?> post(@RequestBody CadastroVO cadastroVO) {
        return ResponseEntity.ok(cadastroService.save(cadastroVO));
    }

    @Operation(
            operationId = "getByIdCadastro",
            summary = "Retorna um cadastros",
            tags = {"cadastro"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = CadastroVO.class
                                    )
                            )
                    )}
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Invalid ID supplied"
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Not found"
            )}
    )
    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/cadastros/{id}"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroService.findById(id));
    }

    @Operation(
            operationId = "getAllCadastro",
            summary = "Retorna uma lista de cadastros",
            tags = {"cadastro"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = CadastroVO.class
                                    )
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/cadastros"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(cadastroService.findAll());
    }

    @Operation(
            operationId = "pachByIdCadastro",
            summary = "Cria um novo cadastro",
            tags = {"cadastro"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = CadastroVO.class
                            )
                    )}
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Invalid ID supplied"
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Not found"
            )}
    )
    @RequestMapping(
            method = {RequestMethod.PATCH},
            value = {"/cadastros/{id}"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody CadastroVO cadastroVO ) {
        return ResponseEntity.ok(cadastroService.update(id,cadastroVO));
    }

    @Operation(
            operationId = "deleteByIdCadastro",
            summary = "Cria um novo cadastro",
            tags = {"cadastro"},
            responses = {@ApiResponse(
                    responseCode = "400",
                    description = "Invalid pet value"
            )}
    )
    @RequestMapping(
            method = {RequestMethod.DELETE},
            value = {"/cadastros/{id}"}
    )
    public ResponseEntity<?> delete(@PathVariable Long id) {
        cadastroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
