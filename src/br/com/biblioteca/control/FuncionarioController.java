package br.com.biblioteca.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.FuncionarioDAO;
import br.com.biblioteca.dao.UsuarioDAO;
import br.com.biblioteca.model.Item;
import br.com.biblioteca.model.Usuario;

@Controller
public class FuncionarioController {
	private FuncionarioDAO dao;
	
	public FuncionarioController(){
		this.dao=new FuncionarioDAO();
	}
	
	@RequestMapping("menuFuncionario")
	public String irMenu(){
		return "usuario/adm/menu";
	}
	
	@RequestMapping("efetuarLoginAdm")
	public ModelAndView efetuarLogin(Usuario usuario, HttpSession session){
		ModelAndView mv = new ModelAndView("usuario/adm/menu");		//instancia MV e insere o String da proxima pagina
		try{
			//cria DAO para validar usuario, se der certo...
			if(dao.existeFuncionario(usuario)){
				usuario=dao.buscaFuncionario(usuario.getLogin(),usuario.getSenha());
				if(!usuario.getTipo().equals("funcionario")){
					mv.setViewName("loginAdm");	
					return mv;
				}
				session.setAttribute("funcionarioLogado", usuario);//insere na sessao o objeto usuario
				mv.addObject("funcionarioLogado", usuario);	//insere dados
				return mv;		//vai para proxima pagina
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//se nao der certo volta pro login
		mv.setViewName("loginAdm");	
		return mv;
	}
	
	@RequestMapping("novoItem")
	public String novoItem(){
		return "usuario/adm/adicionar";
	}
	
	@RequestMapping("adicionarItem")
	public String adicionarItem(@Valid Item item){
		try{
		dao.adicionarItem(item);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "usuario/adm/sucesso";
	}
}
