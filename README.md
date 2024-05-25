
## OpenSource - API

This API provides you with the list of projects submitted to different opensource organizations. 

## Currently Available Organizations
- GSSoC : 2021 - 2024
- GSoD : 2021 - 2023

## Tech Stack
 - Java
 - Spring Boot
 - Spring MongoDB
 - Spring Security


## Run Locally

Clone the project

```bash
  https://github.com/ShashankDeepak/opensource-api
```

Go to the project directory

```bash
  cd opensource-api
```

Install dependencies

```bash
  mvn install
```

Start the server

```bash
  mvn spring-boot:run
```

## Documentation

### Authentication 

#### Register
```
/v1/auth/register
```
#### Description
Register a new user. The registerd user will recieve an access_token which is required for access and will be valid for 7 days and after that the user has to login.

#### Body
```JSON
"email" : "user@email.com",
"password" : "password"
```

#### Response
```JSON
"access_token" : <JWT Token>
```
#### Error

Status code : 403
```JSON
"error" : "USER_ALREADY_EXISTS"
```
#

#### Login  
```
/v1/auth/login
```

#### Description
Login a user. The user will recieve an access_token which is required for access and will be valid for 7 days and after that the user has to login again.

#### Body
```JSON
"email" : "user@email.com",
"password" : "password"
```

#### Response
```JSON
"access_token" : <JWT Token>
```
#### Error

Status code : 404
```JSON
"error" : "USER_NOT_FOUND"
```

### Projects

You will need the authotizaton header in all of your requests 
```
Bearer <JWT Token>
```

#### Path  
```
/gssoc/id={id}
```
#### Description
Get Gssoc project by id.

#### Response
```JSON
{
    "id": "6646f44e2024d0bd24c2a97d",
    "name": "Project Sakura",
    "year": 2021,
    "github_url": "https://github.com/ProjectSakura/ProjectSakura.github.io",
    "tech_stack": [
        "CSS",
        "HTML",
        "Adobe XD",
        "Javascript",
        "Logo Design"
    ],
    "hosted_by": "Arun Teltia"
}
```

#### Path  
```
/gssoc/year={year}
```
#### Description
Get all the projects by year

#### Response
```JSON
[
    {
        "id": "6646f4732024d0bd24c2d120",
        "name": "CodeSetGo Website",
        "year": 2022,
        "github_url": "https://github.com/agamjotsingh18/codesetgo-website",
        "tech_stack": [
            "ReactJS",
            "NodeJS",
            "MongoDB"
        ],
        "hosted_by": "Agamjot Singh"
    },
    .
    .
    .
]
```

#### Path  
```
/page?pageNumber=[int]&pageSize=[int]
```
#### Description
Get differnet projects seperated in pages.

#### Response
```JSON
{
    "pageSize": 20,
    "total_pages": 26,
    "content": [
        {
            "id": "6646f44e2024d0bd24c2a966",
            "name": "SheHeroes",
            "year": 2021,
            "github_url": "https://github.com/shagun25/SheHeroes",
            "tech_stack": [
                "C++",
                "DART",
                "FLUTTER",
                "SQLITE",
                "GITHUB",
                "Python",
                "FIREBASE",
                "GOOGLE API",
                "DEEPLEARNING"
            ],
            "hosted_by": "Shagun Goyal"
        },
    .
    .
    .
    ]
}
```
#### Error

Status code : 400
```JSON
{
    recived : ""
    expected : ""
    error : "INVALID_PARAMETERS"
}
```
#

#### Path  
```
/gsod/year={year}/id={id}
```
#### Description
Get Gssoc project by id. 

#### Response
If year parameter is in range of 2021 - 2023
```JSON
{
    "id": "6647274d2024d0bd24e9e13d",
    "year": 2021,
    "organization_name": "FOLIO",
    "organization_url": "https://www.folio.org",
    "docs_page": "FOLIO SoD page",
    "docs_page_url": "https://wiki.folio.org/display/COMMUNITY/Google+Season+of+Docs+2021",
    "budget": "FOLIO budget",
    "budget_url": "https://wiki.folio.org/display/COMMUNITY/Google+Season+of+Docs+2021",
    "accepted_project_proposal": "Update FOLIO End User and System Administrator Guides",
    "accepted_project_proposal_url": "https://wiki.folio.org/display/COMMUNITY/Google+Season+of+Docs+2021",
    "case_study": "FOLIO Case Study",
    "case_study_url": "https://www.folio.org/about/news-events/article/folio-updating-end-user-and-system-administrator-guides/"
},
```

If year parameter is in range of 2019 - 2020
```JSON
{
    "id": "6647273a2024d0bd24e9d425",
    "year": 2020,
    "organization": "Apache Beam",
    "organization_url": "https://github.com/apache/beam",
    "technical_writer": "Sruthi Sree Kumar",
    "mentor": "pabloem",
    "project": "Update of the runner comparison page / capability matrix",
    "project_url": "https://developers.google.com/season-of-docs/docs/2020/participants/project-apachebeam-sruthisreekumar",
    "report": "Update of the runner comparison page / capability matrix",
    "report_url": "https://docs.google.com/document/d/1qcR4PXOybynWu7q7xEmbjPc2BmTiUVeUo9CbkafsM7Q/edit?usp=sharing",
    "original_project_proposal": "Update of the runner comparison page / capability matrix",
    "original_project_proposal_url": "https://developers.google.com/season-of-docs/docs/2020/participants/project-apachebeam-sruthisreekumar"
},
```

#### Path  
```
/gsod/year={year}
```
#### Description
Get all the projects by year

#### Response
```JSON
[
    {
        "id": "6647275d2024d0bd24e9ef1b",
        "year": 2022,
        "organization_name": "LFortran",
        "organization_url": "https://lfortran.org/",
        "docs_page": "LFortran SoD page",
        "docs_page_url": "https://gitlab.com/lfortran/lfortran/-/wikis/GSoD%202022%20Ideas",
        "budget": "LFortran budget",
        "budget_url": "https://gitlab.com/lfortran/lfortran/-/wikis/GSoD%20Proposal%202022%20-%20LFortran%20Compiler%20Developer%20Documentation#project-budget",
        "accepted_project_proposal": "Compiler Developer Documentation",
        "accepted_project_proposal_url": "https://gitlab.com/lfortran/lfortran/-/wikis/GSoD%20Proposal%202022%20-%20LFortran%20Compiler%20Developer%20Documentation",
        "case_study": "LFortran Case Study",
        "case_study_url": "https://github.com/lfortran/lfortran/wiki/LFortran-Season-of-Docs-2022-Case-Study"
    },
    .
    .
    .
]
```

## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`jwt.secret`

`mongo_db_parameters`



## Features

- Pagination
- Multithreading using @Async
- Role based authorization
- JWT Authentication


## Upcoming Features

- Addition on more organizations like GSoC, Linux Foundation, Summer of Docs etc.
- Admin control
## 🔗 Contact me
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/shashank-deepak-08488922b/)
[![X](https://img.shields.io/badge/X(twitter)-black?style=for-the-badge&logo=X&logoColor=white)](https://x.com/deepak_sha26222?t=YvJItu1vkh9cOQ-QnobbSA&s=08)

