package br.com.banco.emprestimoservice.entity;

public class Emprestimo {
    private double valorTotal;
    private double juros;
    private int parcelas;
    private boolean aprovado;

    public Emprestimo(double valorTotal) {
        this.valorTotal = valorTotal;
        this.juros = 0.0;
        this.parcelas = 1;
        this.aprovado = false;
    }
     public void aprovar() {
        this.aprovado = true;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public boolean isAprovado() {
        return aprovado;
    }
}
