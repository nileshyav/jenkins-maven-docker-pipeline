# Jenkins Pipeline for Spring Boot app

This repository demonstrates the end-to-end automation of a Java Spring Boot web application using Jenkins, Maven, and Docker. It showcases the evolution of a CI pipeline from a standard Declarative Jenkinsfile to an advanced, parameterized pipeline utilizing external Groovy scripts for logic separation.

## 🛠️ Tech Stack
*   **Application:** Java, Spring Boot, Maven
*   **Containerization:** Docker, DockerHub
*   **CI/CD:** Jenkins (Declarative & Scripted Pipelines, Groovy)
*   **Environment:** AWS EC2 instance

## 🚀 Project Overview

The core application is a lightweight Spring Boot service that serves a "Hello World" web page. The primary focus of this repository is the infrastructure automation required to build, test, package, and deploy this application.

I have implemented two distinct pipeline architectures to demonstrate different DevOps use cases:

### 1. The Standard Declarative Pipeline (`Jenkinsfile1`)
A straightforward, monolithic pipeline ideal for simple, single-purpose repositories.
*   **Stages:** SCM Checkout -> Maven Clean/Package -> Docker Build -> Docker Push.
*   **Security:** Utilizes Jenkins credential bindings to securely authenticate with DockerHub without exposing secrets.

### 2. The Modular Parameterized Pipeline (`Jenkinsfile2` & `script2.groovy`)
An enterprise-grade approach designed for scalability and reusability. 
*   **Parameterization:** Allows dynamic selection of target branches (`main`, `test`) and image repositories (`dockerhub`, `ECR`) at runtime.
*   **Logic Separation:** Offloads the actual build and deployment logic to an external Groovy script (`script2.groovy`). This keeps the main Jenkinsfile clean and allows the Groovy logic to be reused across multiple projects.

## ⚙️ Prerequisites to Run
To execute this pipeline in your own environment, you will need:
*   A Jenkins server running on a Linux environment (or dual-boot).
*   Docker and Maven installed on the Jenkins agent.
*   A DockerHub account.
*   Jenkins Credentials configured:
    *   ID: `dockerhub_auth` (Username with password)

## 🏗️ How It Works

1.  **Code Commit:** Changes pushed to the repository then manually trigger the pipeline.
2.  **Build Phase:** Maven compiles the Java code, runs unit tests, and packages the application into an executable `.jar` file.
3.  **Build Phase:** Docker builds a new image using the generated `.jar` file based on the provided `Dockerfile`.
4.  **Publish Phase:** The pipeline securely authenticates with the target registry (e.g., DockerHub) and pushes the tagged image, making it ready for deployment.

## 📈 Future Enhancements
*   Implement dynamic image tagging using the Git commit hash.
*   Add a deployment stage using Kubernetes manifests.