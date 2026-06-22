package br.edu.infnet.music_streaming_api.musica.api;

import br.edu.infnet.music_streaming_api.musica.application.MusicaApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    @Autowired
    private MusicaApplicationService servico;


    @PostMapping
    public void favoritar(@RequestParam Long idConta, @RequestParam Long idMusica) {
        servico.favoritar(idConta, idMusica);
    }

    @DeleteMapping
    public void desfavoritar(@RequestParam Long idConta, @RequestParam Long idMusica) {
        servico.desfavoritar(idConta, idMusica);
    }
}
