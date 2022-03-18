package com.example.junittestes.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDTO {

    private String nome;
    private String sobreNome;
    private int idade;
}
