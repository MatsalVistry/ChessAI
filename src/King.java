
public class King extends Piece
{
	private int r;
	private int c;
	private boolean alive;
	private int color;
	private int type ;
	private boolean hasMoved;
	private int weight;

	
	public King(int r, int c, int color, boolean alive, int type, boolean hasMoved)
	{
		super(r,c,color, alive,type, hasMoved, 900);
		this.r = r;
		this.c = c;
		this.color = color;
		this.alive = true;
		this.type = type;
		this.hasMoved=hasMoved;
		weight=900;

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
			if(r+1<8 && (board[r+1][c]==null || board[r+1][c].getColor()!=0))
				arr[r+1][c]=true;
			if(c+1<8 && (board[r][c+1]==null || board[r][c+1].getColor()!=0))
				arr[r][c+1]=true;
			if(r-1>=0 && (board[r-1][c]==null || board[r-1][c].getColor()!=0))
				arr[r-1][c]=true;
			if(c-1>=0 && (board[r][c-1]==null || board[r][c-1].getColor()!=0))
				arr[r][c-1]=true;
			if(r+1<8 && c+1<8 && (board[r+1][c+1]==null || board[r+1][c+1].getColor()!=0))
				arr[r+1][c+1]=true;
			if(r-1>=0 && c-1>=0 && (board[r-1][c-1]==null || board[r-1][c-1].getColor()!=0))
				arr[r-1][c-1]=true;
			if(r-1>=0 && c+1<8 && (board[r-1][c+1]==null || board[r-1][c+1].getColor()!=0))
				arr[r-1][c+1]=true;
			if(r+1<8 && c-1>=0 && (board[r+1][c-1]==null || board[r+1][c-1].getColor()!=0))
				arr[r+1][c-1]=true;
			if(hasMoved==false && board[0][0]!=null && board[0][1]==null && board[0][2]==null  && board[0][3]==null && board[0][0].getType()==2 && board[0][0].hasMoved()==false)
				arr[0][2]=true;
			if(hasMoved==false && board[0][7]!=null && board[0][5]==null && board[0][6]==null  && board[0][7].getType()==2 && board[0][7].hasMoved()==false)
				arr[0][6]=true;
			
		}
		else if(color==1)
		{
			if(r+1<8 && (board[r+1][c]==null || board[r+1][c].getColor()!=1))
				arr[r+1][c]=true;
			if(c+1<8 && (board[r][c+1]==null || board[r][c+1].getColor()!=1))
				arr[r][c+1]=true;
			if(r-1>=0 && (board[r-1][c]==null || board[r-1][c].getColor()!=1))
				arr[r-1][c]=true;
			if(c-1>=0 && (board[r][c-1]==null || board[r][c-1].getColor()!=1))
				arr[r][c-1]=true;
			if(r+1<8 && c+1<8 && (board[r+1][c+1]==null|| board[r+1][c+1].getColor()!=1))
				arr[r+1][c+1]=true;
			if(r-1>=0 && c-1>=0 && (board[r-1][c-1]==null || board[r-1][c-1].getColor()!=1))
				arr[r-1][c-1]=true;
			if(r-1>=0 && c+1<8 && (board[r-1][c+1]==null|| board[r-1][c+1].getColor()!=1))
				arr[r-1][c+1]=true;
			if(r+1<8 && c-1>=0 && (board[r+1][c-1]==null|| board[r+1][c-1].getColor()!=1))
				arr[r+1][c-1]=true;
			if(hasMoved==false && board[7][0]!=null && board[7][1]==null && board[7][2]==null  && board[7][0].getType()==2 && board[7][0].hasMoved()==false)
				arr[7][1]=true;
			if(hasMoved==false && board[7][7]!=null && board[7][4]==null && board[7][5]==null  && board[7][6]==null && board[7][7].getType()==2 && board[7][7].hasMoved()==false)
				arr[7][5]=true;
			
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
