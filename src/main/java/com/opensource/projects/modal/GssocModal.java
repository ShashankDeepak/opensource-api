package com.opensource.projects.modal;

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
@Document(collection = "gssoc")
public class GssocModal {
    @Id
    String id;
    String name;
    String githubUrl;

    @JsonProperty("techstack")
    @Field(name = "techstack")
    List<String> techStack;

    String hostedBy;
    Integer year;
}
