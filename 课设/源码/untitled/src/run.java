
import java.sql.*;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import  java.util.ArrayList;
import java.util.List;
import javax.xml.stream.events.StartElement;

import static javax.swing.JOptionPane.ERROR_MESSAGE;


class dbopra {

    public String[] select(int aa) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn=DriverManager.getConnection(jdbc, "root", "root");
        Statement state=conn.createStatement();
        String sql="select * from studentinfo1";
        ResultSet rs=state.executeQuery(sql);
        String[] arrey  = new String[5];
        //int i = 0;
        while(rs.next()){
            if (Integer.parseInt(rs.getString(2) )== aa)
            {
                arrey[0] = rs.getString(1);
                arrey[1] = rs.getString(2);
                arrey[2] = rs.getString(3);
                arrey[3] = rs.getString(4);
                arrey[4] = rs.getString(5);
                System.out.print(rs.getString(1)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
                break;
            }
        }
        conn.close();
        /*String[] arrey  = new String[]{};
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        Statement state = conn.createStatement();
        String sql = "select * from studentinfo1 where no = ?";
        ps = conn.prepareStatement(sql);//sql语句
        ps.setInt(1, aa);
        int insertCount = ps.executeUpdate();
        ResultSet rs = state.executeQuery(sql);
        while (rs.next()) {
            System.out.print(rs.getString(1));
        }
        int i = 0;
        while (rs.next()) {
                 String a = rs.getString(i+1);
                 System.out.print(a);
                 arrey[i] = a;
                 i++;
        }*/
        return  arrey;
    }

    public void insert(String a,int b,int c,int d,int e ) throws Exception{
        //Connection conn = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "INSERT INTO studentinfo1 (name,no,python,java,db) VALUES (?,?,?,?,? )";
        ps = conn.prepareStatement(sql);
        ps.setString(1, a);
        ps.setInt(2, b);
        ps.setInt(3, c);
        ps.setInt(4, d);
        ps.setInt(5, e);
        int insertCount = ps.executeUpdate();


        /*Class.forName("com.mysql.jdbc.Driver");
        String jdbc="jdbc:mysql://127.0.0.1:3306/test?characterEncoding=GBK";
        Connection conn=DriverManager.getConnection(jdbc, "root", "root");
        Statement state=conn.createStatement();
        String name = a;
        int no = b;
        int python = c;
        int java = c;
        int db = c;*/
        //String sql= a;
        //"insert into stduentinfo1 values(?,?,?,?,?)";
        //state.executeUpdate(sql);
        /*PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,a);
        ps.setInt(2,b);
        ps.setInt(3,c);
        ps.setInt(4,d);
        ps.setInt(5,e);
        ps.executeUpdate();
        conn.close();*/
    }

