package br.com.banco.emprestimoservice.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.banco.emprestimoservice.dto.EmprestimoResponse;
import br.com.banco.emprestimoservice.dto.ResultadoDTO;
import br.com.banco.emprestimoservice.entity.Emprestimo;

@Service
public class EmprestimoService {
    private final double multiplicadorMaxEmprestimo = 10.0;

    public EmprestimoResponse solicitacarEmprestimo(Emprestimo emprestimo, String idConta) {
        ResultadoDTO salarioResponse = buscarSalario(idConta);

        if (salarioResponse == null || !salarioResponse.isSucesso()) {
            return new EmprestimoResponse(false, "Não foi possível obter o salário do cliente");

        }
        double salario = salarioResponse.getNovoValor();

        if (salario <= 0) {
            return new EmprestimoResponse(false, "Salário inválido");
        }
        if (emprestimo.getValorTotal() > salario * multiplicadorMaxEmprestimo) {
            return new EmprestimoResponse(false, "Valor do empréstimo excede o limite permitido");
        }
        emprestimo.aprovar();
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://contaprojvaporarquitetura-2.onrender.com/contas/"
                + idConta
                + "/depositar";

        HttpEntity<Map<String, Double>> request = new HttpEntity<>(Map.of(
                "valor",
                emprestimo.getValorTotal()));

        restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                String.class);

        return new EmprestimoResponse(
                true,
                "Empréstimo aprovado e valor depositado");
    }

    private ResultadoDTO buscarSalario(String idConta) {

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://contaprojvaporarquitetura-2.onrender.com/contas/"
                + idConta
                + "/salario";

        return restTemplate.getForObject(
                url,
                ResultadoDTO.class);
    }

}
