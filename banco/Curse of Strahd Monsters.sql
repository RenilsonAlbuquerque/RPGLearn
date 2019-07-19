SELECT * FROM rpg.tb_monster_race;
use rpg;




insert into tb_creature(id) values(1);
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
