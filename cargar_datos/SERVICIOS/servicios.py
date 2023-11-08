from faker import Faker
import csv

fake = Faker()

servicios_data = []

for servicio_id in range(1, 5001):
    servicios_data.append([servicio_id, fake.word(), fake.random_int(min=10, max=200), fake.text(max_nb_chars=50)])

with open('servicios_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'nombre', 'costo', 'descripcion'])
    writer.writerows(servicios_data)

print("Datos generados y guardados en servicios_data.csv.")
