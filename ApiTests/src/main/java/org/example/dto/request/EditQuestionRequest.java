package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditQuestionRequest {

    private String currentLTS;
    private String changeKey;
    private String question;
    private LTP ltp;
    private VersionDetails versionDetails;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LTP {
        private Data data;
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private String jsDetails;
        private String comment;
        private List<Object> quizes;
        private List<Object> hints;
        private String type;
        private List<Object> videos;
        private String name;
        private List<Object> hashTags;
        private String title;
        private String answer;
        private List<Fact> facts;
        private List<UseCase> useCases;
        private String originalDuplicateId;
        private String questionId;
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Fact {
        private String name;
        private String desc;
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UseCase {
        private String name;
        private String desc;
    }

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VersionDetails {
        private int patch;
        private int subVersion;
        private int version;
        private String versionStr;
    }
}

