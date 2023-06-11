use osb;

-- Grados y cursos
insert into gradua values (1, 'Ingeniería Informática'), (2, 'Administración de Empresas');
insert into kurtsoa values (3, 'Infor 1', 1), (4, 'Infor 3', 1), (5, 'ADE 2', 2), (6, 'ADE 4', 2);

-- Roles
insert into role values (1, 1), (2, 2), (3, 0);

########################################      Admin      ########################################
insert into user value (77777777, 'Cristiano', 'Ronaldo', 'cronaldo@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 3);

########################################   Irakasleak   ########################################
insert into user values 
-- Profes infor
(45679130, 'Xabier', 'Artetxe', 'xartetxe@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(68032001, 'David', 'Pereira', 'dpereira@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(34205520, 'Ekaitz', 'Urzelai', 'eurzelai@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(67108894, 'Ander', 'Bruschi', 'abruchi@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(97248841, 'Peru', 'Jauregi', 'pjauregi@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(67217721, 'Telmo', 'Rubio', 'trubio@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(97430220, 'Andoni', 'Urrutia', 'aurrutia@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
-- Profes ADE
(91308476, 'Gaizka', 'Saenz', 'gsaenz@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(10007970, 'Eñaut', 'Genua', 'egenua@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(54672210, 'Gorka', 'Fernandez', 'gfernandez@asb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(32186441, 'Martzel', 'Gutierrez', 'mgutierrez@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(65472210, 'Eider', 'Allan Poe', 'eallan@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2);

insert into irakaslea values
-- Profes info
(45679130, 45679130),
(68032001, 68032001),
(34205520, 34205520),
(67108894, 67108894),
(97248841, 97248841),
(67217721, 67217721),
(97430220, 97430220),
-- Profes ADE
(91308476, 91308476),
(10007970, 10007970),
(54672210, 54672210),
(32186441, 32186441),
(65472210, 65472210);

########################################   Ikasleak   ########################################
insert into user values 
-- Infor 1. curso
(45352838, 'Unai', 'Agirre', 'uagirre@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(39892610, 'Julen', 'Iturrospe', 'jiturrospe@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(10587663, 'Martin', 'Arza', 'marza@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(68155391, 'Carlos', 'Perez', 'cperez@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(10222304, 'Ander', 'Garcia', 'agarcia@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
-- Infor 3.curso
(29866122, 'Eneko', 'Zugazaga', 'ezugazaga@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(39265610, 'Maddi', 'Arregi', 'marregi@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(68291001, 'Jonathan', 'Flores', 'jfroles@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(90021866, 'Aitor', 'Gonzalez', 'agonzalez@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
-- ADE 2. curso
(56789540, 'Ainhoa', 'Murgia', 'amurgia@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(13407900, 'Asier', 'Berreteaga', 'aberreteaga@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(49753200, 'Aimar', 'Erostarbe', 'aerostarbe@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(79242270, 'Begoña', 'Erasti', 'berasti@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
-- ADE 4. curso
(13765234, 'Unai', 'Dieguez', 'udieguez@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(13277745, 'Diogo', 'Sousa', 'dsousa@osb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2),
(98753200, 'Nikolas', 'Beitia', 'nbeitia@asb.com', '$2a$10$679zXBIfsAIRtjsMi06KJOc96FybtlWevw98U7OB9cHMuQGcPtccu', "2023-05-10 15:30:45", 2);

-- ikasleak
insert into ikaslea values 
-- Infor 1. curso
(45352838, 1, 3, 45352838),
(39892610, 1, 3, 39892610),
(10587663, 1, 3, 10587663),
(68155391, 1, 3, 68155391),
(10222304, 1, 3, 10222304),
-- Infor 3.curso
(29866122, 1, 4, 29866122),
(39265610, 1, 4, 39265610),
(68291001, 1, 4, 68291001),
(90021866, 1, 4, 90021866),
-- ADE 2. curso
(56789540, 2, 5, 56789540),
(13407900, 2, 5, 13407900),
(49753200, 2, 5, 49753200),
(79242270, 2, 5, 79242270),
-- ADE 4. curso
(13765234, 2, 6, 13765234),
(13277745, 2, 6, 13277745),
(98753200, 2, 6, 98753200);

#################################################################################################
-- Infor 1. curso
insert into ikasgaia values 
(11, 'Matemática', 3, 45679130), (12, 'Física', 3, 68032001), (13, 'Programación', 3, 34205520), 
(14, 'Programacion II', 3, 34205520), (15, 'Redes de Comunicación', 3, 67108894), (16, 'Programacion III', 3, 97248841), 
(17, 'Sistemas Operativos', 3, 67217721), (18, 'Desarrollo Web', 3, 67217721), (19, 'Matemática II', 3, 45679130);

-- Infor 3.curso
insert into ikasgaia values (20, 'Inteligencia Artificial', 4, 67217721), (21, 'Redes de Comunicación II', 4, 97430220), 
(22, 'Microcontroladores', 4, 68032001), (23, 'Computación', 4, 97430220), (24, 'Desarrollo Web II', 4, 97248841), 
(25, 'Seguridad Web', 4, 97248841), (26, 'Hacking Ético', 4, 97430220), (27, 'Base de Datos', 4, 34205520);

-- ADE 2. curso
insert into ikasgaia values (28, 'Derecho de la Empresa', 5, 91308476), (29, 'Finanzas', 5, 91308476), 
(30, 'Microeconomía', 5, 10007970), (31, 'Contabilidad', 5,65472210), (32, 'Estadística', 5, 65472210), 
(33, 'Microeconomía II', 5, 10007970), (34, 'Economía Mundial', 5, 32186441), (35, 'Matemáticas Financieras', 5, 10007970);

-- ADE 4. curso
insert into ikasgaia values (36, 'Dirección Financiera', 6, 91308476), (37, 'Banca y Bolsa', 6, 32186441), 
(38, 'Gestión de Comercio Exterior', 6, 32186441), (39, 'Marketing', 6, 10007970), (40, 'Logística', 6, 54672210), 
(41, 'Servicios Industriales', 6, 54672210), (42, 'Análisis de Riesgo Financiero', 6, 10007970);

-- Los temas de cada asignaturaedukia
insert into gaia values 
(43, 'Lehenengo Gaia', 11), (44, 'Bigarren Gaia', 11), (45, 'Hirugarren Gaia', 11),
(46, 'Lehenengo Gaia', 12), (47, 'Bigarren Gaia', 12), (48, 'Hirugarren Gaia', 12),
(49, 'Lehenengo Gaia', 13), (50, 'Bigarren Gaia', 13), (51, 'Hirugarren Gaia', 13),
(52, 'Lehenengo Gaia', 14), (53, 'Bigarren Gaia', 14), (54, 'Hirugarren Gaia', 14),
(55, 'Lehenengo Gaia', 15), (56, 'Bigarren Gaia', 15), (57, 'Hirugarren Gaia', 15),
(58, 'Lehenengo Gaia', 16), (59, 'Bigarren Gaia', 16), (60, 'Hirugarren Gaia', 16),
(61, 'Lehenengo Gaia', 17), (62, 'Bigarren Gaia', 17), (63, 'Hirugarren Gaia', 17),
(64, 'Lehenengo Gaia', 18), (65, 'Bigarren Gaia', 18), (66, 'Hirugarren Gaia', 18),
(67, 'Lehenengo Gaia', 19), (68, 'Bigarren Gaia', 19), (69, 'Hirugarren Gaia', 19),
(70, 'Lehenengo Gaia', 20), (71, 'Bigarren Gaia', 20), (138, 'Hirugarren Gaia', 20),
(72, 'Lehenengo Gaia', 21), (73, 'Bigarren Gaia', 21), (74, 'Hirugarren Gaia', 21),
(75, 'Lehenengo Gaia', 22), (76, 'Bigarren Gaia', 22), (77, 'Hirugarren Gaia', 22),
(78, 'Lehenengo Gaia', 23), (79, 'Bigarren Gaia', 23), (80, 'Hirugarren Gaia', 23),
(81, 'Lehenengo Gaia', 24), (82, 'Bigarren Gaia', 24), (83, 'Hirugarren Gaia', 24),
(84, 'Lehenengo Gaia', 25), (85, 'Bigarren Gaia', 25), (86, 'Hirugarren Gaia', 25),
(87, 'Lehenengo Gaia', 26), (88, 'Bigarren Gaia', 26), (89, 'Hirugarren Gaia', 26),
(90, 'Lehenengo Gaia', 27), (91, 'Bigarren Gaia', 27), (92, 'Hirugarren Gaia', 27),
(93, 'Lehenengo Gaia', 28), (94, 'Bigarren Gaia', 28), (95, 'Hirugarren Gaia', 28),
(96, 'Lehenengo Gaia', 29), (97, 'Bigarren Gaia', 29), (98, 'Hirugarren Gaia', 29),
(99, 'Lehenengo Gaia', 30), (100, 'Bigarren Gaia', 30), (101, 'Hirugarren Gaia', 30),
(102, 'Lehenengo Gaia', 31), (103, 'Bigarren Gaia', 31), (104, 'Hirugarren Gaia', 31),
(105, 'Lehenengo Gaia', 32), (106, 'Bigarren Gaia', 32), (107, 'Hirugarren Gaia', 32),
(108, 'Lehenengo Gaia', 33), (109, 'Bigarren Gaia', 33), (110, 'Hirugarren Gaia', 33),
(111, 'Lehenengo Gaia', 34), (112, 'Bigarren Gaia', 34), (113, 'Hirugarren Gaia', 34),
(114, 'Lehenengo Gaia', 35), (115, 'Bigarren Gaia', 35), (116, 'Hirugarren Gaia', 35),
(117, 'Lehenengo Gaia', 36), (118, 'Bigarren Gaia', 36), (119, 'Hirugarren Gaia', 36),
(120, 'Lehenengo Gaia', 37), (121, 'Bigarren Gaia', 37), (122, 'Hirugarren Gaia', 37),
(123, 'Lehenengo Gaia', 38), (124, 'Bigarren Gaia', 38), (125, 'Hirugarren Gaia', 38),
(126, 'Lehenengo Gaia', 39), (127, 'Bigarren Gaia', 39), (128, 'Hirugarren Gaia', 39),
(129, 'Lehenengo Gaia', 40), (130, 'Bigarren Gaia', 40), (131, 'Hirugarren Gaia', 40),
(132, 'Lehenengo Gaia', 41), (133, 'Bigarren Gaia', 41), (134, 'Hirugarren Gaia', 41),
(135, 'Lehenengo Gaia', 42), (136, 'Bigarren Gaia', 42), (137, 'Hirugarren Gaia', 42);

-- Artxiboak
-- insert into artxiboa values (550, load_file("C:\Users\diosg\Downloads\1_Enunciado_DDL_DML.pdf"), 46, 500);

-- Examenes
insert into azterketa values 
(139, 'Azterketa 1', 11), (140, 'Azterketa 2', 11), (141, 'Azterketa 3', 11), (142, 'Azterketa 4', 11), 
(143, 'Azterketa 5', 11), (144, 'Azterketa 6', 11), (145, 'Azterketa 7', 11), (146, 'Azterketa 8', 11),
(147, 'Azterketa 9', 12), (170, 'Azterketa 10', 12), (148, 'Azterketa 11', 12), (149, 'Azterketa 12', 12),
(150, 'Azterketa 13', 12), (151, 'Azterketa 14', 12), (152, 'Azterketa 15', 12), (153, 'Azterketa 16', 12),
(154, 'Azterketa 17', 13), (155, 'Azterketa 18', 13), (156, 'Azterketa 19', 13), (157, 'Azterketa 20', 13),
(158, 'Azterketa 21', 13), (159, 'Azterketa 22', 13), (160, 'Azterketa 23', 13), (161, 'Azterketa 24', 13),
(162, 'Azterketa 25', 14), (163, 'Azterketa 26', 14), (164, 'Azterketa 27', 14), (165, 'Azterketa 28', 14),
(166, 'Azterketa 29', 14), (167, 'Azterketa 30', 14), (168, 'Azterketa 31', 14), (169, 'Azterketa 32', 14);

-- Apuntes
insert into apuntea values 
(500, 'Apunteak 1', 56789540, 28), (501, 'Apunteak 2', 13277745, 42), (502, 'Apunteak 3', 13277745, 42),
(503, 'Apunteak 4', 56789540, 28), (504, 'Apunteak 5', 13277745, 42), (505, 'Apunteak 6', 13277745, 42);

-- Erlazio Taulak
insert into ikasgaia_ikaslea values 
-- infor 1
(11, 45352838), (11, 39892610), (11, 10587663), (11, 68155391), (11, 10222304),
(12, 45352838), (12, 39892610), (12, 10587663), (12, 68155391), (12, 10222304),
(13, 45352838), (13, 39892610), (13, 10587663), (13, 68155391), (13, 10222304),
(14, 45352838), (14, 39892610), (14, 10587663), (14, 68155391), (14, 10222304),
(15, 45352838), (15, 39892610), (15, 10587663), (15, 68155391), (15, 10222304),
(16, 45352838), (16, 39892610), (16, 10587663), (16, 68155391), (16, 10222304),
(17, 45352838), (17, 39892610), (17, 10587663), (17, 68155391), (17, 10222304),
(18, 45352838), (18, 39892610), (18, 10587663), (18, 68155391), (18, 10222304),
(19, 45352838), (19, 39892610), (19, 10587663), (19, 68155391), (19, 10222304),
-- infor 3
(20, 29866122), (20, 39265610), (20, 68291001), (20, 90021866),
(21, 29866122), (21, 39265610), (21, 68291001), (21, 90021866),
(22, 29866122), (22, 39265610), (22, 68291001), (22, 90021866),
(23, 29866122), (23, 39265610), (23, 68291001), (23, 90021866),
(24, 29866122), (24, 39265610), (24, 68291001), (24, 90021866),
(25, 29866122), (25, 39265610), (25, 68291001), (25, 90021866),
(26, 29866122), (26, 39265610), (26, 68291001), (26, 90021866),
(27, 29866122), (27, 39265610), (27, 68291001), (27, 90021866),
-- ade 2
(28, 56789540), (28, 13407900), (28, 49753200), (28, 79242270),
(29, 56789540), (29, 13407900), (29, 49753200), (29, 79242270),
(30, 56789540), (30, 13407900), (30, 49753200), (30, 79242270),
(31, 56789540), (31, 13407900), (31, 49753200), (31, 79242270),
(32, 56789540), (32, 13407900), (32, 49753200), (32, 79242270),
(33, 56789540), (33, 13407900), (33, 49753200), (33, 79242270),
(34, 56789540), (34, 13407900), (34, 49753200), (34, 79242270),
(35, 56789540), (35, 13407900), (35, 49753200), (35, 79242270),
-- ade 4
(36, 13765234), (36, 13277745), (36, 98753200),
(37, 13765234), (37, 13277745), (37, 98753200),
(38, 13765234), (38, 13277745), (38, 98753200),
(39, 13765234), (39, 13277745), (39, 98753200),
(40, 13765234), (40, 13277745), (40, 98753200),
(41, 13765234), (41, 13277745), (41, 98753200),
(42, 13765234), (42, 13277745), (42, 98753200);

insert into azterketa_ikaslea values
(29866122, 139, 7.4, null, null), (29866122, 140, 9.0, 'ondo', null), (29866122, 141, 1.9, null,5.2), (29866122, 142, 3.1,'ondo', 4.0), 
(29866122, 143, 5.4, null, null), (13407900, 144, 2.25, null, 3.2), (13407900, 145, 5.1, null, null), (13407900, 146, 4.82, null, null), 
(13407900, 147, 3.1, 'gaizki', 2.2), (13407900, 148, 2.4, null, 1.9);

insert into kurtsoa_ikaslea values 
(45352838, 3), (39892610, 3), (10587663, 3), (68155391, 3), (10222304, 3), 
(39892610, 4), (29866122, 4), (39265610, 4), (68291001, 4), (90021866, 4),
(56789540, 5), (13407900, 5), (49753200, 5), (79242270, 5),
(13765234, 6), (13277745, 6), (98753200, 6), (98753200, 5);