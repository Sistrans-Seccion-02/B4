import json
import random
import uuid
from datetime import datetime, timedelta

def generate_random_date():
    start_date = datetime(2023, 1, 1)
    end_date = datetime(2024, 1, 1)
    random_date = start_date + timedelta(days=random.randint(0, 365))
    return random_date.isoformat() + ".000+00:00"

def generate_data(servicios):
    productos = ["pollo, papa", "bebidas, snacks", "frutas, ensaladas"]

    data = []
    for servicio in servicios:
        entry = {
            "id": str(uuid.uuid4()),
            "nombre": servicio,
            "inicioServicio": generate_random_date(),
            "finServicio": generate_random_date(),
            "costo": random.randint(10000, 50000),
            "_class": "com.example.demo.modelo.servicio"
        }
        if servicio in ["Restaurante1", "Mini bar"]:
            entry["productos"] = random.choice(productos)
        data.append(entry)
    return data

# Lista de 35 servicios únicos
servicios = ["Restaurante1", "Gimnasio", "Spa", "WiFi", "Mini bar", "Piscina", "Parqueadero", "Lavandería", "Bar", "Cafetería",
             "Salón de belleza", "Sauna", "Jacuzzi", "Cine", "Biblioteca", "Jardín", "Terraza", "Sala de juegos", "Guardería", "Tienda de regalos",
             "Sala de conferencias", "Centro de negocios", "Servicio de habitaciones", "Transporte al aeropuerto", "Alquiler de bicicletas",
             "Alquiler de coches", "Cambio de divisas", "Asistencia turística", "Seguridad 24 horas", "Recepción 24 horas",
             "Servicio de despertador", "Servicio de lavado en seco", "Servicio de planchado", "Servicio de masajes", "Cancha de tenis"]

# Generar 35 entradas
data = generate_data(servicios)

# Guardar en un archivo JSON
with open('servicio_data.json', 'w') as file:
    json.dump(data, file, indent=4)
