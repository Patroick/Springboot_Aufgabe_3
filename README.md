# Springboot_Aufgabe_3

- [Springboot_Aufgabe_3](#springboot-aufgabe-3)
- [Projekt Erstellen](#projekt-erstellen)
- [Creating Simple API](#creating-simple-api)
- [Springboot Devtools](#springboot-devtools)
- [Architektur](#architektur)
- [H2/JPA](#h2-jpa)
- [Komponeneten erstellen](#komponeneten-erstellen)
- [Testen mit Rest Client](#testen-mit-rest-client)
- [Get Mapping](#get-mapping)
- [Fetching Data by ID](#fetching-data-by-id)
- [Daten löschen](#daten-l-schen)
- [Daten Updaten](#daten-updaten)
- [Daten fetchen nach Name](#daten-fetchen-nach-name)
- [Hibernate Validation](#hibernate-validation)
- [Loggers](#loggers)
- [Project Lombok](#project-lombok)
- [Exception Handling](#exception-handling)
- [H2 zu SQL](#h2-zu-sql)
- [Unit Testing](#unit-testing)
  * [Service Layer](#service-layer)
  * [Repository Layer](#repository-layer)
  * [Controller Layer](#controller-layer)
- [Config in Properties](#config-in-properties)
- [Application.yml](#applicationyml)
- [Springboot Profile](#springboot-profile)
- [Projekt in JAR umwandeln](#projekt-in-jar-umwandeln)
- [Springboot Actuator](#springboot-actuator)
- [Custom Endpoints](#custom-endpoints)
- [Endpoints exkludieren](#endpoints-exkludieren)

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

# Daten löschen

Um Daten zu löschen wird gleich wie bei den beiden oberen Methoden vorgegangen

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-43-17-2021-11-15-21-43-14-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-44-28-2021-11-15-21-43-33-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-44-26-2021-11-15-21-44-23-image.png)

Überprüfung mit Insomnia

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-21-45-15-2021-11-15-21-45-13-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-40-54-2021-11-15-21-46-00-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-40-51-2021-11-15-21-46-13-image.png)

# Daten Updaten

Um Daten updaten zu können muss im Controller eine neue Methode hinzugefügt werden. 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-39-35-2021-11-15-23-39-33-image.png)

Die Methode updateDepartment muss im Interface erstellt werden und in der Implementierungsklasse implementiert werden.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-40-46-2021-11-15-23-40-42-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-41-40-2021-11-15-23-41-38-image.png)

Überprüfung mit Insomnia

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-45-34-2021-11-15-23-45-31-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-46-10-2021-11-15-23-45-51-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-46-25-2021-11-15-23-46-06-image.png)

# Daten fetchen nach Name

Gleich wie bei den oberen Implementierungen 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-57-05-2021-11-15-23-54-11-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-57-13-2021-11-15-23-54-23-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-57-15-2021-11-15-23-54-35-image.png)

Da es die Methode findByDepartmentName noch nicht gibt muss sie im Repository erstellt werden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/15-23-57-18-2021-11-15-23-55-37-image.png)

Mithilfe der richtigen Namenskonvention werden die richtigen Daten zurückgegeben.

findBy + EntityName

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-01-28-2021-11-16-00-01-24-image.png)

Um die Methode Case Insensitive zu machen muss im Repository IgnoreCase zum Methoden Name angehängt werden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-03-48-2021-11-16-00-03-21-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-03-56-2021-11-16-00-02-53-image.png)

[Spring Data JPA - Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

# Hibernate Validation

Um die Validation zu ermöglichen muss eine neue Dependency in die pom.xml eingefügt werden 

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-18-07-2021-11-16-00-18-03-image.png)

In der Department Klasse muss eine `@NotBlank` Annotation hinzugefügt werden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-21-04-2021-11-16-00-20-58-image.png)

Im Controller muss in der save Methode `@Valid` hinzugefügt werden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-31-29-2021-11-16-00-21-16-image.png)

Wenn nun kein Name übermittelt wird erscheint ein Fehler mit der Fehlernachricht "Department name is required"

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-31-20-2021-11-16-00-24-46-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-31-17-2021-11-16-00-31-14-image.png)

# Loggers

In dem Controller muss ein neuer Logger erstellt werden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-40-20-2021-11-16-00-39-21-image.png)

Dieser wird dann in den Methoden aufgerufen

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-40-14-2021-11-16-00-40-11-image.png)

Ausgabe in der Konsole

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-40-53-2021-11-16-00-40-49-image.png)

# Project Lombok

Um Boiler Plate Code (Getter, Setter, etc.) zu entfernen wird Project Lombok verwendet.

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-48-22-2021-11-16-00-45-23-image.png)

Mit `@Data`, `@NoArgsConstructor` und `@AllArgsConstructor` werden Getter Setter und Konstruktoren verfügbar gemacht

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-00-48-32-2021-11-16-00-48-19-image.png)

# Exception Handling

Neues Package für Exceptions

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-00-13-2021-11-16-00-59-44-image.png)

Neue Exception erweitert die Exception Klasse und Überschreibt einige Methoden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-02-32-2021-11-16-01-00-07-image.png)

Die Service Methode fetchById wirft diese Exception

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-02-29-2021-11-16-01-01-40-image.png)

Ebenso auch der Controller

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-02-27-2021-11-16-01-02-23-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-02-51-2021-11-16-01-02-48-image.png)

Um die Fehlermeldung übersichtlicher zu machen erstellen wir einen RestResponseEntityExceptionHandler

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-16-35-2021-11-16-01-16-33-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-15-33-2021-11-16-01-15-25-image.png)

Die Klasse ErrorMessage hat 2 Datenfelder mit dem Http Status und einer Fehlermeldung

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-16-19-2021-11-16-01-16-15-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-17-51-2021-11-16-01-17-46-image.png)

# H2 zu SQL

Die application.properties muss mit der Konfiguration für SQL aktualisiert werden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-32-44-2021-11-16-01-32-38-image.png)

Dependency in der pom.xml

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-33-06-2021-11-16-01-33-02-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-33-24-2021-11-16-01-33-20-image.png)

# Unit Testing

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-39-28-2021-11-16-01-39-24-image.png)

## Service Layer

Mit IntelliJ können Tests einfach über Generate erstellt werden

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-41-41-2021-11-16-01-41-35-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-01-41-46-2021-11-16-01-41-21-image.png)

`setUp` mit `@BeforeEach` Annotation wird vor jedem Test ausgeführt

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-02-08-20-2021-11-16-02-08-12-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-02-17-52-2021-11-16-02-09-32-image.png)

## Repository Layer

Für jeden Layer Test wird ein neues Package mit jeweils Test Klasse erstellt

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-02-16-42-2021-11-16-02-16-40-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-02-17-47-2021-11-16-02-17-44-image.png)

