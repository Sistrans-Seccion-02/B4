import json
import random
import uuid
from datetime import datetime, timedelta

def generate_random_date():
    start_date = datetime(2023, 1, 1)
    end_date = datetime(2024, 1, 1)
    random_date = start_date + timedelta(days=random.randint(0, 365))
    return random_date.isoformat() + ".000+00:00"

def generate_data(n):
    data = []
    for i in range(n):
        entry = {
            "_id": str(uuid.uuid4()),
            "llegada": random.choice([True, False]),
            "fecha": generate_random_date(),
            "idReserva": str(uuid.uuid4()),
            "idUsuario": str(i + 1),
            "_class": "com.example.demo.modelo.Check"
        }
        data.append(entry)
    return data

# Generar 50000 entradas
data = generate_data(50000)

# Guardar en un archivo JSON
with open('check_data.json', 'w') as file:
    json.dump(data, file, indent=4)
