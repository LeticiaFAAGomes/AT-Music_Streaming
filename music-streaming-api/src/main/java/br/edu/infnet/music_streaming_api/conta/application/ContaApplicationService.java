package br.edu.infnet.music_streaming_api.conta.application;

import br.edu.infnet.music_streaming_api.conta.domain.CartaoCredito;
import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import br.edu.infnet.music_streaming_api.conta.infrastructure.ContaJpaRepository;
import br.edu.infnet.music_streaming_api.shared.dto.request.ContaRequest;
import br.edu.infnet.music_streaming_api.shared.dto.response.ContaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;

@Service
public class ContaApplicationService {

    @Autowired
    private ContaJpaRepository repositorioConta;

    @Transactional
    public ContaResponse criar(ContaRequest request) {
        CartaoCredito cartao = new CartaoCredito(
                request.getNumeroCartao(),
                YearMonth.parse(request.getDataValidade()),
                request.getCvv()
        );
        Conta conta = new Conta(request.getNome(), request.getEmail(), cartao);
        Conta salva = repositorioConta.save(conta);
        return new ContaResponse(salva.getId(), salva.getNome(), salva.getEmail());
    }
}
