package com.example.mongodb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author weizihan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student {

    @Id
    private String studentId;

    private String studentName;

    private Integer studentAge;

    private Double studentScore;

    private Date studentBirthday;
}
