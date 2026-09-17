package dev.java10x.ItauJava10x.Docs;
import dev.java10x.ItauJava10x.Estatisticas.EstatisticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(
        name = "Estatisticas",
        description = "Endpoints responsaveis por consultar as estatisticas das transacoes"
)
public interface EstatisticaControllerDoc {

        @Operation(
                summary = "Consulta estatisticas",
                description = "Retorna as estatisticas das transacoes realizadas nos ultimos segundos configurados"
        )
        @ApiResponse(
                responseCode = "200",
                description = "Estatisticas calculadas com sucesso"
        )
        @ApiResponse(
                responseCode = "400",
                description = "Erro ao consultar as estatisticas"
        )
        ResponseEntity<EstatisticaDTO> estatistica();

}
