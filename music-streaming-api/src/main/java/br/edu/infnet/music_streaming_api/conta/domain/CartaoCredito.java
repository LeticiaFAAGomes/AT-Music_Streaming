package br.edu.infnet.music_streaming_api.conta.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoCredito {
    private String numero;
    private YearMonth dataValidade;
    private String cvv;
    private boolean ativo;

    public CartaoCredito(String numero, YearMonth dataValidade, String cvv) {
        this.numero = numero;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
        this.ativo = true;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }
}
