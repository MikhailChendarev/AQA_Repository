package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamResponse {

    private Data data;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private Integer _id;
        private String name;
        private List<Object> potQuizes;
        private List<Object> potQuestions;
        private List<Object> currentPotQuestions;
        private Integer user;
        private String minutesStr;
        private List<Object> startArr;
        private List<Object> quizQuestionsPlain;
        private List<Object> quizQuestionsPlainPub;
        private List<Object> questions;
        private String cd;
    }

}
