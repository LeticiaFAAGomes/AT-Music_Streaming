package br.edu.infnet.music_streaming_api.transacao.domain;

import br.edu.infnet.music_streaming_api.conta.infrastructure.ContaAdapter;
import br.edu.infnet.music_streaming_api.shared.exceptions.TransacaoNegadaException;
import br.edu.infnet.music_streaming_api.transacao.infrastructure.TransacaoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AutorizacaoTransacaoService {

    @Autowired
    private TransacaoJpaRepository transacaoRepository;
    @Autowired
    private ContaAdapter adaptadorConta;

    @Transactional
    public Transacao autorizar(Long idConta, BigDecimal valor, String comerciante) {
        if (!adaptadorConta.isCartaoAtivo(idConta)) {
            throw new TransacaoNegadaException("Cartão inativo");
        }
        if (!adaptadorConta.possuiAssinaturaAtiva(idConta)) {
            throw new TransacaoNegadaException("Usuário não possui assinatura ativa");
        }

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime doisMinutosAtras = agora.minusMinutes(2);

        List<Transacao> recentes = transacaoRepository.buscarRecentesPorConta(idConta, doisMinutosAtras);
        if (recentes.size() >= 3) {
            throw new TransacaoNegadaException("Alta frequência de transações");
        }

        List<Transacao> similares = transacaoRepository.buscarRecentesSimilares(idConta, valor, comerciante, doisMinutosAtras);
        if (similares.size() >= 2) {
            throw new TransacaoNegadaException("Transação duplicada");
        }

        Transacao transacao = new Transacao(idConta, valor, comerciante, agora, StatusTransacao.APROVADO);
        return transacaoRepository.save(transacao);
    }
}
