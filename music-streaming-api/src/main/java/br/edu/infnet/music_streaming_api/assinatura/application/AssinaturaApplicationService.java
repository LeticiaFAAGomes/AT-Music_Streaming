package br.edu.infnet.music_streaming_api.assinatura.application;

import br.edu.infnet.music_streaming_api.assinatura.domain.AssinaturaService;
import br.edu.infnet.music_streaming_api.assinatura.domain.Plano;
import br.edu.infnet.music_streaming_api.assinatura.infrastructure.PlanoJpaRepository;
import br.edu.infnet.music_streaming_api.shared.dto.request.AssinaturaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssinaturaApplicationService {

    @Autowired
    private AssinaturaService servicoAssinatura;

    @Autowired
    private PlanoJpaRepository planoJpaRepository;

    @Transactional
    public void assinar(AssinaturaRequest request) {
        Plano plano = planoJpaRepository.findById(request.getIdPlano())
                .orElseThrow(() -> new IllegalArgumentException("Plano não encontrado"));
        servicoAssinatura.assinar(request.getIdConta(), plano);
    }
}
