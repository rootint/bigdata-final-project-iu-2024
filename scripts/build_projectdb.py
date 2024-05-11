"""
    Script to add the data from a CSV to a postgres database.
"""
from pprint import pprint
import os
import psycopg2 as psql

# load_dotenv is not available, so this ¯\_(ツ)_/¯
DB_PASSWORD = None
with open('.env', 'r', encoding='utf-8') as f:
    DB_PASSWORD = f.readline()


# Build the connection string
CONN_STRING = f"""host=hadoop-04.uni.innopolis.ru
                  port=5432 
                  user=team17 
                  dbname=team17_projectdb 
                  password={DB_PASSWORD}"""


# Connect to the remote dbms
with psql.connect(CONN_STRING) as conn:
    # Create a cursor for executing psql commands
    cur = conn.cursor()
    print('Creating tables and setting constraints...')
    with open(os.path.join("sql", "create_tables.sql"), encoding='utf-8') as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    print('Importing data from CSV...')
    with open(os.path.join("sql", "import_data.sql"), encoding='utf-8') as file:
        commands= file.readlines()
        with open(os.path.join("data","location_and_time.csv"), "r", encoding='utf-8') as location:
            cur.copy_expert(commands[0], location)
        with open(os.path.join("data","weather_conditions.csv"), "r", encoding='utf-8') as weather:
            cur.copy_expert(commands[1], weather)
        with open(os.path.join("data","air_quality.csv"), "r", encoding='utf-8') as aq:
            cur.copy_expert(commands[2], aq)
    conn.commit()

    # do I need this line?
    cur = conn.cursor()
    print('Checking results... You will see 3 rows from the weather database now.')
    # Read the sql commands from the file
    with open(os.path.join("sql", "test_database.sql"), encoding='utf-8') as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command)
            # Read all records and print them
            pprint(cur.fetchall())
