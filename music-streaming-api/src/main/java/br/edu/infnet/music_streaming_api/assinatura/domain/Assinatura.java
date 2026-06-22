package br.edu.infnet.music_streaming_api.assinatura.domain;

import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;

    @ManyToOne
    private Plano plano;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean ativa;

    public Assinatura(Conta conta, Plano plano, LocalDate dataInicio) {
        this.conta = conta;
        this.plano = plano;
        this.dataInicio = dataInicio;
        this.dataFim = dataInicio.plusMonths(plano.getDuracaoMeses());
        this.ativa = true;
    }

    public void cancelar() { this.ativa = false; }
}