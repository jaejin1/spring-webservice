package com.jaejin.webservice.dto.students;

import com.jaejin.webservice.domain.students.Students;
import lombok.*;

public class StudentsDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RegistStudentReq {

        private String name;
        private String sex;
        private String password;
        private String birthDay;
        private String phone;
        private String email;

        @Builder
        public RegistStudentReq(String name, String sex, String password, String birthDay, String phone, String email) {
            this.name = name;
            this.sex = sex;
            this.password = password;
            this.birthDay = birthDay;
            this.phone = phone;
            this.email = email;
        }

        public Students toEntity() {
            return Students.builder()
                    .name(name)
                    .sex(sex)
                    .password(password)
                    .birthDay(birthDay)
                    .phone(phone)
                    .email(email)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdateStudentReq {
        private String password;
        private String birthDay;
        private String phone;
        private String email;

        @Builder
        public UpdateStudentReq(final String password,
                          final String birthDay,
                          final String phone,
                          final String email) {
            this.password = password;
            this.birthDay = birthDay;
            this.phone = phone;
            this.email = email;
        }
    }


    @Getter
    public static class Res {
        private String name;
        private String sex;
        private String password;
        private String birthDay;
        private String phone;
        private String email;

        public Res(Students students) {
            this.name = students.getName();
            this.sex = students.getSex();
            this.password = students.getPassword();
            this.birthDay = students.getBirthDay();
            this.phone = students.getPhone();
            this.email = students.getEmail();
        }
    }

}
