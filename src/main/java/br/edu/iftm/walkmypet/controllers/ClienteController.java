package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.ClienteVO;
import br.edu.iftm.walkmypet.services.ClienteService;
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
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Operation(
            operationId = "postCliente",
            summary = "Cria um novo cliente",
            tags = {"cliente"},
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ClienteVO.class
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/clientes"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<?> post(@RequestBody ClienteVO clienteVO) {
        return ResponseEntity.ok(clienteService.save(clienteVO));
    }

    @Operation(
            operationId = "getByIdCliente",
            summary = "Retorna um cliente",
            tags = {"cliente"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = ClienteVO.class
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
            value = {"/clientes/{id}"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @Operation(
            operationId = "getAllClientes",
            summary = "Retorna uma lista de clientes",
            tags = {"cliente"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = ClienteVO.class
                                    )
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/clientes"},
            produces = {"application/json"}
    )
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @Operation(
            operationId = "pachByIdCliente",
            summary = "Cria um novo cliente",
            tags = {"cliente"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ClienteVO.class
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
            value = {"/clientes/{id}"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<?> patch(@PathVariable Long id, @RequestBody ClienteVO clienteVO ) {
        return ResponseEntity.ok(clienteService.update(id,clienteVO));
    }

    @Operation(
            operationId = "deleteByIdCliente",
            summary = "Cria um novo cliente",
            tags = {"cliente"},
            responses = {@ApiResponse(
                    responseCode = "400",
                    description = "Invalid pet value"
            )}
    )
    @RequestMapping(
            method = {RequestMethod.DELETE},
            value = {"/clientes/{id}"}
    )
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
