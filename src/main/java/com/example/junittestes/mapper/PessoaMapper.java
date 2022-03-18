package com.example.junittestes.mapper;

import com.example.junittestes.dto.PessoaDTO;
import com.example.junittestes.model.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa pessoaDtoToPessoa(PessoaDTO pessoaDTO);
}
