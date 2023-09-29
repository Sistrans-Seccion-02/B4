package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String productos(Model model, Float costo, String descripcion){
        model.addAttribute("productos", productoRepository.mostrarProductos());
        return "productos";
    }

    @GetMapping("/productos/new")
    public String productosForm(Model model){
        model.addAttribute("producto", new Producto());
        return "productoNuevo";
    }

    @GetMapping("/productos/new/save")
    public String productoSave(Producto producto){
        productoRepository.insertarProducto(producto.getCosto(), producto.getDescripcion());
        return "redirect:/consumos";
    }

    @GetMapping("/productos/{id}/edit")
    public String productoEditarForm(@PathVariable Integer id, Model model){
        Producto producto = productoRepository.mostrarProductoPorId(id);
        if(producto != null){
            model.addAttribute("producto", producto);
            return "productoEditar";
        }

        else return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/edit/save")
    public String productoEditarSave(@PathVariable Integer id, Producto producto ){
        productoRepository.actualizarProducto(id, producto.getCosto(), producto.getDescripcion());
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}/delete")
    public String productoDelete(@PathVariable Integer id){
        productoRepository.eliminarProducto(id);
        return "redirect:/productos";
    }
}
