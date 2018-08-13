INSERT INTO break(id, break_number, break_length, break_time) VALUE (1, 0, 10, '7:45 - 8:00');
INSERT INTO break(id, break_number, break_length, break_time) VALUE (2, 1, 10, '8:45 - 8:55');
INSERT INTO break(id, break_number, break_length, break_time) VALUE (3, 2, 10, '9:40 - 9:50');

INSERT INTO place_of_guard(id, name, is_assigned) VALUE (1, 'place1', 0);
INSERT INTO place_of_guard(id, name, is_assigned) VALUE (2, 'place2', 0);
INSERT INTO place_of_guard(id, name, is_assigned) VALUE (3, 'place3', 0);

INSERT INTO teacher(id, name, surname) VALUE (1, 'Jan', 'Kowalski');
INSERT INTO teacher(id, name, surname) VALUE (2, 'Piotr', 'Nowak');
INSERT INTO teacher(id, name, surname) VALUE (3, 'Adam', 'Cybulski');