package com.jaejin.webservice.api;

import com.jaejin.webservice.dto.students.StudentsDto.Res;
import com.jaejin.webservice.dto.students.StudentsDto;
import com.jaejin.webservice.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentContoller {

    private StudentsService studentsService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Res registStudent(@Valid @RequestBody StudentsDto.RegistStudentReq dto) {
        return new StudentsDto.Res(studentsService.create(dto));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public StudentsDto.Res getStudent(@PathVariable final long id) {
        return new StudentsDto.Res(studentsService.findById(id));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public StudentsDto.Res updateStudent(@PathVariable final long id, @RequestBody final StudentsDto.UpdateStudentReq dto){
        return new StudentsDto.Res(studentsService.updateStudent(id, dto));
    }

}
