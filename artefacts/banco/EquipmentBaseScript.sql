use rpg2;

/*##################### classifications ###################*/

/*---------------------armas-------------------------------*/
insert into tb_equipament_category(id,name) values (1,"Machado de batalha");
insert into tb_weapon_category(id) values (1);
insert into tb_equipament_category(id,name) values (2,"Machadinha");
insert into tb_weapon_category(id) values (2);
insert into tb_equipament_category(id,name) values (3,"Martelo de Arremesso");
insert into tb_weapon_category(id) values (3);
insert into tb_equipament_category(id,name) values (4,"Martelo de leve");
insert into tb_weapon_category(id) values (4);
insert into tb_equipament_category(id,name) values (5,"Martelo de guerra");
insert into tb_weapon_category(id) values (5);
insert into tb_equipament_category(id,name) values (6,"Espada longa");
insert into tb_weapon_category(id) values (6);
insert into tb_equipament_category(id,name) values (7,"Espada curta");
insert into tb_weapon_category(id) values (7);
insert into tb_equipament_category(id,name) values (8,"Arco longo");
insert into tb_weapon_category(id) values (8);
insert into tb_equipament_category(id,name) values (9,"Arco curto");
insert into tb_weapon_category(id) values (9);
insert into tb_equipament_category(id,name) values (10,"Sabre");
insert into tb_weapon_category(id) values (10);
insert into tb_equipament_category(id,name) values (11,"Besta de mão");
insert into tb_weapon_category(id) values (11);
insert into tb_equipament_category(id,name) values (12,"Faca");
insert into tb_weapon_category(id) values (12);
/*---------------------Ferramentas------------------------*/
insert into tb_equipament_category(id,name) values (13,"Ferramentas de artesão");
insert into tb_tool_category(id) values (13);
insert into tb_equipament_category(id,name) values (14,"Ferramentas de navegação");
insert into tb_tool_category(id) values (14);
insert into tb_equipament_category(id,name) values (15,"Ferramentas de ladrão");
insert into tb_tool_category(id) values (15);
insert into tb_equipament_category(id,name) values (16,"Instrumento musical");
insert into tb_tool_category(id) values (16);
insert into tb_equipament_category(id,name) values (17,"Kit de disfarce");
insert into tb_tool_category(id) values (17);
insert into tb_equipament_category(id,name) values (18,"Kit de falsificação");
insert into tb_tool_category(id) values (18);
insert into tb_equipament_category(id,name) values (19,"Kit de herbalismo");
insert into tb_tool_category(id) values (19);
insert into tb_equipament_category(id,name) values (20,"Kit de jogo");
insert into tb_tool_category(id) values (20);
insert into tb_equipament_category(id,name) values (21,"Kit de venenos");
insert into tb_tool_category(id) values (21);


insert into tb_equipament_category(id,name) values (22,"Equipamento padrão");
insert into tb_adventure_gear_category(id) values (22);

insert into tb_weapon_classification(id,name) values (1,"Simples");
insert into tb_weapon_classification(id,name) values (2,"Marcial");

insert into tb_weapon_range(id,name) values (1,"Corpo-a-corpo");
insert into tb_weapon_range(id,name) values (2,"à Distância");


/*##################### Weapon ###########################*/
insert into tb_cost(id,quantity,coin_id) value (1,2,2);
insert into tb_equipament(id,image_path,name,description,weight,cost_id,rarity_id)
values (1,'https://vignette.wikia.nocookie.net/dnd4/images/8/83/P201H.jpg/revision/latest/scale-to-width-down/200?cb=20150119125601',
'adaga','Agada simples e comum, pode ser de qualquer metal',0.5,1,1);
insert into tb_weapon(bonus,id,category_id,classification_id,range_id) values (0,1,12,1,1,0);
insert into mtm_weapon_dice(weapon_id,dice_id,damage_type_id,bonus,quantity) values (1,1,9,0,1);


insert into tb_cost(id,quantity,coin_id) value (2,350000,2);
insert into tb_equipament(id,image_path,name,description,weight,cost_id,rarity_id)
values (2,'https://media-waterdeep.cursecdn.com/avatars/thumbnails/7/253/1000/1000/636284739956618526.jpeg',
'Vingadora sagrada','Um tipo raro de espada forjada para combater o mal em todas as suas formas, almejada por paladinos de todos os reinos
.Possui magnificos poderes que apenas se mostram nas mãos de um guerreiro benevolente',1.5,2,5);
insert into tb_weapon(bonus,id,category_id,classification_id,range_id) values (3,2,6,2,1);
insert into mtm_weapon_dice(weapon_id,dice_id,damage_type_id,bonus,quantity) values (2,3,11,0,1);
insert into mtm_weapon_dice(weapon_id,dice_id,damage_type_id,bonus,quantity) values (2,4,11,0,1);

   

    