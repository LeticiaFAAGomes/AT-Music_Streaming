package br.edu.infnet.music_streaming_api.musica.domain;

import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @ManyToOne
    private Musica musica;

    public Favorito(Musica musica) {
        this.musica = musica;
    }
}
