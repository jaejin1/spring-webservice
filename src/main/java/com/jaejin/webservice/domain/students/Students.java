package com.jaejin.webservice.domain.students;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Students extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;

    private String password;

    private String name;

    private String sex;

    private String birthDay;

    private String email;

    private String phone;

    @Builder
    public Students(String studentId, String password, String name, String sex,
                    String birthDay, String email, String phone){
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
        this.email = email;
        this.phone = phone;
    }

}
