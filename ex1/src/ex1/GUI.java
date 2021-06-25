package ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener
{
    // ���:������塢�в���塢�ײ����
    private JPanel backPanel,centerPanel,bottomPanel;

    // ��ǩ����ϸ��������ϸ������ǰ����
    private JLabel labelRowNum,labelColNum,labelNowGeneration;

    // �ı�����ϸ��������ϸ����
    private JTextField textRowNum,textColNum;

    // ��ť��һ������ť��ʾһ��ϸ��
    private JButton[][] btnGridCell;

    // ��ť��ȷ�����������㡢ϸ�����㡢�����ʼ������ǰ����
    private JButton btnOK,btnClearGeneration,btnClearCell, btnRandomInit,btnNowGeneration;

    // ��ť����ʼ���ܡ���һ������ͣ���˳�
    private JButton btnAutoProduce,btnNextGeneration, btnStop, btnExit;

    // ����Logic ��ı���
    private Logic logic;
    // ����Map��Ķ���
    Map map = new Map();

    // �߳�
    private Thread thread;

    // ���������
    public static void main(String arg[])
    {
        new GUI();
    }

    // ���췽��
    public GUI()
    {
        // ���ø���JFrame�Ĺ��췽�����ô������
        super("������Ϸ");

        // ��ʼ������
        initGUI();
    }

    // ��ʼ��ui����
    public void initGUI()
    {
        // ������ ��ϸ����ֵ��logic��
        logic = new Logic(map.getMaxRowNum(), map.getMaxColNum());

        // ������壺�߿򲼾�
        backPanel = new JPanel(new BorderLayout());
        this.setContentPane(backPanel);

        // �в���壺���񲼾�
        centerPanel = new JPanel(new GridLayout(map.getMaxRowNum(), map.getMaxColNum()));
        backPanel.add(centerPanel,"Center");

        // �ײ���壺���ɸ��ְ�ť
        bottomPanel = new JPanel();
        backPanel.add(bottomPanel,"South");

        // ��������ϸ����ť����,��ť����
        btnGridCell = new JButton[map.getMaxRowNum()][map.getMaxColNum()];

        // ��ʼ������ť�����Ա�ʾϸ��
        for (int i = 0; i < map.getMaxRowNum(); i++)
        {
            for (int j = 0; j < map.getMaxColNum(); j++)
            {
                // ϸ����������Ϊ�ձ�ʾϸ��
                btnGridCell[i][j] = new JButton("");
                // ϸ������ɫΪ��ɫ
                btnGridCell[i][j].setBackground(Color.WHITE);
                // ���ϸ������ť�����
                centerPanel.add(btnGridCell[i][j]);
            }
        }

        // ��ǩ����ϸ����
        labelRowNum = new JLabel("��ϸ����:");
        bottomPanel.add(labelRowNum);

        // �ı�����ϸ����
        textRowNum = new JTextField(2);
        textRowNum.setText(""+map.getMaxRowNum());
        bottomPanel.add(textRowNum);

        // ��ǩ����ϸ����
        labelColNum = new JLabel("��ϸ����:");
        bottomPanel.add(labelColNum);

        // �ı�����ϸ����
        textColNum = new JTextField(2);
        textColNum.setText(""+map.getMaxColNum());
        bottomPanel.add(textColNum);

        // ��ť��ȷ��
        btnOK = new JButton("ȷ��");
        bottomPanel.add(btnOK);

        // ��ǩ����ǰ����
        labelNowGeneration = new JLabel("��ǰ����:");
        bottomPanel.add(labelNowGeneration);

        // ��ť����ʾ��ǰ����
        btnNowGeneration = new JButton(""+logic.getNowGeneration());
        // ���ð�ť���ɵ��
        btnNowGeneration.setEnabled(false);
        bottomPanel.add(btnNowGeneration);

        // �������㰴ť
        btnClearGeneration = new JButton("��������");
        bottomPanel.add(btnClearGeneration);

        // �����ʼ����ť
        btnRandomInit = new JButton("�����ʼ��");
        bottomPanel.add(btnRandomInit);

        // ϸ�����㰴ť
        btnClearCell = new JButton("ϸ������");
        bottomPanel.add(btnClearCell);

        // �Զ����ܰ�ť
        btnAutoProduce = new JButton("�Զ�����");
        bottomPanel.add(btnAutoProduce);

        // ��һ����ť
        btnNextGeneration = new JButton("��һ��");
        bottomPanel.add(btnNextGeneration);

        // ��ͣ��ť
        btnStop = new JButton("��ͣ");
        bottomPanel.add(btnStop);

        // �˳���ť
        btnExit = new JButton("�˳�");
        bottomPanel.add(btnExit);

        // ע�������
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosed(WindowEvent e)
            {
                System.exit(0);
            }
        });

        btnOK.addActionListener(this);
        btnClearGeneration.addActionListener(this);
        btnRandomInit.addActionListener(this);
        btnClearCell.addActionListener(this);
        btnNextGeneration.addActionListener(this);
        btnAutoProduce.addActionListener(this);
        btnStop.addActionListener(this);
        btnExit.addActionListener(this);
        for (int i = 0; i < map.getMaxRowNum(); i++) {
            for (int j = 0; j < map.getMaxColNum(); j++) {
                btnGridCell[i][j].addActionListener(this);
            }
        }
        // ���ô����С
        this.setSize(1000,650);
        // �����С�ɱ�
        this.setResizable(true);
        // ���������ʾ
        this.setLocationRelativeTo(null);
        // ����ɼ�
        this.setVisible(true);
    }

    // �����¼�����
    public void actionPerformed(ActionEvent e)
    {
        // ȷ��
        if(e.getSource() == btnOK)
        {
            // ��Map���л�ȡ���µ�ui�����С���С���ֵ
            map.setMaxRowNum(Integer.valueOf(textRowNum.getText()));
            map.setMaxColNum(Integer.valueOf(textColNum.getText()));

            // �����С���ϸ����ֵ��Logic��
            logic = new Logic(map.getMaxRowNum(), map.getMaxColNum());

            // ���´���
            initGUI();
        }
        // ��������
        else if(e.getSource() == btnClearGeneration)
        {
            // ���ô���ֵΪ0
            logic.setNowGeneration(0);
            // ˢ�µ�ǰ������ʾ
            btnNowGeneration.setText(""+logic.getNowGeneration());
            // δ���Զ�����
            map.setIsRunning(false);
        }
        // �����ʼ��
        else if(e.getSource() == btnRandomInit)
        {
            // �����ʼ��һ����ϸ��״̬Ϊ1
            logic.randomCell();
            // ��ʾϸ��
            showCell();
            // δ���Զ�����
            map.setIsRunning(false);
        }
        // ϸ������
        else if(e.getSource() == btnClearCell)
        {
            // ��������ϸ��״̬Ϊ0
            logic.deleteAllCell();
            // ��ʾϸ��
            showCell();
            // δ���Զ�����
            map.setIsRunning(false);
        }
        // �Զ�����
        else if (e.getSource() == btnAutoProduce)
        {
            // �����Զ�����
            map.setIsRunning(true);
            // �Զ�����
            autoProduce();
        }
        // ��һ��
        else if (e.getSource() == btnNextGeneration)
        {
            // ������һ��
            makeNextGeneration();
            // δ���Զ�����
            map.setIsRunning(false);
        }
        // ��ͣ
        else if (e.getSource() == btnStop)
        {
            // δ���Զ�����
            map.setIsRunning(false);
        }
        // �˳�
        else if (e.getSource() == btnExit)
        {
            dispose();
            System.exit(0);
        }
        // ϸ����ť
        else
        {
            // ��Logic���л��ÿ������ϸ����ť��Ӧ��ֵ��1��0
            int[][] grid = logic.getGrid();

            for (int i = 0; i < map.getMaxRowNum(); i++)
            {
                for (int j = 0; j < map.getMaxColNum(); j++)
                {
                    // �����ĳһ��ϸ����ť
                    if (e.getSource() == btnGridCell[i][j])
                    {
                        // �޸���ѡ��״̬Ϊ�෴״̬
                        map.setIsSelected(i,j);

                        // ���ѡ���˸�ϸ����ť
                        if (map.getIsSelected(i,j))
                        {
                            // ����ɫΪ��ɫ
                            btnGridCell[i][j].setBackground(Color.BLACK);
                            // ѡ�������ø�ϸ��Ϊ��ϸ����״̬Ϊ1
                            grid[i + 1][j + 1] = 1;
                        }
                        else
                        {
                            // ��ϸ������ɫΪ��ɫ��״̬Ϊ0
                            btnGridCell[i][j].setBackground(Color.WHITE);
                            grid[i + 1][j + 1] = 0;
                        }
                        break;
                    }
                }
            }
            // �޸�Logic����������ť��Ӧ��ά������Ԫ�ص�ֵ
            logic.setGrid(grid);
        }
    }

    // ������һ��
    protected void makeNextGeneration()
    {
        // ����
        logic.update();
        // ��ʾϸ��
        showCell();
        // ˢ�´�����ʾ��ť
        btnNowGeneration.setText(""+logic.getNowGeneration());
    }

    // ����ϸ��״̬��ʾϸ����ɫ
    private void showCell()
    {
        int[][] grid = logic.getGrid();

        for (int i = 0; i < map.getMaxRowNum(); i++)
        {
            for (int j = 0; j < map.getMaxColNum(); j++)
            {
                if (grid[i + 1][j + 1] == 1)
                {
                    // ��ϸ���ú�ɫ��ʾ
                    btnGridCell[i][j].setBackground(Color.BLACK);
                }
                else
                {
                    // ��ϸ���ð�ɫ��ʾ
                    btnGridCell[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
    // �Զ�����
    private void autoProduce()
    {
        thread = new Thread(new Runnable()
        {
            public void run()
            {
                while (map.getIsRunning())
                {
                    // ������һ��
                    makeNextGeneration();
                    try 
                    {
                        thread.sleep(500);
                    } catch (InterruptedException e1)
                    {
                        e1.printStackTrace();
                    }

                    map.setIsDead(true);

                    for(int row = 1; row <= map.getMaxRowNum(); row++)
                    {
                        for (int col = 1; col <= map.getMaxColNum(); col++)
                        {
                            if (logic.getGrid()[row][col] != 0)
                            {
                                map.setIsDead(false);
                                break;
                            }
                        }
                        if (!map.getIsDead())
                        {
                            break;
                        }
                    }

                    if (map.getIsDead())
                    {
                        JOptionPane.showMessageDialog(null, "����ϸ��������");
                        map.setIsRunning(false);
                        thread = null;
                    }
                }
            }
        });
        thread.start();
    }
}