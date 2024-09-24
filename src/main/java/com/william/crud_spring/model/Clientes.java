package com.william.crud_spring.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@SuppressWarnings("deprecation")
@Data
@Entity

@SQLDelete(sql = "UPDATE Clientes SET status ='Inativo' WHERE id = ?" )
@Where(clause = "status = 'Ativo'")
public class Clientes { 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @org.hibernate.validator.constraints.Length(min=5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Pattern(regexp = "Pessoa Fisica|Pessoa Juridica")
    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 20, nullable = false)
    private String cnpj;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 20, nullable = false)
    private String ie;

    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @NotNull
    @Pattern(regexp= "Ativo|Inativo")
    @Column(length = 20, nullable = false)
    private String status = "Ativo";

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDateTime.now();
    }
}