    public void delete(int b) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "delete from studentinfo1 where no = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,b);
        int insertCount = ps.executeUpdate();
        conn.close();

    }


    public void updatename(String a,String b,int c) throws  Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        if (a.equals("姓名"))
        {
            String sql = "update studentinfo1 set name = ? where no = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        conn.close();
    }


    public void update(String a,int b,int c) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        if (a.equals("python"))
        {
            String sql = "update studentinfo1 set python = ? where no = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        /*else if (a.equals("姓名"))
        {
            String sql = "update studentinfo1 set name = ? where no = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }*/
        else if(a.equals("java"))
        {
            String sql = "update studentinfo1 set java = ? where no = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        else if(a.equals("db"))
        {
            String sql = "update studentinfo1 set db = ? where no = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        conn.close();


    }


    public void teainsert(int a,String b,String c,int d,String e ) throws Exception {
        //Connection conn = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "INSERT INTO teacherinfo (id,name,sex,age,cor) VALUES (?,?,?,?,? )";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, a);
        ps.setString(2, b);
        ps.setString(3, c);
        ps.setInt(4, d);
        ps.setString(5, e);
        int insertCount = ps.executeUpdate();
    }

    public void teadelete(int b) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "delete from teacherinfo where id = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,b);
        int insertCount = ps.executeUpdate();
        conn.close();

    }


    public void teacherupdate(String a,String b,int c) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        if (a.equals("性别"))
        {
            String sql = "update teacherinfo set sex = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        else if (a.equals("姓名"))
        {
            String sql = "update studentinfo1 set name = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        else if(a.equals("课程"))
        {
            String sql = "update teacherinfo1 set cor = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        conn.close();


    }


    public void teaupdateage(String a,int b,int c)throws  Exception {
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        if (a.equals("年龄")) {
            String sql = "update teacherinfo1 set age = ? where no = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        conn.close();

    }


    public void stuupdateage(String a,int b,int c)throws  Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        if (a.equals("年龄"))
        {
            String sql = "update stuinfo set age = ? where no = ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        conn.close();
    }


    public void stuinsert(int a,String b,String c,int d,String e ) throws Exception {
        //Connection conn = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "INSERT INTO stuinfo (id,name,sex,age,sdept) VALUES (?,?,?,?,? )";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, a);
        ps.setString(2, b);
        ps.setString(3, c);
        ps.setInt(4, d);
        ps.setString(5, e);
        int insertCount = ps.executeUpdate();
    }

    public void studelete(int b) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "delete from stuinfo where id = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,b);
        int insertCount = ps.executeUpdate();
        conn.close();

    }


    public void studentupdate(String a,String b,int c) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        if (a.equals("性别"))
        {
            String sql = "update stuinfo set sex = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        else if (a.equals("姓名"))
        {
            String sql = "update stuinfo set name = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        else if(a.equals("专业"))
        {
            String sql = "update stuinfo set sdept = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        conn.close();


    }

    public void corupdate(String a,String b,int c) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        if (a.equals("课程"))
        {
            String sql = "update corinfo set cor = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }
        else if (a.equals("班级"))
        {
            String sql = "update corinfo set class = ? where id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, b);
            ps.setInt(2, c);
            int insertCount = ps.executeUpdate();
        }

        conn.close();


    }


    public void corinsert(int a,String b,String c) throws Exception {
        //Connection conn = null;
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "INSERT INTO corinfo (id,cor,class) VALUES (?,?,? )";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, a);
        ps.setString(2, b);
        ps.setString(3, c);
        int insertCount = ps.executeUpdate();
    }


    public void cordelete(int b) throws Exception{
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "root");
        String sql = "delete from corinfo where id = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,b);
        int insertCount = ps.executeUpdate();
        conn.close();

    }

}


class menuoprat extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    public menuoprat()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("多功能面板");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton b1 = new JButton("查询学分");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    String[] a = tdp.select(Integer.parseInt(menuoprat.this.t1.getText()));
                    double score = (Integer.parseInt(a[2]) * 4 +  Integer.parseInt(a[3]) * 2 + Integer.parseInt(a[4]) * 3)/9;
                    t2.setText(String.valueOf(score));
                }catch(Exception e1){}
            }
        });


        JButton b2 = new JButton("奖学金");
        b2.setOpaque(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    String[] a = tdp.select(Integer.parseInt(menuoprat.this.t1.getText()));
                    double score = (Integer.parseInt(a[2]) * 4 +  Integer.parseInt(a[3]) * 2 + Integer.parseInt(a[4]) * 3)/9;
                    if (score > 80)
                    {
                        t2.setText("你获得一等奖学金");
                    }
                    else if (score > 75)
                    {
                        t2.setText("你获得二等奖学金");
                    }
                    else if (score > 70)
                    {
                        t2.setText("你获得三等奖学金");
                    }
                    else
                    {
                        t2.setText("你未获得奖学金");
                    }
                }catch(Exception e1){}
            }
        });


        JButton b3 = new JButton("挂科预警");
        b3.setOpaque(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    String[] a = tdp.select(Integer.parseInt(menuoprat.this.t1.getText()));
                    if ((Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) > 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的python成绩不合格");
                    }
                    else if((Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[2]) > 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的java成绩不合格");
                    }
                    else if((Integer.parseInt(a[4]) < 60)&&(Integer.parseInt(a[3]) > 60)&&(Integer.parseInt(a[2]) > 60))
                    {
                        t2.setText("你的数据库成绩不合格");
                    }
                    else if((Integer.parseInt(a[4]) < 60)&&(Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[2]) > 60))
                    {
                        t2.setText("你的数据库成绩和java成绩不合格");
                    }
                    else if((Integer.parseInt(a[4]) < 60)&&(Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) > 60))
                    {
                        t2.setText("你的数据库成绩和python成绩不合格");
                    }
                    else if((Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的python成绩和java成绩不合格");
                    }
                    else if((Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[4]) < 60))
                    {
                        t2.setText("你的成绩全部不合格");
                    }
                    else if((Integer.parseInt(a[2]) > 60)&&(Integer.parseInt(a[3]) > 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的成绩全部合格");
                    }
                }catch(Exception e1){}

            }
        });

        JLabel l1 = new JLabel("学号");
        JLabel l2 = new JLabel("结果");

        JLayeredPane pa = new JLayeredPane();
        JPanel p = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p = (JPanel)getContentPane();
        p.add(jl);

        l1.setBounds(100, 60, 30, 30);
        t1.setBounds(150, 60, 250, 30);
        l2.setBounds(100, 140, 30, 30);
        t2.setBounds(150, 140, 250, 30);
        b1.setBounds(100,220,100,30);
        b2.setBounds(220,220,100,30);
        b3.setBounds(340,220,100,30);

        pa.add(p, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(b1, JLayeredPane.MODAL_LAYER);
        pa.add(b2, JLayeredPane.MODAL_LAYER);
        pa.add(b3, JLayeredPane.MODAL_LAYER);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem returnmain = new JMenuItem("返回主界面");
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuoprat.this.dispose();
                new teacher();
            }
        });

        setLayeredPane(pa);
        bar.add(op);
        op.add(returnmain);
        setJMenuBar(bar);
        setVisible(true);
    }

}


