package ex1;

public class Logic
{
    // 行细胞数值、列细胞数值
    private int maxRow,maxCol;
    // 当前代数,繁衍第几代
    private int nowGeneration;
    // 细胞状态：0代表死细胞，1代表活细胞---大小跟ui界面的大小相同，一个元素对应一个按钮细胞
    private int[][] grid;

    // 构造方法
    public Logic(int maxRowNum, int maxColNum)
    {
        // 设置整型输入grid的行列值为ui界面中的值
        this.maxRow = maxRowNum;
        this.maxCol = maxColNum;

        // 代数置0
        nowGeneration = 0;

        // 创建多维数组，使边界处理与中间一致
        grid = new int[maxRow + 2][maxCol + 2];

        // 所有细胞开局全死亡
        for (int i = 0; i <= maxRow + 1; i++)
        {
            for (int j = 0; j <= maxCol + 1; j++)
            {
                grid[i][j] = 0;
            }
        }
    }

    // 设置ui界面按钮对应的数组大小
    public void setGrid(int[][] grid)
    {
        this.grid = grid;
    }

    // 获取ui界面按钮对应的数组大小
    public int[][] getGrid()
    {
        return grid;
    }

    // 设置当前繁衍代数
    public void setNowGeneration(int nowGeneration)
    {
        this.nowGeneration = nowGeneration;
    }

    // 获得当前繁衍代数
    public int getNowGeneration()
    {
        return nowGeneration;
    }

    // 随机初始化细胞,随机初始化部分细胞状态为1
    public void randomCell()
    {
        for (int i = 1; i <= maxRow; i++)
        {
            for (int j = 1; j <= maxCol; j++)
            {
                grid[i][j] = Math.random() > 0.5? 1 : 0;
            }
        }

    }

    // 细胞清零
    public void deleteAllCell()
    {
        for (int i = 1; i <= maxRow; i++)
        {
            for (int j = 1; j <= maxCol; j++)
            {
                // 所有细胞状态为0：死细胞
                grid[i][j] = 0;
            }
        }
    }

    // 获取细胞的邻居数量
    public int getNeighborCount(int row, int col)
    {
        int countNeighbor = 0;

        // 以自己为中心，判断周围八个细胞状态
        for (int i = row - 1; i <= row + 1; i++)
        {
            for (int j = col - 1; j <= col + 1; j++)
            {
                // 判断到自己时，直接跳过
                if(i == row && j == col)
                {
                    continue;
                }
                countNeighbor += grid[i][j]; //如果邻居还活着，邻居的状态为1，邻居数便会+1
                if(countNeighbor==4)
                	break;
            }
            if(countNeighbor==4)
            	break;
        }
        return countNeighbor;
    }

    // 繁衍
    public void update()
    {
        // 创建与ui界面大小相同的多维数组
    	int[][] newGrid = new int[maxRow + 2][maxCol + 2];
        // 遍历每一个元素，每一个元素对应一个网格细胞按钮
        for (int i = 1; i <= maxRow; i++)
        {
            for (int j = 1; j <= maxCol; j++)
            {
                // 根据邻居数量，判断细胞存亡
                switch (getNeighborCount(i, j))
                {
                    case 2:
                        // 邻居数量为2，细胞状态保持不变
                        newGrid[i][j] = grid[i][j];
                        break;
                    case 3:
                        // 邻居数量为3，死细胞变为活细胞
                        newGrid[i][j] = 1;
                        break;
                    default:
                        // 其它情况一律为死细胞
                        newGrid[i][j] = 0;
                }
            }
        }
        // 给grid[][]多维数组赋值为新的细胞状态
        for (int i = 1; i <= maxRow; i++)
        {
            for (int j = 1; j <= maxCol; j++)
            {
                grid[i][j] = newGrid[i][j];
            }
        }

        // 代数自增1
        nowGeneration++;
    }
}
