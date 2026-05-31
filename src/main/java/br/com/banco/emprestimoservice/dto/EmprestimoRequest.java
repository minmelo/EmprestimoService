package br.com.banco.emprestimoservice.dto;

public class EmprestimoRequest {
    private double valor;
    private double salario;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