class menuopra extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    public menuopra()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("多功能面板");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton b1 = new JButton("查询学分");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    String[] a = tdp.select(Integer.parseInt(menuopra.this.t1.getText()));
                    double score = (Integer.parseInt(a[2]) * 4 +  Integer.parseInt(a[3]) * 2 + Integer.parseInt(a[4]) * 3)/9;
                    t2.setText(String.valueOf(score));
                }catch(Exception e1){}
            }
        });


        JButton b2 = new JButton("奖学金");
        b2.setOpaque(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    String[] a = tdp.select(Integer.parseInt(menuopra.this.t1.getText()));
                    double score = (Integer.parseInt(a[2]) * 4 +  Integer.parseInt(a[3]) * 2 + Integer.parseInt(a[4]) * 3)/9;
                    if (score > 80)
                    {
                        t2.setText("你获得一等奖学金");
                    }
                    else if (score > 75)
                    {
                        t2.setText("你获得二等奖学金");
                    }
                    else if (score > 70)
                    {
                        t2.setText("你获得三等奖学金");
                    }
                    else
                        {
                            t2.setText("你未获得奖学金");
                        }
                }catch(Exception e1){}
            }
        });


        JButton b3 = new JButton("挂科预警");
        b3.setOpaque(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    String[] a = tdp.select(Integer.parseInt(menuopra.this.t1.getText()));
                    if ((Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) > 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的python成绩不合格");
                    }
                    else if((Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[2]) > 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的java成绩不合格");
                    }
                    else if((Integer.parseInt(a[4]) < 60)&&(Integer.parseInt(a[3]) > 60)&&(Integer.parseInt(a[2]) > 60))
                    {
                        t2.setText("你的数据库成绩不合格");
                    }
                    else if((Integer.parseInt(a[4]) < 60)&&(Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[2]) > 60))
                    {
                        t2.setText("你的数据库成绩和java成绩不合格");
                    }
                    else if((Integer.parseInt(a[4]) < 60)&&(Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) > 60))
                    {
                        t2.setText("你的数据库成绩和python成绩不合格");
                    }
                    else if((Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的python成绩和java成绩不合格");
                    }
                    else if((Integer.parseInt(a[2]) < 60)&&(Integer.parseInt(a[3]) < 60)&&(Integer.parseInt(a[4]) < 60))
                    {
                        t2.setText("你的成绩全部不合格");
                    }
                    else if((Integer.parseInt(a[2]) > 60)&&(Integer.parseInt(a[3]) > 60)&&(Integer.parseInt(a[4]) > 60))
                    {
                        t2.setText("你的成绩全部合格");
                    }
                }catch(Exception e1){}

            }
        });

        JLabel l1 = new JLabel("学号");
        JLabel l2 = new JLabel("结果");

        JLayeredPane pa = new JLayeredPane();
        JPanel p = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p = (JPanel)getContentPane();
        p.add(jl);

        l1.setBounds(100, 60, 30, 30);
        t1.setBounds(150, 60, 250, 30);
        l2.setBounds(100, 140, 30, 30);
        t2.setBounds(150, 140, 250, 30);
        b1.setBounds(100,220,100,30);
        b2.setBounds(220,220,100,30);
        b3.setBounds(340,220,100,30);

        pa.add(p, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(b1, JLayeredPane.MODAL_LAYER);
        pa.add(b2, JLayeredPane.MODAL_LAYER);
        pa.add(b3, JLayeredPane.MODAL_LAYER);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem returnmain = new JMenuItem("返回主界面");
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuopra.this.dispose();
                new student();
            }
        });

        setLayeredPane(pa);
        bar.add(op);
        op.add(returnmain);
        setJMenuBar(bar);
        setVisible(true);
    }

}

class adteacherup extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);

    public adteacherup()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("修改面板");
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(4,1));

        JLabel l1 = new JLabel("工号");
        JLabel l2 = new JLabel("项目");
        JLabel l3 = new JLabel("结果");
        JButton b1 =new JButton("确定");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    if ((adteacherup.this.t2.getText()).equals("年龄"))
                    {
                        tdp.teaupdateage(adteacherup.this.t2.getText(), Integer.parseInt(adteacherup.this.t3.getText()), Integer.parseInt(adteacherup.this.t1.getText()));
                    }
                    else {
                        tdp.teacherupdate(adteacherup.this.t2.getText(), adteacherup.this.t3.getText(), Integer.parseInt(adteacherup.this.t1.getText()));
                    }
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"修改成功","修改提示",JOptionPane.PLAIN_MESSAGE);
                    adteacherup.this.dispose();
                    new adteacher();
                }catch(Exception e1){}
            }
        });

        JLayeredPane pa = new JLayeredPane();
        JPanel p = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p = (JPanel)getContentPane();
        p.add(jl);

        l1.setBounds(150, 60, 30, 30);
        t1.setBounds(200, 60, 200, 30);
        l2.setBounds(150, 140, 30, 30);
        t2.setBounds(200, 140, 200, 30);
        l3.setBounds(150, 220, 30, 30);
        t3.setBounds(200, 220, 200, 30);
        b1.setBounds(260, 300, 60, 30);

        pa.add(p, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);

        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);

        pa.add(b1, JLayeredPane.MODAL_LAYER);

        setLayeredPane(pa);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem returnmain = new JMenuItem("返回主界面");
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adteacherup.this.dispose();
                new adteacher();
            }
        });

        bar.add(op);
        op.add(returnmain);
        setJMenuBar(bar);
        setVisible(true);
    }

}

