SELECT *
FROM PESSOA p
RIGHT JOIN CONTATO c ON (P.ID_PESSOA = C.ID_PESSOA)

SELECT *
FROM PESSOA p 
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA)
RIGHT JOIN ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = EP.ID_ENDERECO)

SELECT *
FROM PESSOA p 
RIGHT JOIN CONTATO c ON (P.ID_PESSOA = C.ID_PESSOA)
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA)
RIGHT JOIN ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = EP.ID_ENDERECO)

SELECT *
FROM PESSOA p
FULL OUTER JOIN CONTATO c ON (P.ID_PESSOA = C.ID_PESSOA)

SELECT *
FROM PESSOA p 
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = EP.ID_ENDERECO)

SELECT *
FROM PESSOA p 
FULL OUTER JOIN CONTATO c ON (P.ID_PESSOA = C.ID_PESSOA)
FULL OUTER JOIN PESSOA_X_PESSOA_ENDERECO pxpe ON (P.ID_PESSOA = PXPE.ID_PESSOA)
FULL OUTER JOIN ENDERECO_PESSOA ep ON (PXPE.ID_ENDERECO = EP.ID_ENDERECO)

SELECT * FROM PESSOA p
WHERE EXISTS (
SELECT *
FROM PESSOA_X_PESSOA_ENDERECO pxpe
WHERE p.ID_PESSOA = pxpe.ID_PESSOA
)

SELECT NOME, ID_PESSOA 
FROM PESSOA p 
UNION
SELECT LOGRADOURO, ID_ENDERECO
FROM ENDERECO_PESSOA ep 