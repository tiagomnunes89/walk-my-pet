package br.edu.iftm.walkmypet.controllers;

import br.edu.iftm.walkmypet.data.vo.CadastroVO;
import br.edu.iftm.walkmypet.data.vo.PetVO;
import br.edu.iftm.walkmypet.services.PetService;
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
public class PetController {

    @Autowired
    private PetService petService;
    @Operation(
            operationId = "postPet",
            summary = "Cria um novo pet",
            tags = { "pet" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PetVO.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/pets",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<PetVO> post(@RequestBody PetVO petVO) {
        return ResponseEntity.ok(petService.save(petVO));
    }

    @Operation(
            operationId = "getAllPets",
            summary = "Retorna uma lista de pets",
            tags = { "pet" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PetVO.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/pets",
            produces = { "application/json" }
    )
    public ResponseEntity<List<PetVO>> findAll() {
        return ResponseEntity.ok(petService.findAll());
    }

    @Operation(
            operationId = "getByIdPets",
            summary = "Retorna um pet",
            tags = { "pet" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PetVO.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/pets/{id}",
            produces = { "application/json" }
    )
    public ResponseEntity<PetVO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.findById(id));
    }

    @Operation(
            operationId = "pachByIdPet",
            summary = "Cria um novo pet",
            tags = { "pet" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Created", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = PetVO.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
                    @ApiResponse(responseCode = "404", description = "Not found")
            }
    )
    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/pets/{id}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<PetVO> patch(@PathVariable Long id, @RequestBody PetVO petVO ) {
        return ResponseEntity.ok(petService.update(id,petVO));
    }

    @Operation(
            operationId = "deleteByIdPet",
            summary = "Cria um novo pet",
            tags = { "pet" },
            responses = {
                    @ApiResponse(responseCode = "400", description = "Invalid pet value")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/pets/{id}"
    )
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
