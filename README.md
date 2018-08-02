# CompanyDatabase
console application that creates 1m employees databese and perfoms filter query based on users input

Works properly of there is no database file in the directory. Will fix this later. 

Data That is inserted in the DB is completly random.
I made 1k unique rows, and then made a copy of what i got, and inserted it as next 1k.
This operation 10 times in a row gave me a little bit N > 1M rows.

This tactic is simple, and "straitforward", but it does what had to be done according to the task
Another way is to Import CSV File like here(http://www.postgresqltutorial.com/import-csv-file-into-posgresql-table/)
