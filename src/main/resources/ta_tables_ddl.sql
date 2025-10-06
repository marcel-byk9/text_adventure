DROP TABLE IF EXISTS Storytelling;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Situation;
DROP TABLE IF EXISTS Option;
DROP TABLE IF EXISTS PlayerBackgroundOption;
DROP TABLE IF EXISTS PlayerClassOption;
DROP TABLE IF EXISTS StartingSituation;

CREATE TABLE IF NOT EXISTS PlayerClassOption(
    Id TEXT NOT NULL PRIMARY KEY,
    Name TEXT,
    Description TEXT
);

CREATE TABLE IF NOT EXISTS PlayerBackgroundOption(
    Id TEXT NOT NULL PRIMARY KEY,
    Name TEXT,
    Description TEXT
);

CREATE TABLE IF NOT EXISTS Option(
    Id TEXT NOT NULL PRIMARY KEY,
    Description TEXT
);

CREATE TABLE IF NOT EXISTS Situation(
    Id TEXT NOT NULL PRIMARY KEY,
    Description TEXT,
    IsEnding BOOLEAN
);

CREATE TABLE IF NOT EXISTS Player(
    Id TEXT NOT NULL PRIMARY KEY,
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
    Id TEXT NOT NULL PRIMARY KEY,
    Situation TEXT,
    Option TEXT,
    Next_Situation TEXT,
    CONSTRAINT FK_Next_Situation FOREIGN KEY (Next_Situation) REFERENCES Situation(Id),
	CONSTRAINT FK_Situation FOREIGN KEY (Situation) REFERENCES Situation(Id),
	CONSTRAINT FK_Option FOREIGN KEY (Option) REFERENCES Option(Id)
);

CREATE TABLE IF NOT EXISTS StartingSituation(
    Id TEXT NOT NULL PRIMARY KEY,
    ClassOptionId TEXT NOT NULL,
    BackgroundOptionId TEXT NOT NULL,
    SituationId TEXT NOT NULL,

    CONSTRAINT FK_ClassOption FOREIGN KEY (ClassOptionId) REFERENCES PlayerClassOption(Id),
    CONSTRAINT FK_BackgroundOption FOREIGN KEY (BackgroundOptionId) REFERENCES PlayerBackgroundOption(Id),
    CONSTRAINT FK_SituationStart FOREIGN KEY (SituationId) REFERENCES Situation(Id),

    CONSTRAINT Unique_Combination UNIQUE (ClassOptionId, BackgroundOptionId)
);
