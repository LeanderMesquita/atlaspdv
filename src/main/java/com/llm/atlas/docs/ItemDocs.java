package com.llm.atlas.docs;

import com.llm.atlas.entity.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "Item")
public interface ItemDocs {


    @Operation(summary = "Retorna todas os itens cadastrados, independente de subtipo.")
    @ApiResponse(
            responseCode = "200",
            description = "Todos os itens cadastrados.",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Item.class))
            )
    )
    ResponseEntity<List<Item>> getAll();


    @Operation(summary = "Retorna o item procurado pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Item encontrado com sucesso.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Item.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Item não encontrado no banco.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "EntityNotFoundException"
                            )
                    )
            )
    })
    ResponseEntity<?> getById(@PathVariable Integer id);


    @Operation(summary = "Exclui o cadastro de um item no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "209",
                    description = "Item excluido com sucesso.",
                    content = @Content(
                            mediaType = "application/json"
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Item não encontrado.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(value = "Item não encontrado.")
                    )
            )
    })
    ResponseEntity<?> delete(@PathVariable Integer id);













}
