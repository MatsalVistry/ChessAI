
public class StandByPiece extends Piece
{
    private int r;
    private int c;
    private boolean alive;
    private int color;
    private int type ;
    private boolean hasMoved;
    private int weight;

    public StandByPiece(int r, int c, int color, boolean alive, int type, boolean hasMoved)
    {
        super(r,c,color, alive,type, hasMoved,0);
        this.r = r;
        this.c = c;
        this.color = color;
        this.alive = true;
        this.type = type;
        this.hasMoved=hasMoved();
        weight = 0;
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
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

}
