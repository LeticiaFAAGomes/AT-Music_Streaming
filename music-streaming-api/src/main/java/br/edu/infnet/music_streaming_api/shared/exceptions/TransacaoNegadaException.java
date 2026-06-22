package br.edu.infnet.music_streaming_api.shared.exceptions;

public class TransacaoNegadaException extends RuntimeException {
    public TransacaoNegadaException(String mensagem) {
        super(mensagem);
    }
}
