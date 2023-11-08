from faker import Faker
import csv

fake = Faker()

seviciohotel_data = []

for _ in range(5001):
    hoteles_id = fake.random_int(min=1, max=5000)
    servicios_id = fake.random_int(min=1, max=5000)
    seviciohotel_data.append([hoteles_id, servicios_id])

with open('seviciohotel_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['hoteles_id', 'servicios_id'])
    writer.writerows(seviciohotel_data)

print("Datos generados y guardados en seviciohotel_data.csv.")
