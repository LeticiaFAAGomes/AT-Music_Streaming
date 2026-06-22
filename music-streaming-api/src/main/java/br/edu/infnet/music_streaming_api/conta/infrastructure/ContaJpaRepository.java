package br.edu.infnet.music_streaming_api.conta.infrastructure;

import br.edu.infnet.music_streaming_api.conta.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaJpaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByEmail(String email);
}
