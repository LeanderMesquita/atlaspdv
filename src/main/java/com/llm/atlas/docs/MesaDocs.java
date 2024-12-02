package com.llm.atlas.docs;

import com.llm.atlas.dto.MesaDto;
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

@Tag(name = "Mesa")
public interface MesaDocs {

    @Operation(summary = "Retorna todas as mesas cadastradas.")
    @ApiResponse(
            responseCode = "200",
            description = "Todas as mesas cadastradas",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = MesaDto.class))
            )
    )
    ResponseEntity<List<MesaDto>> getAll();


    @Operation(summary = "Retorna a mesa procurada pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Mesa encontrada com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Mesa não encontrada no banco.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "EntityNotFoundException"
                            )
                    )
            )
    })
    ResponseEntity<MesaDto> getById(@PathVariable Integer id);

    @Operation(summary = "Faz o cadastro da Mesa através do json enviado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Mesa criada com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    ResponseEntity<Void> create(@Valid @RequestBody MesaDto dto);

    @Operation(summary = "Faz a atualização dos dados da Mesa.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Mesa atualizada com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Mesa não encontrada.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Mesa não encontrada.")
                    )
            )
    })
    ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody MesaDto dto);

    @Operation(summary = "Exclui o cadastro de uma mesa no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "209",
                    description = "Mesa excluida com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Mesa não encontrada.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Mesa não encontrada.")
                    )
            )
    })
    ResponseEntity<Void> delete(@PathVariable Integer id);
}