class corup extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);

    public corup()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("修改面板");
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(4,1));

        JLabel l1 = new JLabel("工号");
        JLabel l2 = new JLabel("项目");
        JLabel l3 = new JLabel("结果");
        JButton b1 =new JButton("确定");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    tdp.corupdate(corup.this.t2.getText(),corup.this.t3.getText(),Integer.parseInt(corup.this.t1.getText()));
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"修改成功","修改提示",JOptionPane.PLAIN_MESSAGE);
                    corup.this.dispose();
                    new course();
                }catch(Exception e1){}
            }
        });

        JLayeredPane pa = new JLayeredPane();
        JPanel p = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p = (JPanel)getContentPane();
        p.add(jl);

        l1.setBounds(150, 60, 30, 30);
        t1.setBounds(200, 60, 200, 30);
        l2.setBounds(150, 140, 30, 30);
        t2.setBounds(200, 140, 200, 30);
        l3.setBounds(150, 220, 30, 30);
        t3.setBounds(200, 220, 200, 30);
        b1.setBounds(260, 300, 60, 30);

        pa.add(p, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);

        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);

        pa.add(b1, JLayeredPane.MODAL_LAYER);

        setLayeredPane(pa);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem returnmain = new JMenuItem("返回主界面");
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                corup.this.dispose();
                new course();
            }
        });

        setLayeredPane(pa);
        bar.add(op);
        op.add(returnmain);
        setJMenuBar(bar);
        setVisible(true);
    }

}


class teacherup extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);

    public teacherup()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("修改面板");
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(4,1));

        JLabel l1 = new JLabel("学号");
        JLabel l2 = new JLabel("项目");
        JLabel l3 = new JLabel("结果");
        JButton b1 =new JButton("确定");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    if ((teacherup.this.t2.getText()).equals("姓名"))
                    {
                        tdp.updatename(teacherup.this.t2.getText(), teacherup.this.t3.getText(), Integer.parseInt(teacherup.this.t1.getText()));
                    }
                    else {
                        tdp.update(teacherup.this.t2.getText(), Integer.parseInt(teacherup.this.t3.getText()), Integer.parseInt(teacherup.this.t1.getText()));
                    }
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"修改成功","修改提示",JOptionPane.PLAIN_MESSAGE);
                    teacherup.this.dispose();
                    new teacher();
                }catch(Exception e1){}
            }
        });

        JLayeredPane pa = new JLayeredPane();
        JPanel p = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p = (JPanel)getContentPane();
        p.add(jl);

        l1.setBounds(150, 60, 30, 30);
        t1.setBounds(200, 60, 200, 30);
        l2.setBounds(150, 140, 30, 30);
        t2.setBounds(200, 140, 200, 30);
        l3.setBounds(150, 220, 30, 30);
        t3.setBounds(200, 220, 200, 30);
        b1.setBounds(260, 300, 60, 30);

        pa.add(p, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);

        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);

        pa.add(b1, JLayeredPane.MODAL_LAYER);

        setLayeredPane(pa);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem oper = new JMenuItem("多功能面板");
        oper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherup.this.dispose();
                new menuoprat();
            }
        });
        JMenuItem returnmain = new JMenuItem("返回主界面");
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherup.this.dispose();
                new menuoprat();
            }
        });


        bar.add(op);
        op.add(oper);
        op.add(returnmain);
        setJMenuBar(bar);
        setVisible(true);
    }

}
class adstudentup extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);

    public adstudentup()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("修改面板");
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(4,1));

        JLabel l1 = new JLabel("学号");
        JLabel l2 = new JLabel("项目");
        JLabel l3 = new JLabel("结果");
        JButton b1 =new JButton("确定");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    if ((adstudentup.this.t2.getText()).equals("年龄"))
                    {
                        tdp.stuupdateage(adstudentup.this.t2.getText(), Integer.parseInt(adstudentup.this.t3.getText()), Integer.parseInt(adstudentup.this.t1.getText()));
                    }
                    else
                    {
                        tdp.studentupdate(adstudentup.this.t2.getText(), adstudentup.this.t3.getText(), Integer.parseInt(adstudentup.this.t1.getText()));
                    }
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"修改成功","修改提示",JOptionPane.PLAIN_MESSAGE);
                    adstudentup.this.dispose();
                    new adstudent();
                }catch(Exception e1){}
            }
        });

        JLayeredPane pa = new JLayeredPane();
        JPanel p = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p = (JPanel)getContentPane();
        p.add(jl);

        l1.setBounds(150, 60, 30, 30);
        t1.setBounds(200, 60, 200, 30);
        l2.setBounds(150, 140, 30, 30);
        t2.setBounds(200, 140, 200, 30);
        l3.setBounds(150, 220, 30, 30);
        t3.setBounds(200, 220, 200, 30);
        b1.setBounds(260, 300, 60, 30);

        pa.add(p, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);

        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);

        pa.add(b1, JLayeredPane.MODAL_LAYER);

        setLayeredPane(pa);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem returnmain = new JMenuItem("返回主界面");
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adstudentup.this.dispose();
                new adstudent();
            }
        });


        bar.add(op);
        op.add(returnmain);
        setJMenuBar(bar);
        setVisible(true);
    }


}

