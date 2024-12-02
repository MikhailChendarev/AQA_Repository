package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.dto.request.TemplateRequest;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateResponse {

    public Data data;

    @EqualsAndHashCode(callSuper = true)
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data extends TemplateRequest {
        private Integer _id;
        private Integer user;
        private List<Object> sprints;
        private String cd;
    }

}
