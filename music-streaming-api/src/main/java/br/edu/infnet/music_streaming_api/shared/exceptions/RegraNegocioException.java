package br.edu.infnet.music_streaming_api.shared.exceptions;

public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }
}