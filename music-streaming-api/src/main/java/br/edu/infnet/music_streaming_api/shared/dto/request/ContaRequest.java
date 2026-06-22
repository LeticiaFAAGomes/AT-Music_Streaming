package br.edu.infnet.music_streaming_api.shared.dto.request;

import lombok.Data;

@Data
public class ContaRequest {
    private String nome;
    private String email;
    private String numeroCartao;
    private String dataValidade;
    private String cvv;
}
