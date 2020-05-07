use rpg2;

insert into tb_race(id,name,description,speed) values (1,"Anão","Criaturas pequenas, de boa índolenatural
possuem um coração muito grande, porém do tamanho de sua ganância.",5);

insert into tb_character_race_atribute_bonus(id,ability,bonus, race_id)
values(1,3,2,1);

ALTER TABLE tb_image_token
DROP FOREIGN KEY FK9kdb0br8ipdk62fx8oj0cglhn;

ALTER TABLE tb_image_token
DROP column creature_id;
