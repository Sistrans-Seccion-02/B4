from faker import Faker
import csv
from datetime import datetime, timedelta

fake = Faker()

consumos_data = []

for i in range(100001):
    consumos_data.append([i, fake.text(max_nb_chars=10), fake.random_int(min=10, max=200), fake.date_between(start_date='-30d', end_date='today'), fake.random_int(min=1, max=100000)])

with open('consumos_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'descripcion', 'costo', 'fecha', 'reservahabitaciones_id'])
    writer.writerows(consumos_data)

print("Datos generados y guardados en consumos_data.csv.")
