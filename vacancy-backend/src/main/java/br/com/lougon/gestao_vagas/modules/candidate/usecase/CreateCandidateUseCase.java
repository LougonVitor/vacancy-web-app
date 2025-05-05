package br.com.lougon.gestao_vagas.modules.candidate.usecase;

import br.com.lougon.gestao_vagas.exceptions.UserAlreadyExists;
import br.com.lougon.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.lougon.gestao_vagas.modules.candidate.entity.CandidateEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserAlreadyExists();
            });
            
        return this.candidateRepository.save(candidateEntity);
    }
}