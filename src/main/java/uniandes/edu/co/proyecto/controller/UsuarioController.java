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
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.mostrarUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/new";
    }

    @PostMapping("/usuarios/new/save")
    public String usuarioSubmit(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEdit(Model model, @PathVariable Integer id) {
        Usuario usuario = usuarioRepository.mostrarUsuarioPorId(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarios/edit";
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditSubmit(@ModelAttribute Usuario usuario, @PathVariable Integer id) {
        usuarioRepository.actualizarUsuario(id, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getRol());
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/{id}/delete")
    public String usuarioDelete(@PathVariable Integer id) {
        usuarioRepository.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
    
}
