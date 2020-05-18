insert into tb_class(id,name,description,life_dice_id) values (1,"Bárbaro","Um humano alto membro de alguma tribo caminha em
meio a uma nevasca, coberto por peles e empunhando seu
machado. Ele gargalha à medida que avança em direção
do gigante do gelo que ousou caçar os alces que o seu povo
arrebanhava.",6);
insert into mtm_class_atribute(class_id,atribute_id) values (1,1);
insert into mtm_class_atribute(class_id,atribute_id) values (1,2);

insert into tb_class_starting_proeficiency_choice(id,choose,class_id) values (1,2,1);
insert into mtm_class_starting_proeficiency_choice(starting_proeficiency_id,proeficiency_id) values (1,1);
insert into mtm_class_starting_proeficiency_choice(starting_proeficiency_id,proeficiency_id) values (1,8);
insert into mtm_class_starting_proeficiency_choice(starting_proeficiency_id,proeficiency_id) values (1,11);
insert into mtm_class_starting_proeficiency_choice(starting_proeficiency_id,proeficiency_id) values (1,13);
insert into mtm_class_starting_proeficiency_choice(starting_proeficiency_id,proeficiency_id) values (1,14);
insert into mtm_class_starting_proeficiency_choice(starting_proeficiency_id,proeficiency_id) values (1,18);

insert into mtm_class_level(class_id,level_id) values (1,4);