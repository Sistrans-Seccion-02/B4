from faker import Faker
import csv

fake = Faker()

productos_data = []

for i in range(50001):
    productos_data.append([i, fake.random_int(min=10, max=200), fake.word()])

with open('productos_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'costo', 'descripcion'])
    writer.writerows(productos_data)

print("Datos generados y guardados en productos_data.csv.")
