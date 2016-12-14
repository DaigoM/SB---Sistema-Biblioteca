package br.com.biblioteca.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.dao.ItemDAO;
import br.com.biblioteca.model.Usuario;

@Controller
public class ItemController {
	@RequestMapping("listaItens")
	public String listaItens(){
		return "redirect:consultarItens";
	}
	
	@RequestMapping("consultarItens")
	public ModelAndView consultarItens(){
		ItemDAO dao = new ItemDAO();
		ModelAndView mv = new ModelAndView("usuario/lista-livros");
		mv.addObject("itens", dao.consultar());
		return mv;
	}

}
