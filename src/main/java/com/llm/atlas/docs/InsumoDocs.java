package com.llm.atlas.docs;

import com.llm.atlas.dto.InsumoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Insumo")
public interface InsumoDocs {
    @Operation(summary = "Retorna todos os insumos cadastrados.")
    @ApiResponse(
            responseCode = "200",
            description = "Todos os insumos retornados",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = InsumoDto.class))
            )
    )
    ResponseEntity<List<InsumoDto>> getAll();


    @Operation(summary = "Retorna o insumo procurado pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Insumo encontrado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Insumo não encontrado no banco.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "EntityNotFoundException"
                            )
                    )
            )
    })
    ResponseEntity<InsumoDto> getById(@PathVariable Integer id);

    @Operation(summary = "Faz o cadastro do insumo através do json enviado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Insumo criado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    ResponseEntity<Void> create(@Valid @RequestBody InsumoDto dto);

    @Operation(summary = "Faz a atualização dos dados do insumo.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Insumo atualizado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Insumo não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Insumo não encontrado.")
                    )
            )
    })
    ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody InsumoDto dto);

    @Operation(summary = "Exclui o cadastro de uma mesa no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "209",
                    description = "Insumo excluido com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Insumo não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Insumo não encontrado.")
                    )
            )
    })
    ResponseEntity<Void> delete(@PathVariable Integer id);
}
