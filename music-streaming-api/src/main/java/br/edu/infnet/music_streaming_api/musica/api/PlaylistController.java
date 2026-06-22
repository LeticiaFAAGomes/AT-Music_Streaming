package br.edu.infnet.music_streaming_api.musica.api;

import br.edu.infnet.music_streaming_api.musica.application.MusicaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private MusicaApplicationService servico;

    @PostMapping
    public void criar(@RequestParam Long idConta, @RequestParam String nome) {
        servico.criarPlaylist(idConta, nome);
    }

    @PostMapping("/{idPlaylist}/musicas/{idMusica}")
    public void adicionarMusica(@PathVariable Long idPlaylist, @PathVariable Long idMusica) {
        servico.adicionarMusicaNaPlaylist(idPlaylist, idMusica);
    }
}
