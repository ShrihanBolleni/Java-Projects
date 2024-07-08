/**
 * This program simulates a Petri dish by creating a grid of cells, where each cell has a 30% chance of being populated.
 * It then displays the initial state of the grid, updates the grid according to specific rules, and displays the updated state.
 */

public class PetriDishSimulator
{

	public static void main(String args[])
	{
		PetriDish p = new PetriDish();
		p.showGrid();
		p.updateGrid();
		System.out.println("");
		p.showGrid();
	}
}


class PetriDish
{
	private boolean[][] grid;
	/**
     * Constructs a PetriDish object with a randomly generated grid of cells.
     * Each position in the grid has a 30% chance of being populated (true).
     */
    public PetriDish()
    {
        int r=(int)(Math.random()*26+5);
        int c=(int)(Math.random()*26+5);
        grid=new boolean[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int a=(int)(Math.random()*10+1);
                if(a>7)
                grid[i][j]=true;
                else
                grid[i][j]=false;
            }
        }
    }
    
    public int randomRows()
    {
        return ((int)(Math.random()*grid.length));
    }
    
    public int randomCols()
    {
        return ((int)(Math.random()*grid[0].length));
    }

	// Displays the current state of the grid.
	 public void showGrid()
	 {
        for(int r=0;r<grid.length;r++)
        {
            for(int c=0;c<grid[r].length;c++)
            {
                if(grid[r][c]==true)
                System.out.print("O");
                else
                System.out.print(".");
            }
            System.out.print("\n");
        }
	 }

    /**
     * Counts the number of adjacent true elements (neighbors) in the grid for a given cell.
     * @param row The row index of the cell
     * @param col The column index of the cell
     * @return The number of adjacent true elements (neighbors) in the grid
     */
	 public int numNeighbors(int row, int col)
	 {
	    int f=0;
	    for(int r=row-1;r<=row+1;r++)
	    {
	        for(int c=col-1;c<=col+1;c++)
	        {
	            if(r>=0&&c>=0&&r<grid.length&&c<grid[0].length)
	            {
	                if(r!=row||c!=col)
	                {
	                    if(grid[r][c])
	                    f++;
	                }
	            }
	        }
	    }
	    return f;
	 }
	 
	 /**
     * Updates the state of a cell based on specific rules.
     * @param row The row index of the cell
     * @param col The column index of the cell
     * @return The updated state of the cell (true if populated, false otherwise)
     */
	 public boolean updateCell(int row, int col)
	 {
	    int g=numNeighbors(row,col);
	    if(grid[row][col])
	    {
	        if(g==2||g==3)
	        return true;
	        return false;
	    }
	    else
	    {
	        if(g==3)
	        return true;
	        return false;
	    }
	 }
	 
	 // Updates the entire grid based on the rules of the Petri dish simulation.
	 public void updateGrid()
	 {
	     boolean[][] a= new boolean[grid.length][grid[0].length];
	     for(int r=0;r<grid.length;r++)
	     {
	         for(int c=0;c<grid[r].length;c++)
	         {
	             a[r][c]=updateCell(r,c);
	         }
	     }
	     for(int r=0;r<grid.length;r++)
	     {
	         for(int c=0;c<grid[r].length;c++)
	         {
	             grid[r][c]=a[r][c];
	         }
	     }
	 }
}
