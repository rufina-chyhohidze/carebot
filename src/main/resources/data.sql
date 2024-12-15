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

-- -- FOR ITEM_REQUESTS table:
-- \COPY item_requests(item_name,path,request_time,status,employee_id,number_of_obstacles)
-- FROM '/home/AnirSaddik/Desktop/Integration_3_Y2_SMS1/Integration-WebApp/carebot_integration3_team17/predictor/ModelforCareBot/item_request_data.csv'
-- WITH (FORMAT csv, HEADER true);

-- -- FOR ITEMS table
-- \COPY items(id,category,name,price,stock_quantity)
-- FROM '//home/AnirSaddik/Desktop/Integration_3_Y2_SMS1/Integration-WebApp/carebot_integration3_team17/src/main/resources/laptop_and_tablets.csv'
-- WITH (FORMAT csv, HEADER true);

    -- -- For delivery table:
-- \COPY deliveries(delivery_finished,delivery_started,total_delivery_time,status,number_of_obstacles, item_request_id)
--     FROM '/home/AnirSaddik/Desktop/Integration_3_Y2_SMS1/Integration-WebApp/carebot_integration3_team17/predictor/ModelforCareBot/deliveries_fixed.csv'
--     WITH (FORMAT csv, HEADER true);



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
--
-- UPDATE deliveries
-- SET status = 'COMPLETED'
-- WHERE status = 'PROCESSING';
--
-- INSERT INTO deliveries(item_request_id, delivery_finished, delivery_started, total_delivery_time, status, number_of_obstacles) VALUES(1, '2024-12-05 16:00:00','2024-12-05 15:55:00',5,'COMPLETED',0)

-- SELECT AVG(d.number_of_obstacles)
-- FROM deliveries d
-- JOIN item_requests ir ON (d.item_request_id = ir.id)
-- WHERE ir.path = 'PATH1';
-- -- -- WHERE
--
-- SELECT d.number_of_obstacles
-- FROM deliveries d
--          JOIN item_requests ir ON (d.item_request_id = ir.id)
-- WHERE ir.path = 'PATH1';
--
-- UPDATE deliveries d
-- SET number_of_obstacles = 12
-- FROM item_requests ir
-- WHERE ir.path = 'PATH1' AND d.number_of_obstacles <= 5;
