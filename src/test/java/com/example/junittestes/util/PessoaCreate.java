package com.example.junittestes.util;

import com.example.junittestes.dto.PessoaDTO;
import com.example.junittestes.model.Pessoa;

public class PessoaCreate {


    public static Pessoa createPessoa(){

        return Pessoa.builder().id(1L).idade(24).nome("Felipe").sobreNome("de Lima").build();
    }


    public static PessoaDTO createPessoaDTO(){

        return PessoaDTO.builder().idade(24).nome("Felipe").sobreNome("de Lima").build();
    }
}
