package com.example.junittestes.service;

import com.example.junittestes.dto.PessoaDTO;
import com.example.junittestes.exception.BadRequestException;
import com.example.junittestes.mapper.PessoaMapper;
import com.example.junittestes.model.Pessoa;
import com.example.junittestes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    public Pessoa createPessoa(PessoaDTO pessoa){

        Pessoa pessaToSave = pessoaMapper.pessoaDtoToPessoa(pessoa);
        return pessoaRepository.save(pessaToSave);
    }

    public List<Pessoa> getAll(){
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList;
    }


    public Pessoa getPessoaByNome(Pessoa pessoa){

        return pessoaRepository.findByNome(pessoa.getNome());
    }


    public Pessoa getPessoaById(Pessoa pessoa){

        return pessoaRepository.findById(pessoa.getId())
                .orElseThrow(() -> new BadRequestException("Pessoa not foud"));
    }
}
