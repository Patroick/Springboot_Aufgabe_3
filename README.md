# Springboot_Aufgabe_3

- [Springboot_Aufgabe_3](#springboot-aufgabe-3)
- [Projekt Erstellen](#projekt-erstellen)
- [Creating Simple API](#creating-simple-api)
- [Springboot Devtools](#springboot-devtools)

# Projekt Erstellen

Erstellung des Springboot Projekts mithilfe des Spring Initializers. 

Link: https://start.spring.io/

Einstellungen laut Screenshot

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-00-45-37-2021-11-15-00-45-06-image.png)

Verwendete Dependencies:

- Spring Web

- H2 Database

# Creating Simple API

`@SpringBootApplication` Annotation 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-00-46-04-2021-11-15-00-45-57-image.png)

`SpringBootConfiguration ` Gibt dem Programm den Hinweis dass hier die Hauptkonfiguration für Spring Boot stattfindet. 

`@EnableAutoConfiguration` Klassen die nicht automatisch Konfiguriert werden sollen können hier exkludiert werden. 

`@ComponentScan` Scannt alle Komponenten des Projekts und werden beim Start zum Spring Container hinzugefügt. 

Erstellen eines neuen Packages und Java Klasse

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-00-49-06-2021-11-15-00-49-00-image.png)

`@RestController` um dem Programm mitzuteilen dass die nachfolgende Klasse ein Controller ist der immer einen Response Body zurück liefert.

![](C:\Users\Patrick\AppData\Roaming\marktext\images\2021-11-15-00-51-54-image.png)

`@RequestMapping(value = "/", method = RequestMethod.GET)` Sobald der "/" End Point erreicht wird, wird die Methode `helloWorld` aufgerufen. 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-00-55-06-2021-11-15-00-55-02-image.png)

In den `application.properties` können verschiedenste Eigenschaften des Projekts eingestellt werden.

Mit der Zeile `server.port = 8082` wird der Port auf 8082 geändert.

Hier ist die Adresse localhost:8082/ mit dem "/" End Point wodurch die Methode `helloWorld` aufgerufen wird. 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-01-09-15-2021-11-15-00-59-26-image.png)

Gleiches kann auch mit dem Befehl `@GetMapping("/")` erreicht werden. 

# Springboot Devtools

Um die Richtige Dependency zu finden kann wieder der Spring Initializer helfen.  

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-01-09-40-2021-11-15-01-09-11-image.png)

In dem Tab Explorer kann man die benötigten Dependencies sehen.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-01-14-53-2021-11-15-01-14-48-image.png)

Diese Dependency muss dann in die pom.xml des Projekts eingefügt werden.

Mit `Doppel Shift` kann die Suche in IntelliJ geöffnet werden. Im Registry müssen einige Einstellungen vorgenommen werden.   ![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-01-18-32-2021-11-15-01-18-25-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-01-19-24-2021-11-15-01-19-13-image.png)

In den Einstellungen muss unter Compiler "Build Project automatically" aktiviert werden.

![](C:\Users\Patrick\AppData\Roaming\marktext\images\2021-11-15-01-20-10-image.png)

# Architektur

In dem Tutorial wird nur da Backend einer Web Applikation erstellt. 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-10-03-2021-11-15-17-09-59-image.png)

Rest API - Routing Layer um Daten zu bekommen und senden

Service Layer - Business Logik Implementierung

Data Access / Repository Layer - Layer um mit der Datenbank zu interagieren



# H2/JPA

Die Dependency für die H2 Datenbank haben wir bereits bei Projektstart hinzugefügt nun muss auch die JPA Dependency hinzugefügt werden. Erfolgt gleich wie bei den Springboot Devtools.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-15-54-2021-11-15-17-15-49-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-17-18-2021-11-15-17-17-15-image.png)

Konfiguration der Datenbank in der application.properties

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-21-44-2021-11-15-17-21-38-image.png)

