package Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/Authentication")
public class Authentication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = UsuarioSQL.buscar(email);

        if(email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
            Cookie cookieUser = new Cookie(usuario.getNome(), usuario.getEmail());
            response.addCookie(cookieUser);
            HttpSession session = request.getSession(true);
            response.sendRedirect("/ListaProdutos.jsp?tipo="+usuario.getTipo());

//            if(usuario.getTipo().equals("Cliente")){
//                response.sendRedirect("/ListaProdutos.jsp?tipo=Cliente");
//            } else {
//                response.sendRedirect("/ListaProdutos.jsp?tipo=Lojista");
//            }
        } else {
            response.sendRedirect("/Login.jsp");
        }


    }
}