class adstudent extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);
    final JTextField t4 = new JTextField(20);
    final JTextField t5 = new JTextField(20);
    public adstudent()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("学生端");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(6,1));

        JLabel l2 = new JLabel("姓名");
        //t1 = new JTextField(20);

        JLabel l1 = new JLabel("学号");
        //JTextField t2 = new JTextField(20);

        JLabel l3 = new JLabel("性别");

        JLabel l4 = new JLabel("年龄");

        JLabel l5 = new JLabel("专业");

        JButton b1 = new JButton("存储");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dbopra tdp = new dbopra();
                    tdp.stuinsert(Integer.parseInt(adstudent.this.t1.getText()),adstudent.this.t2.getText(),adstudent.this.t3.getText(),Integer.parseInt(adstudent.this.t4.getText()),adstudent.this.t5.getText());
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"已存入数据库","存储提示",JOptionPane.PLAIN_MESSAGE);
                }catch(Exception e1){}
            }
        });

        JButton b3  = new JButton("修改");
        b3.setOpaque(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adstudent.this.dispose();
                new adstudentup();
                //dbopra tdp = new dbopra();
                //tdp.update();
            }
        });

        JButton b4 = new JButton("删除");
        b4.setOpaque(false);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    tdp.studelete(Integer.parseInt(adstudent.this.t1.getText()));
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d, "删除成功", "删除提示",JOptionPane.PLAIN_MESSAGE);
                }catch (Exception e1){}
            }
        });


        JLayeredPane pa = new JLayeredPane();
        JPanel p1 = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p1 = (JPanel)getContentPane();
        p1.add(jl);

        l1.setBounds(150, 40, 30, 30);
        t1.setBounds(200, 40, 220, 30);
        l2.setBounds(150, 90, 30, 30);
        t2.setBounds(200, 90, 220, 30);
        l3.setBounds(150, 140, 60, 30);
        t3.setBounds(200, 140, 220, 30);
        l4.setBounds(150, 190, 30, 30);
        t4.setBounds(200, 190, 220, 30);
        l5.setBounds(150, 240, 60, 30);
        t5.setBounds(200, 240, 220, 30);
        b1.setBounds(180, 290, 60, 30);
        b3.setBounds(280, 290, 60, 30);
        b4.setBounds(380, 290, 60, 30);


        pa.add(p1, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);
        pa.add(l4, JLayeredPane.MODAL_LAYER);
        pa.add(l5, JLayeredPane.MODAL_LAYER);
        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);
        pa.add(t4, JLayeredPane.MODAL_LAYER);
        pa.add(t5, JLayeredPane.MODAL_LAYER);
        pa.add(b1, JLayeredPane.MODAL_LAYER);
        pa.add(b3, JLayeredPane.MODAL_LAYER);
        pa.add(b4, JLayeredPane.MODAL_LAYER);


        setLayeredPane(pa);
        setVisible(true);


    }


}


class adteacher extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);
    final JTextField t4 = new JTextField(20);
    final JTextField t5 = new JTextField(20);
    public adteacher()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("教师端");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(6,1));

        JLabel l2 = new JLabel("姓名");
        //t1 = new JTextField(20);

        JLabel l1 = new JLabel("id");
        //JTextField t2 = new JTextField(20);

        JLabel l3 = new JLabel("性别");

        JLabel l4 = new JLabel("年龄");

        JLabel l5 = new JLabel("课程");

        JButton b1 = new JButton("存储");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dbopra tdp = new dbopra();
                    //String a = "insert into studentinfo1 values "+"("+adteacher.this.t2.getText()+","+adteacher.this.t2.getText()+","+adteacher.this.t3.getText()+","+teacher.this.t4.getText()+","+teacher.this.t5.getText()+")";
                    //System.out.print(a);
                    tdp.teainsert(Integer.parseInt(adteacher.this.t1.getText()),adteacher.this.t2.getText(),adteacher.this.t3.getText(),Integer.parseInt(adteacher.this.t4.getText()),adteacher.this.t5.getText());
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"已存入数据库","存储提示",JOptionPane.PLAIN_MESSAGE);
                }catch(Exception e1){}
            }
        });

        JButton b3  = new JButton("修改");
        b3.setOpaque(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adteacher.this.dispose();
                new adteacherup();
                //dbopra tdp = new dbopra();
                //tdp.update();
            }
        });

        JButton b4 = new JButton("删除");
        b4.setOpaque(false);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    tdp.teadelete(Integer.parseInt(adteacher.this.t1.getText()));
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d, "删除成功", "删除提示",JOptionPane.PLAIN_MESSAGE);
                }catch (Exception e1){}
            }
        });


        JLayeredPane pa = new JLayeredPane();
        JPanel p1 = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p1 = (JPanel)getContentPane();
        p1.add(jl);

        l1.setBounds(150, 40, 30, 30);
        t1.setBounds(200, 40, 220, 30);
        l2.setBounds(150, 90, 30, 30);
        t2.setBounds(200, 90, 220, 30);
        l3.setBounds(150, 140, 60, 30);
        t3.setBounds(200, 140, 220, 30);
        l4.setBounds(150, 190, 30, 30);
        t4.setBounds(200, 190, 220, 30);
        l5.setBounds(150, 240, 60, 30);
        t5.setBounds(200, 240, 220, 30);
        b1.setBounds(180, 290, 60, 30);
        b3.setBounds(280, 290, 60, 30);
        b4.setBounds(380, 290, 60, 30);


        pa.add(p1, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);
        pa.add(l4, JLayeredPane.MODAL_LAYER);
        pa.add(l5, JLayeredPane.MODAL_LAYER);
        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);
        pa.add(t4, JLayeredPane.MODAL_LAYER);
        pa.add(t5, JLayeredPane.MODAL_LAYER);
        pa.add(b1, JLayeredPane.MODAL_LAYER);
        pa.add(b3, JLayeredPane.MODAL_LAYER);
        pa.add(b4, JLayeredPane.MODAL_LAYER);


        setLayeredPane(pa);
        setVisible(true);


    }

}


