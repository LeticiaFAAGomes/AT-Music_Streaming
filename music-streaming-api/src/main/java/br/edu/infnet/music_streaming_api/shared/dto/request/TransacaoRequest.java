package br.edu.infnet.music_streaming_api.shared.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransacaoRequest {
    private Long idConta;
    private BigDecimal valor;
    private String comerciante;
}
