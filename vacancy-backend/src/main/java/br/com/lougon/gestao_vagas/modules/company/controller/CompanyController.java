package br.com.lougon.gestao_vagas.modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lougon.gestao_vagas.exceptions.CompanyAlreadyExists;
import br.com.lougon.gestao_vagas.modules.company.entity.CompanyEntity;
import br.com.lougon.gestao_vagas.modules.company.usecase.CreateCompanyUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try{
            CompanyEntity result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        } catch(CompanyAlreadyExists ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body("Unknown error: " + ex.getMessage());
        }
    }
}