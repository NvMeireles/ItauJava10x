package dev.java10x.ItauJava10x.Transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;


    public void validarTransacao(TransacaoRequest transacaoRequest){

        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação valida, transações devem ter valor maior que zero");
        }

        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Problema na Data da transação");
        }

    }

    public void adicionarTransacao(TransacaoRequest transacaoRequest){
        validarTransacao(transacaoRequest);
        transacaoRepository.salvarDados(transacaoRequest);
    }

    public void deletarTransacoes(){
        transacaoRepository.deletarDados();
    }

}
