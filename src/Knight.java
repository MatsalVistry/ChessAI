
public class Knight extends Piece
{
	private int r;
	private int c;
	private boolean alive;
	private int color;
	private int type ;
	private boolean hasMoved;
	private int weight;
	
	public Knight(int r, int c, int color, boolean alive, int type, boolean hasMoved)
	{
		super(r,c,color, alive, type, hasMoved,30);
		this.r = r;
		this.c = c;
		this.color = color;
		this.alive = true;
		this.type = type;
		this.hasMoved=hasMoved;
		weight = 30;

	}
	public void setRow(int x)
	{
		r=x;
	}
	public void setCol(int y)
	{
		c=y;
	}
	public int getType()
	{
		return type;
	}
	public boolean[][] getAvailableMoves(Piece[][] board)
	{
		boolean[][] arr = new boolean[8][8];
		for(int x=0;x<8;x++)
		{
			for(int y=0; y<8; y++)
			{
				arr[x][y]= false;
			}
		}
		if(color==0)
		{
			if(r+2<8 && c+1<8 && (board[r+2][c+1]==null || board[r+2][c+1].getColor()!=0))
				arr[r+2][c+1]=true;
			if(r+1<8 && c+2<8 && (board[r+1][c+2]==null || board[r+1][c+2].getColor()!=0))
				arr[r+1][c+2]=true;
			if(r+2<8 && c-1>=0 && (board[r+2][c-1]==null || board[r+2][c-1].getColor()!=0))
				arr[r+2][c-1]=true;
			if(r+1<8 && c-2>=0 && (board[r+1][c-2]==null || board[r+1][c-2].getColor()!=0))
				arr[r+1][c-2]=true;
			if(r-1>=0 && c+2<8 && (board[r-1][c+2]==null || board[r-1][c+2].getColor()!=0))
				arr[r-1][c+2]=true;
			if(r-1>=0 && c-2>=0 && (board[r-1][c-2]==null || board[r-1][c-2].getColor()!=0))
				arr[r-1][c-2]=true;
			if(r-2>=0 && c+1<8 && (board[r-2][c+1]==null || board[r-2][c+1].getColor()!=0))
				arr[r-2][c+1]=true;
			if(r-2>=0 && c-1>=0 && (board[r-2][c-1]==null || board[r-2][c-1].getColor()!=0))
				arr[r-2][c-1]=true;

			
		}
		else if(color==1)
		{
			if(r+2<8 && c+1<8 && (board[r+2][c+1]==null || board[r+2][c+1].getColor()!=1))
				arr[r+2][c+1]=true;
			if(r+1<8 && c+2<8 && (board[r+1][c+2]==null || board[r+1][c+2].getColor()!=1))
				arr[r+1][c+2]=true;
			if(r+2<8 && c-1>=0 && (board[r+2][c-1]==null || board[r+2][c-1].getColor()!=1))
				arr[r+2][c-1]=true;
			if(r+1<8 && c-2>=0 && (board[r+1][c-2]==null || board[r+1][c-2].getColor()!=1))
				arr[r+1][c-2]=true;
			if(r-1>=0 && c+2<8 && (board[r-1][c+2]==null || board[r-1][c+2].getColor()!=1))
				arr[r-1][c+2]=true;
			if(r-1>=0 && c-2>=0 && (board[r-1][c-2]==null || board[r-1][c-2].getColor()!=1))
				arr[r-1][c-2]=true;
			if(r-2>=0 && c+1<8 && (board[r-2][c+1]==null || board[r-2][c+1].getColor()!=1))
				arr[r-2][c+1]=true;
			if(r-2>=0 && c-1>=0 && (board[r-2][c-1]==null || board[r-2][c-1].getColor()!=1))
				arr[r-2][c-1]=true;
		}
		return arr;
	}
	public int getRow()
	{
		return r;
	}
	public int getCol()
	{
		return c;
	}

	public boolean hasMoved() {
		return hasMoved;
	}
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

}
