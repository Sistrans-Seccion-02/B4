from faker import Faker
import csv
from datetime import datetime, timedelta

fake = Faker()

reservaservicios_data = []

for i in range(100001):
    fechainicio = fake.date_between(start_date='-30d', end_date='today')
    fechafin = fechainicio + timedelta(days=fake.random_int(min=1, max=30))
    pago = fake.random_int(min=50, max=300)
    servicios_id = fake.random_int(min=1, max=5000)
    nombre_servicio = fake.word()
    existe = fake.random_int(min=1, max=1)
    habitacion_id = fake.random_int(min=1, max=100000)
    reservaservicios_data.append([i, fechainicio, fechafin, pago, servicios_id, nombre_servicio, existe, habitacion_id])

with open('reservaservicios_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'fechainicio', 'fechafin', 'pago', 'servicios_id', 'nombre_servicio', 'existe', 'habitacion_id'])
    writer.writerows(reservaservicios_data)

print("Datos generados y guardados en reservaservicios_data.csv.")