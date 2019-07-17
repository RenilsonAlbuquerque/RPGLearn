SELECT * FROM rpg.tb_monster_race;
use rpg;
insert into tb_monster_race (id, name,description) values (1,"PLANETÁRIO","Os planetários agem como as armas dos deuses que
servem, apresentando uma representação tangível da
força de suas divindades. Um planetário pode evocar
chuva para aliviar uma seca ou pode liberar uma praga
de insetos para devorar colheitas. Os ouvidos celestiais de
um planetário detectam cada falsidade e seus olhos
radiantes veem através de toda enganação.
Planetários são musculosos, carecas e possuem uma
pele num tom verde opalescente e asas plumadas
brancas. Eles são bem mais altos que a maioria dos
humanoides, brandindo imensas espadas graciosamente.
Às vezes, enviados para ajudar mortais poderosos em
tarefas importantes do bem, os planetários gostam
especialmente das missões que envolvam combater
corruptores.");



insert into tb_creature(id) values(1);
insert into tb_monster(creature_id,race_id,armor_class,base_life_dice) values (1,1,19,200);

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


