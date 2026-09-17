package dev.java10x.ItauJava10x.Transacoes;

import dev.java10x.ItauJava10x.Docs.TransacaoControllerDoc;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController implements TransacaoControllerDoc {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody @Valid TransacaoRequest transacaoRequest){

        log.info("Recebendo nova transação");

        try{
            transacaoService.adicionarTransacao(transacaoRequest);

            log.info("Transação adicionada com sucesso");

            return  ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (IllegalArgumentException exception){
            log.error("Erro em uma ou mais validações: {}", exception.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        } catch (Exception exception){
            log.error("Erro inesperado ao adicionar transação", exception);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }

    @DeleteMapping
    public ResponseEntity deletar(){

        log.info("Deletando todas as transações");

        transacaoService.deletarTransacoes();

        log.info("Todas as transações foram deletadas com sucesso");

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
