package br.edu.infnet.music_streaming_api.musica.application;

import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import br.edu.infnet.music_streaming_api.conta.infrastructure.ContaJpaRepository;
import br.edu.infnet.music_streaming_api.musica.domain.Favorito;
import br.edu.infnet.music_streaming_api.musica.domain.Musica;
import br.edu.infnet.music_streaming_api.musica.domain.Playlist;
import br.edu.infnet.music_streaming_api.musica.infrastructure.FavoritoJpaRepository;
import br.edu.infnet.music_streaming_api.musica.infrastructure.MusicaJpaRepository;
import br.edu.infnet.music_streaming_api.musica.infrastructure.PlaylistJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MusicaApplicationService {

    @Autowired
    private PlaylistJpaRepository playlistRepository;
    @Autowired
    private MusicaJpaRepository musicaRepository;
    @Autowired
    private FavoritoJpaRepository favoritoRepository;
    @Autowired
    private ContaJpaRepository contaRepository;


    @Transactional
    public Playlist criarPlaylist(Long idConta, String nome) {
        Conta conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
        Playlist playlist = new Playlist(nome);
        conta.adicionarPlaylist(playlist);
        return playlistRepository.save(playlist);
    }

    @Transactional
    public void adicionarMusicaNaPlaylist(Long idPlaylist, Long idMusica) {
        Playlist playlist = playlistRepository.findById(idPlaylist)
                .orElseThrow(() -> new IllegalArgumentException("Playlist não encontrada"));
        Musica musica = musicaRepository.findById(idMusica)
                .orElseThrow(() -> new IllegalArgumentException("Música não encontrada"));
        playlist.adicionarMusica(musica);
        playlistRepository.save(playlist);
    }

    @Transactional
    public void favoritar(Long idConta, Long idMusica) {
        Conta conta = contaRepository.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
        Musica musica = musicaRepository.findById(idMusica)
                .orElseThrow(() -> new IllegalArgumentException("Música não encontrada"));
        Favorito favorito = new Favorito(musica);
        conta.adicionarFavorito(favorito);
        favoritoRepository.save(favorito);
    }

    @Transactional
    public void desfavoritar(Long idConta, Long idMusica) {
        favoritoRepository.deleteByContaIdAndMusicaId(idConta, idMusica);
    }
}
