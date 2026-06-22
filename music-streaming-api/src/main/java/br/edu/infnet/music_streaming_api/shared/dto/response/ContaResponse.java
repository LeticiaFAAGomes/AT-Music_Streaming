package br.edu.infnet.music_streaming_api.shared.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContaResponse {
    private Long id;
    private String nome;
    private String email;
}
