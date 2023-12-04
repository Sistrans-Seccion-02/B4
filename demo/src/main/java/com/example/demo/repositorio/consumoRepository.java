package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.example.demo.modelo.consumo;

public interface consumoRepository extends MongoRepository<consumo, String> {

    public class DineroRecolectadoPorHabitacion {
        public String idHabitacion;
        public double totalRecolectado;

        public DineroRecolectadoPorHabitacion(String idHabitacion, double totalRecolectado) {
            this.idHabitacion = idHabitacion;
            this.totalRecolectado = totalRecolectado;
        }

        // Getters y setters
        public String getIdHabitacion() {
            return idHabitacion;
        }

        public void setIdHabitacion(String idHabitacion) {
            this.idHabitacion = idHabitacion;
        }

        public double gettotalRecolectado() {
            return totalRecolectado;
        }

        public void settotalRecolectado(double totalRecolectado) {
            this.totalRecolectado = totalRecolectado;
        }
    }

    @Aggregation(pipeline = {
        "{ $match: { inicio: { $gte: ISODate('2023-01-01T00:00:00.000Z'), $lt: ISODate('2024-01-01T00:00:00.000Z') } } }",
        "{ $group: { _id: '$idHabitacion', totalRecolectado: { $sum: '$pago' } } }",
        "{ $project: { idHabitacion: '$_id', totalRecolectado: 1, _id: 0 } }"
    })
    List<DineroRecolectadoPorHabitacion> calcularDineroRecolectadoPorHabitacion();
}
