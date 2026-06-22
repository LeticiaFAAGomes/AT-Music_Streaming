package br.edu.infnet.music_streaming_api.assinatura.api;

import br.edu.infnet.music_streaming_api.assinatura.application.AssinaturaApplicationService;
import br.edu.infnet.music_streaming_api.shared.dto.request.AssinaturaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assinaturas")
public class AssinaturaController {

    @Autowired
    private AssinaturaApplicationService servico;

    @PostMapping
    public void assinar(@RequestBody AssinaturaRequest request) {
        servico.assinar(request);
    }
}
