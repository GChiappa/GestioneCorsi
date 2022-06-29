create table docente(
	cod_docente varchar2(10),
	nome varchar2(30) not null,
	cognome varchar2(30) not null,
	cv varchar2(2000) not null,
	constraint p_coddocente primary key(cod_docente)
);

create table corsista(
	cod_corsista int,
	nome varchar2(30) not null,
	cognome varchar2(30) not null,
	precedenti_formativi char(2) not null,
	constraint p_codcorsista primary key(cod_corsista)
);

create table corso(
	cod_corso int,
	cod_docente varchar2(10),
	nome varchar2(30),
	data_inizio date,
	data_fine date,
	aula varchar2(10),
	constraint p_codcorso primary key(cod_corso),
	constraint f_docentecorso foreign key(cod_docente) references docente(cod_docente)
);

create table corso_corsista(
	cod_corso_corsista varchar2(10),
	cod_corso int,
	cod_corsista int,
	constraint p_corsocorsista primary key(cod_corso_corsista),
	constraint f_codcorsocc foreign key(cod_corso) references corso(cod_corso),
	constraint f_codcorsistacc foreign key(cod_corsista) references corsista(cod_corsista)
);

create table commenti(
	id_commento int,
	cod_corso int,
	cod_corsista int,
	descrizione varchar2(500),
	constraint p_idcommento primary key(id_commento),
	constraint f_codcorsoc foreign key(cod_corso) references corso(cod_corso),
	constraint f_codcorsistac foreign key(cod_corsista) references corsista(cod_corsista)
);


--Admin
create table amministratore(
	cod_amministratore varchar2(10),
	nome varchar2(30),
	cognome varchar2(30),
	password varchar2(1000),
	constraint p_codamministratore primary key(cod_amministratore)
);