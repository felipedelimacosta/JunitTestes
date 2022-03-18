package com.example.junittestes.service;

import com.example.junittestes.dto.PessoaDTO;
import com.example.junittestes.mapper.PessoaMapper;
import com.example.junittestes.model.Pessoa;
import com.example.junittestes.repository.PessoaRepository;
import com.example.junittestes.util.PessoaCreate;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Log4j2
public class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;


    @BeforeEach
    void setup(){
        BDDMockito.when(pessoaRepository.save(ArgumentMatchers.any(Pessoa.class)))
                .thenReturn(PessoaCreate.createPessoa());

        BDDMockito.when(pessoaRepository.findByNome(ArgumentMatchers.anyString()))
                .thenReturn(PessoaCreate.createPessoa());

        BDDMockito.when(pessoaMapper.pessoaDtoToPessoa(ArgumentMatchers.any(PessoaDTO.class)))
                .thenReturn(PessoaCreate.createPessoa());
    }

    @Test
    @DisplayName("Save Return Pessoa When Sucess Ful")
    void save_ReturnPessoa_WhenSucessFul(){
        Long expectId = PessoaCreate.createPessoa().getId();

        Pessoa pessoa = pessoaService.createPessoa(PessoaCreate.createPessoaDTO());

        Assertions.assertThat(pessoa).isNotNull();

        log.info("Id criado pelo Create Pessoa" + expectId);
        log.info("Id criado pelo ServicePessoa" + pessoa.getId());

        Assertions.assertThat(pessoa.getId())
                .isNotNull()
                .isEqualTo(expectId);
    }


    @Test
    @DisplayName("Get Return Pessoa When Sucess Ful")
    void get_ReturnPessoa_WhenSucessFul(){
        Long expectId = PessoaCreate.createPessoa().getId();

        Pessoa pessoaByNome = pessoaService.getPessoaByNome(PessoaCreate.createPessoa());

        Assertions.assertThat(pessoaByNome).isNotNull();

        log.info("Id criado pelo Create Pessoa" + expectId);
        log.info("Id criado pelo ServicePessoa" + pessoaByNome.getId());

        Assertions.assertThat(pessoaByNome.getId())
                .isNotNull()
                .isEqualTo(expectId);
    }
}
