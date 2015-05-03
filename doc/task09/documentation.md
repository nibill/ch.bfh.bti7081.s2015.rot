# Softwarearchitektur
## Vaadin Framework
## Systemanforderungen
### Datenpersistenz

Die PatientApp ben�tigt lokale Daten, da eine Verbindung zum Klinikserver nicht immer m�glich oder erw�nscht ist. MongoDB ist eine einfache, quelloffene und perfomante L�sung. Es ist die am weitesten verbreiteste NoSQL-Datenbank, verwendet also keine SQL Abfragen um Daten zu erstellen, erhalten oder manipulieren. Schematas der Daten k�nnen im m�chtigen Format JSON ("JavaScript Object Notation") abgelegt werden. JSON ist ein weit verbreitetes Textformat, um Informationen auszutauschen oder speichern. Der grosse Vorteil dabei ist, dass JSON-Texte immer in Objekte umgewandlet werden k�nnen und umgekehrt. Da Vaadin aus dem in Java geschriebenen Programm eine Webapplikation erstellt, entsteht kein direkter Technologieumbruch, was die Unterst�tzung von MongoDB weiter bef�rwortet. Eine MongoDB besteht grunds�tzlich aus einer Textdatei auf dem Dateisystem - es ist kein DBMS notwendig. Die Kommunikation mit den Daten �bernimmt das MongoDB-Objekt, das es in praktisch allen Programmiersprachen gibt.  

### GPS & Foto

Die zu entwickelnde Applikation benutzt f�r das Spiel "LifeUp" in gewissen F�llen GPS-Koordinaten, um beispielsweise das Erreichen oder Besuchen eines bestimmten Ortes zu �berpr�fen. Das Framework Vaadin, das verwendet wird, �bersetzt mithilfe des GWTKs das in Java geschrieben Progamm in eine Webapplikation. W�hrend in der Standard Androidentwicklungsumgebung GPS eine h�ufige und unterst�zte Komponente ist, kann das Vaadin-Framework eine solche Unterst�tzung nicht vollst�ndig gew�hrleisten. Die HTMl5 Funktion, die Vaadin verwendet, nennt sich GPS.getIfSupported(). Falls das GPS auf dem Endger�t nicht benutzt werden kann, muss eine solche GPS-Funktionalit�t simuliert, respektive darauf reagiert werden, damit das LifeUp-Spiel keine Aktivit�ten vorschreiben kann, die nicht �berpr�fbar sind. Das genaue Vorgehen f�r das Simulieren ist nocht ausstehend.

Ein �hnliches Problem existiert auch f�r die Foto-Komponente, die im Spiel verwendet werden soll. Vaadin hat keinen Zugriff auf solche Bauteile. Das Problem, dass das Aufnehmen von Fotos nicht m�glich ist, wird durch eine einfache Umgehung gel�st: Es k�nnen lokale Bilder, die sich auf dem Endger�t befinden, hochgeladen werden. Diese werden dann wie als neues Foto behandelt. 
 
 
## Patterns
### MVC
#### Modell
#### View
#### Controller

### MVP
#### Modell
#### View
#### Presenter
### Vaadin MVP
### Implementation

## Softwarearchitektur
## Appendix
