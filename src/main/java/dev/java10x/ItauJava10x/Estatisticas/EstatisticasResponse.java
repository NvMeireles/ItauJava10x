package dev.java10x.ItauJava10x.Estatisticas;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EstatisticasResponse {

    private long count;
    private BigDecimal sum;
    private BigDecimal avg;
    private BigDecimal min;
    private BigDecimal max;
}
