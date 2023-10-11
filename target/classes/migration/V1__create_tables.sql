CREATE TABLE aircraft
(
    aircraft_id   SERIAL PRIMARY KEY,
    aircraft_name VARCHAR(255) NOT NULL,
    capacity      INT,
    range_km      INT
);

CREATE TABLE flight
(
    flight_id           SERIAL PRIMARY KEY,
    aircraft_id         INT REFERENCES aircraft (aircraft_id),
    departure_airport   VARCHAR(255) NOT NULL,
    destination_airport VARCHAR(255) NOT NULL,
    departure_time      TIMESTAMP    NOT NULL,
    arrival_time        TIMESTAMP    NOT NULL,
    status              VARCHAR(50) DEFAULT 'Scheduled', -- Possible statuses 'Scheduled', 'Cancelled', etc.
    CONSTRAINT chk_departure_arrival CHECK (departure_time < arrival_time)
);

CREATE TABLE flight_crew
(
    crew_id          SERIAL PRIMARY KEY,
    flight_id        INT REFERENCES flight (flight_id),
    crew_member_name VARCHAR(255) NOT NULL,
    role             VARCHAR(50)  NOT NULL
);

CREATE TABLE cancellation_reason
(
    reason_id   SERIAL PRIMARY KEY,
    reason_text TEXT
);

CREATE TABLE flight_cancellation
(
    cancellation_id   SERIAL PRIMARY KEY,
    flight_id         INT REFERENCES flight (flight_id),
    reason_id         INT REFERENCES cancellation_reason (reason_id),
    cancellation_time TIMESTAMP NOT NULL
);

CREATE TABLE airport_change
(
    change_id               SERIAL PRIMARY KEY,
    flight_id               INT REFERENCES flight (flight_id),
    new_destination_airport VARCHAR(255) NOT NULL,
    change_time             TIMESTAMP    NOT NULL
);

INSERT INTO aircraft (aircraft_name, capacity, range_km)
VALUES ('Boeing 747', 400, 12000),
       ('Airbus A320', 150, 5500),
       ('Boeing 787', 250, 9000);

INSERT INTO flight (aircraft_id, departure_airport, destination_airport, departure_time, arrival_time, status)
VALUES (1, 'JFK', 'LHR', '2023-10-15 08:00:00', '2023-10-15 16:00:00', 'SCHEDULED'),
       (2, 'LAX', 'SFO', '2023-10-16 10:00:00', '2023-10-16 11:30:00', 'SCHEDULED'),
       (3, 'ORD', 'HND', '2023-10-17 14:00:00', '2023-10-18 18:00:00', 'SCHEDULED');

INSERT INTO flight_crew (flight_id, crew_member_name, role)
VALUES (1, 'John Smith', 'Pilot'),
       (1, 'Alice Johnson', 'Navigator'),
       (1, 'Bob Brown', 'Operator Radio'),
       (1, 'Emily Davis', 'Cabin Crew'),
       (2, 'Michael Wilson', 'Pilot'),
       (2, 'Sophia Martinez', 'Cabin Crew'),
       (3, 'David Lee', 'Pilot'),
       (3, 'Olivia Anderson', 'Navigator'),
       (3, 'Liam White', 'Cabin Crew');

INSERT INTO cancellation_reason (reason_text)
VALUES ('Weather Conditions'),
       ('Technical Issues'),
       ('Unforeseen Circumstances');

INSERT INTO flight_cancellation (flight_id, reason_id, cancellation_time)
VALUES (1, 1, '2023-10-15 07:30:00'),
       (3, 2, '2023-10-18 10:30:00');

INSERT INTO airport_change (flight_id, new_destination_airport, change_time)
VALUES (1, 'CDG', '2023-10-15 10:00:00'),
       (3, 'NRT', '2023-10-18 12:00:00');
