package com.llm.atlas.docs;

import com.llm.atlas.dto.PedidoDto;
import com.llm.atlas.dto.PedidoRequestDto;
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

@Tag(name = "Pedido")
public interface PedidoDocs {

    @Operation(summary = "Retorna todas os pedidos cadastrados.")
    @ApiResponse(
            responseCode = "200",
            description = "Todos os pedidos retornados",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = PedidoDto.class))
            )
    )
    ResponseEntity<List<PedidoDto>> getAll();


    @Operation(summary = "Retorna o pedido procurado pelo UUID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido encontrado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pedido não encontrado no banco.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "EntityNotFoundException"
                            )
                    )
            )
    })
    ResponseEntity<PedidoDto> getById(@PathVariable String id);

    @Operation(summary = "Faz o cadastro do Pedido através do json enviado.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Pedido criado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            )
    })
    ResponseEntity<Void> create(@Valid @RequestBody PedidoRequestDto dto);

    @Operation(summary = "Faz a atualização dos dados do Pedido.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido atualizado com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pedido não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Pedido não encontrado.")
                    )
            )
    })
    ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody PedidoRequestDto dto);

    @Operation(summary = "Exclui o cadastro de um pedido no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "209",
                    description = "Pedido excluido com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pedido não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Pedido não encontrado.")
                    )
            )
    })
    ResponseEntity<Void> delete(@PathVariable String id);
}
