CREATE TABLE department (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

CREATE TABLE employee (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          department_id INT REFERENCES department(id)
);

CREATE TABLE project (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL
);

CREATE TABLE employee_project (
                                  employee_id INT REFERENCES employee(id),
                                  project_id INT REFERENCES project(id),
                                  PRIMARY KEY (employee_id, project_id)
);

CREATE TABLE address (
                         id SERIAL PRIMARY KEY,
                         street VARCHAR(100) NOT NULL,
                         city VARCHAR(100) NOT NULL,
                         employee_id INT UNIQUE REFERENCES employee(id)
);