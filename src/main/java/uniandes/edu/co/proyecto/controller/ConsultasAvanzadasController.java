package uniandes.edu.co.proyecto.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Date;

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
       model.addAttribute("rol", rol);
       if (rol.equals("Administrador")){
          return "consultasAvanzadasAdmin";
       }
       else if (rol.equals("Recepcionista")){
            return "consultasAvanzadasRec";
       } 
       else if (rol.equals("Gerente")){
         return "consultasAvanzadasGer";
       }
       else if (rol.equals("GerenteGeneral")){
         return "consultasAvanzadasGerGen";
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
         model.addAttribute("fecha1",fechas.getFecha1());
         model.addAttribute("fecha2",fechas.getFecha2());
        return "consultasAvanzadasR9";
     }


     //ordernar resultados req9 por fecha
     @GetMapping("/consultasavanzadas/R9/mod1/{fecha1}/{fecha2}")
     public String consultasAvanzadasR9mod1(@ModelAttribute("fecha1") Date fecha1, @ModelAttribute("fecha2") Date fecha2, Model model){
      model.addAttribute("reservaservicios", consultasRepository.r9mod1(fecha1, fecha2));
      return "consultasAvanzadasR9mod1";
     }
     //ordernar resultados req9 por el id del usuario
     @GetMapping("/consultasavanzadas/R9/mod2/{fecha1}/{fecha2}")
     public String consultasAvanzadasR9mod2(@ModelAttribute("fecha1") Date fecha1, @ModelAttribute("fecha2") Date fecha2, Model model){
      model.addAttribute("reservaservicios", consultasRepository.r9mod2(fecha1, fecha2));
      return "consultasAvanzadasR9mod2";
     }

     //ordernar resultados req9 por el nombre del usuario
     @GetMapping("/consultasavanzadas/R9/mod3/{fecha1}/{fecha2}")
     public String consultasAvanzadasR9mod3(@ModelAttribute("fecha1") Date fecha1, @ModelAttribute("fecha2") Date fecha2, Model model){
      model.addAttribute("reservaservicios", consultasRepository.r9mod3(fecha1, fecha2));
      return "consultasAvanzadasR9mod3";
     }

     //ordernar resultados req9 por el nombre del servicio
     @GetMapping("/consultasavanzadas/R9/mod4/{fecha1}/{fecha2}")
     public String consultasAvanzadasR9mod4(@ModelAttribute("fecha1") Date fecha1, @ModelAttribute("fecha2") Date fecha2, Model model){
      model.addAttribute("reservaservicios", consultasRepository.r9mod4(fecha1, fecha2));
      return "consultasAvanzadasR9mod4";
     }




     @GetMapping("/consultasavanzadas/R10")
     public String consultasAvanzadasR10(Model model){
        model.addAttribute("fechas", new fechas2());
        return "consultasAvanzadasR10Nuevo";
     }

     @GetMapping("/consultasavanzadas/R10fechasid")
     public String consultasAvanzadasR10fechasid(@ModelAttribute fechas2 fechas, Model model){
        model.addAttribute("reservaservicios", consultasRepository.r10(fechas.getFecha1(), fechas.getFecha2()));
         model.addAttribute("fecha1",fechas.getFecha1());
         model.addAttribute("fecha2",fechas.getFecha2());
        return "consultasAvanzadasR10";
     }

     //ordernar resultados req10 por nombre usuario
     @GetMapping("/consultasavanzadas/R10/mod1/{fecha1}/{fecha2}")
     public String consultasAvanzadasR10mod1(@ModelAttribute("fecha1") Date fecha1, @ModelAttribute("fecha2") Date fecha2, Model model){
      model.addAttribute("reservaservicios", consultasRepository.r10mod1(fecha1, fecha2));
      return "consultasAvanzadasR10mod1";
     }

     //ordernar resultados req10 por id usuario
     @GetMapping("/consultasavanzadas/R10/mod2/{fecha1}/{fecha2}")
     public String consultasAvanzadasR10mod2(@ModelAttribute("fecha1") Date fecha1, @ModelAttribute("fecha2") Date fecha2, Model model){
      model.addAttribute("reservaservicios", consultasRepository.r10mod2(fecha1, fecha2));
      return "consultasAvanzadasR10mod2";
     }
}
