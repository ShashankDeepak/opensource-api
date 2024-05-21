package com.opensource.projects.modal.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sob")
public class SobModal extends Project{
    @Id
    String id;
    String name;
    String organization;
    String description;
    String mentor;
    String university;
    String country;

    @Field("project_links")
    @JsonProperty("project_links")
    List<String> projectLinks;

    Integer year;
}
