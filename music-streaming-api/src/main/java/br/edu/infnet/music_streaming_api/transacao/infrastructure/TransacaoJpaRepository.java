package br.edu.infnet.music_streaming_api.transacao.infrastructure;

import br.edu.infnet.music_streaming_api.transacao.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransacaoJpaRepository extends JpaRepository<Transacao, Long> {
    @Query("SELECT t FROM Transacao t WHERE t.idConta = :idConta AND t.dataHora >= :desde")
    List<Transacao> buscarRecentesPorConta(@Param("idConta") Long idConta,
                                           @Param("desde") LocalDateTime desde);

    @Query("SELECT t FROM Transacao t WHERE t.idConta = :idConta " +
            "AND t.valor = :valor AND t.comerciante = :comerciante AND t.dataHora >= :desde")
    List<Transacao> buscarRecentesSimilares(@Param("idConta") Long idConta,
                                            @Param("valor") BigDecimal valor,
                                            @Param("comerciante") String comerciante,
                                            @Param("desde") LocalDateTime desde);
}
