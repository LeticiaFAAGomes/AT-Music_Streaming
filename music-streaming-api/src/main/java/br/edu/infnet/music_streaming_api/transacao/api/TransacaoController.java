package br.edu.infnet.music_streaming_api.transacao.api;

import br.edu.infnet.music_streaming_api.shared.dto.request.TransacaoRequest;
import br.edu.infnet.music_streaming_api.shared.dto.response.TransacaoResponse;
import br.edu.infnet.music_streaming_api.transacao.application.TransacaoApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoApplicationService servico;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransacaoResponse autorizar(@RequestBody TransacaoRequest request) {
        return servico.autorizar(request);
    }
}
