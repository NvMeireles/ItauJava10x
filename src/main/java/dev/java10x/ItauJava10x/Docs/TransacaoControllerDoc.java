package dev.java10x.ItauJava10x.Docs;

import dev.java10x.ItauJava10x.Transacoes.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Transacoes", description = "Endpoints responsaveis por criar e adicionar as transacoes")
public interface TransacaoControllerDoc {

        @Operation(summary = "Cria Transacao", description = "Recebe uma Transacao valida em uma lista"
        )
        @ApiResponse(
                responseCode = "201",
                description = "Transacao criada com sucesso"
        )
        @ApiResponse(
                responseCode = "422",
                description = "Erro de validacao capturado"
        )
        @ApiResponse(
                responseCode = "400",
                description = "Erro inesperado no servidor"
        )
        ResponseEntity<Void> adicionar(@RequestBody @Valid TransacaoRequest transacaoRequest);

        @Operation (summary = "Deleta a Transacao",
                description = "Remove todas as transacoes adicionadas a lista")

        @ApiResponse(
                responseCode = "200",
                description = "Todas as transacoes foram deletadas"
        )

        ResponseEntity<Void> deletar();

}
