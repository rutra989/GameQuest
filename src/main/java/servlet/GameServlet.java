package servlet;

import model.GameState;
import repository.JsonQuestRepository;
import repository.QuestRepository;
import service.GameProcess;
import service.GameResult;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    QuestRepository questRepository;
    GameProcess gameProcess = new GameProcess();

    @Override
    public void init() throws ServletException {
        super.init();
        String path = getServletContext().getRealPath("/WEB-INF/data/quest.json"); // получаю истинный путь к файлу
        try {
            questRepository = new JsonQuestRepository(path);
        } catch (IOException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        GameState gameState;
        ObjectMapper objectMapper = new ObjectMapper();
        if (session != null) {
            // достаю нужный объект из сессии
            gameState = (GameState) session.getAttribute("gameState");
            if (gameState != null) {
                // устанавливаю тип контекста и кодировку на отправку клиенту
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                // отправляю ответ клиенту нужного объекта по номеру id
                objectMapper.writeValue(resp.getWriter(), questRepository.findById(gameState.getCurrentStepId()));
            } else {
                resp.sendRedirect("/start");
            }
        } else {
            resp.sendRedirect("/start");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        ObjectMapper mapper = new ObjectMapper();
        int stepId = Integer.parseInt(req.getParameter("nextStepId"));
        GameState gameState = (GameState) session.getAttribute("gameState");
        if ((gameState.getCurrentStepId() == 0 || gameState.getCurrentStepId() == 99) && stepId == 1) {
            session.invalidate();
            resp.sendRedirect("/start");
        } else {
            gameState.setCurrentStepId(stepId);
            session.setAttribute("gameState", gameState);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            mapper.writeValue(resp.getWriter(), questRepository.findById(gameState.getCurrentStepId()));

        }
    }
}
