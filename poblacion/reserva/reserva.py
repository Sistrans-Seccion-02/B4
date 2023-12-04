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
        inicio_reserva = generate_random_date(2023, 2024)
        fin_reserva = inicio_reserva + timedelta(days=random.randint(1, 14)) # asumiendo un máximo de 14 días de reserva
        dias = (fin_reserva - inicio_reserva).days

        entry = {
            "_id": str(uuid.uuid4()),
            "descripcion": "Reserva " + str(uuid.uuid4())[:8],  # Descripción aleatoria
            "costo": round(random.uniform(20.0, 500.0), 2),  # Costo aleatorio entre 20 y 500
            "FechaInicioReserva": inicio_reserva.isoformat() + ".000+00:00",
            "FechaFinReserva": fin_reserva.isoformat() + ".000+00:00",
            "idUsuario": random.randint(1, 10000),  # Asumiendo un rango de ID de usuario
            "idHabitacion": str(uuid.uuid4()),  # ID de habitación aleatoria
            "dias": dias,
            "_class": "com.example.demo.modelo.ReservaHabitacion"
        }
        data.append(entry)
    return data

# Generar 50,000 entradas
data = generate_data(50000)

# Guardar en un archivo JSON
with open('reserva_habitacion_data.json', 'w') as file:
    json.dump(data, file, indent=4)
