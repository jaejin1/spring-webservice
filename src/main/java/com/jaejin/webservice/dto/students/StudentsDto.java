package com.jaejin.webservice.dto.students;


import com.jaejin.webservice.domain.students.Students;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

public class StudentsDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RegistStudentInfo {

        private String name;
        private String sex;
        private String password;
        private String birthDay;
        private String phone;
        private String email;

        @Builder
        public RegistStudentInfo(String name, String sex, String password, String birthDay, String phone, String email) {
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
    public static class ChangeEmailInfo {
        private Long studentId;
        private String beforeEmail;
        private String afterEmail;
    }

    @Getter
    @Setter
    public static class MyInfo {
        private Long studentId;
        private String name;
        private String email;
    }

}
