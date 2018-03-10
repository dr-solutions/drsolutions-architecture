drop table Termin;

create table Termin (
    termin_id int not null AUTO_INCREMENT,
    bezeichnung varchar(255) not null,
    zeitpunkt date not null,
    beteiligte_person varchar(255),
    PRIMARY KEY (termin_id)
);

Insert into Termin (bezeichnung, zeitpunkt, beteiligte_person) values ('Codingsession','2018-03-07','Jakob, René');
Insert into Termin (bezeichnung, zeitpunkt, beteiligte_person) values ('Frühstücken','2018-03-11','Jakob, Lisa');
