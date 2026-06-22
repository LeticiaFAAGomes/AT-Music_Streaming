package br.edu.infnet.music_streaming_api.shared.dto.response;

import br.edu.infnet.music_streaming_api.transacao.domain.StatusTransacao;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransacaoResponse {
    private Long idTransacao;
    private StatusTransacao status;
}
