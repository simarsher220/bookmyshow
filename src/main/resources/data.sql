insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (1, 'The Lion King','Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cubs arrival. Scar, Mufasas brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simbas exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.','http://image.tmdb.org/t/p/original/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg','https://www.youtube.com/watch?v=4CbLXeGSDxg','120');
--insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (9, 'Detective Conan: The Fist of Blue Sapphire','23rd movie in the \"Detective Conan\" franchise.','http://image.tmdb.org/t/p/original/86Y6qM8zTn3PFVfCm9J98Ph7JEB.jpg','https://www.youtube.com/watch?v=4BO8RY7Jm_Q','175')
insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (2, 'Spider-Man: Far from Home','Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.','http://image.tmdb.org/t/p/original/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg','https://www.youtube.com/watch?v=DYYtuKyMtY8','130');
insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (3, 'Fast & Furious Presents: Hobbs & Shaw','A spinoff of The Fate of the Furious, focusing on Johnsons US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Stathams Deckard Shaw.','http://image.tmdb.org/t/p/original/keym7MPn1icW1wWfzMnW3HeuzWU.jpg','https://www.youtube.com/watch?v=9SA7FaKxZVI','144');
insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (4, 'Long Shot','When Fred Flarsky reunites with and charms his first crush, Charlotte Field—one of the most influential women in the world. As Charlotte prepares to make a run for the Presidency, she hires Fred as her speechwriter and sparks fly.','http://image.tmdb.org/t/p/original/m2ttWZ8rMRwIMT7zA48Jo6mTkDS.jpg','https://www.youtube.com/watch?v=ZKsc2I4Tgsk','156');
insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (5, 'Godzilla: King of the Monsters','Follows the heroic efforts of the crypto-zoological agency Monarch as its members face off against a battery of god-sized monsters, including the mighty Godzilla, who collides with Mothra, Rodan, and his ultimate nemesis, the three-headed King Ghidorah. When these ancient super-species - thought to be mere myths - rise again, they all vie for supremacy, leaving humanitys very existence hanging in the balance.','http://image.tmdb.org/t/p/original/pU3bnutJU91u3b4IeRPQTOP8jhV.jpg','https://www.youtube.com/watch?v=wVDtmouV9kM','135');
insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (6, 'Toy Story 4','Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether thats Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.','http://image.tmdb.org/t/p/original/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg','https://www.youtube.com/watch?v=LDXYRzerjzU','160');
insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (7, 'John Wick: Chapter 3 – Parabellum','Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.','http://image.tmdb.org/t/p/original/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg','https://www.youtube.com/watch?v=M7XM597XO94','91');
insert into movie (movie_id, movie_name, movie_overview, movie_poster, movie_trailer, length) values (8, 'Pokémon Detective Pikachu','In a world where people collect pocket-size monsters (Pokémon) to do battle, a boy comes across an intelligent monster who seeks to be a detective.','http://image.tmdb.org/t/p/original/wgQ7APnFpf1TuviKHXeEe3KnsTV.jpg','https://www.youtube.com/watch?v=1roy4o4tqQM','100');


insert into theatre (theatre_id, theatre_name, theatre_location, city, pincode) values (9, 'Bharath Cinemas','Central Spirit Mall, Bellandur','Bengaluru','576104');
insert into theatre (theatre_id, theatre_name, theatre_location, city, pincode) values (10, 'INOX Cinemas','Lido Mall, MG Road','Bengaluru','560008');
insert into theatre (theatre_id, theatre_name, theatre_location, city, pincode) values (11, 'Wave Cinemas','Industrial Area, Andheri','Mumbai','460004');
insert into theatre (theatre_id, theatre_name, theatre_location, city, pincode) values (12, 'Fun Cinemas','Fun Republic Mall, Gomtinagar','Lucknow','226011');
insert into theatre (theatre_id, theatre_name, theatre_location, city, pincode) values (13, 'PVR Cinemas','Saharaganj Mall, Hazratganj','Lucknow','226001');
insert into theatre (theatre_id, theatre_name, theatre_location, city, pincode) values (14, 'SRS Cinemas','City Square Mall, Shivaji Place','Delhi','110027');

insert into show (movie_id, theatre_id, show_date, show_time) values ('1','9','2019-08-02','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('1','10','2019-08-02','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('1','11','2019-08-02','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('1','12','2019-08-02','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('1','13','2019-08-02','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('1','14','2019-08-02','17:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('1','9','2019-08-02','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('1','10','2019-08-02','20:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','9','2019-08-03','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','10','2019-08-03','13:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','11','2019-08-03','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','12','2019-08-03','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','13','2019-08-03','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','14','2019-08-03','17:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','9','2019-08-03','18:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','11','2019-08-03','19:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','14','2019-08-03','20:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('2','10','2019-08-03','21:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','9','2019-08-04','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','10','2019-08-04','13:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','11','2019-08-04','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','12','2019-08-04','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','13','2019-08-04','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','14','2019-08-04','17:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','10','2019-08-04','18:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('3','12','2019-08-04','19:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','9','2019-08-05','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','10','2019-08-05','13:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','11','2019-08-06','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','12','2019-08-06','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','13','2019-08-06','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','14','2019-08-06','17:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','14','2019-08-06','18:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('4','13','2019-08-06','19:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','9','2019-08-07','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','10','2019-08-07','13:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','11','2019-08-07','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','12','2019-08-07','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','13','2019-08-07','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','14','2019-08-07','17:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','10','2019-08-07','18:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('5','13','2019-08-07','19:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('6','9','2019-08-08','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('6','10','2019-08-08','13:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('6','11','2019-08-08','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('6','12','2019-08-08','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('6','13','2019-08-08','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('6','14','2019-08-08','17:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('7','9','2019-08-09','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('7','10','2019-08-09','13:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('7','11','2019-08-09','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('7','12','2019-08-09','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('7','13','2019-08-09','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('8','14','2019-08-10','12:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('8','9','2019-08-10','13:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('8','10','2019-08-10','14:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('8','11','2019-08-10','15:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('8','12','2019-08-10','16:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('8','13','2019-08-10','17:00:00');
insert into show (movie_id, theatre_id, show_date, show_time) values ('8','10','2019-08-10','18:00:00');