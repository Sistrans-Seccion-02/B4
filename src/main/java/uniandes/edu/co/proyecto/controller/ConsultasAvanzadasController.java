package uniandes.edu.co.proyecto.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.nuevasClases.fechas2;
import uniandes.edu.co.proyecto.nuevasClases.usuarioid;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.ConsultasAvanzadasRepository;


@Controller
public class ConsultasAvanzadasController {
   
      @Autowired
      private UsuarioRepository usuarioRepository;

      @Autowired
      private ConsultasAvanzadasRepository consultasRepository;

     @GetMapping("/consultasavanzadas")
     public String consultasAvanzadas(Model model){
        model.addAttribute("usuarioid", new usuarioid());
        return "consultasAvanzadasNuevo";
     }
    
     @GetMapping("/consultasavanzadas/user")
     public String consultasAvanzadasId(Model model, @ModelAttribute("id") Integer id){
       String rol = usuarioRepository.mostrarRolUsuarioPorId(id);
       System.out.println("********************");
       System.out.println(rol);
       if (rol.equals("Administrador")){
          return "consultasAvanzadasAdmin";
       }
       else if (rol.equals("Recepcionista")){
            return "consultasAvanzadasRec";
       } 
       else if (rol.equals("Gerente")){
         return "consultasAvanzadasGer";
       }
       else{
         return "consultasAvanzadasSinPermiso";
       }
     }


     @GetMapping("/consultasavanzadas/R9")
     public String consultasAvanzadasR9(Model model){
        model.addAttribute("fechas", new fechas2());
        return "consultasAvanzadasR9Nuevo";
     }

     @GetMapping("/consultasavanzadas/R9fechasid")
     public String consultasAvanzadasR9fechasid(@ModelAttribute fechas2 fechas, Model model){
        model.addAttribute("reservaservicios", consultasRepository.r9(fechas.getFecha1(), fechas.getFecha2()));
        return "consultasAvanzadasR9";
     }

}
