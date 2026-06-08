package br.com.banco.emprestimoservice.dto;

public class EmprestimoRequest {
    private double valor;
    private String idConta;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

}
