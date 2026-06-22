package br.edu.infnet.music_streaming_api.conta.infrastructure;

import br.edu.infnet.music_streaming_api.conta.domain.CartaoCredito;
import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaAdapter {

    @Autowired
    private ContaJpaRepository repositorioConta;

    public boolean isCartaoAtivo(Long idConta) {
        return repositorioConta.findById(idConta)
                .map(Conta::getCartaoCredito)
                .map(CartaoCredito::isAtivo)
                .orElse(false);
    }

    public boolean possuiAssinaturaAtiva(Long idConta) {
        return repositorioConta.findById(idConta)
                .map(Conta::possuiAssinaturaAtiva)
                .orElse(false);
    }
}
