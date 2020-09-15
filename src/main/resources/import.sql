insert into Users(user_id, firstname, lastname) values (USER_SEQ.nextval, 'Stephen', 'Ripley');
insert into Users(user_id, firstname, lastname) values (USER_SEQ.nextval, 'June', 'McPake');

insert into Item(item_id, name, description, price, stock) values (ITEM_SEQ.nextval, 'Thor', 'DVD', '12.99', 5);
insert into Item(item_id, name, description, price, stock) values (ITEM_SEQ.nextval, 'Man of Steel', 'DVD', '10.99', 4);
insert into Item(item_id, name, description, price, stock) values (ITEM_SEQ.nextval, 'The Dark Knight', 'DVD', '8.99', 10);
insert into Item(item_id, name, description, price, stock) values (ITEM_SEQ.nextval, 'The Avengers', 'DVD', '15.99', 3);
insert into Item(item_id, name, description, price, stock) values (ITEM_SEQ.nextval, 'Thor 2', 'DVD', '5.99', 0);

insert into USERS_BASKET (USERS_USER_ID, BASKET_ITEM_ID) values (1,1);
insert into USERS_BASKET (USERS_USER_ID, BASKET_ITEM_ID) values (1,2);
insert into USERS_BASKET (USERS_USER_ID, BASKET_ITEM_ID) values (1,3);

insert into USERS_BASKET (USERS_USER_ID, BASKET_ITEM_ID) values (2,1);
insert into USERS_BASKET (USERS_USER_ID, BASKET_ITEM_ID) values (2,4);
insert into USERS_BASKET (USERS_USER_ID, BASKET_ITEM_ID) values (2,5);