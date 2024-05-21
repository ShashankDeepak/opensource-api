package com.opensource.projects.modal.projects.gsod;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opensource.projects.modal.projects.Project;
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
@Document(collection = "gsod")
public class GsodModalOld extends Project {

    @Id
    String id;

    @JsonProperty("organization")
    @Field("organization")
    String organization;

    @JsonProperty("organization_url")
    @Field("organization_url")
    String organization_url;

    @JsonProperty("technical_writer")
    @Field("technical_writer")
    String technicalWrite;

    @JsonProperty("mentor")
    @Field("mentor")
    String mentor;

    @JsonProperty("project")
    @Field("project")
    String project;

    @JsonProperty("project_url")
    @Field("project_url")
    String projectUrl;

    @JsonProperty("report")
    @Field("report")
    String report;

    @JsonProperty("report_url")
    @Field("report_url")
    String reportUrl;

    @JsonProperty("original_project_proposal")
    @Field("original_project_proposal")
    String originalProjectProposal;

    @JsonProperty("original_project_proposal_url")
    @Field("original_project_proposal_url")
    String originalProjectProposalUrl;
    Integer year;
}
