--Selecionar todos os países ordenados por nome decrescente
SELECT * FROM PAIS ORDER BY NOME DESC 

--Selecionar logradouro e cep dos endereços. Porém, somente os logradouros que comecem com a letra ‘a’ (maiúsculo ou minúsculo)
SELECT LOGRADOURO, CEP FROM ENDERECO WHERE LOGRADOURO LIKE 'A%' OR LOGRADOURO LIKE 'a%'

--Selecionar todos os endereços que tenham cep com final ‘0’
SELECT * FROM ENDERECO WHERE CEP LIKE '%0'

--Selecionar todos os endereços que tenham números entre 1 e 100
SELECT * FROM ENDERECO WHERE NUMERO BETWEEN 1 AND 100

--Selecionar todos os endereços que comecem por “RUA” e ordenar pelo cep de forma decrescente
SELECT * FROM ENDERECO WHERE UPPER(LOGRADOURO) LIKE 'RUA%'

--Selecionar a quantidade de endereços cadastrados na tabela
SELECT COUNT(LOGRADOURO) FROM ENDERECO

--Selecionar a quantidade de endereços cadastrados agrupados pelo id da cidade
SELECT ID_CIDADE, COUNT(LOGRADOURO) FROM ENDERECO GROUP BY ID_CIDADE