package CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import informacao.Cursos;

public class CursoDAO {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public CursoDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
	}
	
public void cursoCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String curso = request.getParameter("inputCURSO");
	Cursos curso1 = em.find(Cursos.class, curso);
	if(curso1 == null) {
		String nome = request.getParameter("inputNome");
		String valor = request.getParameter("inputVALOR");
		String site = request.getParameter("inputSITE");
		Cursos cur = new Cursos(nome,curso,Float.parseFloat(valor), site);
		em.getTransaction().begin();
		em.persist(cur);
		em.getTransaction().commit();
		response.sendRedirect("index.jsp");
	}
	em.close();
	emf.close();
	}
	
	public void cursoExclusao(HttpServletRequest request, HttpServletResponse response) {
		String curso = request.getParameter("inputCURSO");
		Cursos curso1 = em.find(Cursos.class, curso);
		if(curso1 != null) {
			em.getTransaction().begin();
			em.remove(curso1);
			em.getTransaction().commit();
		}
		em.close();
		emf.close();
	}
	
	public void cursoAlteracao(HttpServletRequest request, HttpServletResponse response) {
		String curso = request.getParameter("inputCURSO");
		Cursos curso1 = em.find(Cursos.class, curso);
		if(curso1 != null) {
			String nome = request.getParameter("inputNome");
			String valor = request.getParameter("inputVALOR");
			String site = request.getParameter("inputSITE");
			curso1.setNome(nome);
			curso1.setSite(site);
			curso1.setValor(Float.parseFloat(valor));
			em.getTransaction().begin();
			em.merge(curso1);
			em.getTransaction().commit();
		}
		em.close();
		emf.close();
	}
	
	public void cursoConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String curso = request.getParameter("inputCURSO");
		Cursos curso1 = em.find(Cursos.class, curso);
		if(curso1 != null) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('"+curso1.toString()+"');");
			out.println("location='/ProjetoWEB/clientes/index.jsp';");
			out.println("</script>");
			out.close();
		}
		em.close();
		emf.close();
	}
}
