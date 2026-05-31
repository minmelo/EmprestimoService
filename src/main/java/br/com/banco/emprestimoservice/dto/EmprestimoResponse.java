package br.com.banco.emprestimoservice.dto;

public class EmprestimoResponse {
    private final boolean aprovado;
    private final String mensagem;

    public EmprestimoResponse(boolean aprovado, String mensagem) {
        this.aprovado = aprovado;
        this.mensagem = mensagem;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public String getMensagem() {
        return mensagem;
    }
}
