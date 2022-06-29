insert into docente values('1','Giovanni','Chiappa','Curriculum Vitae');
insert into docente values('2','Max','Ghianda','Curriculum Vitae');
insert into docente values('3','Tiziano','Ferro','Curriculum Vitae');

insert into corso values(corso_seq.nextval,1,'HTML', TO_DATE('07/09/2022', 'dd/mm/yyyy'),TO_DATE('07/09/2022', 'dd/mm/yyyy'),'A1');
insert into corso values(corso_seq.nextval,2,'JAVA',TO_DATE('05/07/2022', 'dd/mm/yyyy'),TO_DATE('07/08/2022', 'dd/mm/yyyy'),'C3');
insert into corso values(corso_seq.nextval,2,'PHP',TO_DATE('22/07/2022', 'dd/mm/yyyy'),TO_DATE('16/08/2022', 'dd/mm/yyyy'),'L19');
insert into corso values(corso_seq.nextval,3,'Canto',TO_DATE('25/09/2022', 'dd/mm/yyyy'),TO_DATE('30/09/2022', 'dd/mm/yyyy'),'C2');

insert into corsista values(corsista_seq.nextval,'Carlo','Carifi','NO');
insert into corsista values(corsista_seq.nextval,'Giovanni','Galliani','NO');
insert into corsista values(corsista_seq.nextval,'Leonardo','Bonadie','NO');
insert into corsista values(corsista_seq.nextval,'Riccardo','Verde','SI');

insert into corso_corsista values(corso_corsista_seq.nextval,1,1);
insert into corso_corsista values(corso_corsista_seq.nextval,1,2);
insert into corso_corsista values(corso_corsista_seq.nextval,2,1);
insert into corso_corsista values(corso_corsista_seq.nextval,3,2);
insert into corso_corsista values(corso_corsista_seq.nextval,1,3);
insert into corso_corsista values(corso_corsista_seq.nextval,2,4);

insert into amministratore values ('codeAdmin1','nome1','Cognome1','pass');
commit