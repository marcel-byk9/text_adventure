INSERT INTO PlayerClassOption(Id, Name, Description) VALUES 
('8f3d6f2e-7a5d-4c9a-9c52-6a01e1f89cb3','Klassenlos','noch keine Klasse'),
('1c4b9f67-27b1-4e0d-9a0b-5a3e0f4d6c27','Feuerbendiger', 'Holzkohle der höchsten Qualität für die Schmiedefeuer herzustellen.'),
('e2a1c8da-bf4e-4b5e-9134-02f28a64d8e6','Wasserbendiger','das Wasser in Pflanzen beeinflussen zu können und besondere Heilkräuter zu züchten.'),
('74d3d0ab-1922-4aef-82b7-5d5b9c5e0f92','Erdbendiger','Erze verschiedener Metalle zu finden und diese von Unreinheiten zu befreien.');

INSERT INTO PlayerBackgroundOption(Id, Name, Description) VALUES
('8f3d6f2e-7a5d-4c9a-9c52-6a01e1f89cb3', 'Akrobat', 'Akrobat bei einem wandernden Zirkus'),
('3b7c9e12-5f4b-4a4a-bd14-1b2d6a9f02c8', 'Stadtwache', 'Stadtwache, die bei einem Überfall am Knie verletzt wurde und den Dienst verlassen musste'),
('c12a0c71-2c8f-4e2d-9b43-2a5e5a6e7f45', 'Feuersoldat', 'Soldat in der Armee der Feuernation'),
('b4e3f9d8-68a7-4e94-82b1-9a43f20b5f1c', 'Wassersoldat', 'Soldat in der Armee des Wasserstamms'),
('a19f3c62-58d1-41e7-9d2c-31d0c93a4b20', 'Erdsoldat', 'Soldat in der Armee des Erdkönigreichs');

