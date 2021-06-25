package ex1;

public class Logic
{
    // ��ϸ����ֵ����ϸ����ֵ
    private int maxRow,maxCol;
    // ��ǰ����,���ܵڼ���
    private int nowGeneration;
    // ϸ��״̬��0������ϸ����1�����ϸ��---��С��ui����Ĵ�С��ͬ��һ��Ԫ�ض�Ӧһ����ťϸ��
    private int[][] grid;

    // ���췽��
    public Logic(int maxRowNum, int maxColNum)
    {
        // ������������grid������ֵΪui�����е�ֵ
        this.maxRow = maxRowNum;
        this.maxCol = maxColNum;

        // ������0
        nowGeneration = 0;

        // ������ά���飬ʹ�߽紦�����м�һ��
        grid = new int[maxRow + 2][maxCol + 2];

        // ����ϸ������ȫ����
        for (int i = 0; i <= maxRow + 1; i++)
        {
            for (int j = 0; j <= maxCol + 1; j++)
            {
                grid[i][j] = 0;
            }
        }
    }

    // ����ui���水ť��Ӧ�������С
    public void setGrid(int[][] grid)
    {
        this.grid = grid;
    }

    // ��ȡui���水ť��Ӧ�������С
    public int[][] getGrid()
    {
        return grid;
    }

    // ���õ�ǰ���ܴ���
    public void setNowGeneration(int nowGeneration)
    {
        this.nowGeneration = nowGeneration;
    }

    // ��õ�ǰ���ܴ���
    public int getNowGeneration()
    {
        return nowGeneration;
    }

    // �����ʼ��ϸ��,�����ʼ������ϸ��״̬Ϊ1
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

    // ϸ������
    public void deleteAllCell()
    {
        for (int i = 1; i <= maxRow; i++)
        {
            for (int j = 1; j <= maxCol; j++)
            {
                // ����ϸ��״̬Ϊ0����ϸ��
                grid[i][j] = 0;
            }
        }
    }

    // ��ȡϸ�����ھ�����
    public int getNeighborCount(int row, int col)
    {
        int countNeighbor = 0;

        // ���Լ�Ϊ���ģ��ж���Χ�˸�ϸ��״̬
        for (int i = row - 1; i <= row + 1; i++)
        {
            for (int j = col - 1; j <= col + 1; j++)
            {
                // �жϵ��Լ�ʱ��ֱ������
                if(i == row && j == col)
                {
                    continue;
                }
                countNeighbor += grid[i][j]; //����ھӻ����ţ��ھӵ�״̬Ϊ1���ھ������+1
                if(countNeighbor==4)
                	break;
            }
            if(countNeighbor==4)
            	break;
        }
        return countNeighbor;
    }

    // ����
    public void update()
    {
        // ������ui�����С��ͬ�Ķ�ά����
    	int[][] newGrid = new int[maxRow + 2][maxCol + 2];
        // ����ÿһ��Ԫ�أ�ÿһ��Ԫ�ض�Ӧһ������ϸ����ť
        for (int i = 1; i <= maxRow; i++)
        {
            for (int j = 1; j <= maxCol; j++)
            {
                // �����ھ��������ж�ϸ������
                switch (getNeighborCount(i, j))
                {
                    case 2:
                        // �ھ�����Ϊ2��ϸ��״̬���ֲ���
                        newGrid[i][j] = grid[i][j];
                        break;
                    case 3:
                        // �ھ�����Ϊ3����ϸ����Ϊ��ϸ��
                        newGrid[i][j] = 1;
                        break;
                    default:
                        // �������һ��Ϊ��ϸ��
                        newGrid[i][j] = 0;
                }
            }
        }
        // ��grid[][]��ά���鸳ֵΪ�µ�ϸ��״̬
        for (int i = 1; i <= maxRow; i++)
        {
            for (int j = 1; j <= maxCol; j++)
            {
                grid[i][j] = newGrid[i][j];
            }
        }

        // ��������1
        nowGeneration++;
    }
}
