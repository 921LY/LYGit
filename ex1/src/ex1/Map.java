package ex1;

public class Map
{
    // 行细胞数、列细胞数
    private int maxRowNum = 20;
    private int maxColNum = 36;

    // 界面中细胞是否死完
    private boolean isDead;
    // 是否正在繁衍
    private boolean isRunning;
    // 细胞是否被选中
    private boolean[][] isSelected;

    // 构造方法
    public Map()
    {
        isSelected = new boolean[maxRowNum][maxColNum];

        // 默认初始化所有细胞未选中
        for(int i = 0; i < maxRowNum; i++)
        {
            for(int j = 0; j < maxColNum; j++)
            {
                isSelected[i][j] = false;
            }
        }
    }

    // 获取细胞行数
    public int getMaxRowNum()
    {
        return maxRowNum;
    }

    // 获取细胞列数
    public int getMaxColNum()
    {
        return maxColNum;
    }

    // 设置细胞行数
    public void setMaxColNum(int maxColNum)
    {
        this.maxColNum = maxColNum;
    }

    // 设置细胞列数
    public void setMaxRowNum(int maxRowNum)
    {
        this.maxRowNum = maxRowNum;
    }

    // 获取所有细胞是否死亡
    public boolean getIsDead()
    {
        return isDead;
    }

    // 设置所有细胞是否死亡
    public void setIsDead(boolean isDead)
    {
        this.isDead = isDead;
    }

    // 获取是否正在繁衍状态
    public boolean getIsRunning()
    {
        return isRunning;
    }

    // 设置是否正在繁衍状态
    public void setIsRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }

    // 获取细胞是否选中
    public boolean getIsSelected(int row, int col)
    {
        return isSelected[row][col];
    }

    // 设置细胞是否选中
    public void setIsSelected(int row, int col)
    {
        isSelected[row][col] = !isSelected[row][col];
    }
}
