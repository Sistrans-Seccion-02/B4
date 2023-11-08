from faker import Faker
import csv
import random
from datetime import datetime, timedelta

fake = Faker()

check_data = []

for i in range(25001):
    llegada = random.choice(["T", "F"])
    check_data.append([i, llegada, fake.date_between(start_date='-30d', end_date='today'), fake.random_int(min=1, max=100000), fake.random_int(min=1, max=5000)])

with open('check_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'llegada', 'fecha', 'usuarios_id', 'reservahabitaciones_id'])
    writer.writerows(check_data)

print("Datos generados y guardados en check_data.csv.")
