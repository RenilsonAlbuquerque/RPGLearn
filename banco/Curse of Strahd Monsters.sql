SELECT * FROM rpg.tb_monster_race;
use rpg;

#-----------------------Deva----------------------------------

insert into tb_creature(id,image_path) values(2,"https://vignette.wikia.nocookie.net/forgottenrealms/images/1/12/Deva-5e.jpg/revision/latest?cb=20161119153420");
insert into tb_monster(creature_id,race_id,armor_class,challenge_level_id,base_life_dice) values (2,2,17,12,136);

#Idiomas
insert into mtm_creature_language(creature_id,language_id) values (2,1);

#atributes
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(2,1,18,false,4);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(2,2,18,false,4);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(2,3,18,true,4);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(2,4,17,false,3);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(2,5,20,true,5);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(2,6,20,true,5);

#resistence
insert into mtm_creature_resistence(creature_id,damage_type_id,type) values (2,1,0);
insert into mtm_creature_resistence(creature_id,damage_type_id,type) values (2,7,0);
insert into mtm_creature_resistence(creature_id,damage_type_id,type) values (2,10,0);

#features
insert into tb_monster_features(id,name,description,monster_id) values (4,"Armas Angelicais"," Os ataques armados do deva são mágicos.
Quando o deva atinge com qualquer arma, a arma causa 4d8
de dano radiante (incluso no ataque) extra",2);

insert into tb_monster_features(id,name,description,monster_id) values (5,"Conjuração Inata"," A habilidade de conjuração de um deva é
Carisma (CD de resistência de magia 17). O deva pode conjurar,
inatamente, as seguintes magias, necessitando apenas de
componentes verbais:À vontade: detectar bem e mal
1/dia cada: comunhão, reviver os mortos",2);
insert into tb_monster_features(id,name,description,monster_id) values (6,"Resistência à Magia.","O deva possui vantagem nos testes
de resistência contra magias e outros efeitos mágicos.",2);

insert into tb_action(name,description,creature_id) values ("Maça."," Ataque Corpo-a-Corpo com Arma: +8 para atingir, alcance
1,5 m, um alvo. Acerto: 7 (1d6 + 4) de dano de concussão mais
18 (4d8) de dano radiante.",1);

insert into tb_attack(action_id) values (1);
insert into mtm_attack_dice(attack_id,dice_id,quantity,bonus_damage,damage_type_id) values (1,2,4,7,12);
insert into mtm_attack_dice(attack_id,dice_id,quantity,bonus_damage,damage_type_id) values (1,3,5,0,11);
#--------------------------------Planetário-------------------------------


insert into tb_creature(id,image_path) values(1,"https://www.tribality.com/wp-content/uploads/2016/12/planetar.png");
insert into tb_monster(creature_id,race_id,armor_class,challenge_level_id,base_life_dice) values (1,1,19,18,200);

#Idiomas
insert into mtm_creature_language(creature_id,language_id) values (1,1);

#atributes
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(1,1,24,false,7);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(1,2,20,false,5);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(1,3,24,true,7);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(1,4,19,false,4);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(1,5,22,true,6);
insert into mtm_creature_atribute(creature_id,atribute_id,value,proeficiency,modfier) values(1,6,25,true,7);

#resistence
insert into mtm_creature_resistence(creature_id,damage_type_id,type) values (1,2,0);
insert into mtm_creature_resistence(creature_id,damage_type_id,type) values (1,8,0);
insert into mtm_creature_resistence(creature_id,damage_type_id,type) values (1,11,0);

#features
insert into tb_monster_features(id,name,description,monster_id) values (1,"Armas Angelicais"," Os ataques armados do planetário são mágicos.
Quando o planetário atinge com qualquer arma, a arma causa 5d8
de dano radiante (incluso no ataque) extra",1);

insert into tb_monster_features(id,name,description,monster_id) values (2,"Consciência Divina"," O planetário sabe quando ouve uma mentira.",1);
insert into tb_monster_features(id,name,description,monster_id) values (3,"Resistência à Magia.","O planetário possui vantagem nos testes
de resistência contra magias e outros efeitos mágicos.",1);

insert into tb_action(id,name,description,creature_id) values (1,"Espada Grande"," Ataque Corpo-a-Corpo com Arma: +12 para
atingir, alcance 1,5 m, um alvo. Acerto: 21 (4d6 + 7) de dano
cortante mais 22 (5d8) de dano radiante.",1);

insert into tb_attack(action_id) values (1);
insert into mtm_attack_dice(attack_id,dice_id,quantity,bonus_damage,damage_type_id) values (1,2,4,7,12);
insert into mtm_attack_dice(attack_id,dice_id,quantity,bonus_damage,damage_type_id) values (1,3,5,0,11);

#---------------------------------------------