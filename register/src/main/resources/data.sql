-- Tabela Company - Empresa
insert into Empresa (id_empresa, razao_social, cnpj, telefone, email, data_abertura, ativa)
values (2000, 'Clarice e Lorena Contábil ME', '40298826000101', '1129361399',
'estoque@clariceelorenacontabilme.com.br', '2022-03-12', true);

insert into Empresa (id_empresa, razao_social, cnpj, telefone, email, data_abertura, ativa)
values (2001,'São Paulo Tech School', '07165496000100', '1135894043',
'atendimento@sptech.school', '2022-02-12', true);

-- Tabela Manager - Gestor
insert into Gestor (id_gestor, nome, login, senha, fk_empresa) values (500, 'Lorena Machado',
'lmachado@oncln.com', '#Tortalaranja123', 2000);

insert into Gestor (id_gestor, nome, login, senha, fk_empresa) values (501, 'Marcos Santos',
'msantos@oncln.com', '#Tortalaranja123', 2001);

-- Tabela Building - Prédio
insert into Predio (id_predio, nome, fk_empresa) values (250, 'Centro Empresarial', 2000);
insert into Predio (id_predio, nome, fk_empresa) values (251, 'Digital Building', 2001);


-- Tabela Address - Endereco
insert into Endereco (logradouro, numero, bairro, cidade, uf, fk_predio) values
('Rua Tiugibe Inoue', 251, 'Cidade dos Bandeirantes', 'São Paulo', 'SP', 250);

insert into Endereco (logradouro, numero, bairro, cidade, uf, fk_predio) values
('Rua Haddock Lobo', 595, 'Cerqueira César', 'São Paulo', 'SP', 251);

-- Tabela Room - Sala
insert into Sala (nome, andar, fk_predio) values ('Sala de reuniões', 2, 250);
insert into Sala (nome, andar, fk_predio) values ('Recursos Humanos', 4, 250);
insert into Sala (nome, andar, fk_predio) values ('A', 1, 251);
insert into Sala (nome, andar, fk_predio) values ('B', 1, 251);