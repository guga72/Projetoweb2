package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CRUD.ClienteDAO;
import CRUD.CursoDAO;
import CRUD.PagamentoDAO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String form = request.getParameter("formulario");
		
		if (form.contains("cli")) {
			ClienteDAO cli = new ClienteDAO();
			if (form.equals("clirem"))
				cli.clienteExclusao(request, response);
			else
				if (form.equals("cliadd"))
					cli.clienteCadastro(request, response);
				else
					if (form.equals("clialt"))
						cli.clienteAlteracao(request, response);
					else
						if (form.equals("clicon"))
							cli.clienteConsulta(request, response);
		} else {
			if (form.contains("cur")) {
				CursoDAO cur = new CursoDAO();
				if (form.equals("currem"))
					cur.cursoExclusao(request, response);
				else
					if (form.equals("curadd"))
						cur.cursoCadastro(request, response);
					else
						if (form.equals("curalt"))
							cur.cursoAlteracao(request, response);
						else
							if (form.equals("curcon"))
								cur.cursoConsulta(request, response);
			} else {
				if (form.contains("pag")) {
					PagamentoDAO pag = new PagamentoDAO();
					if (form.equals("pagrem"))
						pag.pagamentoExclusao(request, response);
					else
						if (form.equals("pagadd"))
							pag.pagamentoCadastro(request, response);
						else
							if (form.equals("pagalt"))
								pag.pagamentoAlteracao(request, response);
							else
								if (form.equals("pagcon"))
									pag.pagamentoConsulta(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
