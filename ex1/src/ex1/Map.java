package ex1;

public class Map
{
    // ��ϸ��������ϸ����
    private int maxRowNum = 20;
    private int maxColNum = 36;

    // ������ϸ���Ƿ�����
    private boolean isDead;
    // �Ƿ����ڷ���
    private boolean isRunning;
    // ϸ���Ƿ�ѡ��
    private boolean[][] isSelected;

    // ���췽��
    public Map()
    {
        isSelected = new boolean[maxRowNum][maxColNum];

        // Ĭ�ϳ�ʼ������ϸ��δѡ��
        for(int i = 0; i < maxRowNum; i++)
        {
            for(int j = 0; j < maxColNum; j++)
            {
                isSelected[i][j] = false;
            }
        }
    }

    // ��ȡϸ������
    public int getMaxRowNum()
    {
        return maxRowNum;
    }

    // ��ȡϸ������
    public int getMaxColNum()
    {
        return maxColNum;
    }

    // ����ϸ������
    public void setMaxColNum(int maxColNum)
    {
        this.maxColNum = maxColNum;
    }

    // ����ϸ������
    public void setMaxRowNum(int maxRowNum)
    {
        this.maxRowNum = maxRowNum;
    }

    // ��ȡ����ϸ���Ƿ�����
    public boolean getIsDead()
    {
        return isDead;
    }

    // ��������ϸ���Ƿ�����
    public void setIsDead(boolean isDead)
    {
        this.isDead = isDead;
    }

    // ��ȡ�Ƿ����ڷ���״̬
    public boolean getIsRunning()
    {
        return isRunning;
    }

    // �����Ƿ����ڷ���״̬
    public void setIsRunning(boolean isRunning)
    {
        this.isRunning = isRunning;
    }

    // ��ȡϸ���Ƿ�ѡ��
    public boolean getIsSelected(int row, int col)
    {
        return isSelected[row][col];
    }

    // ����ϸ���Ƿ�ѡ��
    public void setIsSelected(int row, int col)
    {
        isSelected[row][col] = !isSelected[row][col];
    }
}