class course extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);

    public course()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("教师课程/班级管理面板");
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(4,1));

        JLabel l1 = new JLabel("工号");
        JLabel l2 = new JLabel("课程");
        JLabel l3 = new JLabel("班级");
        JButton b1 =new JButton("存储");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    tdp.corinsert(Integer.parseInt(course.this.t1.getText()),course.this.t2.getText(),course.this.t3.getText());
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"存储成功","存储提示",JOptionPane.PLAIN_MESSAGE);
                    course.this.dispose();
                    new teacher();
                }catch(Exception e1){}
            }
        });

        JButton b2 = new JButton("删除");
        b2.setOpaque(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    tdp.cordelete(Integer.parseInt(course.this.t1.getText()));
                    JDialog d = new JDialog();
                    d.setSize(100, 100);
                    JOptionPane.showMessageDialog(d, "删除成功", "删除提示", JOptionPane.PLAIN_MESSAGE);
                    course.this.dispose();
                    new teacher();
                }catch(Exception e1){}
            }
        });

        JButton b3 = new JButton("修改");
        b3.setOpaque(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                course.this.dispose();
                new corup();
            }
        });

        JLayeredPane pa = new JLayeredPane();
        JPanel p = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p = (JPanel)getContentPane();
        p.add(jl);

        l1.setBounds(150, 60, 30, 30);
        t1.setBounds(200, 60, 200, 30);
        l2.setBounds(150, 140, 30, 30);
        t2.setBounds(200, 140, 200, 30);
        l3.setBounds(150, 220, 30, 30);
        t3.setBounds(200, 220, 200, 30);
        b1.setBounds(200, 300, 60, 30);
        b2.setBounds(260,300,60,30);
        b3.setBounds(320,300,60,30);
        pa.add(p, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);

        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);

        pa.add(b1, JLayeredPane.MODAL_LAYER);
        pa.add(b2, JLayeredPane.MODAL_LAYER);
        pa.add(b3, JLayeredPane.MODAL_LAYER);

        setLayeredPane(pa);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem returnmain = new JMenuItem("返回主界面");
        returnmain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                course.this.dispose();
                new teacher();
            }
        });


        bar.add(op);
        op.add(returnmain);
        setJMenuBar(bar);
        setVisible(true);
    }
}


class teacher extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);
    final JTextField t4 = new JTextField(20);
    final JTextField t5 = new JTextField(20);
    public teacher()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("教师端");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(6,1));

        JLabel l2 = new JLabel("学号");
        //t1 = new JTextField(20);

        JLabel l1 = new JLabel("姓名");
        //JTextField t2 = new JTextField(20);

        JLabel l3 = new JLabel("python");

        JLabel l4 = new JLabel("java");

        JLabel l5 = new JLabel("数据库");

        JButton b1 = new JButton("存储");
        b1.setOpaque(false);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    dbopra tdp = new dbopra();
                    String a = "insert into studentinfo1 values "+"("+teacher.this.t1.getText()+","+teacher.this.t2.getText()+","+teacher.this.t3.getText()+","+teacher.this.t4.getText()+","+teacher.this.t5.getText()+")";
                    System.out.print(a);
                    tdp.insert(teacher.this.t1.getText(),Integer.parseInt(teacher.this.t2.getText()),Integer.parseInt(teacher.this.t3.getText()),Integer.parseInt(teacher.this.t4.getText()),Integer.parseInt(teacher.this.t5.getText()));
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d,"已存入数据库","存储提示",JOptionPane.PLAIN_MESSAGE);
                }catch(Exception e1){}
            }
        });

        JButton b3  = new JButton("修改");
        b3.setOpaque(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacher.this.dispose();
                new teacherup();
            }
        });

        JButton b4 = new JButton("删除");
        b4.setOpaque(false);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbopra tdp = new dbopra();
                    tdp.delete(Integer.parseInt(teacher.this.t2.getText()));
                    JDialog d = new JDialog();
                    d.setSize(100,100);
                    JOptionPane.showMessageDialog(d, "删除成功", "删除提示",JOptionPane.PLAIN_MESSAGE);
                }catch (Exception e1){}
            }
        });

        JButton b2 = new JButton("查询");
        b2.setOpaque(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //System.out.print("ok");
                    dbopra tdp = new dbopra();
                    //System.out.print("1ok");
                    //tdp.select(Integer.parseInt(teacher.this.t2.getText()));
                    String []a  = tdp.select(Integer.parseInt(teacher.this.t2.getText()));
                    //System.out.print(a[0]);
                    //System.out.print(a[1]);
                    t1.setText(a[0]);
                    t2.setText(a[1]);
                    t3.setText(a[2]);
                    t4.setText(a[3]);
                    t5.setText(a[4]);
                } catch (Exception e1) {}
            }
        });

        JLayeredPane pa = new JLayeredPane();
        JPanel p1 = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p1 = (JPanel)getContentPane();
        p1.add(jl);

        l1.setBounds(150, 40, 30, 30);
        t1.setBounds(200, 40, 220, 30);
        l2.setBounds(150, 90, 30, 30);
        t2.setBounds(200, 90, 220, 30);
        l3.setBounds(150, 140, 60, 30);
        t3.setBounds(200, 140, 220, 30);
        l4.setBounds(150, 190, 30, 30);
        t4.setBounds(200, 190, 220, 30);
        l5.setBounds(150, 240, 60, 30);
        t5.setBounds(200, 240, 220, 30);
        b1.setBounds(180, 290, 60, 30);
        b2.setBounds(250, 290, 60, 30);
        b3.setBounds(320, 290, 60, 30);
        b4.setBounds(390, 290, 60, 30);


        pa.add(p1, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);
        pa.add(l4, JLayeredPane.MODAL_LAYER);
        pa.add(l5, JLayeredPane.MODAL_LAYER);
        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);
        pa.add(t4, JLayeredPane.MODAL_LAYER);
        pa.add(t5, JLayeredPane.MODAL_LAYER);
        pa.add(b1, JLayeredPane.MODAL_LAYER);
        pa.add(b2, JLayeredPane.MODAL_LAYER);
        pa.add(b3, JLayeredPane.MODAL_LAYER);
        pa.add(b4, JLayeredPane.MODAL_LAYER);


        setLayeredPane(pa);

        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem oper = new JMenuItem("多功能面板");
        oper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacher.this.dispose();
                new menuoprat();
            }
        });

        JMenuItem cor = new JMenuItem("班级/课程管理");
        cor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacher.this.dispose();
                new course();
            }
        });

        bar.add(op);
        op.add(oper);
        op.add(cor);
        setJMenuBar(bar);
        setVisible(true);


    }

}


