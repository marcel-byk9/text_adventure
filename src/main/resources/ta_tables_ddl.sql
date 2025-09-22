DROP TABLE IF EXISTS Storytelling;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Situation;
DROP TABLE IF EXISTS Option;
DROP TABLE IF EXISTS PlayerBackgroundOption;
DROP TABLE IF EXISTS PlayerClassOption;

CREATE TABLE IF NOT EXISTS PlayerClassOption(
    Id TEXT PRIMARY KEY,
    Name TEXT,
    Description TEXT
);

CREATE TABLE IF NOT EXISTS PlayerBackgroundOption(
    Id TEXT PRIMARY KEY,
    Name TEXT,
    Description TEXT
);

CREATE TABLE IF NOT EXISTS Option(
    Id TEXT PRIMARY KEY,
    Description TEXT
);

CREATE TABLE IF NOT EXISTS Situation(
    Id TEXT PRIMARY KEY,
    Description TEXT,
    IsEnding BOOLEAN
);

CREATE TABLE IF NOT EXISTS Player(
    Id TEXT PRIMARY KEY,
    Name TEXT,
    Background TEXT,
    Class TEXT,
    Story_Save TEXT,
    IsActive BOOLEAN,
    SituationsCounter TEXT,
    CONSTRAINT FK_Background FOREIGN KEY (Background) REFERENCES PlayerBackgroundOption(Id),
    CONSTRAINT FK_Class FOREIGN KEY (Class) REFERENCES PlayerClassOption(Id),
    CONSTRAINT FK_StorySave FOREIGN KEY (Story_Save) REFERENCES Situation(Id)
);

CREATE TABLE IF NOT EXISTS Storytelling(
    Id TEXT PRIMARY KEY,
    Situation TEXT,
    Option TEXT,
    Next_Situation TEXT,
    CONSTRAINT FK_Next_Situation FOREIGN KEY (Next_Situation) REFERENCES Situation(Id)
	CONSTRAINT FK_Situation FOREIGN KEY (Situation) REFERENCES Situation(Id)
	CONSTRAINT FK_Option FOREIGN KEY (Option) REFERENCES Option(Id)
);
