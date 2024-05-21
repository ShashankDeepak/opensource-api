package com.opensource.projects.modal.projects.gsod;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opensource.projects.modal.projects.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "gsod")
public class GsodModalNew extends Project {

    @Id
    String id;

    @Field(name = "organization_name")
    @JsonProperty("organization_name")
    String organizationName;

    @Field(name = "organization_url")
    @JsonProperty("organization_url")
    String organizationUrl;

    @Field(name = "docs_page")
    @JsonProperty("docs_page")
    String docsPage;

    @Field(name = "docs_page_url")
    @JsonProperty("docs_page_url")
    String docsPageUrl;

    @Field(name = "budget")
    @JsonProperty("budget")
    String budget;

    @Field(name = "budget_url")
    @JsonProperty("budget_url")
    String budgetUrl;

    @Field(name = "accepted_project_proposal")
    @JsonProperty("accepted_project_proposal")
    String acceptedProjectProposal;

    @Field(name = "accepted_project_proposal_url")
    @JsonProperty("accepted_project_proposal_url")
    String acceptedProjectProposalUrl;

    @Field(name = "case_study")
    @JsonProperty("case_study")
    String caseStudy;

    @Field(name = "case_study_url")
    @JsonProperty("case_study_url")
    String caseStudyUrl;

    Integer year;
}
