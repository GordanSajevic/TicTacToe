public class TicTacToeLogic {

	
	private int[][] table;
	private int numEmptyFields;
	private String winner;
	private boolean player;
	private boolean gameOver;
	
	public TicTacToeLogic(int size)
	{
		this.table = new int[size][size];
		initTable();
		this.numEmptyFields = -1;
		this.winner = "Tie";
		this.player = true;
		this.gameOver = false;
		
	}

	private void initTable() 
	{
		for (int i=0; i<table.length; i++)
		{
			for (int j=0; j<table[i].length; j++)
			{
				table[i][j] = -1;
			}
		}
		
	}
	
	public boolean setCell(int x, int y)
	{
		if (x < 0 || x >= table.length || y < 0 || y >= table.length)
		{
			throw new IndexOutOfBoundsException();	
		}
		if (table[x][y] != -1)
		{
			throw new IllegalArgumentException("This field is alredy used!");
		}
		if (player)
		{
			table[x][y] = 1;
		}
		else
		{
			table[x][y] = 2;
		}
		
		numEmptyFields--;
		player= !player;
		gameOver = isOver();
		return gameOver;
	}

	private boolean isOver() 
	{
		if (numEmptyFields == 0)
		{
			return true;
		}
		
		if (checkRows() == true)
		{
			return true;
		}
		
		if (checkColumns() == true)
		{
			return true;
		}
		
		if (checkDiagonals() == true)
		{
			return true;
		}
		return false;
	}

	private boolean checkDiagonals() {
		//First diagonal
		for (int i=1; i<table.length; i++)
		{
			for (int j=1; j<table[i].length; j++)
			{
				if (i == j)
				{
					if (table[i][j] != table[i-1][j-1])
					{
						return false;
					}
				}
			}
		}
		//Second diagonal
		for (int i=0; i<table.length; i++)
		{
			for (int j=table.length-1; j>0; j--)
			{
				if (table[i][j] != table[i-1][j+1])
				{
					return false;
				}
			}
		}
		setWinner(table[table.length/2][table[0].length/2]);
		return true;
	}

	private boolean checkColumns() {
		for (int i=0; i<table[0].length; i++)
		{
			if (checkColumn(i) == true)
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkColumn(int index) {
		if (table[0][index] == -1)
		{
			return false;
		}
		
		for (int i=1; i<table[0].length; i++)
		{
			if (table[i][index] != table[i-1][index])
			{
				return false;
			}
		}
		setWinner(table[0][index]);
		return true;
	}

	private void setWinner() {
		// TODO Auto-generated method stub
		
	}
	
	private boolean checkRows() {
		for (int i=0; i<table.length; i++)
		{
			if (checkRow(i) == true)
			{
				return true;
			}
		}
		return false;
	}

	private boolean checkRow(int index) {
		if (table[index][0] == -1)
		{
			return false;
		}
		for (int i=1; i<table.length; i++)
		{
			if (table[index][i] != table[index][i-1])
			{
				return false;
			}
		}
		setWinner(table[index][0]);
		return true;
	}
	
	public String getWinner()
	{
		return winner;
	}
	
	public boolean getGameOver()
	{
		return gameOver;
	}
	
	
	private void setWinner(int cellValue){
		if( cellValue == 1)
		{
			winner = "First Player";
		}
		else
		{
			winner = "Second Player";
		}
	}
	
}
