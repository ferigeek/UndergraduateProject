# Proposal
## Project Summary

In this project, a software system similar to the social network X (formerly Twitter) will be developed.  
Users of this platform will be able to publish their content in different formats such as images, videos, and text. They will also be able to interact with these posts, express whether they like or dislike content, and share their opinions regarding different posts and messages. The system will attempt to analyze user interactions and present content that is more aligned with the interests and preferences of each individual user.

## Problem and Objectives

This project is being developed as a Bachelor's thesis project in Computer Science. The primary goal of this project is not necessarily innovation or solving a completely new problem; this topic may even be considered a common and repetitive subject by some. However, the main objectives of this project are, first, reinforcing and applying the knowledge acquired throughout the course of study, and second, learning and utilizing new concepts and technologies.

A variety of concepts and tools will be used throughout this project. By applying different areas of computer science, including software engineering, machine learning and artificial intelligence, data science, DevOps, and related topics, the goal is to improve understanding and practical experience in these fields.

In this project, simply building a working product is not considered the final objective. Real-world and professional engineering concerns will also be carefully considered, including:

- Producing clear, organized, and detailed documentation
- Extensively testing the software and improving confidence in the correctness and efficiency of the system
- Automating various processes such as testing, documentation generation, compiling, and deployment preparation
- Separating different system responsibilities and applying practical software engineering principles
- Considering security and secure design as a fundamental aspect of the system

## System Overview

```mermaid
flowchart TB

Client[External Clients]

API[Spring Boot Backend]

subgraph Backend[Backend Core]
    Auth[Auth Service]
    User[User Service]
    Post[Post Service]
    Feed[Feed Service]
    Logic[Business Logic]
end

subgraph Intel[Python Intelligence Layer]
    Rank[Recommendation Service]
    Analytics[Analytics Jobs]
    NLP[NLP Processing]
end

DB[(PostgreSQL Database)]

subgraph Infra[Infrastructure]
    Mon[Monitoring]

end

Client --> API

API --> Auth
API --> User
API --> Post
API --> Feed

Feed --> Rank
Rank --> Feed

Auth --> DB
User --> DB
Post --> DB
Feed --> DB

Analytics --> DB
NLP --> DB
Rank --> DB

API --> Mon
Backend --> Mon
Intel --> Mon
DB --> Mon
```

This software system is divided into separate components, each with specific responsibilities and implementation requirements. At a high level, the system consists of the following parts:

- A core backend application responsible for:
    - Managing users and authentication
    - Managing posts and user interactions (likes, comments, follows)
    - Generating and serving user feeds
    - Collecting and storing user behavioral events (logs)
- An intelligence layer responsible for processing system data and producing analytical and machine learning-based outputs. This layer is divided into two main components:
    - A recommendation service that ranks and scores posts based on user behavior, post features, and interaction history in order to generate personalized feeds
    - An analytics service that processes historical user data in batch mode to extract system-wide insights such as active users, peak activity hours, trending posts, and engagement metrics
- A database layer responsible for persistent storage of all core system data, including users, posts, interactions, and behavioral logs
- An infrastructure and monitoring layer responsible for system observability, performance tracking, and operational metrics collection

The primary focus of this project is on server-side system design and data processing, while other aspects such as advanced analytics, optimization, and infrastructure enhancements may be gradually extended during later stages of development.

---

In the following sections, the requirements of the system will be analyzed in greater detail in order to establish the necessary foundations for system design and implementation.
