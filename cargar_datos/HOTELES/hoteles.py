from faker import Faker
import csv

fake = Faker()

hoteles_data = []

for hotel_id in range(1, 5001):
    adress = fake.address()[0:3:]
    hoteles_data.append([hotel_id, fake.last_name(), adress])

with open('hoteles_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'nombre', 'ubicacion'])
    writer.writerows(hoteles_data)

print("Datos generados y guardados en hoteles_data.csv.")
