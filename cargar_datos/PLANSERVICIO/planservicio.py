from faker import Faker
import csv

fake = Faker()

planservicio_data = []

for i in range(5000):
    planservicio_data.append([i, fake.random_int(min=1, max=5000)])

with open('planservicio_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['planesconsumo_id', 'servicios_id'])
    writer.writerows(planservicio_data)

print("Datos generados y guardados en planservicio_data.csv.")
