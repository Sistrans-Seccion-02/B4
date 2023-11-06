package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;
import uniandes.edu.co.proyecto.modelo.Usuario;

@Controller
public class UsuarioController {

    //id
    //nombre
    //apellido
    //correo
    //rol
    @Autowired
    private UsuarioRepository usuarioRepository;

    //mostrar todos los usuarios
    @GetMapping("/usuarios")
    public String usuarios(Model model,Integer id) {
        if(id != null && !id.equals("")){
            model.addAttribute("usuarios", usuarioRepository.mostrarUsuarioPorId(id));
        }
        else{
            model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
        }
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getId(),usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEdit(Model model, @PathVariable("id") Integer id) {
        Usuario usuario = usuarioRepository.mostrarUsuarioPorId(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditSubmit(@ModelAttribute Usuario usuario, @PathVariable("id") Integer id) {
        usuarioRepository.actualizarUsuario(id, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioDelete(@PathVariable Integer id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }

    //encontrar buenos clientes
    @GetMapping("/usuarios/buenosClientes")
    public String buenosClientes(Model model) {
        model.addAttribute("buenosClientes", usuarioRepository.obtenerBuenosClientes());
        return "usuariosBuenosClientes";
    }
    
}
