package br.edu.infnet.music_streaming_api.assinatura.infrastructure;

import br.edu.infnet.music_streaming_api.assinatura.domain.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssinaturaJpaRepository extends JpaRepository<Assinatura, Long> {
    Optional<Assinatura> findByContaId(Long contaId);
}