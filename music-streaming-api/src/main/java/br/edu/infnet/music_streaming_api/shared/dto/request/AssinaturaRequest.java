package br.edu.infnet.music_streaming_api.shared.dto.request;

import lombok.Data;

@Data
public class AssinaturaRequest {
    private Long idConta;
    private Long idPlano;
}
