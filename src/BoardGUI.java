import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class BoardGUI extends JFrame implements ActionListener {
    public static int DEPTH= 10;
    public static boolean forceJump=false;
    public static ArrayList<Move> movelist=new ArrayList<Move>();
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static double width = screenSize.getWidth();
    public static double height = screenSize.getHeight();
    public static int HEIGHT=(int)(height*.8),WIDTH=HEIGHT;
    public static int pieceSelected=-1;
    public static boolean selectedKing=false;
    public static JButton s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,resetbutton;
    public static JLabel a,b,c,d,e,f,g,h,l1,l2,l3,l4,l5,l6,l7,l8;
    public static JTextArea info;
    public static char[] board;
    public static JScrollPane textScroll;
    public static boolean player;
    public static String coordinate[]={"b1","d1","f1","h1","a2","c2","e2","g2","b3","d3","f3","h3","a4","c4","e4","g4",
            "b5","d5","f5","h5","a6","c6","e6","g6","b7","d7","f7","h7","a8","c8","e8","g8"};

    void setPiece(JButton b, char c){
        if(c=='b') {
            try {
                Image img = ImageIO.read(getClass().getResource("image/black.png"));
                Image newimg = img.getScaledInstance(HEIGHT / 8, HEIGHT / 8, java.awt.Image.SCALE_SMOOTH) ;
                b.setIcon(new ImageIcon(newimg));
            } catch (IOException ex) {
            }
        }
        else if(c=='r'){
            try {
                Image img = ImageIO.read(getClass().getResource("image/red.png"));
                Image newimg = img.getScaledInstance(HEIGHT / 8, HEIGHT / 8, java.awt.Image.SCALE_SMOOTH) ;
                b.setIcon(new ImageIcon(newimg));
            } catch (IOException ex) {
            }
        }
        else if(c=='B'){
            try {
                Image img = ImageIO.read(getClass().getResource("image/blackK.png"));
                Image newimg = img.getScaledInstance(HEIGHT / 8, HEIGHT / 8, java.awt.Image.SCALE_SMOOTH) ;
                b.setIcon(new ImageIcon(newimg));
            } catch (IOException ex) {
            }
        }
        else if(c=='R'){
            try {
                Image img = ImageIO.read(getClass().getResource("image/redK.png"));
                Image newimg = img.getScaledInstance(HEIGHT / 8, HEIGHT / 8, java.awt.Image.SCALE_SMOOTH) ;
                b.setIcon(new ImageIcon(newimg));
            } catch (IOException ex) {
            }
        }
        else b.setIcon(null);
    }

    public BoardGUI(char[] inboard, boolean inplayer) throws IOException {
        this.setResizable(true);
        Container pane = getContentPane();
        pane.setLayout(null);

        board=inboard;
        player=inplayer;

        a=new JLabel();
        a.setSize(HEIGHT / 8, HEIGHT / 16);
        a.setLocation(HEIGHT / 16, 0);
        a.setText("       A");
        a.setFont(new Font("Georgia", Font.PLAIN, 24));
        a.setForeground(Color.WHITE);
        a.setBackground(Color.DARK_GRAY);
        a.setOpaque(true);
        pane.add(a);

        b=new JLabel();
        b.setSize(HEIGHT / 8, HEIGHT / 16);
        b.setLocation(HEIGHT / 8 + HEIGHT / 16, 0);
        b.setText("       B");
        b.setFont(new Font("Georgia", Font.PLAIN, 24));
        b.setForeground(Color.WHITE);
        b.setBackground(Color.DARK_GRAY);
        b.setOpaque(true);
        pane.add(b);

        c=new JLabel();
        c.setSize(HEIGHT / 8, HEIGHT / 16);
        c.setLocation(2 * (HEIGHT / 8) + HEIGHT / 16, 0);
        c.setText("       C");
        c.setFont(new Font("Georgia", Font.PLAIN, 24));
        c.setForeground(Color.WHITE);
        c.setBackground(Color.DARK_GRAY);
        c.setOpaque(true);
        pane.add(c);

        d=new JLabel();
        d.setSize(HEIGHT / 8, HEIGHT / 16);
        d.setLocation(3 * (HEIGHT / 8) + HEIGHT / 16, 0);
        d.setText("       D");
        d.setFont(new Font("Georgia", Font.PLAIN, 24));
        d.setForeground(Color.WHITE);
        d.setBackground(Color.DARK_GRAY);
        d.setOpaque(true);
        pane.add(d);

        e=new JLabel();
        e.setSize(HEIGHT / 8, HEIGHT / 16);
        e.setLocation(4 * (HEIGHT / 8) + HEIGHT / 16, 0);
        e.setText("       E");
        e.setFont(new Font("Georgia", Font.PLAIN, 24));
        e.setForeground(Color.WHITE);
        e.setBackground(Color.DARK_GRAY);
        e.setOpaque(true);
        pane.add(e);

        f=new JLabel();
        f.setSize(HEIGHT / 8, HEIGHT / 16);
        f.setLocation(5 * (HEIGHT / 8) + HEIGHT / 16, 0);
        f.setText("       F");
        f.setFont(new Font("Georgia", Font.PLAIN, 24));
        f.setForeground(Color.WHITE);
        f.setBackground(Color.DARK_GRAY);
        f.setOpaque(true);
        pane.add(f);

        g=new JLabel();
        g.setSize(HEIGHT / 8, HEIGHT / 16);
        g.setLocation(6 * (HEIGHT / 8) + HEIGHT / 16, 0);
        g.setText("       G");
        g.setFont(new Font("Georgia", Font.PLAIN, 24));
        g.setForeground(Color.WHITE);
        g.setBackground(Color.DARK_GRAY);
        g.setOpaque(true);
        pane.add(g);

        h=new JLabel();
        h.setSize(HEIGHT / 8, HEIGHT / 16);
        h.setLocation(7 * (HEIGHT / 8) + HEIGHT / 16, 0);
        h.setText("       H");
        h.setFont(new Font("Georgia", Font.PLAIN, 24));
        h.setForeground(Color.WHITE);
        h.setBackground(Color.DARK_GRAY);
        h.setOpaque(true);
        pane.add(h);

        l1=new JLabel();
        l1.setSize(HEIGHT / 16, HEIGHT / 8);
        l1.setLocation(0, HEIGHT / 16);
        l1.setText("   1");
        l1.setFont(new Font("Georgia", Font.PLAIN, 24));
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.DARK_GRAY);
        l1.setOpaque(true);
        pane.add(l1);

        l2=new JLabel();
        l2.setSize(HEIGHT / 16, HEIGHT / 8);
        l2.setLocation(0, HEIGHT / 8 + HEIGHT / 16);
        l2.setText("   2");
        l2.setFont(new Font("Georgia", Font.PLAIN, 24));
        l2.setForeground(Color.WHITE);
        l2.setBackground(Color.DARK_GRAY);
        l2.setOpaque(true);
        pane.add(l2);

        l3=new JLabel();
        l3.setSize(HEIGHT / 16, HEIGHT / 8);
        l3.setLocation(0, 2 * (HEIGHT / 8) + HEIGHT / 16);
        l3.setText("   3");
        l3.setFont(new Font("Georgia", Font.PLAIN, 24));
        l3.setForeground(Color.WHITE);
        l3.setBackground(Color.DARK_GRAY);
        l3.setOpaque(true);
        pane.add(l3);

        l4=new JLabel();
        l4.setSize(HEIGHT / 16, HEIGHT / 8);
        l4.setLocation(0, 3 * (HEIGHT / 8) + HEIGHT / 16);
        l4.setText("   4");
        l4.setFont(new Font("Georgia", Font.PLAIN, 24));
        l4.setForeground(Color.WHITE);
        l4.setBackground(Color.DARK_GRAY);
        l4.setOpaque(true);
        pane.add(l4);

        l5=new JLabel();
        l5.setSize(HEIGHT / 16, HEIGHT / 8);
        l5.setLocation(0, 4 * (HEIGHT / 8) + HEIGHT / 16);
        l5.setText("   5");
        l5.setFont(new Font("Georgia", Font.PLAIN, 24));
        l5.setForeground(Color.WHITE);
        l5.setBackground(Color.DARK_GRAY);
        l5.setOpaque(true);
        pane.add(l5);

        l6=new JLabel();
        l6.setSize(HEIGHT / 16, HEIGHT / 8);
        l6.setLocation(0, 5 * (HEIGHT / 8) + HEIGHT / 16);
        l6.setText("   6");
        l6.setFont(new Font("Georgia", Font.PLAIN, 24));
        l6.setForeground(Color.WHITE);
        l6.setBackground(Color.DARK_GRAY);
        l6.setOpaque(true);
        pane.add(l6);

        l7=new JLabel();
        l7.setSize(HEIGHT / 16, HEIGHT / 8);
        l7.setLocation(0, 6 * (HEIGHT / 8) + HEIGHT / 16);
        l7.setText("   7");
        l7.setFont(new Font("Georgia", Font.PLAIN, 24));
        l7.setForeground(Color.WHITE);
        l7.setBackground(Color.DARK_GRAY);
        l7.setOpaque(true);
        pane.add(l7);

        l8=new JLabel();
        l8.setSize(HEIGHT / 16, HEIGHT / 8);
        l8.setLocation(0, 7 * (HEIGHT / 8) + HEIGHT / 16);
        l8.setText("   8");
        l8.setFont(new Font("Georgia", Font.PLAIN, 24));
        l8.setForeground(Color.WHITE);
        l8.setBackground(Color.DARK_GRAY);
        l8.setOpaque(true);
        pane.add(l8);

        s1=new JButton();
        s1.setSize(HEIGHT / 8, HEIGHT / 8);
        s1.setLocation(HEIGHT / 16 + HEIGHT / 8, HEIGHT / 16 + 0);
        s1.setBackground(Color.BLACK);
        setPiece(s1, board[0]);
        s1.addActionListener(this);
        s1.setActionCommand("0");
        pane.add(s1);

        s2=new JButton();
        s2.setSize(HEIGHT / 8, HEIGHT / 8);
        s2.setLocation(HEIGHT / 16 + HEIGHT / 8 * 3, HEIGHT / 16 + 0);
        s2.setBackground(Color.BLACK);
        setPiece(s2, board[1]);
        s2.addActionListener(this);
        s2.setActionCommand("1");
        pane.add(s2);

        s3=new JButton();
        s3.setSize(HEIGHT / 8, HEIGHT / 8);
        s3.setLocation(HEIGHT / 16 + HEIGHT / 8 * 5, HEIGHT / 16 + 0);
        s3.setBackground(Color.BLACK);
        setPiece(s3, board[2]);
        s3.addActionListener(this);
        s3.setActionCommand("2");
        pane.add(s3);

        s4=new JButton();
        s4.setSize(HEIGHT / 8, HEIGHT / 8);
        s4.setLocation(HEIGHT / 16 + HEIGHT / 8 * 7, HEIGHT / 16 + 0);
        s4.setBackground(Color.BLACK);
        setPiece(s4, board[3]);
        s4.addActionListener(this);
        s4.setActionCommand("3");
        pane.add(s4);

        s5=new JButton();
        s5.setSize(HEIGHT / 8, HEIGHT / 8);
        s5.setLocation(HEIGHT / 16 + 0, HEIGHT / 16 + HEIGHT / 8);
        s5.setBackground(Color.BLACK);
        setPiece(s5, board[4]);
        s5.addActionListener(this);
        s5.setActionCommand("4");
        pane.add(s5);

        s6=new JButton();
        s6.setSize(HEIGHT / 8, HEIGHT / 8);
        s6.setLocation(HEIGHT / 16 + HEIGHT / 8 * 2, HEIGHT / 16 + HEIGHT / 8);
        s6.setBackground(Color.BLACK);
        setPiece(s6, board[5]);
        s6.addActionListener(this);
        s6.setActionCommand("5");
        pane.add(s6);

        s7=new JButton();
        s7.setSize(HEIGHT / 8, HEIGHT / 8);
        s7.setLocation(HEIGHT / 16 + HEIGHT / 8 * 4, HEIGHT / 16 + HEIGHT / 8);
        s7.setBackground(Color.BLACK);
        setPiece(s7, board[6]);
        s7.addActionListener(this);
        s7.setActionCommand("6");
        pane.add(s7);

        s8=new JButton();
        s8.setSize(HEIGHT / 8, HEIGHT / 8);
        s8.setLocation(HEIGHT / 16 + HEIGHT / 8 * 6, HEIGHT / 16 + HEIGHT / 8);
        s8.setBackground(Color.BLACK);
        setPiece(s8, board[7]);
        s8.addActionListener(this);
        s8.setActionCommand("7");
        pane.add(s8);

        s9=new JButton();
        s9.setSize(HEIGHT / 8, HEIGHT / 8);
        s9.setLocation(HEIGHT / 16 + HEIGHT / 8, HEIGHT / 16 + HEIGHT / 8 * 2);
        s9.setBackground(Color.BLACK);
        setPiece(s9, board[8]);
        s9.addActionListener(this);
        s9.setActionCommand("8");
        pane.add(s9);

        s10=new JButton();
        s10.setSize(HEIGHT / 8, HEIGHT / 8);
        s10.setLocation(HEIGHT / 16 + HEIGHT / 8 * 3, HEIGHT / 16 + HEIGHT / 8 * 2);
        s10.setBackground(Color.BLACK);
        setPiece(s10, board[9]);
        s10.addActionListener(this);
        s10.setActionCommand("9");
        pane.add(s10);

        s11=new JButton();
        s11.setSize(HEIGHT / 8, HEIGHT / 8);
        s11.setLocation(HEIGHT / 16 + HEIGHT / 8 * 5, HEIGHT / 16 + HEIGHT / 8 * 2);
        s11.setBackground(Color.BLACK);
        setPiece(s11, board[10]);
        s11.addActionListener(this);
        s11.setActionCommand("10");
        pane.add(s11);

        s12=new JButton();
        s12.setSize(HEIGHT / 8, HEIGHT / 8);
        s12.setLocation(HEIGHT / 16 + HEIGHT / 8 * 7, HEIGHT / 16 + HEIGHT / 8 * 2);
        s12.setBackground(Color.BLACK);
        setPiece(s12, board[11]);
        s12.addActionListener(this);
        s12.setActionCommand("11");
        pane.add(s12);

        s13=new JButton();
        s13.setSize(HEIGHT / 8, HEIGHT / 8);
        s13.setLocation(HEIGHT / 16 + 0, HEIGHT / 16 + HEIGHT / 8 * 3);
        s13.setBackground(Color.BLACK);
        setPiece(s13, board[12]);
        s13.addActionListener(this);
        s13.setActionCommand("12");
        pane.add(s13);

        s14=new JButton();
        s14.setSize(HEIGHT / 8, HEIGHT / 8);
        s14.setLocation(HEIGHT / 16 + HEIGHT / 8 * 2, HEIGHT / 16 + HEIGHT / 8 * 3);
        s14.setBackground(Color.BLACK);
        setPiece(s14, board[13]);
        s14.addActionListener(this);
        s14.setActionCommand("13");
        pane.add(s14);

        s15=new JButton();
        s15.setSize(HEIGHT / 8, HEIGHT / 8);
        s15.setLocation(HEIGHT / 16 + HEIGHT / 8 * 4, HEIGHT / 16 + HEIGHT / 8 * 3);
        s15.setBackground(Color.BLACK);
        setPiece(s15, board[14]);
        s15.addActionListener(this);
        s15.setActionCommand("14");
        pane.add(s15);

        s16=new JButton();
        s16.setSize(HEIGHT / 8, HEIGHT / 8);
        s16.setLocation(HEIGHT / 16 + HEIGHT / 8 * 6, HEIGHT / 16 + HEIGHT / 8 * 3);
        s16.setBackground(Color.BLACK);
        setPiece(s16, board[15]);
        s16.addActionListener(this);
        s16.setActionCommand("15");
        pane.add(s16);

        s17=new JButton();
        s17.setSize(HEIGHT / 8, HEIGHT / 8);
        s17.setLocation(HEIGHT / 16 + HEIGHT / 8, HEIGHT / 16 + HEIGHT / 8 * 4);
        s17.setBackground(Color.BLACK);
        setPiece(s17, board[16]);
        s17.addActionListener(this);
        s17.setActionCommand("16");
        pane.add(s17);

        s18=new JButton();
        s18.setSize(HEIGHT / 8, HEIGHT / 8);
        s18.setLocation(HEIGHT / 16 + HEIGHT / 8 * 3, HEIGHT / 16 + HEIGHT / 8 * 4);
        s18.setBackground(Color.BLACK);
        setPiece(s18, board[17]);
        s18.addActionListener(this);
        s18.setActionCommand("17");
        pane.add(s18);

        s19=new JButton();
        s19.setSize(HEIGHT / 8, HEIGHT / 8);
        s19.setLocation(HEIGHT / 16 + HEIGHT / 8 * 5, HEIGHT / 16 + HEIGHT / 8 * 4);
        s19.setBackground(Color.BLACK);
        setPiece(s19, board[18]);
        s19.addActionListener(this);
        s19.setActionCommand("18");
        pane.add(s19);

        s20=new JButton();
        s20.setSize(HEIGHT / 8, HEIGHT / 8);
        s20.setLocation(HEIGHT / 16 + HEIGHT / 8 * 7, HEIGHT / 16 + HEIGHT / 8 * 4);
        s20.setBackground(Color.BLACK);
        setPiece(s20, board[19]);
        s20.addActionListener(this);
        s20.setActionCommand("19");
        pane.add(s20);

        s21=new JButton();
        s21.setSize(HEIGHT / 8, HEIGHT / 8);
        s21.setLocation(HEIGHT / 16 + 0, HEIGHT / 16 + HEIGHT / 8 * 5);
        s21.setBackground(Color.BLACK);
        setPiece(s21, board[20]);
        s21.addActionListener(this);
        s21.setActionCommand("20");
        pane.add(s21);

        s22=new JButton();
        s22.setSize(HEIGHT / 8, HEIGHT / 8);
        s22.setLocation(HEIGHT / 16 + HEIGHT / 8 * 2, HEIGHT / 16 + HEIGHT / 8 * 5);
        s22.setBackground(Color.BLACK);
        setPiece(s22, board[21]);
        s22.addActionListener(this);
        s22.setActionCommand("21");
        pane.add(s22);

        s23=new JButton();
        s23.setSize(HEIGHT / 8, HEIGHT / 8);
        s23.setLocation(HEIGHT / 16 + HEIGHT / 8 * 4, HEIGHT / 16 + HEIGHT / 8 * 5);
        s23.setBackground(Color.BLACK);
        setPiece(s23, board[22]);
        s23.addActionListener(this);
        s23.setActionCommand("22");
        pane.add(s23);

        s24=new JButton();
        s24.setSize(HEIGHT / 8, HEIGHT / 8);
        s24.setLocation(HEIGHT / 16 + HEIGHT / 8 * 6, HEIGHT / 16 + HEIGHT / 8 * 5);
        s24.setBackground(Color.BLACK);
        setPiece(s24, board[23]);
        s24.addActionListener(this);
        s24.setActionCommand("23");
        pane.add(s24);

        s25=new JButton();
        s25.setSize(HEIGHT / 8, HEIGHT / 8);
        s25.setLocation(HEIGHT / 16 + HEIGHT / 8, HEIGHT / 16 + HEIGHT / 8 * 6);
        s25.setBackground(Color.BLACK);
        setPiece(s25, board[24]);
        s25.addActionListener(this);
        s25.setActionCommand("24");
        pane.add(s25);

        s26=new JButton();
        s26.setSize(HEIGHT / 8, HEIGHT / 8);
        s26.setLocation(HEIGHT / 16 + HEIGHT / 8 * 3, HEIGHT / 16 + HEIGHT / 8 * 6);
        s26.setBackground(Color.BLACK);
        setPiece(s26, board[25]);
        s26.addActionListener(this);
        s26.setActionCommand("25");
        pane.add(s26);

        s27=new JButton();
        s27.setSize(HEIGHT / 8, HEIGHT / 8);
        s27.setLocation(HEIGHT / 16 + HEIGHT / 8 * 5, HEIGHT / 16 + HEIGHT / 8 * 6);
        s27.setBackground(Color.BLACK);
        setPiece(s27, board[26]);
        s27.addActionListener(this);
        s27.setActionCommand("26");
        pane.add(s27);

        s28=new JButton();
        s28.setSize(HEIGHT / 8, HEIGHT / 8);
        s28.setLocation(HEIGHT / 16 + HEIGHT / 8 * 7, HEIGHT / 16 + HEIGHT / 8 * 6);
        s28.setBackground(Color.BLACK);
        setPiece(s28, board[27]);
        s28.addActionListener(this);
        s28.setActionCommand("27");
        pane.add(s28);

        s29=new JButton();
        s29.setSize(HEIGHT / 8, HEIGHT / 8);
        s29.setLocation(HEIGHT / 16 + 0, HEIGHT / 16 + HEIGHT / 8 * 7);
        s29.setBackground(Color.BLACK);
        setPiece(s29, board[28]);
        s29.addActionListener(this);
        s29.setActionCommand("28");
        pane.add(s29);

        s30=new JButton();
        s30.setSize(HEIGHT / 8, HEIGHT / 8);
        s30.setLocation(HEIGHT / 16 + HEIGHT / 8 * 2, HEIGHT / 16 + HEIGHT / 8 * 7);
        s30.setBackground(Color.BLACK);
        setPiece(s30, board[29]);
        s30.addActionListener(this);
        s30.setActionCommand("29");
        pane.add(s30);

        s31=new JButton();
        s31.setSize(HEIGHT / 8, HEIGHT / 8);
        s31.setLocation(HEIGHT / 16 + HEIGHT / 8 * 4, HEIGHT / 16 + HEIGHT / 8 * 7);
        s31.setBackground(Color.BLACK);
        setPiece(s31, board[30]);
        s31.addActionListener(this);
        s31.setActionCommand("30");
        pane.add(s31);

        s32=new JButton();
        s32.setSize(HEIGHT / 8, HEIGHT / 8);
        s32.setLocation(HEIGHT / 16 + HEIGHT / 8 * 6, HEIGHT / 16 + HEIGHT / 8 * 7);
        s32.setBackground(Color.BLACK);
        setPiece(s32, board[31]);
        s32.addActionListener(this);
        s32.setActionCommand("31");
        pane.add(s32);

        resetbutton=new JButton("R");
        resetbutton.setSize(HEIGHT / 16, HEIGHT / 16);
        resetbutton.setLocation(0, 0);
        resetbutton.addActionListener(this);
        resetbutton.setActionCommand("32");
        resetbutton.setFont(new Font("Georgia", Font.PLAIN, 24));
        resetbutton.setForeground(Color.WHITE);
        resetbutton.setBackground(Color.DARK_GRAY);
        resetbutton.setOpaque(true);
        pane.add(resetbutton);

        info=new JTextArea();
        info.setSize(6*(HEIGHT/8), 8*(HEIGHT/8)+HEIGHT/6+39);
      //  info.setLocation(HEIGHT / 16 + WIDTH, HEIGHT / 16 + 0);
        movelist=Logic.runACheck(player,board,false);
      //  String report=Minmax.makeReport(board,movelist,DEPTH,player);
       // info.setText(report);
        info.setLocation(0, 0);
        JScrollPane textScroll=new JScrollPane(info);
        textScroll.setBounds(8 * (HEIGHT / 8) + HEIGHT / 16, 0, 6 * (HEIGHT / 8), 8 * (HEIGHT / 8) + HEIGHT / 16);
        textScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pane.add(textScroll);
        //String report=Minmax.getBestMoves(board, movelist, DEPTH, player);
        //String report=Minmax.makeReport(board,movelist,DEPTH,player);
        //info.setText(report);

        String report=Minmax.bestReport(board, Logic.createAllMoves(board, player), DEPTH, player);
        info.setText(report);


        this.setSize(14*(HEIGHT/8)+HEIGHT/16,HEIGHT/16+8*(HEIGHT/8)+39);
        pane.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        this.setTitle("Checkers Tutor");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="32"){
            for (int i = 0; i < 32; i++) {
                if (i < 12) board[i] = 'r';
                else if (i > 19) board[i] = 'b';
                else board[i] = 'x';
            }
            redrawBoard();
            player=true;
            movelist=Logic.runACheck(player,board,false);
            String report=Minmax.bestReport(board, movelist, DEPTH, player);
            //String report=Minmax.makeReport(board,movelist,DEPTH,player);
            info.setText(report);
            return;
        }

        movelist=Logic.runACheck(player,board,forceJump);
        int i=Integer.parseInt(e.getActionCommand());
        //select a piece
        if(pieceSelected==-1){
            if(Logic.checkMyPiece(board,player,i)){
                pieceSelected=i;
                if(board[i]=='B'||board[i]=='R')selectedKing=true;
                else selectedKing=false;
                highlightSquare(i);
            }
        }

        //click on selected piece again
        else if(pieceSelected==i){
            resetSelection(i);
        }

        //check if selected move is legal
        else if(Logic.checkLegal(board,pieceSelected,i,forceJump,player)){
            boolean moveFound=false;
            for(int t=0;t<movelist.size();t++){
                if(movelist.get(t).start==pieceSelected&&movelist.get(t).end==i)
                    moveFound=true;
            }
            if(!moveFound)return;
            boolean jumpmove=false;
            if(Math.abs(pieceSelected-i)>6)jumpmove=true;
            char originalPiece=board[pieceSelected];
            board=Logic.movePiece(board,new Move(pieceSelected,i,board[pieceSelected]));
            boolean newKing=false;
            if((board[i]!='B'&&board[i]!='R')&&Logic.checkKing(i,player,selectedKing)){
                newKing=true;
                if(player)board[i]='B';
                else board[i]='R';
            }
            if(originalPiece!=board[i])newKing=true;
            redrawBoard();
            if(!newKing) {
                resetSelection(pieceSelected);
                pieceSelected = i;
                highlightSquare(i);
                if (jumpmove&&Logic.getDoubleMoves(i,board,player).size()>0) return;
            }
            resetSelection(pieceSelected);
            player=!player;
            forceJump=false;
            movelist=Logic.runACheck(player,board,false);
            if(movelist.size()==0){
                String winner=new String();
                if(player)winner="Red";
                else winner="Black";
                info.setText("Game over!\n"+winner+" wins!");
            }
            else {
                String report=Minmax.bestReport(board, Logic.createAllMoves(board, player), DEPTH, player);
                info.setText(report);
                ArrayList<Move> myList=new ArrayList<Move>();
                myList=Logic.createAllMoves(board, player);
                System.out.println(Minmax.makeReport(board,myList,10,player));
            }
        }








    }

    void redrawBoard(){
        setPiece(s1, board[0]);
        setPiece(s2, board[1]);
        setPiece(s3, board[2]);
        setPiece(s4, board[3]);
        setPiece(s5, board[4]);
        setPiece(s6, board[5]);
        setPiece(s7, board[6]);
        setPiece(s8, board[7]);
        setPiece(s9, board[8]);
        setPiece(s10, board[9]);
        setPiece(s11, board[10]);
        setPiece(s12, board[11]);
        setPiece(s13, board[12]);
        setPiece(s14, board[13]);
        setPiece(s15, board[14]);
        setPiece(s16, board[15]);
        setPiece(s17, board[16]);
        setPiece(s18, board[17]);
        setPiece(s19, board[18]);
        setPiece(s20, board[19]);
        setPiece(s21, board[20]);
        setPiece(s22, board[21]);
        setPiece(s23, board[22]);
        setPiece(s24, board[23]);
        setPiece(s25, board[24]);
        setPiece(s26, board[25]);
        setPiece(s27, board[26]);
        setPiece(s28, board[27]);
        setPiece(s29, board[28]);
        setPiece(s30, board[29]);
        setPiece(s31, board[30]);
        setPiece(s32, board[31]);
    }

    void highlightSquare(int i){

        Border thickBorder = new LineBorder(Color.WHITE, 12);
        if (i == 0) s1.setBorder(thickBorder);
        if (i == 1) s2.setBorder(thickBorder);
        if (i == 2) s3.setBorder(thickBorder);
        if (i == 3) s4.setBorder(thickBorder);
        if (i == 4) s5.setBorder(thickBorder);
        if (i == 5) s6.setBorder(thickBorder);
        if (i == 6) s7.setBorder(thickBorder);
        if (i == 7) s8.setBorder(thickBorder);
        if (i == 8) s9.setBorder(thickBorder);
        if (i == 9) s10.setBorder(thickBorder);
        if (i == 10) s11.setBorder(thickBorder);
        if (i == 11) s12.setBorder(thickBorder);
        if (i == 12) s13.setBorder(thickBorder);
        if (i == 13) s14.setBorder(thickBorder);
        if (i == 14) s15.setBorder(thickBorder);
        if (i == 15) s16.setBorder(thickBorder);
        if (i == 16) s17.setBorder(thickBorder);
        if (i == 17) s18.setBorder(thickBorder);
        if (i == 18) s19.setBorder(thickBorder);
        if (i == 19) s20.setBorder(thickBorder);
        if (i == 20) s21.setBorder(thickBorder);
        if (i == 21) s22.setBorder(thickBorder);
        if (i == 22) s23.setBorder(thickBorder);
        if (i == 23) s24.setBorder(thickBorder);
        if (i == 24) s25.setBorder(thickBorder);
        if (i == 25) s26.setBorder(thickBorder);
        if (i == 26) s27.setBorder(thickBorder);
        if (i == 27) s28.setBorder(thickBorder);
        if (i == 28) s29.setBorder(thickBorder);
        if (i == 29) s30.setBorder(thickBorder);
        if (i == 30) s31.setBorder(thickBorder);
        if (i == 31) s32.setBorder(thickBorder);
    }

    void resetSelection(int i){
        pieceSelected=-1;
        selectedKing=false;
        if(i==0)s1.setBorder(null);
        if(i==1)s2.setBorder(null);
        if(i==2)s3.setBorder(null);
        if(i==3)s4.setBorder(null);
        if(i==4)s5.setBorder(null);
        if(i==5)s6.setBorder(null);
        if(i==6)s7.setBorder(null);
        if(i==7)s8.setBorder(null);
        if(i==8)s9.setBorder(null);
        if(i==9)s10.setBorder(null);
        if(i==10)s11.setBorder(null);
        if(i==11)s12.setBorder(null);
        if(i==12)s13.setBorder(null);
        if(i==13)s14.setBorder(null);
        if(i==14)s15.setBorder(null);
        if(i==15)s16.setBorder(null);
        if(i==16)s17.setBorder(null);
        if(i==17)s18.setBorder(null);
        if(i==18)s19.setBorder(null);
        if(i==19)s20.setBorder(null);
        if(i==20)s21.setBorder(null);
        if(i==21)s22.setBorder(null);
        if(i==22)s23.setBorder(null);
        if(i==23)s24.setBorder(null);
        if(i==24)s25.setBorder(null);
        if(i==25)s26.setBorder(null);
        if(i==26)s27.setBorder(null);
        if(i==27)s28.setBorder(null);
        if(i==28)s29.setBorder(null);
        if(i==29)s30.setBorder(null);
        if(i==30)s31.setBorder(null);
        if(i==31)s32.setBorder(null);
    }

    public String toString(){
        String s=new String();
        for(int i=0;i<board.length;i++){
            s+=board[i];
        }
        return s;
    }
}
