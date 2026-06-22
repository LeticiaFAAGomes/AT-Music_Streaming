package br.edu.infnet.music_streaming_api.musica.infrastructure;

import br.edu.infnet.music_streaming_api.musica.domain.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritoJpaRepository extends JpaRepository<Favorito, Long> {
    void deleteByContaIdAndMusicaId(Long contaId, Long musicaId);
}
