from faker import Faker
import csv

fake = Faker()

ofrecen_data = []

for _ in range(75001):
    establecimiento_id = fake.random_int(min=1, max=999)
    productos_id = fake.random_int(min=1, max=50000)
    ofrecen_data.append([establecimiento_id, productos_id])

with open('ofrecen_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['establecimiento_id', 'productos_id'])
    writer.writerows(ofrecen_data)

print("Datos generados y guardados en ofrecen_data.csv.")