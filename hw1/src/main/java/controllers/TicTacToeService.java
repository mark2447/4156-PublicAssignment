package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import models.GameBoard;
import models.Player;

public class TicTacToeService {
	private GameBoard gameBoard;
	
	private static Logger logger = LoggerFactory.getLogger(TicTacToeService.class);
	
	private static final int typeIndex = 5;
	
	private static Gson gson = new GsonBuilder().create();
	
	public TicTacToeService() {
		this.gameBoard = new GameBoard();
	}
	
	public String getGameBoard() {
		return gson.toJson(gameBoard);
	}
	
	public Context startGame(Context ctx) {
		logger.info("call startGame function");
		//parse the requestType: 'X'or'O'
		char requestTypeP1 = ctx.body().charAt(typeIndex);
		if (requestTypeP1 != 'X' && requestTypeP1 != 'O') {
			throw new BadRequestResponse("Type should be 'X' OR 'O'");
		}
		Player p1 = new Player(requestTypeP1, 1);
		gameBoard.setPlayer1(p1);
		Player p2 = new Player(requestTypeP1 == 'X'? 'O' : 'X', 2);
		gameBoard.setPlayer2(p2);
		ctx.result(gson.toJson(gameBoard));
		ctx.status(200);
		return ctx;
	}
	
	public Context joinGame(Context ctx) {
		logger.info("call joinGame function");
		gameBoard.setGameStarted(true);
		ctx.redirect("/tictactoe.html?p=2");
		return ctx;
	}
	
	public Context move(Context ctx) {
		logger.info("call move function");
		String player = ctx.pathParam("player");
//		Move move = new Move();
		return ctx;
	}
}
