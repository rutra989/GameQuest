package servlet;

import model.Step;
import repository.JsonQuestLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/game")
public class GameServlet  extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        String path = getServletContext().getRealPath("/WEB-INF/data/quest.json");
        JsonQuestLoader loader = new JsonQuestLoader();
        try {
            List<Step> steps = loader.load(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
