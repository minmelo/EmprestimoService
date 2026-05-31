package br.com.banco.emprestimoservice.service;

import org.springframework.stereotype.Service;

import br.com.banco.emprestimoservice.dto.EmprestimoResponse;
import br.com.banco.emprestimoservice.entity.Emprestimo;

@Service
public class EmprestimoService {
   private final double multiplicadorMaxEmprestimo = 10.0;

   public EmprestimoResponse solicitacarEmprestimo(Emprestimo emprestimo, double salario) {
    if (salario <= 0) {
            return new EmprestimoResponse(false, "Salário inválido");
    }
    if (emprestimo.getValorTotal() > salario * multiplicadorMaxEmprestimo) {
        return new EmprestimoResponse(false, "Valor do empréstimo excede o limite permitido"); 
    }
    emprestimo.aprovar();
    return new EmprestimoResponse(true, "Empréstimo aprovado");
}
}