Mithilfe von `localhost:8082/h2-console` kann die Datenbank Konsole geöffnet werden.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-36-56-2021-11-15-17-36-54-image.png)

# Komponeneten erstellen

Es müssen einige neue Packages erstellt werden und in dem entity Paket wird eine Java Klasse Department erstellt.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-43-28-2021-11-15-17-43-22-image.png)

Wichtig sind hier die 3 verwendeten Annotationen.

`@Entity` - Definiert die Klasse als Entity Objekt für die Datenbank

`@Id` - Primarschlüssel der Entity

`@GeneratedValue(strategy = GenerationType.AUTO)` - Zählt die Id automatisch mit jedem erstellten Objekt nach oben

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-47-57-2021-11-15-17-45-20-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-48-02-2021-11-15-17-47-20-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-48-05-2021-11-15-17-47-42-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-48-09-2021-11-15-17-47-54-image.png)

Dann muss eine DepartmentController Klasse erstellt werden. Diese muss mit der `@RestController` Annotation gekennzeichnet werden. 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-53-33-2021-11-15-17-53-31-image.png)

Ebenso muss ein DepartmentRepository Interface, ein DepartmentService Interface und eine Implementierung des DepartmentService Interfaces erstellt werden.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-54-16-2021-11-15-17-54-12-image.png)

Das Repository wird mit `@Repository` gekennzeichnet.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-55-40-2021-11-15-17-55-37-image.png)

Department Service Interface benötigt keine Annotation

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-17-57-14-2021-11-15-17-57-11-image.png)

Die Implementation benötigt eine `@Service` Annotation

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-18-55-00-2021-11-15-17-57-48-image.png)

Der Department Controller Klasse muss ein Objekt von DepartmentService übergeben werden. Dies erfolgt mittels `@Autowired`

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-18-54-57-2021-11-15-18-54-52-image.png)

Die Methode saveDepartment muss in DepartmentServcie erstellt werden, und in DepartmentServiceImpl Implementiert werden. 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-18-57-28-2021-11-15-18-57-25-image.png)

Mit `.save(department)` wird das Objekt in der Datenbank gespeichert.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-19-00-12-2021-11-15-19-00-05-image.png)

# Testen mit Rest Client

Table wird automatisch von Spring erstellt

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-19-03-28-2021-11-15-19-03-25-image.png)

Mit Insomnia senden wir eine POST Request mit den Daten die in der Datenbank gespeichert werden sollen.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-20-58-2021-11-15-21-20-54-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-21-14-2021-11-15-21-21-12-image.png)

Überprüfung ob die Daten in der Datenbank gespeichert wurden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-21-38-2021-11-15-21-21-35-image.png)

# Get Mapping

Um die Daten in einer Get Request zurück zu bekommen muss zunächst im DepartmentController diese Methode implementiert werden.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-27-02-2021-11-15-21-26-59-image.png)

Die fetchDepartmentList Methode muss zuesrt im Interface hinzugefügt werden und dann in DepartmentServiceImpl implementiert werden.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-27-55-2021-11-15-21-27-52-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-28-30-2021-11-15-21-28-27-image.png)

In Insomnia kann man die Daten dann mit einer GET Request erhalten.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-29-17-2021-11-15-21-29-12-image.png)

# Fetching Data by ID

Um die Daten einer bestimmten ID zu bekommen muss im Prinzip die gleiche Methode implementiert werden. Unterschied ist bei `@GetMapping` wird die ID mitgegeben.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-36-19-2021-11-15-21-36-14-image.png)

Ebenfalls wieder Methode hinzufügen im Interface und Implementieren in DepartmentServiceImpl

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-36-32-2021-11-15-21-36-29-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-37-23-2021-11-15-21-37-20-image.png)

Überprüfung mit Insomnia

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-37-56-2021-11-15-21-37-53-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-38-27-2021-11-15-21-38-17-image.png)