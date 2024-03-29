package Utils;

import Utils.Usuario;
import Utils.UsuarioSQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Utils.AddUserServlet", urlPatterns = {"/AddUsuario"})
public class AdicionaUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(nome, email, senha, "Cliente");
        UsuarioSQL.inserir(usuario);

        response.sendRedirect("/Login.jsp");
    }
}
