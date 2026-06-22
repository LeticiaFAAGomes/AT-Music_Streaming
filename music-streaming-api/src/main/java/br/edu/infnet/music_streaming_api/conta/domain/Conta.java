package br.edu.infnet.music_streaming_api.conta.domain;

import br.edu.infnet.music_streaming_api.musica.domain.Favorito;
import br.edu.infnet.music_streaming_api.musica.domain.Playlist;
import br.edu.infnet.music_streaming_api.shared.exceptions.RegraNegocioException;
import br.edu.infnet.music_streaming_api.assinatura.domain.Assinatura;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @Embedded
    private CartaoCredito cartaoCredito;

    @OneToOne(mappedBy = "conta", cascade = CascadeType.ALL)
    private Assinatura assinaturaAtiva;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlists = new ArrayList<>();

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorito> favoritos = new ArrayList<>();

    public Conta(String nome, String email, CartaoCredito cartaoCredito) {
        this.nome = nome;
        this.email = email;
        this.cartaoCredito = cartaoCredito;
    }

    public boolean possuiAssinaturaAtiva() {
        return assinaturaAtiva != null && assinaturaAtiva.isAtiva();
    }

    public void ativarAssinatura(Assinatura assinatura) {
        if (possuiAssinaturaAtiva()) {
            throw new RegraNegocioException("O usuário já possui uma assinatura ativa.");
        }
        this.assinaturaAtiva = assinatura;
        assinatura.setConta(this);
    }

    public void desativarCartao() {
        this.cartaoCredito.desativar();
    }

    public void ativarCartao() {
        this.cartaoCredito.ativar();
    }

    public void adicionarPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
        playlist.setConta(this);
    }

    public void adicionarFavorito(Favorito favorito) {
        this.favoritos.add(favorito);
        favorito.setConta(this);
    }
}