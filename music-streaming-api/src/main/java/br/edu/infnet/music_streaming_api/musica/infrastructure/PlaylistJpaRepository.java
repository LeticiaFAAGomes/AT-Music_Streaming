package br.edu.infnet.music_streaming_api.musica.infrastructure;

import br.edu.infnet.music_streaming_api.musica.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistJpaRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findByContaId(Long contaId);
}