drop database rpg;
create database rpg;
use rpg;

insert into tb_dice(id,value) values (1,0);
insert into tb_dice(id,value) values (2,1);
insert into tb_dice(id,value) values (3,2);
insert into tb_dice(id,value) values (4,3);
insert into tb_dice(id,value) values (5,4);
insert into tb_dice(id,value) values (6,5);

insert into tb_atribute(id,value) values (1,0);
insert into tb_atribute(id,value) values (2,1);
insert into tb_atribute(id,value) values (3,2);
insert into tb_atribute(id,value) values (4,3);
insert into tb_atribute(id,value) values (5,4);
insert into tb_atribute(id,value) values (6,5);

insert into tb_damage_type(id,value) values (1,0);
insert into tb_damage_type(id,value) values (2,1);
insert into tb_damage_type(id,value) values (3,2);
insert into tb_damage_type(id,value) values (4,3);
insert into tb_damage_type(id,value) values (5,4);
insert into tb_damage_type(id,value) values (6,5);
insert into tb_damage_type(id,value) values (7,6);
insert into tb_damage_type(id,value) values (8,7);
insert into tb_damage_type(id,value) values (9,8);
insert into tb_damage_type(id,value) values (10,9);
insert into tb_damage_type(id,value) values (11,10);
insert into tb_damage_type(id,value) values (12,11);
insert into tb_damage_type(id,value) values (13,12);

insert into tb_language(id,name)values(1,"Todos");
insert into tb_language(id,name)values(2,"Comum");
insert into tb_language(id,name)values(3,"Élfico");
insert into tb_language(id,name)values(4,"Anão");
insert into tb_language(id,name)values(5,"Dracônico");
insert into tb_language(id,name)values(6,"Celestial");
insert into tb_language(id,name)values(7,"Infernal");
insert into tb_language(id,name)values(8,"Druida");

insert into tb_monster_challenge_level(id,value,experience_points) values (1,0.5,100);
insert into tb_monster_challenge_level(id,value,experience_points) values (2,0.25,50);
insert into tb_monster_challenge_level(id,value,experience_points) values (3,0.125,25);
insert into tb_monster_challenge_level(id,value,experience_points) values (4,2,450);
insert into tb_monster_challenge_level(id,value,experience_points) values (5,3,700);
insert into tb_monster_challenge_level(id,value,experience_points) values (6,4,1100);
insert into tb_monster_challenge_level(id,value,experience_points) values (7,5,1800);
insert into tb_monster_challenge_level(id,value,experience_points) values (8,6,2300);
insert into tb_monster_challenge_level(id,value,experience_points) values (9,7,2900);
insert into tb_monster_challenge_level(id,value,experience_points) values (10,8,3900);
insert into tb_monster_challenge_level(id,value,experience_points) values (11,9,5000);
insert into tb_monster_challenge_level(id,value,experience_points) values (12,10,5900);
insert into tb_monster_challenge_level(id,value,experience_points) values (13,11,7200);
insert into tb_monster_challenge_level(id,value,experience_points) values (14,12,8400);
insert into tb_monster_challenge_level(id,value,experience_points) values (15,13,10000);
insert into tb_monster_challenge_level(id,value,experience_points) values (16,14,11500);
insert into tb_monster_challenge_level(id,value,experience_points) values (17,15,13000);
insert into tb_monster_challenge_level(id,value,experience_points) values (18,16,15000);
insert into tb_monster_challenge_level(id,value,experience_points) values (19,17,18000);
insert into tb_monster_challenge_level(id,value,experience_points) values (20,18,20000);
insert into tb_monster_challenge_level(id,value,experience_points) values (21,19,22000);
insert into tb_monster_challenge_level(id,value,experience_points) values (22,20,25000);
insert into tb_monster_challenge_level(id,value,experience_points) values (23,21,27500);
insert into tb_monster_challenge_level(id,value,experience_points) values (24,22,30000);
insert into tb_monster_challenge_level(id,value,experience_points) values (25,23,32500);
insert into tb_monster_challenge_level(id,value,experience_points) values (26,24,36000);
insert into tb_monster_challenge_level(id,value,experience_points) values (27,25,50000);
insert into tb_monster_challenge_level(id,value,experience_points) values (28,26,90000);
insert into tb_monster_challenge_level(id,value,experience_points) values (29,30,155000);

insert into tb_monster_size(id,name,description) values (1,"Miúdo","0,75 m/0,75 m");
insert into tb_monster_size(id,name,description) values (2,"Pequeno","1,5 m/1,5 m");
insert into tb_monster_size(id,name,description) values (3,"Médio","1,5 m/1,5 m");
insert into tb_monster_size(id,name,description) values (4,"Grande","3 m/3 m");
insert into tb_monster_size(id,name,description) values (5,"Enorme","4,5 m/4,5 m");
insert into tb_monster_size(id,name,description) values (6,"Imenso","6 m/6 m ou maior");

insert into tb_alignment(id,name,description) values(1,"Leal e Bom", "é a tendência de criaturas que se pode contar para fazer o que é correto como é esperadopela sociedade. Dragões dourados, paladinos e muitos anões são leais e bons");
insert into tb_alignment(id,name,description) values(2,"Neutro e Bom", " é a tendência do povo que faz o melhor que pode para ajudar outros de acordo com suas necessidades. Muitos celestiais, alguns gigantes das nuvens, e grande parte dos gnomos são neutros e bons.");
insert into tb_alignment(id,name,description) values(3,"Caótico e Bom", " é a tendência de criaturas que agem de acordo com sua própria consciência, se importando pouco com as expectativas dos outros. Dragões de cobre, muitos elfos e unicórnios são caóticos e bons.");
insert into tb_alignment(id,name,description) values(4,"Leal e Neutro", " é a tendência dos indivíduos que agem de acordo com as leis, tradições ou códigos pessoais. Muitos monges e alguns magos são leais e neutros");
insert into tb_alignment(id,name,description) values(5,"Neutro", "  é a tendência daqueles que preferem manter distância de questões morais e não tomar partido, fazendo o que aparenta ser melhor conforme a situação. ");
insert into tb_alignment(id,name,description) values(6,"Caótico e Neutro", " é a tendência das criaturas que seguem seus caprichos, mantendo sua liberdade pessoal acima de tudo. Muitos bárbaros e ladinos, e alguns bardos, são caóticos e neutros");
insert into tb_alignment(id,name,description) values(7,"Leal e Mau", " é a tendência das criaturas que conseguem metodicamente tudo o que querem, dentro dos limites de uma tradição, lei ou ordem. Diabos, dragões azuis e hobgoblins são leais e maus");
insert into tb_alignment(id,name,description) values(8,"Neutro e Mau", "  é a tendência daqueles que farão tudo o que quiserem, sem compaixão ou remorso. Muitos drow, alguns gigantes das nuvens e yugoloths são neutros e maus.");
insert into tb_alignment(id,name,description) values(9,"Caótico e Mau", "  é a tendência de criaturas que agem com violência arbitrária, estimulada por sua ganância, ódio ou sede de sangue. Demônios, dragões vermelhos e orcs são caóticos e maus.");

