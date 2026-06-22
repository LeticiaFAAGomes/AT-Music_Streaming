package br.edu.infnet.music_streaming_api.musica.infrastructure;

import br.edu.infnet.music_streaming_api.musica.domain.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaJpaRepository extends JpaRepository<Musica, Long> {
}
