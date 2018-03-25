-- Tabelle Termin
drop table drsolutions.TERMIN;

create table drsolutions.TERMIN (
    termin_id int not null AUTO_INCREMENT,
    bezeichnung varchar(255) not null,
    ort varchar(255) not null,
    zeitpunkt TIMESTAMP not null,
    PRIMARY KEY (termin_id)
);

-- Tabelle Person
--drop table drsolutions.PERSON;

create table drsolutions.PERSON (
    person_id int not null AUTO_INCREMENT,
    vorname varchar(255) not null,
    nachname varchar(255) not null,
    mail varchar(255) not null,
    telefon varchar(255) not null,
    PRIMARY KEY (person_id)
);

-- Tabelle PersonTermin (m:n Tabelle)
--drop table drsolutions.PERSON_TERMIN;

create table drsolutions.PERSON_TERMIN (
    person_termin_id int not null AUTO_INCREMENT,
    termin_id int not null,
    person_id int not null,
    PRIMARY KEY (person_termin_id),
    FOREIGN KEY (termin_id) REFERENCES TERMIN(termin_id),
    FOREIGN KEY (person_id) REFERENCES PERSON(person_id)
);

-- Values fuer Termin
Insert into drsolutions.TERMIN (bezeichnung, ort, zeitpunkt) values ('Codingsession', 'St.Veit', STR_TO_DATE('01.01.2018 14:20', '%d.%m.%Y %H:%i'));
Insert into drsolutions.TERMIN (bezeichnung, ort, zeitpunkt) values ('Frühstücken', 'Traisen', STR_TO_DATE('23.03.2018 09:00', '%d.%m.%Y %H:%i'));

-- Values fuer Person
Insert into drsolutions.PERSON (vorname, nachname, mail, telefon) values ('René', 'Dolar', 'rene.dolar@gmail.com', '069917244225');
Insert into drsolutions.PERSON (vorname, nachname, mail, telefon) values ('Jakob', 'Kraushofer', 'jakob.kraushofer@live.at', '06640001117');
Insert into drsolutions.PERSON (vorname, nachname, mail, telefon) values ('Max', 'Mustermann', 'max.muster@mail.com', '0676123456789');

-- Values fuer PersonTermin
Insert into drsolutions.PERSON_TERMIN (termin_id, person_id) values ((select termin_id from drsolutions.TERMIN where bezeichnung = 'Codingsession'), (select person_id from drsolutions.PERSON where vorname = 'René'));
Insert into drsolutions.PERSON_TERMIN (termin_id, person_id) values ((select termin_id from drsolutions.TERMIN where bezeichnung = 'Codingsession'), (select person_id from drsolutions.PERSON where vorname = 'Jakob'));
Insert into drsolutions.PERSON_TERMIN (termin_id, person_id) values ((select termin_id from drsolutions.TERMIN where bezeichnung = 'Frühstücken'), (select person_id from drsolutions.PERSON where vorname = 'René'));
Insert into drsolutions.PERSON_TERMIN (termin_id, person_id) values ((select termin_id from drsolutions.TERMIN where bezeichnung = 'Frühstücken'), (select person_id from drsolutions.PERSON where vorname = 'Jakob'));
Insert into drsolutions.PERSON_TERMIN (termin_id, person_id) values ((select termin_id from drsolutions.TERMIN where bezeichnung = 'Frühstücken'), (select person_id from drsolutions.PERSON where vorname = 'Max'));
