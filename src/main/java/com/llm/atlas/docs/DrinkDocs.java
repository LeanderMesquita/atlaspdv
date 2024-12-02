package com.llm.atlas.docs;

import com.llm.atlas.dto.ComidaDto;
import com.llm.atlas.dto.DrinkDto;
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

@Tag(name = "Drink")
public interface DrinkDocs {

    @Operation(summary = "Faz o cadastro do Drink através do json enviado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Drink criado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    ResponseEntity<?> create(@Valid @RequestBody DrinkDto dto);

    @Operation(summary = "Faz a atualização dos dados do Drink.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Drink atualizado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Drink não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Drink não encontrado.")
                    )
            )
    })
    ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody DrinkDto dto);
}
