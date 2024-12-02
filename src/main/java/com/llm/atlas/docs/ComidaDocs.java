package com.llm.atlas.docs;

import com.llm.atlas.dto.ComidaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Comida")
public interface ComidaDocs {

    @Operation(summary = "Faz o cadastro da Comida através do json enviado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Comida criada com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    ResponseEntity<?> create(@Valid @RequestBody ComidaDto dto);

    @Operation(summary = "Faz a atualização dos dados da Comida.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Comida atualizada com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Comida não encontrada.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Comida não encontrada.")
                    )
            )
    })
    ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody ComidaDto dto);
}
