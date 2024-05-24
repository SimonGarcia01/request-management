# Project Management System (PMS)

## Overview
Welcome to the Project Management System (PMS) README! This project is designed to improve the reception, tracking, and management of work requests within the Transformation and Improvement of Institutional Processes area at Universidad Icesi. The PMS streamlines the handling of project requests, ensuring efficient responses and better internal organization.

## Purpose
The primary goal of this project is to provide a robust system for managing project requests from various institutional areas, prioritizing them, and tracking their progress through to completion. This system addresses current inefficiencies and aims to enhance the client experience by reducing delays and improving internal coordination.

## Functionality
The PMS offers the following functionalities:

### Data Storage:
- **Requests:** Store details about project requests including registration date, brief description, status, responsible collaborator, and requesting area.
- **Areas:** Manage information about different institutional areas, including unique codes and responsible collaborators.
- **Collaborators:** Store information about collaborators including ID, full name, institutional email, and optional extension number.
- **Projects:** Track projects with a unique code, name, status, priority, leader, and type-specific details.

### Administrative Menu:
- **Register Requests:** Allow new requests to be added with all required details.
- **Change Request Status:** Update the status of existing requests.
- **Register Projects:** Convert requests into projects with appropriate classification and priority.
- **Close Projects:** Mark projects as completed and record the actual completion date.

### Query Menu:
- **View Project Matrix:** Display a matrix view of the latest 5 projects per collaborator, sorted by priority and estimated completion date.
- **Project Details:** Retrieve detailed information about a specific project using its code.
- **Efficiency Metrics:** Calculate and display efficiency metrics for collaborators, projects, and request handling.
- **Global Indicators:** Provide statistics on the number of projects by type and priority, and the number of requests received and managed per month.

## Project Structure
The project is organized into several Java classes representing different entities such as requests, areas, collaborators, and projects. Each class encapsulates relevant data and functionalities to ensure a modular and maintainable codebase. The main user interface (UI) class serves as the entry point for the application.

## Instructions to Run the Program
1. Clone the repository to your local machine.
2. Ensure you have Java installed.
3. Compile the Java files.
4. Run the main program file to access the administrative and query menus.

## Conclusion
I hope this README provides a clear overview of the Project Management System and its functionalities. Feel free to explore the codebase, make improvements, or provide feedback. Thank you for checking out my project!
