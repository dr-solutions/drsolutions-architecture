drop table drsolutions.TERMIN;

create table drsolutions.TERMIN (
    termin_id int not null AUTO_INCREMENT,
    bezeichnung varchar(255) not null,
    zeitpunkt date not null,
    beteiligte_person varchar(255),
    PRIMARY KEY (termin_id)
);

Insert into drsolutions.TERMIN (bezeichnung, zeitpunkt, beteiligte_person) values ('Codingsession','2018-03-07','Jakob, Ren�');
Insert into drsolutions.TERMIN (bezeichnung, zeitpunkt, beteiligte_person) values ('Fr�hst�cken','2018-03-11','Jakob, Lisa');
