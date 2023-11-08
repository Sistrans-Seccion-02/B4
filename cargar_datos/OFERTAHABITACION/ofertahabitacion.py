from faker import Faker
import csv
from datetime import datetime, timedelta

fake = Faker()

ofertashabitaciones_data = []

for oferta_id in range(1, 100001):
    fechainicio = fake.date_between(start_date='-30d', end_date='today')
    fechafin = fechainicio + timedelta(days=fake.random_int(min=1, max=30))
    ofertashabitaciones_data.append([oferta_id, fake.random_int(min=1, max=10), fechainicio, fechafin, fake.random_int(min=50, max=300), fake.random_element(elements=("Individual", "Doble", "Suite")), fake.random_int(min=1, max=100000), fake.random_int(min=1, max=5000),fake.random_int(min=1,max=100001) ,fake.random_int(min=1, max=1)])

with open('ofertashabitaciones_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'capacidad', 'fechainicio', 'fechafin', 'costo', 'tipohabitacion', 'usuarios_id', 'hoteles_id','habitacion_id' ,'existe'])
    writer.writerows(ofertashabitaciones_data)

print("Datos generados y guardados en ofertashabitaciones_data.csv.")
