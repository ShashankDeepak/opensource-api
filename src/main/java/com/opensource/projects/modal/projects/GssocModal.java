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
@Document(collection = "gssoc")
public class GssocModal extends Project{
    @Id
    String id;
    String name;
    @JsonProperty("github_url")
    String githubUrl;

    @JsonProperty("tech_stack")
    @Field(name = "techstack")
    List<String> techStack;

    @JsonProperty("hosted_by")
    String hostedBy;
    Integer year;
}
