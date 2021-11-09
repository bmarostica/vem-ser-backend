CREATE TABLE VEM_SER.ESTUDANTE(
	id_estudante NUMBER NOT NULL,
	nome varchar2(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo char(1) NOT NULL,
	PRIMARY KEY (id_estudante)
);

CREATE SEQUENCE seq_estudante
START WITH 1
INCREMENT BY 1
nocache
nocycle;

INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Bianca Marostica', TO_DATE('06-11-1993', 'dd,mm,yyyy'),  1325646345, 'S');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Joelma', TO_DATE('18-10-1987', 'dd,mm,yyyy'),  5433254325, 'S');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Cris', TO_DATE('06-03-1990', 'dd,mm,yyyy'),  5674907975, 'N');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Juvenal', TO_DATE('14-03-1995', 'dd,mm,yyyy'),  8544667543, 'S');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Augustinho', TO_DATE('10-12-1988', 'dd,mm,yyyy'),  2567675436, 'S');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Melissa', TO_DATE('01-01-1964', 'dd,mm,yyyy'),  1245567856, 'N');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Tiago', TO_DATE('13-05-1987', 'dd,mm,yyyy'),  4534609174, 'S');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'William', TO_DATE('28-02-1994', 'dd,mm,yyyy'),  2356457465, 'S');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Maira', TO_DATE('26-09-1998', 'dd,mm,yyyy'),  3457546876, 'N');
INSERT INTO VEM_SER.estudante
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO)
VALUES (seq_estudante.nextval, 'Joana', TO_DATE('16-07-2001', 'dd,mm,yyyy'),  4574574674, 'S');

SELECT * FROM VEM_SER.ESTUDANTE;