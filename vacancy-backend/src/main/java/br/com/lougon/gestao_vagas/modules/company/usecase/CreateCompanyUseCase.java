package br.com.lougon.gestao_vagas.modules.company.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lougon.gestao_vagas.exceptions.CompanyAlreadyExists;
import br.com.lougon.gestao_vagas.modules.company.entity.CompanyEntity;
import br.com.lougon.gestao_vagas.modules.company.repository.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public void execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).ifPresent((user) -> {
            throw new CompanyAlreadyExists();
        });

        this.companyRepository.save(companyEntity);
    }

}