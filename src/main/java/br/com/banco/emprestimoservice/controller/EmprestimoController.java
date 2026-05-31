package br.com.banco.emprestimoservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.emprestimoservice.dto.EmprestimoRequest;
import br.com.banco.emprestimoservice.dto.EmprestimoResponse;
import br.com.banco.emprestimoservice.entity.Emprestimo;
import br.com.banco.emprestimoservice.service.EmprestimoService;


@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public EmprestimoResponse solicitarEmprestimo(@RequestBody EmprestimoRequest request) {
        Emprestimo emprestimo = new Emprestimo(request.getValor());
        return emprestimoService.solicitacarEmprestimo(emprestimo, request.getSalario());
    }
    
}
