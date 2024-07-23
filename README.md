[![header][header-url]][header-link]

# Programming Studio 1
[![Project Version][version-image]][version-url]
[![Backend][Backend-image]][Backend-url]
<br>
[![SQLite][SQLite-image]][SQLite-url]
[![Java][Java-image]][Java-url]
[![HTML][HTML-image]][HTML-url]
[![CSS][CSS-image]][CSS-url]
[![Js][Js-image]][Js-url]
[![Figma][Figma-image]][Figma-url]

> Website Development with a Focus on Database Management

The project focused on creating a robust website using Javalin, emphasizing user experience through Nielsen's Design Heuristics and attentive usability testing. Integration of Java for backend development, designed a 3NF database schema with attention to functional dependencies, and showcased our work through a structured presentation that highlighted our technical proficiency and teamwork. Our goal was to deliver a user-centric web application while demonstrating our skills in UX/UI design, database management, and effective project execution.

<details>
    <summary>Further project information</summary>
    <br>
    A project showcasing a comprehensive approach to web development and user experience design. At its core, the aim was to create a dynamic website using Javalin, leveraging its lightweight framework and robust capabilities to deliver a responsive and efficient web application. This choice facilitated exploration into backend development using Java but also provided a platform for integrating frontend functionalities.

Central to our project was a adherence to Nielsen's Design Heuristics, ensuring that every aspect of the user interface and experience was intuitive, efficient, and conducive to user satisfaction. Through iterative design processes and usability testing, the interface was refined to prioritize user needs, enhancing usability through intuitive navigation, clear information architecture, and seamless interaction flows.

Simultaneously, the team excelled in database management and design. An ER diagram and database schema were created in third normal form (3NF), ensuring data integrity and optimal query performance. Functional dependencies were carefully analyzed and implemented, supporting the foundation for seamless data management within the web application.

Throughout the project lifecycle, effective teamwork and organizational skills were paramount. Each team member made significant contributions, from persona development and contextual scenarios to frontend mockup creation using Figma and web development utilising the Javalin framework. Clear communication and collaborative efforts were pivotal in aligning our goals and achieving milestones effectively.

In preparation for the final presentation, slideshow was meticulously structured to encompass key elements: from detailed ER diagrams and SQL queries to live demonstrations of the web application's functionality. The presentation not only highlighted technical expertise, but also underscored the ability to convey complex concepts clearly and engage the audience effectively.

Ultimately, the project aimed not just to deliver a functional website, but to showcase the comprehensive skill set across UX/UI design, backend development, database management, and effective teamwork. By leaving assessors and the audience with a clear understanding and minimal questions, the project demonstrated the capability to handle sophisticated projects and adapt to dynamic challenges in the world of web development and user experience design.
</details>

<details>
    <summary>Assignment (Challenge) Details</summary>
    <br>
    Food loss and waste is defined as food products that end up not being eaten for a variety of reasons. Food loss occurs along the food supply chain from harvest/catch/slaughter up to, but not including, the sales level. Food waste occurs at the retail and consumption level. Reasons for loss and waste can vary during each stage. For example, consumption by pests, and spoilage/decay due to improper temperature control, can both occur during the storage stage. Food lose and waste both have a significant impact on many other current global issues, including climate change, food security (availability), resource usage (land and water) as well an impact on biodiversity among others. <br><br>
    Your challenge is to develop a web-application to <strong>help various key parties in the supply chain (including consumers and policy makers) explore unbiased information on the sources of food loss and waste over an extended time period.</strong> You will need to present statistics and calculated information about the types of food loss/waste. You will need to: <br><br>
    <ul>
        <li>Present this information in an informative, respectful, and unbiased manner.</li>
        <li>Cater for a diverse range of users who are seeking to become more informed on this topic.</li>
        <li>Provide diverse types of information and functionality, including both high-level summaries, and enabling an in-depth analysis of the data.</li>
    </ul>
    By using your website, users should be able to become well-informed of the levels of food waste/loss across the world.
</details>

---
## Authors

**Noah Bakr** 
* *Initial work* - Landing Page &amp; Task A Stream
* *Extension Task* - Chart.js 
* *Design &amp; Layout* - CSS/Mockups
* *Presentation* - Powerpoint Slideshow

**Connor Orders**
* *Initial work* - Mission Page &amp; Task B Stream
* *Database Creation* - SQLite

## Showcase

![Webpage-Showcase-image]

