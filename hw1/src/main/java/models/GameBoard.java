package models;

public class GameBoard {

  private Player p1;

  private Player p2;

  private boolean gameStarted;

  private int turn;

  private char[][] boardState;

  private int winner;

  private boolean isDraw;
  
  private int moveCount;
  
  //empty constructor
  public GameBoard() {
	  this.p1 = null;
	  this.p2 = null;
	  this.gameStarted = false;
	  this.turn = 1;
	  this.boardState = new char[3][3];
	  this.winner = 0;
	  this.isDraw = false;
	  this.moveCount = 0;
  }
  
  public void setPlayer1(Player p1) {
	  this.p1 = p1;
  }
  
  public Player getPlayer1() {
	  return p1;
  }
  
  public void setPlayer2(Player p2) {
	  this.p2 = p2;
  }
  
  public Player getPlayer2() {
	  return p2;
  }
  
  public void setGameStarted(boolean gameStarted) {
	  this.gameStarted = gameStarted;
  }
  
  public boolean getGameStarted() {
	  return this.gameStarted;
  }
  
  public void setTurn(int turn) {
	  this.turn = turn;
  }
  
  public int getTurn() {
	  return this.turn;
  }
  
  public void setBoardState(char[][] boardState) {
	  this.boardState = boardState;
  }
  
  public char[][] getBoardState() {
	  return this.boardState;
  }
  
  public void setWinner(int winner) {
	  this.winner = winner;
  }
  
  public int getWinner() {
	  return this.winner;
  }
  
  public void setIsDraw(boolean isDraw) {
	  this.isDraw = isDraw;
  }
  
  public boolean getIsDraw() {
	  return this.isDraw;
  }
  
  public boolean isFull() {
	  return false;
  }
  
  public void setMoveCount(int count) {
	  this.moveCount = count;
  }
  
  public int getMoveCount() {
	  return moveCount;
  }
}


