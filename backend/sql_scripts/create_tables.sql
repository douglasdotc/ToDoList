use todolist_vol;

# todo list/board 
create table board(
	board_id integer not null auto_increment,
	title varchar(255) unique,
	information text,
	created_at datetime,
	updated_at datetime,
	primary key(board_id)
);

# One list/board can have many items
create table board_items(
	board_id integer not null,
	item_id integer not null
);

# title and content are unique to an item
create table item(
	item_id integer not null auto_increment,
	title varchar(255),
	content text,
	primary key(item_id)
);

# One item can have many properties
create table tag(
	tag_id integer not null auto_increment,
	item_id integer,
	tag_name varchar(255) unique,
	primary key(tag_id)
);

# One property can have multiple values
create table tag_values(
	tag_value_id integer not null auto_increment,
	tag_id integer not null,
	val text,
	primary key(tag_value_id)
);
