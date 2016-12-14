package br.com.biblioteca.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Usuario;

@Controller
@SessionAttributes({"usuarioLogado"})
public class UsuarioController {
	//ir para menu
	@RequestMapping("menuUsuario")
	public String irMenu(){
		return "usuario/menu";
	}
	@RequestMapping("cadastroUsuario")
	public String cadastro(Usuario u){
		UsuarioDAO dao = new UsuarioDAO();
		dao.adiciona(u);
		
		return "index";
	}
	//ir para formulario de login
	@RequestMapping("loginForm")
	public String loginForm(){
		return "login";
	}
	//login
	@RequestMapping("efetuarLogin")
	
	public ModelAndView efetuarLogin(Usuario usuario, HttpSession session){
		ModelAndView mv = new ModelAndView("usuario/menu");		//instancia MV e insere o String da proxima pagina
		UsuarioDAO dao = new UsuarioDAO();
		try{
			//cria DAO para validar usuario, se der certo...
			if(dao.existeUsuario(usuario)){
				usuario=dao.buscaUsuario(usuario.getLogin(),usuario.getSenha());
				if(usuario.getTipo().equals("funcionario")){
					mv.setViewName("login");	
					return mv;
				}
				session.setAttribute("usuarioLogado", usuario);		//insere na sessao o objeto usuario
				mv.addObject("usuario", usuario);	//insere dados
				
				return mv;		//vai para proxima pagina
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//se nao der certo volta pro login
		mv.setViewName("login");	
		return mv;
	}
	
	
}
