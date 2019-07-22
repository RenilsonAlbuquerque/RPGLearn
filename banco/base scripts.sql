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


