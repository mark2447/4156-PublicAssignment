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
	
	public Context startGame(Context ctx) {
		logger.info("player 1 comes in...");
		//parse the requestType: 'X'or'O'
		char requestTypeP1 = ctx.body().charAt(typeIndex);
		if (requestTypeP1 != 'X' && requestTypeP1 != 'O') {
			throw new BadRequestResponse("Type should be 'X' OR 'O'");
		}
		Player p1 = new Player(requestTypeP1, 1);
		gameBoard.setPlayer1(p1);
		Player p2 = new Player(requestTypeP1 == 'X'? 'O' : 'X', 2);
		ctx.result(gson.toJson(gameBoard));
		ctx.status(200);
		return ctx;
	}
}