![](https://raw.githubusercontent.com/Patroick/Springboot_Aufgabe_3/main/2021/11/16-02-28-28-2021-11-16-02-28-22-image.png)

## Controller Layer

![grafik](https://user-images.githubusercontent.com/43811779/142028285-71fdbab4-1133-4ba8-a360-8f6f8d34255b.png)

![grafik](https://user-images.githubusercontent.com/43811779/142029514-a775a5a9-a35d-4a02-aa9f-f25c841e50be.png)

Test Methode zum speichern der Daten

![grafik](https://user-images.githubusercontent.com/43811779/142029708-22e07369-c508-41e3-9381-6c9c77fdcf78.png)

![grafik](https://user-images.githubusercontent.com/43811779/142029813-7a3ec894-fea6-457e-8569-089312d7352f.png)

Test Methode zum fetchen der Daten

![grafik](https://user-images.githubusercontent.com/43811779/142030417-d15c0899-ba5e-460b-bb45-b6ae8bb0ba5a.png)

![grafik](https://user-images.githubusercontent.com/43811779/142030440-f22f64af-3a35-4aa2-a77c-3767c4fb0c8f.png)

# Config in Properties 

Um Configurationsdateien im Projekt verwenden zu können müssen die Konfigurationsdaten zunächst in der properties Datei hinzugefügt werden

![grafik](https://user-images.githubusercontent.com/43811779/142031844-9acbef70-4053-4b60-b68b-a6c063133c54.png)

Mit `@Value` kann dem Datenfeld welcomeMessage der Wert der Configurationsdatei gegeben werden

![grafik](https://user-images.githubusercontent.com/43811779/142031878-32e32963-7cf9-43a3-9a00-3b92ce19a400.png)

# Application.yml

Um die application.properties in eine .yml Konfigurationsdatei umzuwandeln muss die .yml Datei erstellt werden

![grafik](https://user-images.githubusercontent.com/43811779/142033525-8f39f38d-3f0a-4cf6-b7a2-8ec8b38cc1bd.png)

Dann wird der Code der properties Datei durch einen Online Converter konvertiert und in die .yml Konfigurationsdatei eingefügt und anschließend in der properties Datei auskommentiert oder entfernt

![grafik](https://user-images.githubusercontent.com/43811779/142033703-8458f517-031e-4ffe-a03f-a87c90441386.png)

# Springboot Profile

In der .yml können mehrere Konfigurationsprofile wie folgt erstellt werden

![grafik](https://user-images.githubusercontent.com/43811779/142036146-965e3d71-2910-4a39-993e-9e35a5f9e3cc.png)

Das Profil das aktiv verwendte werden soll muss so aktiviert werden 

![grafik](https://user-images.githubusercontent.com/43811779/142036228-055a5466-cc0d-4b6a-ad2f-4494c41194f0.png)

Mithilfe der "---" wird ein neues Dokument innerhalb der .yml gekennzeichnet

![grafik](https://user-images.githubusercontent.com/43811779/142036366-efa3ccc8-34fa-41b3-8118-12ebc06159fe.png)

# Projekt in JAR umwandeln

In der pom.xml sollte die Version auf die gewünschte Version geändert werden

![grafik](https://user-images.githubusercontent.com/43811779/142036947-c1f9020b-2db2-4b2c-89c1-b654e2c28df2.png)

Im Terminal kann die Jar Datei des Projektes generiert werden

![grafik](https://user-images.githubusercontent.com/43811779/142040379-151a3afc-0f70-49af-b192-f8257331151c.png)

![grafik](https://user-images.githubusercontent.com/43811779/142040430-1f04bb5d-2822-48d6-baf8-29698f0f819f.png)

Ausführen mit diesem Befehl

![grafik](https://user-images.githubusercontent.com/43811779/142040752-6784e2f6-657a-49f8-8ac5-a6dc9b55f7d0.png)

Beenden mit Strg + C

# Springboot Actuator

Die Springboot Actuator Dependency wird benötigt

![grafik](https://user-images.githubusercontent.com/43811779/142042246-771b7eea-809b-4aa5-9e7a-7c2bec42883b.png)

Endpoints von Actuator anzeigen lassen

![grafik](https://user-images.githubusercontent.com/43811779/142043019-8f1ce2e8-c6f5-4703-befb-bc529bdeb9a4.png)

Mit dieser Konfiguration können alle Endpoints angezeigt werden

![grafik](https://user-images.githubusercontent.com/43811779/142043431-6f4e991c-5c7a-47a0-9365-9f7781aa9d3a.png)

# Custom Endpoints

Um eigene Endpoints zu erstellen muss ein neues Package und eine Klasse erstellt werden

![grafik](https://user-images.githubusercontent.com/43811779/142044045-4e8b997e-3670-4964-8819-25eed9be44dd.png)

`@Endpoint` makiert die Klasse als Endpoint

![grafik](https://user-images.githubusercontent.com/43811779/142044966-96d7d960-39e1-4c0f-86d5-76270464d996.png)

![grafik](https://user-images.githubusercontent.com/43811779/142045238-6f52c7e3-b048-4629-9dd1-fcb48dc64276.png)

![grafik](https://user-images.githubusercontent.com/43811779/142045304-63979b97-dc21-4f99-afd7-b23017ac5b95.png)

# Endpoints exkludieren

Endpoints können einfach mit exclude: exkludiert werden

![grafik](https://user-images.githubusercontent.com/43811779/142046185-dd1ddc16-5e82-4f5f-83da-acfb2686a94b.png)

Nur noch 12 Endpoints anstatt 14

![grafik](https://user-images.githubusercontent.com/43811779/142046212-949988d2-345f-4138-a783-86cffa51af5b.png)
