package com.jaejin.webservice.service;

import com.jaejin.webservice.domain.students.Students;
import com.jaejin.webservice.domain.students.StudentsRepository;
import com.jaejin.webservice.dto.students.StudentsDto;
import com.jaejin.webservice.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentsService {
    private final StudentsRepository studentsRepository;

    public Students create(StudentsDto.RegistStudentReq dto) {
        return studentsRepository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public Students findById(long id) {
        final Optional<Students> students = studentsRepository.findById(id);
        students.orElseThrow(() -> new StudentNotFoundException(id));
        return students.get();
    }

    public Students updateStudent(long id, StudentsDto.UpdateStudentReq dto){
        final Students students = findById(id);
        students.updateStudent(dto);
        return studentsRepository.save(students);
    }
}
