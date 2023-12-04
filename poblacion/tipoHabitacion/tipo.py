import json
import random
import uuid

def generate_data(n):
    tipos_habitacion = ["Suite Presidencial", "Suite", "Familiar", "Doble", "Sencilla"]
    dotaciones = ["TV", "Jacuzzi", "Lavadora", "Mini Bar", "Cafetera", "Nevera", "Estufa"]

    data = []
    for _ in range(n):
        tipo = random.choice(tipos_habitacion)
        dotacion = ', '.join(random.sample(dotaciones, random.randint(1, len(dotaciones))))
        entry = {
            "_id": str(uuid.uuid4()),
            "tipo": tipo,
            "dotacion": dotacion,
            "_class": "com.example.demo.modelo.TipoHabitacion"
        }
        data.append(entry)
    return data

# Generar 20 entradas
data = generate_data(20)

# Guardar en un archivo JSON
with open('tipo_habitacion_data.json', 'w') as file:
    json.dump(data, file, indent=4)
