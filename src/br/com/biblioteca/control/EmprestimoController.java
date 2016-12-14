package br.com.biblioteca.control;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Item;
import br.com.biblioteca.model.ItemSolicitacao;
import br.com.biblioteca.model.Usuario;
@Controller
@SessionAttributes({"usuarioLogado"})
public class EmprestimoController {
	@RequestMapping("novaSolicitacao")
	public String novaSolicitacao(){
		return "usuario/emprestimo";
	}
	@RequestMapping("confirmaEmprestimo")
	public ModelAndView confirmaEmprestimo(ItemSolicitacao is, HttpServletRequest req){
		ModelAndView mv = new ModelAndView("usuario/confirmar");
		Emprestimo emprestimo=new Emprestimo();
		Item item = new Item();
		item.setId(is.getId_item());
		item.setDisponivel(is.isStatus());
		item.setTipo(is.getTipoLivro());
		emprestimo.setItem(item);
		Usuario usuario = new Usuario();
		usuario.setId(is.getId_usuario());
		emprestimo.setUsuario(usuario);
		EmprestimoDAO dao = new EmprestimoDAO();
		Usuario u = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(u.getTipo().equals("estudante") && item.getTipo().equals("especial")){
			mv.setViewName("usuario/restricao/nao-professor");
			return mv;
		}
		if(dao.limiteEmprestimo(emprestimo, u)){
			mv.setViewName("usuario/restricao/item-limite");
			return mv;
		}
		dao.solicitacao(emprestimo,u);
		mv.addObject("emprestimo",emprestimo);
		return mv;
	}
	@RequestMapping("meusEmprestimos")
	public ModelAndView mostrarEmprestimos(HttpServletRequest req){
		ModelAndView mv = new ModelAndView("usuario/meus-livros");
		EmprestimoDAO dao=new EmprestimoDAO();
		Usuario u = (Usuario) req.getSession().getAttribute("usuarioLogado");
		long id = u.getId();
		List<Emprestimo> emprestimos=dao.consultarMinhaLista(id);
		mv.addObject("emprestimo",emprestimos);
		return mv;
	}
	@RequestMapping("listaEmprestimo")
	public ModelAndView listarEmprestimo(){
		ModelAndView mv = new ModelAndView("usuario/adm/lista-solicitacao");
		EmprestimoDAO dao = new EmprestimoDAO();
		List<Emprestimo> emprestimos=dao.consultarEmprestimo();
		mv.addObject("emprestimo",emprestimos);
		return mv;
	}
	@RequestMapping("validarSolicitacao")
	public String validarSolicitacao(Emprestimo e){
		EmprestimoDAO dao = new EmprestimoDAO();
		dao.validaSolicitacao(e);
		System.out.println("validado!");
		return "redirect:listaEmprestimo";
	}
	@RequestMapping("registrarDevolucao")
	public String registrarDevolucao(Emprestimo e){
		EmprestimoDAO dao = new EmprestimoDAO();
		dao.registraDevolucao(e);
		System.out.println("A devolucao foi registrada!");
		return "redirect:listaEmprestimo";
	}
}
