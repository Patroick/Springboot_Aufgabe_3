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

37:30