package com.dominare.api.model.people;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository <PeopleModel, Long> {
    
}
