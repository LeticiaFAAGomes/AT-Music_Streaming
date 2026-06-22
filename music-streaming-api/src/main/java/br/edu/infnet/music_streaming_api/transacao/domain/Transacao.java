package br.edu.infnet.music_streaming_api.transacao.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idConta;
    private BigDecimal valor;
    private String comerciante;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private StatusTransacao status;

    public Transacao(Long idConta, BigDecimal valor, String comerciante,
                     LocalDateTime dataHora, StatusTransacao status) {
        this.idConta = idConta;
        this.valor = valor;
        this.comerciante = comerciante;
        this.dataHora = dataHora;
        this.status = status;
    }
}