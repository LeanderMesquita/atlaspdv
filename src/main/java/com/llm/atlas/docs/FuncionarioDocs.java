package com.llm.atlas.docs;

import com.llm.atlas.dto.FuncionarioDto;
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

@Tag(name = "Funcionário")
public interface FuncionarioDocs {
    @Operation(summary = "Retorna todos os funcionários cadastrados.")
    @ApiResponse(
            responseCode = "200",
            description = "Todos os funcionários retornados",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = FuncionarioDto.class))
            )
    )
    ResponseEntity<List<FuncionarioDto>> getAll();


    @Operation(summary = "Retorna o funcionário procurado pelo UUID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Funcionário encontrado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Funcionário não encontrado no banco.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "EntityNotFoundException"
                            )
                    )
            )
    })
    ResponseEntity<FuncionarioDto> getById(@PathVariable String id);

    @Operation(summary = "Faz o cadastro do funcionário através do json enviado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Funcionário criado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    ResponseEntity<Void> create(@Valid @RequestBody FuncionarioDto dto);

    @Operation(summary = "Faz a atualização dos dados do funcionário.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Funcionário atualizado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Funcionário não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Funcionário não encontrado.")
                    )
            )
    })
    ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody FuncionarioDto dto);

    @Operation(summary = "Exclui o cadastro de uma mesa no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "209",
                    description = "Funcionário excluido com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Funcionário não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Funcionário não encontrado.")
                    )
            )
    })
    ResponseEntity<Void> delete(@PathVariable String id);
}
