package br.edu.infnet.music_streaming_api.assinatura.infrastructure;

import br.edu.infnet.music_streaming_api.assinatura.domain.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoJpaRepository extends JpaRepository<Plano, Long> {
}