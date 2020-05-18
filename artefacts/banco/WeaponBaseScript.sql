insert into tb_weapon_classification(id,name) values (1,"Simples");
insert into tb_weapon_classification(id,name) values (2,"Marcial");

insert into tb_weapon_range(id,name) values (1,"Corpo-a-corpo");
insert into tb_weapon_range(id,name) values (2,"à Distância");

insert into tb_cost(id,quantity,coin_id) value (1,2,2);
insert into tb_weapon(id,image_path, weight,classification_id,cost_id,range_id,rarity_id)
	values (1,'https://vignette.wikia.nocookie.net/dnd4/images/8/83/P201H.jpg/revision/latest/scale-to-width-down/200?cb=20150119125601',
	0.5,1,1,1,1);
insert into mtm_weapon_dice (dice_id,weapon_id,quantity,bonus,damage_type_id) value (1,1,1,0,8);