INSERT INTO Situation(Id, Description, IsEnding) VALUES
('7c1d5a9b-2e3f-4b6d-8c9a-1f2e3a4b5c6d', 'Um dir deinen Lebensunterhalt zu verdienen, setzt du insgeheim deine Bändigungskräfte ein.
Deine Fähigkeit über dein Element ermöglicht es dir...', false),
('2b3c4d5e-6f7a-489b-9c1d-2e3f4a5b6c7d', 'In der Vergangenheit war dein Leben geprägt von großen Herausforderungen und Strapazen.
Bevor du dich in einem kleinen Dorf nahe Omashu im Erdkönigreich wiedergefunden hast
warst du...', false),
('8a9b0c1d-2e3f-4d5a-9b6c-7d8e9f0a1b2c', 'Es ist abend. Du gehst einen Pfad entlang, der durch einen Wald führt.
Auf dem Rücken trägst du einen Korb. Er ist gefüllt mit grobem Eisenerz, dass du heute abgebaut hast.
Am nächsten Tag willst du das Erz...', false),
('3c4d5e6f-7a8b-49c0-9d1e-2f3a4b5c6d7e', 'Während du dem Weg folgst, driften deine Gedanken zurück in die Vergangenheit.
Es ist schon merkwürdig, wie es dazu kam, dass du hier gelandet bist.
Es wirkt wie vor einer Ewigkeit, dass du am Knie verwundet wurdest, weil...', false),
('4d5e6f7a-8b9c-40d1-9e2f-3a4b5c6d7e8f', 'So verloren in der Erinnerung merkst du nicht, dass sich hinter dir dass stampfen von Reitvögeln?
immer näher kommt.

"Platz da, du Lump!"
Erschrocken fährst du herum. Deine Reaktion kommt keinen Moment zu früh. Nur knapp kannst du dem vordersten Reiter ausweichen.
Jedoch kommst du dabei ins straucheln und fällst zu Boden. Ein Krachen ertönt, als der Korb unter deiner Last zerbricht.
Der Reitvogel macht einen Satz. Der Reiter, der nur locker im Sattel sitzt, wird samt seinem Gepäck abgeworfen.
Ein durcheinander bricht in der Gruppe von Reitern aus.
Erst jetzt realisierst du voller Furcht, dass du es mit einem Trupp der Feuernation zu tun hast.

Wenn du dich jetzt zur Seite rollst, aufspringst und in den Wald rennst, könntest du entkommen.
Wie entscheidest du dich?', false),
('5e6f7a8b-9c0d-41e2-9f3a-4b5c6d7e8f9a', 'Dein Instinkt übernimmt. In einem Chaos aus Geschrei und Staub hechtest du in den Wald.
Aber schon nach wenigen Schritten spürst du das etwas nicht stimmt.
Plötzlich gibt dein Knie nach. Du brichst zusammen und wirst vor Schmerz beinahe Ohnmächtig.
Nach wenigen Augenblicken erreichen dich die Soldaten. Du wirst gefangen genommen und in das besetzte Omashu gebracht.
Dort wird deine Vergangenheit als Erdbändiger im Dienst des Erdkönigreichs offenbar.
Deine Zukunft wirst du auf einer Kohleplattform inmitten des Ozeans verbringen.', true),
('6f7a8b9c-0d1e-42f3-9a4b-5c6d7e8f9a0b', 'Der gestürzte Reiter richtet sich auf. Mit hassverzerte Gesicht stürzt er auf dich zu.
Du kannst das unkontrollierte Züngeln von Flammen an seinen Händen sehen.
Du atmest tief in deinen Bauch, verankerst die Füße fest mit dem Boden und wappnest dich.
Kurz bevor der Soldat dich erreicht...', false),
('7a8b9c0d-1e2f-43a4-9b5c-6d7e8f9a0b1c', 'Der Soldat wirkt wie im Wahn. Er scheint die Flammen kaum noch zurückhalten zu können.
Dir ist egal, wie es endet. Du wirst nie vor einem Feuerbändiger zurückweichen.
Du spürst die Kraft und Ruhe der Erde unter deinen Füßen.

Plötzlich kommt ein Ruf von einem der Soldaten im hinteren Teil der Gruppe.
Seine Uniform unterscheidet ihn von den anderen. Vielleicht ein Offizier...

"Kuzon! Wir haben keine Zeit für deine Spielereien! Unser Auftrag kann nicht warten."
Der gestürzte Reiter lässt die Flammen erlischen und hält inne.', false),
('8b9c0d1e-2f3a-44b5-9c6d-7e8f9a0b1c2d', 'Deine Reaktion kam zu früh. Den Bruchteil einer Sekunde später spürst du den Stiefel des Soldaten,
der dir in Bauch getreten hat.
Für einen Moment scheint der Soldat irritiert. Trotz des kraftvollen Tritts gibst du nicht nach.
Ein verwirrter Ausdruck erscheint auf seinem Gesicht. Du kannst dir ein schmales lächeln nicht verkneifen.
Doch plötzlich schießt ein stechender Schmerz durch dein Knie.

Du fällst zu Boden und landest im Staub.', false),
('9c0d1e2f-3a4b-45c6-9d7e-8f9a0b1c2d3e', '"Da gehörst du hin, du elender Bauer!"
Der Soldat verpasst dir einen weiteren Tritt und wendet sich wieder seinem Reittier zu.
Durch einen Schleier des Schmerzes nimmst du noch zur Kenntnis, wie der Trupp davon reitet.
Du merkst, wie dein Bewusstsein schwindet.', false),
('0d1e2f3a-4b5c-46d7-9e8f-9a0b1c2d3e4f', 'Deine Augen öffnen sich.
Es ist tiefe Nacht. Um dich herum ist alles ruhig. Langsam richtest du dich auf und blickst dich um.
Auf der Suche nach deinem Korb fällt dir etwas auf. Dort am Rande des Weges liegt etwas im Staub.
Ein zusammengerolltes und zertrampeltes Stück Papier.', false),
('1e2f3a4b-5c6d-47e8-9f9a-0b1c2d3e4f5a', 'Keuchend bückst du dich herab und stopfst das Papier unter deinen Gürtel.
Du machst dich auf den Weg zu deinem Dorf. Trotz der Schmerzen kommst du gut voran.', false),
('2f3a4b5c-6d7e-48f9-9a0b-1c2d3e4f5a6b', 'Du weißt nicht mehr, wann du das Dorf erreicht hast. Am frühen morgen erwachst du in deiner Hütte.
Du stehst auf und fühlst einen merkwürdigen Druck an deiner Hüfte. Das Stück Papier...', true);

INSERT INTO Option(Id, Description ) VALUES
('6d3a1b9c-2f8e-4a7f-9d2c-1b4e3f6a7c92', 'Als rohes Erz auf dem Markt verkaufen, um bei den Besatzern der Feuernation nicht aufzufallen.'),
('4c8e2b1d-9f3a-42d6-8e1c-7a9b2f3d6c45', 'Aufbereiten und für einen hohen Preis direkt an einen bekannten Schmied verkaufen.'),
('a4f7c9e1-3b2d-41e8-9c7a-2e1b6f4d8a93', 'du eine Razzia gegen illegale Tierhändler angeführt und in einen Hinterhalt geraten bist.'),
('c9e1a7b3-5f2d-4d8c-8b9a-3a7f2e1c6d48', 'du dich dem Dai Lee entgegengestellt hast, um einen unschuldigen Bürger zu beschützen.'),
('b7d9c2f4-1a3e-4b6d-8f9a-2d4c7e1b3a56', 'Du ergreifst die Flucht.'),
('3d9a7c1f-8e2b-42c5-9a4d-1b6f2e3c7d94', 'Du springst auf die Beine und machst dich bereit für das was kommt.'),
('5f3a9c7b-1e2d-4d6f-9b8a-3c2d7a4e1f69', 'blickst du ihm direkt in die Augen. Du lässt dich nicht einschüchtern.'),
('7e2b9f1c-3a5d-4c8e-8d9a-1f2b3c6d4a85', 'blickst du zu Boden. Dein Schicksal scheint besiegelt.'),
('9c1e7b2f-4d3a-4f6d-8e9a-2b1d3a7c5f46', 'Du öffnest den Mund, um etwas zu sagen.'),
('f2a9d7c1-6e3b-4a5d-9c8e-1d7b3a4f2c95', 'Vor Erleichterung lässt du die Schultern hängen.'),
('8f3d6f2e-7a5d-4c9a-9c52-6a01e1f89cb3', 'Du greifst nach deinem Bein...'),
('3b7c9e12-5f4b-4a4a-bd14-1b2d6a9f02c8', 'Du kannst nicht dagegen ankämpfen.'),
('c12a0c71-2c8f-4e2d-9b43-2a5e5a6e7f45', 'Du hattest für heute genug Ärger. Du ignorierst das Papier und machst dich auf den Rückweg zu deinem Dorf.'),
('b4e3f9d8-68a7-4e94-82b1-9a43f20b5f1c', 'Du versuchst, das Papier aufzuheben.'),
('a19f3c62-58d1-41e7-9d2c-31d0c93a4b20', 'Du gehst nach Hause.');

INSERT INTO Storytelling( Id, Situation, Option, Next_Situation) VALUES
('e23a9d7b-9f14-4e2f-84a2-8c4d0f2b3a65', '8a9b0c1d-2e3f-4d5a-9b6c-7d8e9f0a1b2c', '6d3a1b9c-2f8e-4a7f-9d2c-1b4e3f6a7c92', '3c4d5e6f-7a8b-49c0-9d1e-2f3a4b5c6d7e'),
('9b84c3e1-7a1f-44c5-8e1a-7c2f4d1b2a36', '8a9b0c1d-2e3f-4d5a-9b6c-7d8e9f0a1b2c', '4c8e2b1d-9f3a-42d6-8e1c-7a9b2f3d6c45', '3c4d5e6f-7a8b-49c0-9d1e-2f3a4b5c6d7e'),
('2f7c1a3b-8e94-4f23-9b8d-3e2a1d7c6b49', '3c4d5e6f-7a8b-49c0-9d1e-2f3a4b5c6d7e', 'a4f7c9e1-3b2d-41e8-9c7a-2e1b6f4d8a93', '4d5e6f7a-8b9c-40d1-9e2f-3a4b5c6d7e8f'),
('f61a9e7d-4b12-4d8f-9e31-6c7b2f3a1d48', '3c4d5e6f-7a8b-49c0-9d1e-2f3a4b5c6d7e', 'c9e1a7b3-5f2d-4d8c-8b9a-3a7f2e1c6d48', '4d5e6f7a-8b9c-40d1-9e2f-3a4b5c6d7e8f'),
('8c1d4e2f-9a23-4b76-8c9d-1a4f5e7b3d62', '4d5e6f7a-8b9c-40d1-9e2f-3a4b5c6d7e8f', 'b7d9c2f4-1a3e-4b6d-8f9a-2d4c7e1b3a56', '5e6f7a8b-9c0d-41e2-9f3a-4b5c6d7e8f9a'),
('1a9b3e72-3f2d-45c8-8e94-7a6c2b3d1f58', '4d5e6f7a-8b9c-40d1-9e2f-3a4b5c6d7e8f', '3d9a7c1f-8e2b-42c5-9a4d-1b6f2e3c7d94', '6f7a8b9c-0d1e-42f3-9a4b-5c6d7e8f9a0b'),
('d2b4a7c8-5e1f-46a9-9c84-3b2d7f1a6e95', '6f7a8b9c-0d1e-42f3-9a4b-5c6d7e8f9a0b', '5f3a9c7b-1e2d-4d6f-9b8a-3c2d7a4e1f69', '7a8b9c0d-1e2f-43a4-9b5c-6d7e8f9a0b1c'),
('7f1c9e8d-2a3b-42e4-8d7f-9a1b2c3d4e65', '6f7a8b9c-0d1e-42f3-9a4b-5c6d7e8f9a0b', '7e2b9f1c-3a5d-4c8e-8d9a-1f2b3c6d4a85', '7a8b9c0d-1e2f-43a4-9b5c-6d7e8f9a0b1c'),
('e91b7a6c-4f2d-4e3a-9b7c-8a2d1f6c3b45', '7a8b9c0d-1e2f-43a4-9b5c-6d7e8f9a0b1c', '9c1e7b2f-4d3a-4f6d-8e9a-2b1d3a7c5f46', '8b9c0d1e-2f3a-44b5-9c6d-7e8f9a0b1c2d'),
('6d3a1b9c-2f8e-4a7f-9d2c-1b4e3f6a7c92', '7a8b9c0d-1e2f-43a4-9b5c-6d7e8f9a0b1c', 'f2a9d7c1-6e3b-4a5d-9c8e-1d7b3a4f2c95', '8b9c0d1e-2f3a-44b5-9c6d-7e8f9a0b1c2d'),
('4c8e2b1d-9f3a-42d6-8e1c-7a9b2f3d6c45', '8b9c0d1e-2f3a-44b5-9c6d-7e8f9a0b1c2d', '8f3d6f2e-7a5d-4c9a-9c52-6a01e1f89cb3', '9c0d1e2f-3a4b-45c6-9d7e-8f9a0b1c2d3e'),
('a4f7c9e1-3b2d-41e8-9c7a-2e1b6f4d8a93', '9c0d1e2f-3a4b-45c6-9d7e-8f9a0b1c2d3e', '3b7c9e12-5f4b-4a4a-bd14-1b2d6a9f02c8', '0d1e2f3a-4b5c-46d7-9e8f-9a0b1c2d3e4f'),
('c9e1a7b3-5f2d-4d8c-8b9a-3a7f2e1c6d48', '0d1e2f3a-4b5c-46d7-9e8f-9a0b1c2d3e4f', 'c12a0c71-2c8f-4e2d-9b43-2a5e5a6e7f45', '1e2f3a4b-5c6d-47e8-9f9a-0b1c2d3e4f5a'),
('b7d9c2f4-1a3e-4b6d-8f9a-2d4c7e1b3a56', '0d1e2f3a-4b5c-46d7-9e8f-9a0b1c2d3e4f', 'b4e3f9d8-68a7-4e94-82b1-9a43f20b5f1c', '1e2f3a4b-5c6d-47e8-9f9a-0b1c2d3e4f5a'),
('3d9a7c1f-8e2b-42c5-9a4d-1b6f2e3c7d94', '1e2f3a4b-5c6d-47e8-9f9a-0b1c2d3e4f5a', 'a19f3c62-58d1-41e7-9d2c-31d0c93a4b20', '2f3a4b5c-6d7e-48f9-9a0b-1c2d3e4f5a6b');