package org.example.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Interview {

    private String title;
    private LocalDate date;
    private String type;
    private String selfAssessment;
    private String link;
}
