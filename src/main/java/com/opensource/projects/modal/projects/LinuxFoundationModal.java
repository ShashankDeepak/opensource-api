package com.opensource.projects.modal.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "lf")
public class LinuxFoundationModal extends Project{

    @Id
    String id;
    String name;

    @JsonProperty("image_url")
    @Field("image_url")
    String imageUrl;

    @JsonProperty("project_url")
    @Field("project_url")
    String projectUrl;

}
