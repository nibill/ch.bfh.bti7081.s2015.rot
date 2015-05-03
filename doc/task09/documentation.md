# Softwarearchitektur
## Vaadin Framework
## Systemanforderungen
### Datenpersistenz

Die PatientApp ben�tigt lokale Daten, da eine Verbindung zum Klinikserver nicht immer m�glich oder erw�nscht ist. MongoDB ist eine einfache, quelloffene und perfomante L�sung. Es ist die am weitesten verbreiteste NoSQL-Datenbank, verwendet also keine SQL Abfragen um Daten zu erstellen, erhalten oder manipulieren. Schematas der Daten k�nnen im m�chtigen Format JSON ("JavaScript Object Notation") abgelegt werden. JSON ist ein weit verbreitetes Textformat, um Informationen auszutauschen oder speichern. Der grosse Vorteil dabei ist, dass JSON-Texte immer in Objekte umgewandlet werden k�nnen und umgekehrt. Da Vaadin aus dem in Java geschriebenen Programm eine Webapplikation erstellt, entsteht kein direkter Technologieumbruch, was die Unterst�tzung von MongoDB weiter bef�rwortet. Eine MongoDB besteht grunds�tzlich aus einer Textdatei auf dem Dateisystem - es ist kein DBMS notwendig. Die Kommunikation mit den Daten �bernimmt das MongoDB-Objekt, das es in praktisch allen Programmiersprachen gibt.  

### GPS & Foto

Die zu entwickelnde Applikation benutzt f�r das Spiel "LifeUp" in gewissen F�llen GPS-Koordinaten, um beispielsweise das Erreichen oder Besuchen eines bestimmten Ortes zu �berpr�fen. Das Framework Vaadin, das verwendet wird, �bersetzt mithilfe des GWTKs das in Java geschrieben Progamm in eine Webapplikation. W�hrend in der Standard Androidentwicklungsumgebung GPS eine h�ufige und unterst�zte Komponente ist, kann das Vaadin-Framework eine solche Unterst�tzung nicht vollst�ndig gew�hrleisten. Die HTML5 Funktion, die Vaadin verwendet, nennt sich GPS.getIfSupported(). Falls das GPS auf dem Endger�t nicht benutzt werden kann, muss eine solche GPS-Funktionalit�t simuliert, respektive darauf reagiert werden, damit das LifeUp-Spiel keine Aktivit�ten vorschreiben kann, die nicht �berpr�fbar sind. Das genaue Vorgehen f�r das Simulieren ist nocht ausstehend.

Ein �hnliches Problem existiert auch f�r die Foto-Komponente, die im Spiel verwendet werden soll. Vaadin hat keinen Zugriff auf solche Bauteile. Das Problem, dass das Aufnehmen von Fotos nicht m�glich ist, wird durch eine einfache Umgehung gel�st: Es k�nnen lokale Bilder, die sich auf dem Endger�t befinden, hochgeladen werden. Diese werden dann wie als neues Foto behandelt. 
 
 
## Patterns
### MVC
Das Model-View-Controller Pattern ist eine weit verbreitete Struktur, Software in der Art zu implementieren, damit eine Trennung von den Daten, der Logik und der Visualisierung m�glich ist. Der Vorteil ist die Austauschbarkeit der einzelnen Komponenten, beispielsweise f�r Applikationen, die auf verschiedenen Plattformen erstellt werden sollen. Es m�ssen nur die Komponenten ausgetauscht werden, die auf dme Zielsystem anders funktionieren.
#### Model
Das Model enth�lt die Daten der Applikation. H�ufig wird es mithilfe des Obserable-Pattern verwendet - es bildet hier das Subjekt (Falls sich Daten �ndern).
#### View
Die View oder Pr�sentationsschicht bereitet die Daten vom Model auf und visualisiert diese. Die implementierte Logik kennt sie, aber sie verarbeitet Events nicht weiter, da das der Aufgabenbereich des Controllers ist. 
#### Controller
Der Controller nimmt Benutzerinteraktionen entgegegen und l�st die entsprechenden Abl�ufe aus. Er ist das Bindeglied zwischen der View und dem Model. In manchen Implementation verwendet er auch das Observable-Pattern, um bei �nderungen in den Daten direkt die View zu aktualisieren. 

### MVP
Das Model-View-Presenter Pattern ist eine �berarbeitung von MVC. Jede Schicht ist viel strenger abgekapselt und lediglich �ber den Presenter findet die Kommunikation statt. Anders als beim MVC verkn�fpt der Presenter nur �ber Schnittstellen das Model und die View, die die beiden Komponenten implementieren. 
#### Model
Das Model kennt nur sich selber und stellt auch wie beim MVC die Datenschicht dar. 
#### View
Die View ist nur f�r die Visualisierung und die Aktionsein- und ausg�nge verantowrtlich. Auch sie kennt nur sich selber. 
#### Presenter
Der Presenter ist das Bindeglied zwischen Model und View und steuert die logischen Abl�ufe. Er stellt die Verkn�pfung des Model und Views her.
### Vaadin MVP
### Implementation

## Softwarearchitektur
## Appendix
