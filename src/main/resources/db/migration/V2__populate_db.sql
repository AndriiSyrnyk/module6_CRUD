INSERT INTO worker (name, birthday, level, salary)
VALUES 
	('andrii', '1990-02-23', 'Trainee', 999),
	('oleh', '1995-07-12', 'Junior', 999),
	('anna', '1996-02-07', 'Middle', 1500),
	('serhii', '1999-08-11', 'Senior', 2000),
	('volodymyr', '1990-09-13', 'Middle', 2000),
	('marta', '1990-10-16', 'Middle', 2050),
	('stepan', '1990-11-29', 'Middle', 2000),
	('olha', '1990-12-08', 'Junior', 1000),
	('dima', '1901-04-15', 'Senior', 5001),
	('petro', '2000-04-15', 'Senior', 5001);

INSERT INTO client (name)
VALUES
	('james'),
	('mary'),
	('robert'),
	('patricia'),
	('john');
	
INSERT INTO project (client_id, start_date, finish_date)
VALUES 
	(1, '2023-01-05', '2023-05-05'),
	(1, '2023-01-10', '2023-05-10'),
	(1, '2023-01-12', '2024-07-12'),
	(2, '2023-01-15', '2024-06-15'),
	(2, '2023-01-16', '2025-03-16'),
	(3, '2023-01-18', '2025-02-18'),
	(3, '2023-01-20', '2026-08-20'),
	(4, '2023-01-25', '2026-10-25'),
	(4, '2023-01-30', '2027-10-30'),
	(4, '2023-01-30', '2028-10-30'),
	(5, '2023-01-30', '2028-10-30'),
	(5, '2023-01-31', '2027-07-01');
	
INSERT INTO project_worker
VALUES 
	(11, 9),
	(11, 10),
	(12, 9),
	(12, 10),	
	(1, 1),
	(1, 2),
	(1, 3),
	(2, 3),
	(2, 9),
	(2, 4),	
	(3, 5),
	(3, 1),
	(4, 5),
	(5, 6),
	(5, 7),
	(6, 7),
	(6, 8),
	(6, 9),
	(7, 4),
	(8, 1),
	(8, 2),
	(8, 3),
	(9, 9),
	(10, 6),
	(10, 7);
