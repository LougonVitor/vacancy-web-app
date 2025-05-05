package br.com.lougon.gestao_vagas.exceptions;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists() {
        super("Usuário já existe!");
    }
}