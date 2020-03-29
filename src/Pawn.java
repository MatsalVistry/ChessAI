
public class Pawn extends Piece
{
	private int r;
	private int c;
	private boolean alive;
	private int color;
	private int type ;
	
	public Pawn(int r, int c, int color, boolean alive, int type)
	{
		super(r,c,color, alive,type);
		this.r = r;
		this.c = c;
		this.color = color;
		this.alive = true;
		this.type = type;
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
			if(r+1<8 && board[r+1][c]==null)
				arr[r+1][c]=true;
			if(r==1 && board[r+2][c]==null)
				arr[r+2][c]=true;
			if(r+1<8 && c+1<8 && board[r+1][c+1]!=null && board[r+1][c+1].getColor()!=0)
				arr[r+1][c+1]=true;
			if(r+1<8 && c-1>=0 && board[r+1][c-1]!=null && board[r+1][c-1].getColor()!=0)
				arr[r+1][c-1]=true;
			
		}
		else if(color==1)
		{
			if(r-1>0 && board[r-1][c]==null)
				arr[r-1][c]=true;
			if(r==6 && board[r-2][c]==null)
				arr[r-2][c]=true;
			if(r-1>=0 && c+1<8 && board[r-1][c+1]!=null && board[r-1][c+1].getColor()!=1)
				arr[r-1][c+1]=true;
			if(r-1>=0 && c-1>=0 && board[r-1][c-1]!=null && board[r-1][c-1].getColor()!=1)
				arr[r-1][c-1]=true;
			
		}
		return arr;
	}
	public void setRow(int x)
	{
		r=x;
	}
	public void setCol(int y)
	{
		c=y;
	}
	public int getRow()
	{
		return r;
	}
	public int getCol()
	{
		return c;
	}

}
