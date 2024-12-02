package org.example.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class EditQuestionResponse {

    private Data data;

    @lombok.Data
    public static class Data {
        private QuestionDB questionDB;
        private VersionDB versionDB;
    }

    @lombok.Data
    public static class QuestionDB {
        private Integer _id;
        private List<Object> quizes;
        private List<Name> __names;
        private String name;
        private List<Contributor> contributors;
        private List<Object> decliners;
        private List<Object> hints;
        private List<Object> additionalQuestionsArr;
        private List<UseCase> useCases;
        private List<Object> videos;
        private List<Fact> facts;
        private List<Object> interviews;
        private List<Object> hashTags;
        private List<Object> shortAnswers;
        private List<Object> detailedAnswers;
        private String cd;
        private Boolean isDuplicated;
        private Integer useCasesLength;
        private Integer factsLength;
        private Integer answerProgressCount;
        private Integer __v;
        private Integer quizCount;
        private LockData lockData;
        private Object jsDetails;
        private String comment;
        private String type;
        private String title;
        private String answer;
        private Object originalDuplicateId;
        private Owner owner;
        private Integer contributorsScore;
    }

    @lombok.Data
    public static class VersionDB {
        private String source;
        private String sourceId;
        private List<Object> suggests;
        private List<Object> approvers;
        private List<Object> decliners;
        private List<Contributor> contributors;
        private List<Object> prevApprovers;
        private String cd;
        private Integer _id;
        private Integer approveScore;
        private Integer version;
        private Integer subVersion;
        private Integer patch;
        private String versionStr;
        private Integer versionSort;
        private String name;
        private String dataStr;
        private Object letters;
        private String versionStrUniq;
        private Integer __v;
        private Data data;
        private Boolean isLTS;
        private Owner owner;
        private Owner firstOwner;
        private Integer contributorsScore;
    }

    @lombok.Data
    public static class Name {
        private String name;
        private String type;
    }

    @lombok.Data
    public static class Contributor {
        private Integer grade;
        private Integer user;
        private String name;
        private Long cd;
    }

    @lombok.Data
    public static class UseCase {
        private String name;
        private String desc;
    }

    @lombok.Data
    public static class Fact {
        private String name;
        private String desc;
    }

    @lombok.Data
    public static class LockData {
        private Long startCd;
        private Long cd;
        private Integer user;
    }

    @lombok.Data
    public static class Owner {
        private Integer grade;
        private Integer user;
        private String name;
        private Long cd;
    }
}

