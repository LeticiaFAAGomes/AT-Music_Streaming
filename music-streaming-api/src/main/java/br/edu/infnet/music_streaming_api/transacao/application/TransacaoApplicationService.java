package br.edu.infnet.music_streaming_api.transacao.application;

import br.edu.infnet.music_streaming_api.shared.dto.request.TransacaoRequest;
import br.edu.infnet.music_streaming_api.shared.dto.response.TransacaoResponse;
import br.edu.infnet.music_streaming_api.transacao.domain.AutorizacaoTransacaoService;
import br.edu.infnet.music_streaming_api.transacao.domain.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoApplicationService {

    @Autowired
    private AutorizacaoTransacaoService servicoAutorizacao;

    @Transactional
    public TransacaoResponse autorizar(TransacaoRequest request) {
        Transacao transacao = servicoAutorizacao.autorizar(
                request.getIdConta(),
                request.getValor(),
                request.getComerciante()
        );
        return new TransacaoResponse(transacao.getId(), transacao.getStatus());
    }
}
