create table if not exists file_info  (
	file_id serial primary key,
	file_location varchar(32000) not null,
	file_name varchar(260) not null,
	longest_word text,
	shortest_word text,
	length int,
	avarage_word_length int
);

create table if not exists line_info (
	line_id serial primary key,
	file_id int not null,
	longest_word text,
	shortest_word text,
	length int,
	avarage_word_length int,
	constraint line_info_file_info_file_id_fk foreign key (file_id)
	references file_info (file_id) on delete cascade on update cascade
);