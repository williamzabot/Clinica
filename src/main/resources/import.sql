insert into tb_specialties (name, description) VALUES ('Oftalmologia', 'Especialidade médica relacionada a visão')
insert into tb_specialties (name, description) VALUES ('Endrocrinologia', 'Especialidade médica relacionado aos hormônios e metabolismo')

INSERT INTO tb_doctors (name, email, crm, via_health_insurance, specialty_id) VALUES ('Fábio Knost', 'fknost@gmail.com', 'CRM 21458 RS', true, 1);
INSERT INTO tb_doctors (name, email, crm, via_health_insurance, specialty_id) VALUES ('Beatriz Pacheco', 'biapacheco@gmail.com', 'CRM 11254 RS', true, 2);
INSERT INTO tb_doctors (name, email, crm, via_health_insurance, specialty_id) VALUES ('Silvia Botelho', 'drasilviabotelho@gmail.com', 'CRM 16225 RS', false, 2);
INSERT INTO tb_doctors (name, email, crm, via_health_insurance, specialty_id) VALUES ('Flavio Moreira', 'drmoreira@gmail.com', 'CRM 12232 RS', false, 1);