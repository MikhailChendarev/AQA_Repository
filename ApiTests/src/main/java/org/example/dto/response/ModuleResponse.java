package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleResponse {

    private Data data;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private Integer _id;
        private String name;
        private List<Integer> questions;
        private Integer quizExamSize;
        private Integer user;
        private List<Object> blocks;
        private List<Object> quizes;
        private String cd;
    }

}
