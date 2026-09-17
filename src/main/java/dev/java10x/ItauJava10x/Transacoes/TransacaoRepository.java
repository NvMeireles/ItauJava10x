package dev.java10x.ItauJava10x.Transacoes;

import dev.java10x.ItauJava10x.Estatisticas.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> ListaDeTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacaoRequest){
        ListaDeTransacoes.add(transacaoRequest);
    }


    public void limparDados(TransacaoRequest transacaoRequest){

    }

    public void deletarDados(){
        ListaDeTransacoes.clear();
    }

    public List<TransacaoRequest> listarTransacoes(){
        return listarTransacoes();
    }

    public EstatisticaDTO estatistica(OffsetDateTime horaInicial) {

        List<TransacaoRequest> transacoes = ListaDeTransacoes
                .stream()
                .filter(transacao ->
                        !transacao.getDataHora().isBefore(horaInicial))
                .toList();

        if (transacoes.isEmpty()) {
            return new EstatisticaDTO(
                    0,
                    0.0,
                    0.0,
                    0.0,
                    0.0
            );
        }

        DoubleSummaryStatistics estatisticas = transacoes.stream()
                .mapToDouble(transacao -> transacao.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(
                estatisticas.getCount(),
                estatisticas.getAverage(),
                estatisticas.getMax(),
                estatisticas.getMin(),
                estatisticas.getSum()
        );
    }
}
