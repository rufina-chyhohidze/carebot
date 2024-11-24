CREATE TABLE IF NOT EXISTS new(
    id INTEGER PRIMARY KEY,
    category VARCHAR(50),
    name VARCHAR(50),
    price FLOAT,
    stock_quantity INTEGER
);
DROP TABLE IF EXISTS new CASCADE;
ALTER TABLE new
ALTER COLUMN price TYPE FLOAT;

-- \COPY new(id, category, name, price, stock_quantity)
-- FROM '/home/anir333/Desktop/KDG/Subjects/Year_2/Semester_1/Integration_3/Integration-WebApp/carebot_integration3_team17/src/main/resources/laptop_and_tablets.csv'
-- WITH (FORMAT csv, HEADER true);