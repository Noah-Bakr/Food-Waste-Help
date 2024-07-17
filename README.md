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

> Short blurb about your project idea.

One or two paragraphs about your project and what it does.

<details>
    <summary>Further project information</summary>
    <br>
    Text
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

This project was designed to demonstrate:

* Milestone 1
  * Tech 1 subitem
* Milestone 2
  * Tech 1 subitem
* Milestone 3
  * Tech 1 subitem
* Milestone 4
  * Tech 1 subitem

---

## File Directory
Classes backing Web pages:
```bash
├── PageIndex.java                    - Homepage page for Level 1 Sub-task A
├── PageMission.java                  - Mission Statement page for Level 1 Sub-task B
├── PageST2/3.java                    - Sets of 4 Java files backing the 4 pages for 4 Level2/3 sub-tasks. Student in group of 3 will need to add additional Java files
```

Other Classes:
```bash
├── java/app                                - Package location for all Java files for the webserver
│         ├── App.java                      - Main Application entrypoint for Javalin
│         └── JDBCConnection.java           - Example JDBC Connection class based on Studio Project Workshop content
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
│               ├── css          - CSS Style-sheets. Base example style sheet (common.css) provided
│               └── images       - Image files. Base example image (RMIT Logo) provided
│ 
├── /target                      - build directory (DO NOT MODIFY)
├── /database                    - The folder to store sqlite database files (*.db files) and data files (*.csv) related to the database
├── pom.xml                      - Configure Build (DO NOT MODIFY)
└── README.md                    - This file ;)
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

# Building & Running the code
There are two places code can be run from
1. The **main** web server program
2. The **optional** helper program to use JDBC to load the SQLite database from the CSVs using Java

## Running the Main web server
1. Open this project within VSCode
2. Allow VSCode to read the ``pom.xml`` file
 - Allow the popups to run and "say yes" to VSCode configuring the build
 - Allow VSCode to download the required Java libraries
3. To Build & Run
 - Open the ``src/main/java/app/App.java`` source file, and select "Run" from the pop-up above the main function
4. Go to: http://localhost:7000

<details>
<summary>Running the Helper Program</summary>

## Running the Helper Program
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

Describe and reference the slideshow  

```sh
make install
npm test
```

## Running the tests

Remember this is a showcase, thus your potential employer might want to see an automated test-suite of some kind up running.

---

## Built With

* [Javalin][javalin-url] - lightweight Java Framework
* [SQLite](https://www.sqlite.org/) - Database

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

[header-url]: PS-Header.png
[header-link]: https://github.com/Noah-Bakr

[repository-url]: https://github.com/alexandrerosseto/wbshopping

[xerial-sqlite-jdbc-url]: https://github.com/xerial/sqlite-jdbc
[javalin-url]: https://javalin.io/
[thymeleaf-url]: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

[linkedin-url]: https://www.linkedin.com/in/Noah-Bakr

[wiki]: https://github.com/yourname/yourproject/wiki

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