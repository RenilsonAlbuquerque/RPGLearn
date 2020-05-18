use rpg2;

/*################## Anão #########################################################*/
insert into tb_race(id,name,description,speed,size_description,language_description,alignment_description,age_description
,size_id) values (1,"Anão","Criaturas pequenas, de boa índolenatural
possuem um coração muito grande, porém do tamanho de sua ganância.",5," Anões estão entre 1,20 e 1,50 metro de
altura e pesam cerca de 75 kg. Seu tamanho é Médio.",
"Você pode falar, ler e escrever Comum e
Anão. O idioma Anão é repleto de consoantes duras e sons
guturais, e essa característica influencia, como um
sotaque, qualquer outro idioma que o anão falar.",
"A maioria dos anões é leal, pois acreditam
firmemente nos benefícios de uma sociedade bem
organizada. Eles tendem para o bem, com um forte senso
de honestidade e uma crença de que todos merecem
compartilhar os benefícios de uma ordem social justa.",
" Anões tornam-se maduros na mesma
proporção que os humanos, mas são considerados jovens
até atingirem a idade de 50 anos. Em média, eles vivem
350 anos.",3);

insert into tb_character_race_atribute_bonus(id,atribute_id,bonus, race_id)
values(1,3,2,1);

insert into mtm_race__equipment_category(race_id,equipment_category_id) values (1,1);
insert into mtm_race__equipment_category(race_id,equipment_category_id) values (1,2);
insert into mtm_race__equipment_category(race_id,equipment_category_id) values (1,4);
insert into mtm_race__equipment_category(race_id,equipment_category_id) values (1,5);

insert into tb_race_starting_proeficiency_choice(id,choose,race_id) values (1,1,1);
insert into mtm_race_starting_proeficiency_choice(starting_proeficiency_id,equipment_category_id) values (1,13);

insert into mtm_race_language(race_id,language_id) values (1,1);
insert into mtm_race_language(race_id,language_id) values (1,2);

insert into tb_trait(id,name,description) values (1,"Visão no Escuro","Acostumado à vida subterrânea,
você tem uma visão superior no escuro e na penumbra.
Você enxerga na penumbra a até 18 metros como se fosse
luz plena, e no escuro como se fosse na penumbra. Você
não pode discernir cores no escuro, apenas tons de cinza");
insert into mtm_race_trait(race_id,trait_id) values (1,1);

insert into tb_trait(id,name,description) values (2,"Resiliência Anã"," Você possui vantagem em testes de
resistência contra venenos e resistência contra dano de
veneno");
insert into mtm_race_trait(race_id,trait_id) values (1,2);

insert into tb_trait(id,name,description) values (3,"Especialização em Rochas","Sempre que você
realizar um teste de Inteligência (História) relacionado à
origem de um trabalho em pedra, você é considerado
proficiente na perícia História e adiciona o dobro do seu
bônus de proficiência ao teste, ao invés do seu bônus de
proficiência normal.");
insert into mtm_race_trait(race_id,trait_id) values (1,3);

insert into tb_trait(id,name,description) values (4,"Treinamento Anão em Combate","Você tem
proficiência com machados de batalha, machadinhas,
martelos leves e martelos de guerra.");
insert into mtm_race_trait(race_id,trait_id) values (1,4);


insert into tb_sub_race(id,name,description,race_id) values(1,"Anão da colina","Como um anão da colina, você tem sentidos aguçados,
maior intuição e notável resiliência. Os anões dourados de
Faerûn, que vivem em seu poderoso reino ao sul do
continente, são anões da colina, assim como os exilados
Neidar e os depreciáveis Klar de Krynn, no cenário de
Dragonlance",1);
insert into tb_character_subrace_atribute_bonus(id,bonus,atribute_id,sub_race_id)
values(1,1,5,1);
insert into tb_trait(id,name,description) values (5,"Tenacidade Anã.","Seu máximo de pontos de vida
aumentam em 1, e cada vez que o anão da colina sobe um
nível, ele recebe 1 ponto de vida adicional.");
insert into mtm_sub_race_trait(sub_race_id,trait_id) values (1,5);



insert into tb_sub_race(id,name,description,race_id) values(2,"Anão da montanha","Como um anão da montanha, você é forte e resistente,
acostumados a uma vida difícil em terrenos difíceis. Você,
provavelmente tem a descendência daqueles mais altos
(para um anão) e tende a possuir uma coloração mais
clara. Os anões do escudo do norte de Faerûn, bem como o
clã governante Hylar e os clãs nobres Daewar de
Dragonlance, são anões da montanha.",1);
insert into tb_character_subrace_atribute_bonus(id,bonus,atribute_id,sub_race_id)
values(2,2,1,2);
insert into tb_trait(id,name,description) values (6,"Treinamento Anão com Armaduras. ","Você adquire
proficiência em armaduras leves e médias.");
insert into mtm_sub_race_trait(sub_race_id,trait_id) values (2,6);

/*
ALTER TABLE tb_image_token
DROP FOREIGN KEY FK9kdb0br8ipdk62fx8oj0cglhn;

ALTER TABLE tb_image_token
DROP column creature_id;

ALTER TABLE tb_race
DROP column age;
*/

