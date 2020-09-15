package models;

public class GameBoard {

  private Player p1;

  private Player p2;

  private boolean gameStarted;

  private int turn;

  private char[][] boardState;

  private int winner;

  private boolean isDraw;
  
  //empty constructor
  public GameBoard() {
	  this.p1 = null;
	  this.p2 = null;
	  this.gameStarted = false;
	  this.turn = 1;
	  this.boardState = new char[3][3];
	  this.winner = 1;
	  this.isDraw = false;
  }
  
  public void setPlayer1(Player p1) {
	  this.p1 = p1;
  }
  
  public Player getPlayer1() {
	  return this.p1;
  }
  
  public void setPlayer2(Player p2) {
	  this.p2 = p2;
  }
  
  public Player getPlayer2() {
	  return this.p2;
  }
  
  
}
