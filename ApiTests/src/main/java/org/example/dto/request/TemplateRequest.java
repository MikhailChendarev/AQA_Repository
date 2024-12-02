package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRequest {

    private String name;
    private String desc;
    private List<Exam> exams;
    private List<Course> courses;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Exam {
        private Integer sourceId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Course {
        private Integer sourceId;
    }

}