This project was designed to demonstrate:

* **UX/UI**
  * Nielsen Design Heuristics
  * Mockup Creation (Figma)
  * Design Patterns
* **Usability Testing**
  * Participant Information Form (PIF)
  * Personas
  * Context Scenario(s)
  * Key Path Scenario(s)
  * Participant Information Form (PIF)
  * Survey
* **Database**
  * ER Diagram
  * Database Schema (3NF)
    * Functional Dependencies
  * SQL Queries
* **Web Development**
  * Programming (Java, HTML, CSS, Javascript)
* **Presentation and Demonstration**
    * Structure of Slideshow
      * Use of slides, diagrams, code examples, and other presentation aids.
    * Level of Preparation
    * Ability to Leave Assessors (and Audience) with Few Questions.
      * Ability to handle follow-up questions
* **Teamwork and Contribution**
    * Organisational Skills of Group Members.
    * Contributions of Group Members to the Project.
    * Communication of Group Members during the Project.
    * Evaluation of the Teamwork of Group Members

---

## File Directory
### Website Related
Classes backing Web pages:
```bash
├── PageIndex.java                    - Homepage page for Level 1 Sub-task A
├── PageMission.java                  - Mission Statement page for Level 1 Sub-task B
├── PageST2/3.java                    - Sets of 4 Java files backing the 4 pages for 4 Level2/3 sub-tasks
```

Other Classes:
```bash
├── java/app                                - Package location for all Java files for the webserver
│         ├── App.java                      - Main Application entrypoint for Javalin
│         └── JDBCConnection.java           - JDBC Connection class containing all Website/Database methods
├── java/helper                             - Location of the helper file for loading SQLite with JDBC
│         └── FoodProcessCSV.java           - Helper Java program to load SQLite database from the provided CSVs
```

Folders:
```bash
├── /src/main                    - Location of all files as required by build configuration
│         ├── java               - Java Source location
│         │    ├── app           - Package location for all Java files for the webserver
│         │    └── helper        - Location of the helper file for loading SQLite with JDBC
│         └── resources          - Web resources (html templates / style sheets)
│               ├── css          - CSS Style-sheets
│               └── images       - Image files
│ 
├── /target                      - Build directory
├── /database                    - The folder to store SQLite database files (*.db files) and data files (*.csv) related to the database
├── pom.xml                      - Configure Build
│ 
├── README.md                    - This file
├── Starter-Code-README.md       - The initial README.md file for the website template (created by RMIT)
```

### Assignment Related
Folders:
```bash
├── /Assignment-Documents                    - Location of all other documents required for the assignment
│         ├── ER Diagram                     - ER Diagram from the planning stage and, the latest (revised) Diagram
│         ├── Mockup Images                  - Images of each webpage mockups & color palette
│         ├── Presentation                   - The slideshow used to aid the assignment presentation
│         ├── Usability Testing              - Location of all files required to conduct Usability Testing. PIF document not supplied
│               ├── Personas-KPS.pdf         - PDF containing the Personas, their Context Scenarios and Key Path Scenarios (KPS)
│         └── Website Images                 - Location of all webpages as images
│               ├── Website Layout (A)       - Images of all webpages before Usability Testing was conducted
│               └── Website Layout (B)       - Images of all webpages after Usability Testing was conducted
│ 
└── /README-Images                           - Location of images for this file
```

---

## Libraries
**Current Libraries:**
* [org.xerial.sqlite-jdbc][xerial-sqlite-jdbc-url] (SQLite JDBC library)
* [Javalin][javalin-url] (lightweight Java Framework)
* [Thymeleaf][thymeleaf-url] (HTML template)

**Libraries required as dependencies:**
* By Javalin
   * slf4j-simple (lightweight logging)
* By Xerial/JDBC
   * sqlite-jdbc

---

## Building & Running the code
There are two places code can be run from
1. The **main** web server program
2. The **optional** helper program to use JDBC to load the SQLite database from the CSVs using Java

### Running the Main web server
1. Open this project within VSCode
2. Allow VSCode to read the ``pom.xml`` file
 - Allow the popups to run and "say yes" to VSCode configuring the build
 - Allow VSCode to download the required Java libraries
3. To Build & Run
 - Open the ``src/main/java/app/App.java`` source file, and select "Run" from the pop-up above the main function
4. Go to: http://localhost:7000

<details>
<summary>Running the Helper Program</summary>

