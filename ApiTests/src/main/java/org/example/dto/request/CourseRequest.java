package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private String name;
    private List<Module> modules;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Module {
        private Integer module;
        private String name;
    }

}
