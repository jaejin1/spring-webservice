package com.jaejin.webservice.web;

import com.jaejin.webservice.domain.students.Students;
import com.jaejin.webservice.domain.students.StudentsRepository;
import com.jaejin.webservice.dto.students.StudentsDto;
import com.jaejin.webservice.service.StudentsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
public class StudentContoller {

    private StudentsService studentsService;

    @PostMapping("/students")
    public ResponseEntity<StudentsDto.RegistStudentInfo> registStudent(@Valid @RequestBody StudentsDto.RegistStudentInfo students) {
        studentsService.save(students);
        return ResponseEntity.ok(students);
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<StudentsDto.ChangeEmailInfo> registStudent(@PathVariable String studentId,
                                                                     @Valid @RequestBody Students students) {

        // get

        // set
        //studentsRepository.save(students);
        return ResponseEntity.ok(new StudentsDto.ChangeEmailInfo());
    }


//    @PostMapping("/students")
//    public ResponseEntity<Students> registStudent(@Valid @RequestBody Students students) {
//        studentsRepository.save(students);
//        return ResponseEntity.ok(students);
//    }
}