### Running the Helper Program
The helper program in ``src/main/java/helper/FoodProcessCSV.java`` can be run separetly from the main webserver. This gives a demonstration of how you can use Java to read the provided CSV files and store the information in an SQLite database. This example loads a subset of the data in the ``database/FoodLoss.csv`` and ``database/CPC.csv`` files into a database. It also runs a series of queries to do lookups to check records match, but this can be modified to do lookups and insert other data into related tables if necessary.

You can run the optional helper program by
1. Open this ``src/main/java/helper/FoodProcessCSV.java`` source file
2. Select "Run" from the pop-up above the main function (or "Run Java" from the top-right arrow button)
3. Allow the program to run
4. By default it will drop the existing tables and recreate them before populating each table
5. If you do not want to drop existing tables, comment out line line 52: dropTablesAndRecreateTables();

You can modify this file as you wish, for other tables and CSVs. When modifying you may need to pay attention to:
* ``DATABASE`` field to change the database location
* ``FOOD_CSV_FILE`` and ``CPC_CSV_FILE`` to change which CSV files are bring read in
* ``INSERT`` statement construction to:
    * Change the table being used
    * Column data being stored
</details>

---

## Presentation

![M4 Presentation](https://github.com/user-attachments/assets/7744e460-ed9a-4ddb-a60c-85a14979bd94)

The web application 'Food Loss Waste.org' was showcased to assessors and other audience to meet marking criteria and fulfill requirements. A slideshow was used to aid the presentation task. This task aimed to strengthen communication, presentation, critical thinking, and stakeholder engagement skills. It demonstrates the capability to effectively advocate for projects, innovate solutions, and deliver value in diverse professional settings. <br><br>
Emphasis on user experience (UX) and user interface (UI) ensured alignment with personas' needs and goals, integrating contextual scenarios effectively. Design choices were justified through Nielsen's heuristics, with implementation of common design patterns for intuitive navigation. Iterative design improvements were driven by usability testing, addressing a specific user-identified issue and achieving solutions. The presentation included demonstrations of seamless website functionality through various user scenarios, highlighting practical application and user interaction. 

> [!NOTE]
> The presentation file ``Presentation.pptx`` is located in the ``Assignment-Documents/Presentation`` folder. A ``Presentation.pdf`` alternative has been supplied.

---

## Built With

* [Javalin][javalin-url] - lightweight Java Framework
* [SQLite](https://www.sqlite.org/) - Database
* [Figma](https://www.figma.com/) - Mockups
* [Lucidchart](https://www.lucidchart.com/pages/) - ER Diagram
* [PowerPoint](https://www.microsoft.com/en-au/microsoft-365/powerpoint) - Slideshow

## Release History

* 0.1.0
    * Portfolio Presentation (New ``README.md``)
* 0.0.1
    * Initial work

---

## RMIT Authors

* **Dr. Halil Ali**, School of Computing Technologies, STEM College, RMIT University.
* **Dr. Timothy Wiley**, School of Computing Technologies, STEM College, RMIT University.
* **Prof. Santha Sumanasekara**, School of Computing Technologies, STEM College, RMIT University

&copy; RMIT University 2024

<!-- Markdown link & img dfn's -->

[header-url]: README-Images/PS-Header.png
[header-link]: https://github.com/Noah-Bakr

[repository-url]: https://github.com/alexandrerosseto/wbshopping

[Webpage-Showcase-image]: README-Images/Webpage-Showcase.png

[xerial-sqlite-jdbc-url]: https://github.com/xerial/sqlite-jdbc
[javalin-url]: https://javalin.io/
[thymeleaf-url]: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

[linkedin-url]: https://www.linkedin.com/in/Noah-Bakr

[version-image]: https://img.shields.io/badge/Version-1.0.0-brightgreen?style=for-the-badge&logo=appveyor
[version-url]: https://img.shields.io/badge/version-1.0.0-green

[Backend-image]: https://img.shields.io/badge/Backend-Javalin-important?style=for-the-badge
[Backend-url]: https://img.shields.io/badge/Backend-Javalin-important?style=for-the-badge

[SQLite-image]: https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white
[SQLite-url]: https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white

[Java-image]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white

[HTML-image]: https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white
[HTML-url]: https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white

[CSS-image]: https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white
[CSS-url]: https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white

[Js-image]: https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black
[Js-url]: https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black

[Figma-image]: https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white
[Figma-url]: https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white
