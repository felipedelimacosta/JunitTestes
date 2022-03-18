package com.example.junittestes.controller;

import com.example.junittestes.dto.PessoaDTO;
import com.example.junittestes.model.Pessoa;
import com.example.junittestes.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/teste")
    public String testController(){
        return "testando API";
    }


    @PostMapping("/create")
    public Pessoa create(@RequestBody PessoaDTO pessoa){
        return pessoaService.createPessoa(pessoa);
    }

    @GetMapping("/getAll")
    public List<Pessoa> findAll(){
        return pessoaService.getAll();
    }

    @GetMapping("/getByName")
    public Pessoa findByName(@RequestBody Pessoa pessoa){
        return pessoaService.getPessoaByNome(pessoa);
    }

    @GetMapping("/getById")
    public Pessoa findById(@RequestBody Pessoa pessoa){
        return pessoaService.getPessoaByNome(pessoa);
    }
}
