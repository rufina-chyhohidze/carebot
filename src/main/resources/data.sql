-- SELECT MAX(id) FROM item_requests;
-- SELECT last_value FROM item_requests_id_seq;
--
-- SELECT setval('item_requests_id_seq', (SELECT MAX(id) FROM item_requests) + 1);


-- CREATE TABLE IF NOT EXISTS new(
--     id INTEGER PRIMARY KEY,
--     category VARCHAR(50),
--     name VARCHAR(50),
--     price FLOAT,
--     stock_quantity INTEGER
-- );
-- DROP TABLE IF EXISTS new CASCADE;
-- ALTER TABLE new
-- ALTER COLUMN price TYPE FLOAT;
--
--
-- INSERT INTO employees(date_of_birth, department, email, first_name, gender, last_name, password, phone, role, username) VALUES(NOW(), NULL, 'user@gmail.com', 'user', 'FEMALE', 'lastname', 'user', '1', NULL, 'username');

-- \COPY item_requests(id,item_name,path,request_time,status,employee_id,number_of_obstacles)
-- FROM '/home/anir333/Downloads/item_request_data.csv'
-- WITH (FORMAT csv, HEADER true);



-- CREATE TABLE IF NOT EXISTS item_request_table(
--     id INTEGER,
--     item_name VARCHAR(100),
--     path VARCHAR(50),
--     request_time TIMESTAMP,
--     status VARCHAR,
--     employee_id INTEGER,
--     number_of_obstacles INTEGER
-- );

-- INSERT INTO item_requests(id,item_name,path,request_time,status,employee_id,number_of_obstacles)
-- VALUES(1, 'Printer', 'PATH1', now(), 'PENDING', 1, 1);