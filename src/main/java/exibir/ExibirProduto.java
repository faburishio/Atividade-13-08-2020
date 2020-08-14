package exibir;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

import com.google.gson.Gson;

import dao.ProdutoDao;
import model.Produto;

public class ExibirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String idProduto = req.getParameter("idProduto");
        try {
            ProdutoDao dao = new ProdutoDao();
            List<Produto> lstProd = dao.pesquisar();
            System.out.println("ok");
            for (Produto p : lstProd) {
                if (p.getIdProduto() == Integer.parseInt(idProduto)) {

                    p.getIdProduto();
                    p.getDescricao();
                    p.getQuantidade();
                    p.getValor();

                    PrintWriter saida = resp.getWriter();

                    String produtoJsonStr = new Gson().toJson(p);

                    saida.println(produtoJsonStr);
                    saida.flush();
                    saida.close();
                }
            }

        } catch (SQLException e) {
            System.out.println("<p>Erro " + e.getMessage() + "</p>");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

    }

}
