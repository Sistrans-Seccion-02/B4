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
    for _ in range(n):
        entry = {
            "_id": str(uuid.uuid4()),
            "capacidad": random.randint(1, 5),
            "idTipoHabitacion": "Suite Presidencial",
            "FechaInicioOferta": generate_random_date(),
            "FechaFinOferta": generate_random_date(),
            "_class": "com.example.demo.modelo.Habitacion"
        }
        data.append(entry)
    return data

# Generar 2000 entradas
data = generate_data(2000)

# Guardar en un archivo JSON
with open('data.json', 'w') as file:
    json.dump(data, file)
