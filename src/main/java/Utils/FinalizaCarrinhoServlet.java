package Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "FinalizaCarrinhoServlet", urlPatterns = {"/FinalizaCarrinhoServlet"})
public class FinalizaCarrinhoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        Carrinho c = (Carrinho) s.getAttribute("carrinho");

        c.finalizarCarrinho();

        s.setAttribute("carrinho", c);

        response.sendRedirect("/ListaProdutos.jsp");
    }
}
