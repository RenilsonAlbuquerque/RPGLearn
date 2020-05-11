use rpg2;

insert into tb_dice(id,value) values (1,0);
insert into tb_dice(id,value) values (2,1);
insert into tb_dice(id,value) values (3,2);
insert into tb_dice(id,value) values (4,3);
insert into tb_dice(id,value) values (5,4);
insert into tb_dice(id,value) values (6,5);

insert into tb_coin(id,name,abreviation,weight,cotation) values (1,"Peça de platina","PC",2.5,1);
insert into tb_coin(id,name,abreviation,weight,cotation) values (2,"Peça de ouro","PO",2.5,10);
insert into tb_coin(id,name,abreviation,weight,cotation) values (3,"Peça de electrum","PE",2.5,20);
insert into tb_coin(id,name,abreviation,weight,cotation) values (4,"Peça de prata","PP",2.5,100);
insert into tb_coin(id,name,abreviation,weight,cotation) values (5,"Peça de cobre","PC",2.5,1000);

insert into tb_rarity(id,name) values (1,"Comum");
insert into tb_rarity(id,name) values (2,"Incomum");
insert into tb_rarity(id,name) values (3,"Raro");
insert into tb_rarity(id,name) values (4,"Muito Raro");
insert into tb_rarity(id,name) values (5,"Lendário");


insert into tb_atribute(id,value,abbreviation) values (1,"Força","For");
insert into tb_atribute(id,value,abbreviation) values (2,"Destreza","Des");
insert into tb_atribute(id,value,abbreviation) values (3,"Constituição","Con");
insert into tb_atribute(id,value,abbreviation) values (4,"Inteligência","Int");
insert into tb_atribute(id,value,abbreviation) values (5,"Sabedoria","Sab");
insert into tb_atribute(id,value,abbreviation) values (6,"Carisma","Car");

insert into tb_damage_type(id,value) values (1,"Ácido");
insert into tb_damage_type(id,value) values (2,"Concussão");
insert into tb_damage_type(id,value) values (3,"Cortante");
insert into tb_damage_type(id,value) values (4,"Elétrico");
insert into tb_damage_type(id,value) values (5,"Energia");
insert into tb_damage_type(id,value) values (6,"Fogo");
insert into tb_damage_type(id,value) values (7,"Gelo");
insert into tb_damage_type(id,value) values (8,"Necrótico");
insert into tb_damage_type(id,value) values (9,"Perfurante");
insert into tb_damage_type(id,value) values (10,"Psíquico");
insert into tb_damage_type(id,value) values (11,"Radiante");
insert into tb_damage_type(id,value) values (12,"Trovejante");
insert into tb_damage_type(id,value) values (13,"Veneno");

insert into tb_proeficiency(id,name) values (1,"Acrobacia");
insert into tb_proeficiency(id,name) values (2,"Arcanismo");
insert into tb_proeficiency(id,name) values (3,"Atletismo");
insert into tb_proeficiency(id,name) values (4,"Atuação");
insert into tb_proeficiency(id,name) values (5,"Blefar");
insert into tb_proeficiency(id,name) values (6,"Furtividade");
insert into tb_proeficiency(id,name) values (7,"História");
insert into tb_proeficiency(id,name) values (8,"Intimidação");
insert into tb_proeficiency(id,name) values (9,"Intuição");
insert into tb_proeficiency(id,name) values (10,"Investigação");
insert into tb_proeficiency(id,name) values (11,"Lidar com animais");
insert into tb_proeficiency(id,name) values (12,"Medicina");
insert into tb_proeficiency(id,name) values (13,"Natureza");
insert into tb_proeficiency(id,name) values (14,"Percepção");
insert into tb_proeficiency(id,name) values (15,"Persuasão");
insert into tb_proeficiency(id,name) values (16,"Prestidigitação");
insert into tb_proeficiency(id,name) values (17,"Religião");
insert into tb_proeficiency(id,name) values (18,"Sobrevivência");


insert into tb_language(id,name)values(1,"Anão");
insert into tb_language(id,name)values(2,"Comum");
insert into tb_language(id,name)values(3,"Élfico");
insert into tb_language(id,name)values(4,"Gigante");
insert into tb_language(id,name)values(5,"Gnômico");
insert into tb_language(id,name)values(6,"Goblin");
insert into tb_language(id,name)values(7,"Halfling");
insert into tb_language(id,name)values(8,"Orc");
insert into tb_language(id,name)values(9,"Abissal");
insert into tb_language(id,name)values(10,"Celestial");
insert into tb_language(id,name)values(11,"Dialeto Subterrâneo");
insert into tb_language(id,name)values(12,"Dracônico");
insert into tb_language(id,name)values(13,"Infernal");
insert into tb_language(id,name)values(14,"Primordial");
insert into tb_language(id,name)values(15,"Silvestre");
insert into tb_language(id,name)values(16,"Subterrâneo");


insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (1,1,25,50,75,100);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (2,2,50,100,150,200);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (3,3,75,150,225,400);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (4,4,125,250,375,500);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (5,5,250,500,750,1100);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (6,6,300,600,900,1400);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (7,7,350,750,1100,1700);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (8,8,450,900,1400,2100);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (9,9,550,1100,1600,2400);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (10,10,600,1200,1900,2800);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (11,11,800,1500,2400,3600);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (12,12,1000,2000,3000,4500);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (13,13,1100,2200,3400,5100);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (14,14,1250,2500,3800,5700);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (15,15,1400,2800,4300,6500);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (16,16,1600,3200,4800,7200);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (17,17,2000,3900,5900,8800);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (18,18,2100,4200,6300,9500);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (19,19,2400,4900,7300,10900);
insert into tb_challange_dificult(id,level,easy, medium, hard, deadly) values (20,20,2800,5700,8500,12700);

insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (1,0.125,25,2);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (2,0.25,50,2);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (3,0.5,100,2);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (4,1,25,2);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (5,2,450,2);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (6,3,700,2);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (7,4,1100,2);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (8,5,1800,3);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (9,6,2300,3);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (10,7,2900,3);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (11,8,3900,3);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (12,9,5000,4);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (13,10,5900,4);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (14,11,7200,4);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (15,12,8400,4);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (16,13,10000,5);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (17,14,11500,5);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (18,15,13000,5);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (19,16,15000,5);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (20,17,18000,6);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (21,18,20000,6);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (22,19,22000,6);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (23,20,25000,6);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (24,21,33000,7);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (25,22,41000,7);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (26,23,50000,7);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (27,24,62000,7);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (28,25,75000,8);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (29,26,90000,8);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (30,27,105000,8);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (31,28,120000,8);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (32,29,135000,9);
insert into tb_creature_level(id,value,experience_points,proeficiency_bonus) values (33,30,155000,9);

insert into tb_creature_size(id,name,description) values (1,"Miúdo","0,75 m/0,75 m");
insert into tb_creature_size(id,name,description) values (2,"Pequeno","1,5 m/1,5 m");
insert into tb_creature_size(id,name,description) values (3,"Médio","1,5 m/1,5 m");
insert into tb_creature_size(id,name,description) values (4,"Grande","3 m/3 m");
insert into tb_creature_size(id,name,description) values (5,"Enorme","4,5 m/4,5 m");
insert into tb_creature_size(id,name,description) values (6,"Imenso","6 m/6 m ou maior");

insert into tb_alignment(id,name,description) values(1,"Leal e Bom", "é a tendência de criaturas que se pode contar para fazer o que é correto como é esperadopela sociedade. Dragões dourados, paladinos e muitos anões são leais e bons");
insert into tb_alignment(id,name,description) values(2,"Neutro e Bom", " é a tendência do povo que faz o melhor que pode para ajudar outros de acordo com suas necessidades. Muitos celestiais, alguns gigantes das nuvens, e grande parte dos gnomos são neutros e bons.");
insert into tb_alignment(id,name,description) values(3,"Caótico e Bom", " é a tendência de criaturas que agem de acordo com sua própria consciência, se importando pouco com as expectativas dos outros. Dragões de cobre, muitos elfos e unicórnios são caóticos e bons.");
insert into tb_alignment(id,name,description) values(4,"Leal e Neutro", " é a tendência dos indivíduos que agem de acordo com as leis, tradições ou códigos pessoais. Muitos monges e alguns magos são leais e neutros");
insert into tb_alignment(id,name,description) values(5,"Neutro", "  é a tendência daqueles que preferem manter distância de questões morais e não tomar partido, fazendo o que aparenta ser melhor conforme a situação. ");
insert into tb_alignment(id,name,description) values(6,"Caótico e Neutro", " é a tendência das criaturas que seguem seus caprichos, mantendo sua liberdade pessoal acima de tudo. Muitos bárbaros e ladinos, e alguns bardos, são caóticos e neutros");
insert into tb_alignment(id,name,description) values(7,"Leal e Mau", " é a tendência das criaturas que conseguem metodicamente tudo o que querem, dentro dos limites de uma tradição, lei ou ordem. Diabos, dragões azuis e hobgoblins são leais e maus");
insert into tb_alignment(id,name,description) values(8,"Neutro e Mau", "  é a tendência daqueles que farão tudo o que quiserem, sem compaixão ou remorso. Muitos drow, alguns gigantes das nuvens e yugoloths são neutros e maus.");
insert into tb_alignment(id,name,description) values(9,"Caótico e Mau", "  é a tendência de criaturas que agem com violência arbitrária, estimulada por sua ganância, ódio ou sede de sangue. Demônios, dragões vermelhos e orcs são caóticos e maus.");

