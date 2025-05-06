import os
import pandas as pd
import numpy as np
import sqlite3

# Step 1: Load the CSV file into a pandas DataFrame
media_items_df = pd.read_csv('/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/media_items.csv')
guests_df = pd.read_csv('/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/guests.csv')
checked_out_items_df = pd.read_csv('/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/checked_out_items.csv')
checked_out_items_df['due_date'] = pd.to_datetime(checked_out_items_df['due_date']).values.astype(np.int64)

# Step 2: Create a connection to the SQLite database
# Note: This will create the database file if it doesn't exist already
os.makedirs('/workspaces/code-differently-24-q1/lesson_28/db/db_app/src/main/resources/sqlite/', exist_ok=True)
conn = sqlite3.connect('../db/db_app/src/main/resources/sqlite/data.db')

# Step 3: Write the DataFrame to the SQLite database
media_items_df.to_sql('media_items', conn, if_exists='replace', index=False)
guests_df.to_sql('guests', conn, if_exists='replace', index=False)
checked_out_items_df.to_sql('checked_out_items', conn, if_exists='replace', index=False)

# Don't forget to close the connection
conn.close()