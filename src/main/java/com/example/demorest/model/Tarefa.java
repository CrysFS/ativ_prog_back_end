package com.example.demorest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataEntrega;

    @Column(nullable = false)
    private String responsavel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id) &&
               Objects.equals(nome, tarefa.nome) &&
               Objects.equals(dataEntrega, tarefa.dataEntrega) &&
               Objects.equals(responsavel, tarefa.responsavel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataEntrega, responsavel);
    }
}