class student extends JFrame
{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JTextField t3 = new JTextField(20);
    final JTextField t4 = new JTextField(20);
    final JTextField t5 = new JTextField(20);
    public student()
    {
        init();
    }
    public void init()
    {
        setSize(580,400);
        setTitle("学生端");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
        //setLayout(new GridLayout(6,1));

        JLabel l1 = new JLabel("学号");
        //t1 = new JTextField(20);

        JLabel l2 = new JLabel("姓名");
        //JTextField t2 = new JTextField(20);

        JLabel l3 = new JLabel("python");

        JLabel l4 = new JLabel("java");

        JLabel l5 = new JLabel("数据库");

        JButton b2 = new JButton("查询");
        b2.setOpaque(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try {
                    dbopra sdb = new dbopra();
                    String[]a = sdb.select(Integer.parseInt(student.this.t1.getText()));
                    t1.setText(a[1]);
                    t2.setText(a[0]);
                    t3.setText(a[2]);
                    t4.setText(a[3]);
                    t5.setText(a[4]);
                    //sdb.select(student.this.t1.getText());
                }catch(Exception e1){}
            }
        });




        JLayeredPane pa = new JLayeredPane();
        JPanel p1 = new JPanel();
        ImageIcon image = new ImageIcon("E://3.jpg");
        JLabel jl = new JLabel(image);
        p1 = (JPanel)getContentPane();
        p1.add(jl);

        l1.setBounds(150, 40, 30, 30);
        t1.setBounds(200, 40, 200, 30);
        l2.setBounds(150, 90, 30, 30);
        t2.setBounds(200, 90, 200, 30);
        l3.setBounds(150, 140, 60, 30);
        t3.setBounds(200, 140, 200, 30);
        l4.setBounds(150, 190, 30, 30);
        t4.setBounds(200, 190, 200, 30);
        l5.setBounds(150, 240, 60, 30);
        t5.setBounds(200, 240, 200, 30);
        b2.setBounds(260, 290, 60, 30);;

        pa.add(p1, JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);
        pa.add(l4, JLayeredPane.MODAL_LAYER);
        pa.add(l5, JLayeredPane.MODAL_LAYER);
        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);
        pa.add(t4, JLayeredPane.MODAL_LAYER);
        pa.add(t5, JLayeredPane.MODAL_LAYER);
        pa.add(b2, JLayeredPane.MODAL_LAYER);


        setLayeredPane(pa);
        JMenuBar bar = new JMenuBar();
        JMenu op = new JMenu("操作");
        JMenuItem oper = new JMenuItem("多功能面板");
        oper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student.this.dispose();
                new menuopra();
            }
        });

        /*JMenuItem returnmain = new JMenuItem("返回主界面");
        oper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ();
            }
        });*/


        bar.add(op);
        op.add(oper);
        setJMenuBar(bar);
        setVisible(true);


    }
}


public class run extends JFrame{
    final JTextField t1 = new JTextField(20);
    final JTextField t2 = new JTextField(20);
    final JPasswordField t3 = new JPasswordField(20);
    int input = 6;


