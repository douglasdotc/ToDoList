use todolist_vol;

-- todo list
create table lst(
	list_id integer not null auto_increment,
    title varchar(255) unique,
    descript text,
    created_time datetime,
    last_edited_time datetime,
    primary key(list_id)
);

-- One list can have many items
create table lst_items(
	list_id integer not null,
    item_id integer not null
);

-- title and content are unique to an item
create table item(
	item_id integer not null auto_increment,
    title varchar(255) unique,
    content text,
    primary key(item_id)
);

-- One item can have many properties
create table tag(
	tag_id integer not null auto_increment,
    item_id integer,
    tag_name varchar(255) unique,
    primary key(tag_id)
);

-- One property can have multiple values
create table tag_values(
	tag_value_id integer not null auto_increment,
    tag_id integer not null,
    val text,
    primary key(tag_value_id)
);