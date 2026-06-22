package br.edu.infnet.music_streaming_api.musica.domain;

import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;

    @ManyToMany
    private List<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public void adicionarMusica(Musica musica) { this.musicas.add(musica); }
    public void removerMusica(Musica musica) { this.musicas.remove(musica); }
}
