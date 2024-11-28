package com.llm.atlas.dto;
import java.util.List;

public record PedidoRequestDto(
        String id,
        List<Integer> itensId,
        Integer mesaId,
        String responsavelId
) {
}
