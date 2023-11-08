from faker import Faker
import csv

fake = Faker()

usuarios_data = []

for user_id in range(1, 100001):
    usuarios_data.append([user_id, fake.first_name(), fake.last_name(), fake.email(), fake.random_element(elements=("Recepcionista", "Usuario", "Cliente", "Administrador","Gerente"))])

with open('usuarios_data.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(['id', 'nombre', 'apellido', 'correo', 'rol'])
    writer.writerows(usuarios_data)

print("Datos generados y guardados en usuarios_data.csv.")