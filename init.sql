CREATE TABLE IF NOT EXISTS "Groups" (
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Classes (
    Id SERIAL PRIMARY KEY,
    GroupId INTEGER NOT NULL,
    Subject VARCHAR(255) NOT NULL,
    Date DATE NOT NULL,
    Time TIME NOT NULL,
    Classroom VARCHAR(100),
    CONSTRAINT fk_class_group
        FOREIGN KEY (GroupId)
        REFERENCES "Groups"(Id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "Student" (
    Id SERIAL PRIMARY KEY,
    GroupId INTEGER NOT NULL,
    IsNotified BOOLEAN DEFAULT FALSE,
    MailingTime TIME,
    CONSTRAINT fk_user_group
        FOREIGN KEY (GroupId)
        REFERENCES "Groups"(Id)
        ON DELETE CASCADE
);
