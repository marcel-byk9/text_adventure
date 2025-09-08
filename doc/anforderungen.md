## Lastenheft
-	Text-Adventure mit auswählen bestimmter Dialogoptionen in bestimmten Situationen
-	Die Anwendung soll als Hommage an frühe text-basierte Rollenspiele in der Konsole spielbar sein
-   Die Anwendung soll auf den Schulrechnern des LEBK ausführbar sein
-	Das Spiel sollte unterbrochen werden können, um es zu einem späteren Zeitpunkt fortsetzen zu können
-	Zu Spielbeginn soll es verschiedene Auswahlmöglichkeiten zum Spieler-Charakter geben
-   Es soll möglich sein, Informationen zu abgeschlossenen Spielläufen einzusehen

## Pflichtenheft
-	Umsetzen einer Java Anwendung mit Ein- und Ausgabe über die Konsole, um an frühe textbasierte Rollenspiele zu erinnern
-	Anbindung der Java-Anwendung an eine Sqlite-Datenbank über eine JDBC-Datenbankverbindung
-	Funktionalität implementieren, um das speichern und laden des Spielstands zu ermöglichen sowie die Spieldaten aus der Datenbank abzufragen
-   Dialoge mitsamt ihrer Optionen werden dynamisch aus der Datenbank geladen
-	Nach jeder Dialogauswahl wird der Stand des aktuellen Spiellaufs in der Datenbank gespeichert
-	Zu Programmstart können Spieler einen vorhandenen Speicherstand laden oder einen neuen anlegen, um zuvor unterbrochene Spiele fortzusetzen
-	Abgeschlossene Spielstände werden automatisch deaktiviert und archiviert
-	Nach Abschluss eines Spiellaufes wird angezeigt, welches Spielende erreicht wurde und wie viele Enden in dieser Installation noch nicht erreicht wurden
