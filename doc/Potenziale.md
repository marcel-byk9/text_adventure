# Potenzielle Anpassungen für zukünftige Weiterentwicklung

---

## Wiederverwendbarkeit von Situations-Entitäten
- Während der Entwicklung wurde festgestellt, dass die Wiederverwendbarkeit von Situationen nicht gegeben ist
- Über die Tabelle "StoryTelling" kann Wiederverwendung in verschiedenen Handlungssträngen nicht abgebildet werden
- Hier wäre eine Anpassung des Datenmodells mit einem weiteren schwachen Entitätstyp denkbar, der eine Zuordnung von passenden Optionen für eine wiederverwendete Situation abbildet
- Aufgrund des begrenzten Bearbeitungszeitraums wurde diese Anpassung nicht umgesetzt
- Die Anforderung aus dem Lastenheft wird nicht beeinträchtigt, da die Wiederverwendbarkeit bei einem einzelnen, wenig umfangreichen Spiel vernachlässigbar ist.

---

## Schreiben und Entwickeln der Handlungsstränge über manuelle Insert-Statements
- Während der Umsetzung wurden die Textbausteine der Handlung direkt über eine Datenbank-Query eingepflegt
- Diese Herangehensweise hat sich als sehr mühsam erwiesen
- Für die Weiterentwicklung dieses Projekts in einem größeren Umfang sollte die Implementierung einer Client-Oberfläche zur Eingabe und Verknüpfung von Textbausteinen erwogen werden

## Ermitteln des passenden Handlungsstrangs
- Nach Erstellung eines Charakters wird der Handlungsstrang anhand einer festgesetzten Id ausgewählt
- Um diese Auswahl über das Datenmodell abzubilden, könnte ein schwacher Entitätstyp hinzugefügt werden