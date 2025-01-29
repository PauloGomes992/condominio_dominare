package com.dominare.api.model.apartamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository <ApartamentoModel, Long> {
    
}