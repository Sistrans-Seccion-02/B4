import json
import random
import uuid
from datetime import datetime, timedelta

def generate_random_date(start_year, end_year):
    start_date = datetime(start_year, 1, 1)
    end_date = datetime(end_year, 1, 1)
    random_date = start_date + timedelta(days=random.randint(0, (end_date - start_date).days))
    return random_date

def generate_data(n):
    data = []
    for _ in range(n):
        inicio = generate_random_date(2023, 2024)
        fin = inicio + timedelta(days=random.randint(1, 7))  # asumiendo un máximo de 7 días de consumo

        entry = {
            "_id": str(uuid.uuid4()),
            "idServicio": str(uuid.uuid4()),  # UUID para ID de servicio
            "idReserva": str(uuid.uuid4()),  # UUID para ID de reserva
            "idHabitacion": str(uuid.uuid4()),  # UUID para ID de habitación
            "inicio": inicio.isoformat() + ".000+00:00",
            "fin": fin.isoformat() + ".000+00:00",
            "pago": round(random.uniform(50.0, 1000.0), 2),  # Pago aleatorio entre 50 y 1000
            "_class": "com.example.demo.modelo.consumo"
        }
        data.append(entry)
    return data

# Generar 250,000 entradas
data = generate_data(250000)

# Guardar en un archivo JSON
with open('consumo_data.json', 'w') as file:
    json.dump(data, file, indent=4)
