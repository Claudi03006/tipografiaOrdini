package com.savarino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savarino.entities.Ordine;

public interface OrdineDAO extends JpaRepository<Ordine, Integer> {

}
