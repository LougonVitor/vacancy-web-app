package br.com.lougon.gestao_vagas.exceptions;

public class CompanyAlreadyExists extends RuntimeException {
    public CompanyAlreadyExists() {
        super("Empresa já existe!");
    }
}