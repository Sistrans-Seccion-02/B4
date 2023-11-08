from faker import Faker
import csv

fake = Faker()

planesconsumo_data = []

for i in range(10001):
    planesconsumo_data.append([i, fake.word(), fake.random_int(min=10, max=50)])

with open('planesconsumo_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'nombre', 'descuento'])
    writer.writerows(planesconsumo_data)

print("Datos generados y guardados en planesconsumo_data.csv.")
