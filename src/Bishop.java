
public class Bishop extends Piece
{
	private int r;
	private int c;
	private boolean alive;
	private int color;
	private int type ;

	
	public Bishop(int r, int c, int color, boolean alive, int type)
	{
		super(r,c,color, alive, type);
		this.r = r;
		this.c = c;
		this.color = color;
		this.alive = true;
		this.type = type;

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
			for(int x=1;x<8;x++)
			{
				if(r+x<8 && c+x<8 && board[r+x][c+x]!=null && board[r+x][c+x].getColor()!=0)
				{
					arr[r+x][c+x]=true;
					break;
				}
				if(r+x<8 && c+x<8 && board[r+x][c+x]!=null && board[r+x][c+x].getColor()==0)
				{
					break;
				}
				if(r+x<8 && c+x<8 && board[r+x][c+x]==null)
					arr[r+x][c+x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r-x>=0 && c-x>=0 && board[r-x][c-x]!=null && board[r-x][c-x].getColor()!=0)
				{
					arr[r-x][c-x]=true;
					break;
				}
				if(r-x>=0 && c-x>=0 && board[r-x][c-x]!=null && board[r-x][c-x].getColor()==0)
				{
					break;
				}
				if(r-x>=0 && c-x>=0 && board[r-x][c-x]==null)
					arr[r-x][c-x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r+x<8 && c-x>=0 && board[r+x][c-x]!=null && board[r+x][c-x].getColor()!=0)
				{
					arr[r+x][c-x]=true;
					break;
				}
				if(r+x<8 && c-x>=0 && board[r+x][c-x]!=null && board[r+x][c-x].getColor()==0)
				{
					break;
				}
				if(r+x<8 && c-x>=0 && board[r+x][c-x]==null)
					arr[r+x][c-x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r-x>=0 && c+x<8 && board[r-x][c+x]!=null && board[r-x][c+x].getColor()!=0)
				{
					arr[r-x][c+x]=true;
					break;
				}
				if(r-x>=0 && c+x<8 && board[r-x][c+x]!=null && board[r-x][c+x].getColor()==0)
				{
					break;
				}
				if(r-x>=0 && c+x<8 && board[r-x][c+x]==null)
					arr[r-x][c+x]=true;
			}
			
		}
		else if(color==1)
		{
			for(int x=1;x<8;x++)
			{
				if(r+x<8 && c+x<8 && board[r+x][c+x]!=null && board[r+x][c+x].getColor()!=1)
				{
					arr[r+x][c+x]=true;
					break;
				}
				if(r+x<8 && c+x<8 && board[r+x][c+x]!=null && board[r+x][c+x].getColor()==1)
				{
					break;
				}
				if(r+x<8 && c+x<8 && board[r+x][c+x]==null)
					arr[r+x][c+x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r-x>=0 && c-x>=0 && board[r-x][c-x]!=null && board[r-x][c-x].getColor()!=1)
				{
					arr[r-x][c-x]=true;
					break;
				}
				if(r-x>=0 && c-x>=0 && board[r-x][c-x]!=null && board[r-x][c-x].getColor()==1)
				{
					break;
				}
				if(r-x>=0 && c-x>=0 && board[r-x][c-x]==null)
					arr[r-x][c-x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r+x<8 && c-x>=0 && board[r+x][c-x]!=null && board[r+x][c-x].getColor()!=1)
				{
					arr[r+x][c-x]=true;
					break;
				}
				if(r+x<8 && c-x>=0 && board[r+x][c-x]!=null && board[r+x][c-x].getColor()==1)
				{
					break;
				}
				if(r+x<8 && c-x>=0 && board[r+x][c-x]==null)
					arr[r+x][c-x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r-x>=0 && c+x<8 && board[r-x][c+x]!=null && board[r-x][c+x].getColor()!=1)
				{
					arr[r-x][c+x]=true;
					break;
				}
				if(r-x>=0 && c+x<8 && board[r-x][c+x]!=null && board[r-x][c+x].getColor()==1)
				{
					break;
				}
				if(r-x>=0 && c+x<8 && board[r-x][c+x]==null)
					arr[r-x][c+x]=true;
			}
			
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

}
