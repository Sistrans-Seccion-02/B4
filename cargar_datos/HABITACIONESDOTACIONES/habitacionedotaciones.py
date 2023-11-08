from faker import Faker
import csv

fake = Faker()

habitacionesdotaciones_data = []

for _ in range(1000):
    ofertashabitaciones_id = fake.random_int(min=1, max=5000)
    dotaciones_id = fake.random_int(min=1, max=5000)
    habitacionesdotaciones_data.append([ofertashabitaciones_id, dotaciones_id])

with open('habitacionesdotaciones_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['ofertashabitaciones_id', 'dotaciones_id'])
    writer.writerows(habitacionesdotaciones_data)

print("Datos generados y guardados en habitacionesdotaciones_data.csv.")