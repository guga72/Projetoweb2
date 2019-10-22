package CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import informacao.Cliente;

public class ClienteDAO {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public ClienteDAO() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojavirtual");
		EntityManager em = emf.createEntityManager();
	}

	public void clienteCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cpf = request.getParameter("inputEmail3");
		Cliente cli = em.find(Cliente.class, cpf);
		if (cli == null) {
			String nome = request.getParameter("inputNome");
			String email = request.getParameter("inputEMAIL");
			Cliente c = new Cliente(cpf, nome, email);
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			response.sendRedirect("index.jsp");
		}
		em.close();
		emf.close();
	}

	public void clienteExclusao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cpf = request.getParameter("inputEmail3");
		Cliente cli = em.find(Cliente.class, cpf);
		if (cli != null) {
			em.getTransaction().begin();
			em.remove(cli);
			em.getTransaction().commit();
			response.sendRedirect("index.jsp");
		}
		em.close();
		emf.close();
	}

	public void clienteAlteracao(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cpf = request.getParameter("inputEmail3");
		Cliente cli = em.find(Cliente.class, cpf);
		if (cli != null) {
			if (cli.getCpf().equals(cpf)) {
				String email = request.getParameter("inputEMAIL");
				String nome = request.getParameter("inputNome");
				cli.setEmail(email);
				cli.setNome(nome);
				em.getTransaction().begin();
				em.merge(cli);
				em.getTransaction().commit();
				response.sendRedirect("index.jsp");
			}
			em.close();
			emf.close();
		}
	}

	public void clienteConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cpf = request.getParameter("inputEmail3");
		Cliente cli = em.find(Cliente.class, cpf);
		if (cli != null) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + cli.toString() + "');");
			out.println("location='/ProjetoWEB/clientes/index.jsp';");
			out.println("</script>");
			out.close();

		}
		em.close();
		emf.close();
	}
}
