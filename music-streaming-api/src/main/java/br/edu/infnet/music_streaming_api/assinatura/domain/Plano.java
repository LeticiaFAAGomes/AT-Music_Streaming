package br.edu.infnet.music_streaming_api.assinatura.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Entity
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int duracaoMeses;

    public Plano(String nome, BigDecimal preco, int duracaoMeses) {
        this.nome = nome;
        this.preco = preco;
        this.duracaoMeses = duracaoMeses;
    }
}
