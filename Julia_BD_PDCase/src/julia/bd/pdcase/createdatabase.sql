/*
@author Júlia Gonzaga
*/

-- CREATE DATABASE PD Case;

DROP TABLE IF EXISTS person CASCADE;

CREATE TABLE person (
    id bigserial CONSTRAINT person_pkey PRIMARY KEY,
    nomePaciente text,
    sobrenomePaciente text,
    idPlanoDeSaude text,
    numeroCarteiraPlano integer,
    idEspecialidade text,
    birthday date
);