package com.jaejin.webservice.domain.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
}


