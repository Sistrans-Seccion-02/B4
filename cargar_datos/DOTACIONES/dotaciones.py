from faker import Faker
import csv

fake = Faker()

dotaciones_data = []

for dotacion_id in range(1, 5001):
    dotaciones_data.append([dotacion_id, fake.word()])

with open('dotaciones_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'nombre'])
    writer.writerows(dotaciones_data)

print("Datos generados y guardados en dotaciones_data.csv.")
