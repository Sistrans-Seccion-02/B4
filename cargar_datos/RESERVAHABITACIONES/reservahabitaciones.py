from faker import Faker
import csv
from datetime import datetime, timedelta

fake = Faker()

reservahabitaciones_data = []

for i in range(350001):
    fechainicio = fake.date_between(start_date='-30d', end_date='today')
    fechafin = fechainicio + timedelta(days=fake.random_int(min=1, max=30))
    reservahabitaciones_data.append([i, fechainicio, fechafin, fake.random_int(min=50, max=300), fake.random_int(min=1, max=1000), fake.random_int(min=1, max=100000), fake.random_int(min=1, max=100000)])

with open('reservahabitaciones_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'fechainicio', 'fechafin', 'pago', 'planesconsumo_id', 'ofertashabitaciones_id', 'usuarios_id'])
    writer.writerows(reservahabitaciones_data)

print("Datos generados y guardados en reservahabitaciones_data.csv.")