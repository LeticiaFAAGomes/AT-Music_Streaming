package br.edu.infnet.music_streaming_api.assinatura.domain;

import br.edu.infnet.music_streaming_api.assinatura.infrastructure.AssinaturaJpaRepository;
import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import br.edu.infnet.music_streaming_api.conta.infrastructure.ContaJpaRepository;
import br.edu.infnet.music_streaming_api.shared.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class AssinaturaService {

    @Autowired
    private AssinaturaJpaRepository assinaturaJpaRepository;

    @Autowired
    private ContaJpaRepository contaRepository;

    @Transactional
    public Assinatura assinar(Long idConta, Plano plano) {
        Conta conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));

        if (conta.possuiAssinaturaAtiva()) {
            throw new RegraNegocioException("Usuário já possui uma assinatura ativa");
        }

        Assinatura assinatura = new Assinatura(conta, plano, LocalDate.now());
        conta.ativarAssinatura(assinatura);
        return assinaturaJpaRepository.save(assinatura);
    }
}
