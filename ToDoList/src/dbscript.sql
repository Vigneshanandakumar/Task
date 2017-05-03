/*Please run the dbscript before proceeding with the project; 
 * Database = sqlite
 * Database name = Todo*/

CREATE TABLE task (
    taskId INTEGER PRIMARY KEY   AUTOINCREMENT
                   NOT NULL,
    taskName TEXT NOT NULL,
    taskDescription  TEXT NOT NULL,
    addedOn    DATETIME DEFAULT CURRENT_TIMESTAMP
);

