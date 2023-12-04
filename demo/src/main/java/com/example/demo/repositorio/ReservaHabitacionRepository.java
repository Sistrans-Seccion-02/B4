package com.example.demo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Aggregation;

import java.util.Date;
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
    public class GastoTotal {
        private String idUsuario;
        private double totalGastado;
    
        public GastoTotal(String idUsuario, double totalGastado) {
            this.idUsuario = idUsuario;
            this.totalGastado = totalGastado;
        }
    
        // Getters y Setters
        public String getIdUsuario() {
            return idUsuario;
        }
    
        public void setIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
        }
    
        public double getTotalGastado() {
            return totalGastado;
        }
    
        public void setTotalGastado(double totalGastado) {
            this.totalGastado = totalGastado;
        }
    }

    

    @Aggregation(pipeline = {
        "{$group: { _id: '$idHabitacion', totalDias: { $sum: '$dias' } } }",
        "{$project: { _id: 0, idHabitacion: '$_id', total: { $multiply: ['$totalDias', 0.274] } } }"
    })
    List<TotalDiasPorHabitacion> calcularTotalPorHabitacion();

    @Aggregation(pipeline = {
        "{ $match: { idUsuario: ?0, inicio: { $gte: ?1 }, fin: { $lte: ?2 } } }",
        "{ $group: { _id: '$idUsuario', totalGastado: { $sum: '$pago' } } }",
        "{ $project: { idUsuario: '$_id', totalGastado: 1, _id: 0 } }"
    })
    GastoTotal calcularGastoTotalPorUsuarioYRango(String idUsuario, Date fechaInicio, Date fechaFin);
}
