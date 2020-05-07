use rpg2;

/*##################### classifications ###################*/

insert into tb_equipament_category(id,name) values (1,"Machado de guerra");
insert into tb_weapon_category(id) values (1);
insert into tb_equipament_category(id,name) values (2,"Machadinha");
insert into tb_weapon_category(id) values (2);
insert into tb_equipament_category(id,name) values (3,"Martelo de Arremesso");
insert into tb_weapon_category(id) values (3);
insert into tb_equipament_category(id,name) values (4,"Martelo de guerra");
insert into tb_weapon_category(id) values (4);
insert into tb_equipament_category(id,name) values (5,"Espada longa");
insert into tb_weapon_category(id) values (5);
insert into tb_equipament_category(id,name) values (6,"Espada curta");
insert into tb_weapon_category(id) values (6);
insert into tb_equipament_category(id,name) values (7,"Arco longo");
insert into tb_weapon_category(id) values (7);
insert into tb_equipament_category(id,name) values (8,"Arco curto");
insert into tb_weapon_category(id) values (8);
insert into tb_equipament_category(id,name) values (9,"Sabre");
insert into tb_weapon_category(id) values (9);
insert into tb_equipament_category(id,name) values (10,"Besta de mão");
insert into tb_weapon_category(id) values (10);
insert into tb_equipament_category(id,name) values (11,"Faca");
insert into tb_weapon_category(id) values (11);


insert into tb_weapon_classification(id,name) values (1,"Simples");
insert into tb_weapon_classification(id,name) values (2,"Marcial");

insert into tb_weapon_range(id,name) values (1,"Corpo-a-corpo");
insert into tb_weapon_range(id,name) values (2,"à Distância");


/*##################### Weapon ###########################*/
insert into tb_cost(id,quantity,coin_id) value (1,2,2);
insert into tb_equipament(id,image_path,name,description,weight,cost_id,rarity_id)
values (1,'https://vignette.wikia.nocookie.net/dnd4/images/8/83/P201H.jpg/revision/latest/scale-to-width-down/200?cb=20150119125601',
'adaga','Agada simples e comum, pode ser de qualquer metal',0.5,1,1);
insert into tb_weapon(id,category_id,classification_id,range_id)
	values (1,11,1,1);