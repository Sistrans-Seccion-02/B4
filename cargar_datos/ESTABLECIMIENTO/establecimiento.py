from faker import Faker
import csv

fake = Faker()

establecimiento_data = []

for i in range(1000):
    establecimiento_data.append([i, i, fake.last_name(), fake.random_int(min=50, max=300)])

with open('establecimiento_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'id_establecimiento', 'nombre', 'capacidad'])
    writer.writerows(establecimiento_data)

print("Datos generados y guardados en establecimiento_data.csv.")
