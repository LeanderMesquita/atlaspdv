package com.llm.atlas.docs;

import com.llm.atlas.dto.NaoManufaturadoDto;
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

@Tag(name = "Não Manufaturados")
public interface NaoManufaturadoDocs {

    @Operation(summary = "Faz o cadastro do Não Manufaturado através do json enviado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Não manufaturado criado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    ResponseEntity<?> create(@Valid @RequestBody NaoManufaturadoDto dto);

    @Operation(summary = "Faz a atualização dos dados do Não Manufaturado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Não Manufaturado atualizado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Não Manufaturado não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Não Manufaturado não encontrado.")
                    )
            )
    })
    ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody NaoManufaturadoDto dto);
}
