package controllers;

import io.javalin.Javalin;
import models.GameBoard;
import models.Player;

import java.io.IOException;
import java.util.Queue;
import org.eclipse.jetty.websocket.api.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;

class PlayGame {

	private static final int PORT_NUMBER = 8080;

	private static Javalin app;

	private static GameBoard gameBoard;
	
	private static Gson gson;
	
	private static Logger logger = LoggerFactory.getLogger(PlayGame.class);
	
	/**
	 * Main method of the application.
	 * 
	 * @param args Command line arguments
	 */
	public static void main(final String[] args) {
		TicTacToeService ticTacToeService = new TicTacToeService();

		app = Javalin.create(config -> {
			config.addStaticFiles("/public");
		}).start(PORT_NUMBER);

		// Test Echo Server
		app.post("/echo", ctx -> {
			ctx.result(ctx.body());
		});
		// add some endpoints here
		// new game
		app.get("/newgame", ctx -> {
			logger.info("start a new game, please wait...");
			ctx.redirect("tictactoe.html");
		});
		// start the game
		app.post("/startgame", ctx -> {
			logger.info("start the game, please wait for another players to join in");
			ticTacToeService.startGame(ctx);
		});
		// Player2 join the game
		app.post("/joingame", ctx -> {
			logger.info("player2 joins in the game");
			ticTacToeService.joinGame(ctx);
		});
		
		
		
		// Web sockets - DO NOT DELETE or CHANGE
		app.ws("/gameboard", new UiWebSocket());
	}

	/**
	 * Send message to all players.
	 * 
	 * @param gameBoardJson Gameboard JSON
	 * @throws IOException Websocket message send IO Exception
	 */
	private static void sendGameBoardToAllPlayers(final String gameBoardJson) {
		Queue<Session> sessions = UiWebSocket.getSessions();
		for (Session sessionPlayer : sessions) {
			try {
				sessionPlayer.getRemote().sendString(gameBoardJson);
			} catch (IOException e) {
				// Add logger here
			}
		}
	}

	public static void stop() {
		app.stop();
	}
}
