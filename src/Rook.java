
public class Rook extends Piece
{
	private int r;
	private int c;
	private boolean alive;
	private int color;
	private int type;
	private boolean hasMoved;

	
	public Rook(int r, int c, int color, boolean alive, int type, boolean hasMoved)
	{
		super(r,c,color, alive, type, hasMoved);
		this.r = r;
		this.c = c;
		this.color = color;
		this.alive = true;
		this.type = type;
		this.hasMoved=hasMoved;

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
				if(r+x<8 && board[r+x][c]!=null && board[r+x][c].getColor()!=0)
				{
					arr[r+x][c]=true;
					break;
				}
				if(r+x<8 && board[r+x][c]!=null && board[r+x][c].getColor()==0)
				{
					break;
				}
				if(r+x<8 && board[r+x][c]==null)
					arr[r+x][c]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r-x>=0 && board[r-x][c]!=null && board[r-x][c].getColor()!=0)
				{
					arr[r-x][c]=true;
					break;
				}
				if(r-x>=0 && board[r-x][c]!=null && board[r-x][c].getColor()==0)
				{
					break;
				}
				if(r-x>=0 && board[r-x][c]==null)
					arr[r-x][c]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(c+x<8 && board[r][c+x]!=null && board[r][c+x].getColor()!=0)
				{
					arr[r][c+x]=true;
					break;
				}
				if(c+x<8 && board[r][c+x]!=null && board[r][c+x].getColor()==0)
				{
					break;
				}
				if(c+x<8 && board[r][c+x]==null)
					arr[r][c+x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(c-x>=0 && board[r][c-x]!=null && board[r][c-x].getColor()!=0)
				{
					arr[r][c-x]=true;
					break;
				}
				if(c-x>=0 && board[r][c-x]!=null && board[r][c-x].getColor()==0)
				{
					break;
				}
				if(c-x>=0 && board[r][c-x]==null)
					arr[r][c-x]=true;
			}
		}
		
		if(color==1)
		{
			for(int x=1;x<8;x++)
			{
				if(r+x<8 && board[r+x][c]!=null && board[r+x][c].getColor()!=1)
				{
					arr[r+x][c]=true;
					break;
				}
				if(r+x<8 && board[r+x][c]!=null && board[r+x][c].getColor()==1)
				{
					break;
				}
				if(r+x<8 && board[r+x][c]==null)
					arr[r+x][c]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(r-x>=0 && board[r-x][c]!=null && board[r-x][c].getColor()!=1)
				{
					arr[r-x][c]=true;
					break;
				}
				if(r-x>=0 && board[r-x][c]!=null && board[r-x][c].getColor()==1)
				{
					break;
				}
				if(r-x>=0 && board[r-x][c]==null)
					arr[r-x][c]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(c+x<8 && board[r][c+x]!=null && board[r][c+x].getColor()!=1)
				{
					arr[r][c+x]=true;
					break;
				}
				if(c+x<8 && board[r][c+x]!=null && board[r][c+x].getColor()==1)
				{
					break;
				}
				if(c+x<8 && board[r][c+x]==null)
					arr[r][c+x]=true;
			}
			for(int x=1;x<8;x++)
			{
				if(c-x>=0 && board[r][c-x]!=null && board[r][c-x].getColor()!=1)
				{
					arr[r][c-x]=true;
					break;
				}
				if(c-x>=0 && board[r][c-x]!=null && board[r][c-x].getColor()==1)
				{
					break;
				}
				if(c-x>=0 && board[r][c-x]==null)
					arr[r][c-x]=true;
			}
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

	public boolean hasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
