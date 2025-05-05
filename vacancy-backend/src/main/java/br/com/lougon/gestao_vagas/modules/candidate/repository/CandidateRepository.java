package br.com.lougon.gestao_vagas.modules.candidate.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import br.com.lougon.gestao_vagas.modules.candidate.entity.CandidateEntity;

@Component
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}