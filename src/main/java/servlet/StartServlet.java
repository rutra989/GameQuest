package servlet;

import model.GameState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/start.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        GameState gameState = new GameState(); // создаем объект GameState, в котором будем инициализировать внутренние переменные
        gameState.setPlayerName(req.getParameter("username")); // инициализируем имя пользователя введенное в поле для ввода из html
        gameState.setPlayerId(new Random().nextInt(10000)); // рандомно создаем номер id и присваиваем его пользователю
        gameState.setCurrentStepId(1); // обновляем номер локации, с которой пользователь начнет квест
        session.setAttribute("gameState",gameState); // сохраняем сессия
        resp.sendRedirect("/game.html"); // редирект на страницу квеста
    }
}
