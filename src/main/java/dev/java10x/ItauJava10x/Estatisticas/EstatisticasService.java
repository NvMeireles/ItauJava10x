package dev.java10x.ItauJava10x.Estatisticas;

import dev.java10x.ItauJava10x.Transacoes.TransacaoRepository;
import dev.java10x.ItauJava10x.Transacoes.TransacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EstatisticasService {

@Autowired
    private TransacaoRepository transacaoRepository;

    public EstatisticasResponse buscarEstatisticas(){

        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime limite = agora.minusSeconds(60);

        List<TransacaoRequest> ultimastransacoes = transacaoRepository
                .listarTransacoes()
                .stream()
                .filter(transacaoRequest -> transacaoRequest.getDataHora().isBefore(limite))
                .toList();

        if (ultimastransacoes.isEmpty()){
            EstatisticasResponse response = new EstatisticasResponse();

            response.setCount(0);
            response.setSum(BigDecimal.ZERO);
            response.setAvg(BigDecimal.ZERO);
            response.setMin(BigDecimal.ZERO);
            response.setMax(BigDecimal.ZERO);

            return response;
        }

        long count = ultimastransacoes.size();
        BigDecimal sum = ultimastransacoes.stream()
                .map(TransacaoRequest::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal avg = sum.divide(
                BigDecimal.valueOf(count),
                2,
                RoundingMode.HALF_UP
        );
        BigDecimal min = ultimastransacoes.stream()
                .map(TransacaoRequest::getValor)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        BigDecimal max = ultimastransacoes.stream()
                .map(TransacaoRequest::getValor)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        EstatisticasResponse response = new EstatisticasResponse();
        response.setCount(count);
        response.setSum(sum);
        response.setAvg(avg);
        response.setMin(min);
        response.setMax(max);

        return response;
    }


}
