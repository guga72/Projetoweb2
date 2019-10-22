package CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import informacao.Pagamentos;

public class PagamentoDAO {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public PagamentoDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
	}

	public void pagamentoCadastro(HttpServletRequest request, HttpServletResponse response) {
		String cpf = request.getParameter("inputEmail3");
		Pagamentos pag = em.find(Pagamentos.class, cpf);
		if(pag == null) {
			String curso = request.getParameter("inputCURSO");
			String data_insc = request.getParameter("inputDATA");
			Pagamentos pagamento = new Pagamentos(cpf, curso,data_insc);
			pagamento.setCurso(curso);
			pagamento.setData_insc(data_insc);
			em.getTransaction().begin();
			em.persist(pagamento);
			em.getTransaction().commit();
		}
	}

	public void pagamentoExclusao(HttpServletRequest request, HttpServletResponse response) {
		String cpf = request.getParameter("inputEmail3");
		Pagamentos pag = em.find(Pagamentos.class, cpf);
		if(pag != null) {
			em.getTransaction().begin();
			em.remove(pag);
			em.getTransaction().commit();
		}
	}

	public void pagamentoAlteracao(HttpServletRequest request, HttpServletResponse response) {
		String cpf = request.getParameter("inputEmail3");
		Pagamentos pag = em.find(Pagamentos.class, cpf);
		if(pag != null) {
			String curso = request.getParameter("inputCURSO");
			String data_insc = request.getParameter("inputDATA");
			pag.setCurso(curso);
			pag.setData_insc(data_insc);
			em.getTransaction().begin();
			em.merge(pag);
			em.getTransaction().commit();
		}
	}

	public void pagamentoConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cpf = request.getParameter("inputEmail3");
		Pagamentos pag = em.find(Pagamentos.class, cpf);
		if(pag != null) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+pag.toString()+"');");
			out.println("location='/ProjetoWEB/clientes/index.jsp';");
			out.println("</script>");
			out.close();
		}
	}
}
