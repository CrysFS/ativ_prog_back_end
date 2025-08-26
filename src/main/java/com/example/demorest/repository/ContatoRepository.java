package com.example.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demorest.model.Contato;

@Repository
public interface ContatoRepository  extends JpaRepository <Contato, Long>{

}
