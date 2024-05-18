package com.opensource.projects.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/*
*   {
    "name": "Aarush Bhat",
    "organization": "Utreexo",
    "description": "Improvements to utreexo.",
    "mentor": "Calvin Kim",
    "university": "Vellore Institute of Technology",
    "country": "India",
    "project_links": [
      "https://github.com/mit-dci/utreexo/commits?author=r-ush"
    ],
    "year": 2021
  },
* */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sob")
public class SobModal {
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
