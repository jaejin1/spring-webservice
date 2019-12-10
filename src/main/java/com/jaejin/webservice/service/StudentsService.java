package com.jaejin.webservice.service;

import com.jaejin.webservice.domain.students.StudentsRepository;
import com.jaejin.webservice.dto.students.StudentsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Transactional
    public Long save(StudentsDto.RegistStudentInfo dto) {
        return studentsRepository.save(dto.toEntity()).getId();
    }
}
