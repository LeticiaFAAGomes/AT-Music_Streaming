package br.edu.infnet.music_streaming_api.conta.api;

import br.edu.infnet.music_streaming_api.conta.application.ContaApplicationService;
import br.edu.infnet.music_streaming_api.shared.dto.request.ContaRequest;
import br.edu.infnet.music_streaming_api.shared.dto.response.ContaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaApplicationService servico;

    @PostMapping
    public ContaResponse criar(@RequestBody ContaRequest request) {
        return servico.criar(request);
    }
}
