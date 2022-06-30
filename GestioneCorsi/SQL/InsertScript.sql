insert into docente values('1','Giovanni','Chiappa','Curriculum Vitae');
insert into docente values('2','Max','Ghianda','Curriculum Vitae');
insert into docente values('3','Tiziano','Ferro','Curriculum Vitae');
insert into docente values('2208', 'Giovanni', 'Galliani', 'CV');

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
insert into corso_corsista values(corso_corsista_seq.nextval,1,3);
insert into corso_corsista values(corso_corsista_seq.nextval,2,4);
insert into corso_corsista values(corso_corsista_seq.nextval,2,1);
insert into corso_corsista values(corso_corsista_seq.nextval,3,2);

insert into commento values(commento_seq.nextval,1,1,'Corso di HTML ben Strutturato CC');
insert into commento values(commento_seq.nextval,1,2,'Corso di HTML Migliorabile GG');
insert into commento values(commento_seq.nextval,2,3,'Corso di  JAVA OK LB');

insert into amministratore values ('CodAdm176','Aldo','Baglio','aeq8tS(r2zC&95gS/ui2R*lkA4£d5q8tS(r2zC&95gS/ui2R*lkA4£46q8tS(r2zC&95gS/ui2R*lkA4£a5q8tS(r2zC&95gS/ui2R*lkA4£8bq8tS(r2zC&95gS/ui2R*lkA4£4dq8tS(r2zC&95gS/ui2R*lkA4£dcq8tS(r2zC&95gS/ui2R*lkA4£28q8tS(r2zC&95gS/ui2R*lkA4£fbq8tS(r2zC&95gS/ui2R*lkA4£ffq8tS(r2zC&95gS/ui2R*lkA4£34q8tS(r2zC&95gS/ui2R*lkA4£a7q8tS(r2zC&95gS/ui2R*lkA4£98q8tS(r2zC&95gS/ui2R*lkA4£d3q8tS(r2zC&95gS/ui2R*lkA4£c4q8tS(r2zC&95gS/ui2R*lkA4£29q8tS(r2zC&95gS/ui2R*lkA4£');
commit