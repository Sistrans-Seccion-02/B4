package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Aggregation;
import java.util.List;
import com.example.demo.modelo.ReservaHabitacion;

public interface ReservaHabitacionRepository extends MongoRepository<ReservaHabitacion, String>{

    public class TotalDiasPorHabitacion {
        private String idHabitacion;
        private double total;

        public TotalDiasPorHabitacion(String idHabitacion, double total) {
            this.idHabitacion = idHabitacion;
            this.total = total;
        }

        // Getters y setters
        public String getIdHabitacion() {
            return idHabitacion;
        }

        public void setIdHabitacion(String idHabitacion) {
            this.idHabitacion = idHabitacion;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }

    @Aggregation(pipeline = {
        "{$group: { _id: '$idHabitacion', totalDias: { $sum: '$dias' } } }",
        "{$project: { _id: 0, idHabitacion: '$_id', total: { $multiply: ['$totalDias', 0.274] } } }"
    })
    List<TotalDiasPorHabitacion> calcularTotalPorHabitacion();
}
