use todolist_vol;

-- todo list
create table lst(
	list_id integer primary key,
    title varchar(255) unique,
    descript text,
    created_time datetime,
    last_edited_time datetime
);

-- One list can have many items
create table lst_items(
	list_id integer,
    item_id integer
);

-- title and content are unique to an item
create table item(
	item_id integer primary key,
    title varchar(255) unique,
    content text
);

-- One item can have many properties
create table tag(
	tag_id integer primary key,
    item_id integer,
    tag_name varchar(255) unique
);

-- One property can have multiple values
create table tag_values(
	tag_value_id integer primary key,
    tag_id integer,
    val text
);