    public void init(){
        setSize(580,400);
        setTitle("成绩管理系统");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel l1 = new JLabel("身份:");
        //t1 = new JTextField(20);

        JLabel l2 = new JLabel("姓名:");
        //JTextField t2 = new JTextField(20);

        JLabel l3 = new JLabel("密码:");
        //JTextField t3 = new JTextField(20);
        //t3.setEchoChar('*');

        JButton b1 = new JButton("确定");
        b1.setOpaque(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int aa = 0 ;
                    FileReader fr = new FileReader("E://loguser.txt");
                    BufferedReader br = new BufferedReader(fr);
                    List<String>list = new ArrayList();
                    String a = br.readLine();
                    while (a !=null)
                    {
                        list.add(a);
                        a = br.readLine();
                    }
                    /*System.out.println(list.size());
                    System.out.println(list.get(0));
                    System.out.println(list.get(1));
                    System.out.println(list.get(2));
                    System.out.println(list.get(3));*/

                    for (int i = 0; i < list.size(); i++) {

                            String el = list.get(i);
                            //System.out.print(el);
                            //System.out.print(run.this.t2.getText()+String.valueOf(run.this.t3.getPassword()));
                            if (el.equals(run.this.t1.getText() + "," + run.this.t2.getText() + "," + String.valueOf(run.this.t3.getPassword())))
                            {
                                //System.out.print("ok");
                                run.this.dispose();
                                //new student();
                                if (run.this.t1.getText().equals("教师")) {

                                    new teacher();

                                }
                                else if (run.this.t1.getText().equals("学生")) {
                                    new student();
                                }
                                else if (run.this.t1.getText().equals("教师端管理员"))
                                {
                                    new adteacher();
                                }
                                else if (run.this.t1.getText().equals("学生端管理员"))
                                {
                                    new adstudent();
                                }
                                break;
                            }
                            if (!(el.equals(run.this.t1.getText() + "," + run.this.t2.getText() + "," + String.valueOf(run.this.t3.getPassword()))))
                            {
                                aa += 1;
                                //System.out.println(aa);
                                if (aa == list.size())
                                {
                                    //System.out.print(aa);
                                    run.this.input -= 1;
                                    JDialog d = new JDialog();
                                    d.setSize(100, 100);
                                    JOptionPane.showMessageDialog(d, "登录失败！你还有"+input+"次机会", "登陆提示", ERROR_MESSAGE);
                                }
                            }

                    }

                    //JDialog d = new JDialog();
                    //d.setSize(100, 100);
                    //JOptionPane.showMessageDialog(d, "登录失败！你还有"+input+"次机会", "登陆提示", ERROR_MESSAGE);
                    if (input == 0)
                    {
                        run.this.dispose();
                        System.exit(0);
                    }
                }catch(Exception e1) {}
            }
        });
        JButton b2 = new JButton("注册");
        b2.setOpaque(false);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] arr ={};
                    FileWriter fw = new FileWriter("E://loguser.txt",true);
                    fw.write(run.this.t1.getText());
                    fw.write(",");
                    fw.write(run.this.t2.getText());
                    fw.write(",");
                    fw.write(run.this.t3.getText());
                    fw.write("\r\n");
                    fw.close();
                    JDialog d = new JDialog();
                    d.setSize(100, 100);
                    JOptionPane.showMessageDialog(d, "注册成功", "注册提示",JOptionPane.PLAIN_MESSAGE);
                }catch(Exception e1){}
            }
        });
        JButton b3 = new JButton("清空");
        b3.setOpaque(false);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run.this.t1.setText(" ");
                run.this.t2.setText(" ");
                run.this.t3.setText(" ");
                System.out.print(run.this.t3.getPassword());

            }
        });


        //JPanel p2 = new JPanel();
        //JPanel p3 = new JPanel();
        //JPanel p4 = new JPanel();


        JLayeredPane pa = new JLayeredPane();
        JPanel p1 = new JPanel();
        ImageIcon image = new ImageIcon("E://2.jpg");
        JLabel ji = new JLabel(image);
        p1 = (JPanel)getContentPane();
        p1.add(ji);


        l1.setBounds(100, 120, 30, 30);
        t1.setBounds(150,120,200,30);
        l2.setBounds(100, 170, 30, 30);
        t2.setBounds(150,170,200,30);
        l3.setBounds(100, 220, 30, 30);
        t3.setBounds(150,220,200,30);
        b1.setBounds(150,270,60,30);
        b2.setBounds(290,270,60,30);


        pa.add(p1,JLayeredPane.DEFAULT_LAYER);
        pa.add(l1, JLayeredPane.MODAL_LAYER);
        pa.add(l2, JLayeredPane.MODAL_LAYER);
        pa.add(l3, JLayeredPane.MODAL_LAYER);
        pa.add(t1, JLayeredPane.MODAL_LAYER);
        pa.add(t2, JLayeredPane.MODAL_LAYER);
        pa.add(t3, JLayeredPane.MODAL_LAYER);
        pa.add(b1, JLayeredPane.MODAL_LAYER);
        pa.add(b2, JLayeredPane.MODAL_LAYER);


        setLayeredPane(pa);
        setVisible(true);

    }
    public run()
    {
        init();
    }
    public static void main(String[] args)
    {
        new run();
    }

}
