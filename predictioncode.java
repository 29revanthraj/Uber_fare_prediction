//Model and fare prediction start
package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class vehframe
        extends JFrame
        implements ActionListener {
    private Container container;
    private JLabel l7;
    private JLabel l8;
    private JLabel l9;
    private JLabel l10;
    private JButton a;
    private JButton b;
    private JButton c;

    public vehframe()
    {
        setTitle("Vehicles");
        setBounds(300, 110, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        l7 = new JLabel("SELECT VEHICLE TYPE");
        l7.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        l7.setBounds(100, 30, 400, 40);
        container.add(l7);

        a = new JButton("UberGo");
        a.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        a.setBounds(210, 130, 180, 50);
        a.addActionListener(this);
        container.add(a);

        l8 = new JLabel("Affordable, compact rides");
        l8.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        l8.setBounds(220, 180, 180, 20);
        container.add(l8);

        b = new JButton("Go Sedan");
        b.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        b.setBounds(210, 230, 180, 50);
        b.addActionListener(this);
        container.add(b);

        l9 = new JLabel("Affordable rides in a sedan");
        l9.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        l9.setBounds(210, 280, 200, 20);
        container.add(l9);

        c = new JButton("Uber Auto");
        c.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        c.setBounds(210, 330, 180, 50);
        c.addActionListener(this);
        container.add(c);

        l10 = new JLabel("No bargaining,doorstep pickup");
        l10.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        l10.setBounds(200, 380, 200, 20);
        container.add(l10);

        container.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("src/vehuselectimg.png"));
        container.add(background);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == a) {
            //setVisible(false);
            Label l10,l11,l12;
            JFrame f=new JFrame("UberGo");

            l10 = new Label(" UberGo");
            l10.setBounds(120, 50, 150, 40);
            l10.setFont(new Font("Arial", Font.PLAIN, 35));

            l11= new Label("PREDICTED FARE ");
            l11.setBounds(80, 150, 230, 40);
            l11.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

            l12 = new Label("Estimated km   : ");
            l12.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
            l12.setBounds(40, 110, 130, 20);

            JTextField t6 = new JTextField();
            t6.setBounds(190, 110, 150, 25);
            f.add(l12);
            f.add(t6);

            final JTextArea tf=new JTextArea();
            tf.setBounds(40,200, 300,70);
            tf.setLineWrap(true);

            JButton b=new JButton("Click Here");
            b.setBounds(140,290,95,30);
            b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String km = t6.getText();
                    double x[]={1.5,2.3,2.09,1.79,3.61,2.34,1.64,2.49,3.44,3.23,2.46,1.36,0.91,1.36,1.57,2.67,1.79,2.59,2.63,2.61,2.5,2.58,1.41,2.27,4.44,2.62,2.8,1.34,2.94,3.05,2.66,2.84,4.43,1.22,1.04,1.07,4.55,2.61,0.63,0.54,2.32,1.35,1.25,1.56,1.61,2.33,1.35,2.19,1.52,1.21,1.57,1.23,1.86,1.23,3.39,3.19,3.07,0.49,1.03,2.38,1.08,1.92,1.97,4.73,2.44,3.3,1.81,3.2,3.1,3.08,3.45,2,2.48,0.39,2.12,0.55,1.71,2.14,2.66,2.81,1.89,1.3,3.04,3.05,2.72,};
                    double y[]={18,12,19.5,26,10,16,19,24,28.5,10.5,10.5,28.5,18.5,18,26,27.5,18,26.5,18.5,28,31,13,23,27.5,12,15,11.5,29.5,25,26,29,30.5,24,18.5,28,37.5,28.5,18.5,39,29,27.5,37.5,33.5,17,10.5,14,17.5,17.5,11.5,6,15,19,9,15,41,10.5,31.5,34,35,12.5,11,37.5,28.5,26,19.5,13.5,29.5,28.5,28.5,34,27,36,28,30.5,37,35.5,37,39.5,37.5,48.5,39.5,48,35,47.5,35};
                    double n=85;
                    double sum=0,sum1=0,mean=0,mean1=0;
                    for(int i=0;i<n;i++)
                    {
                        sum=sum+x[i];
                    }
                    mean=sum/n;
                    for(int j=0;j<n;j++)
                    {
                        sum1=sum1+y[j];
                    }
                    mean1=sum1/n;
                    double s=0,s1=0;
                    double sd = 0,sd1=0;
                    for (int i=0;i<n;i++)
                    {
                        sd=x[i]-mean;
                        s=s+sd;
                    }
                    for (int i=0;i<n;i++)
                    {
                        sd1=y[i]-mean1;
                        s1=s1+sd1;
                    }
                    double m=(sd*sd1)/(sd*sd);
                    double c;
                    c=mean1-m*mean;
                    float x1 =Float.parseFloat(km);
                    double kms=(m*x1+c);
                    float pr;
                    pr = (float)(kms);
                    if(x1<3){
                        String caution = " Cabs are not available\n";
                        String range = " Min Km > 3 ";
                        tf.setText(caution+range);
                    }
                    else if((x1<50) && (x1>3)){
                        String data2 = "  Fare : "+Math.floor(pr+105);
                        tf.setText(data2);
                    }
                    else{
                        String data2 = "  Fare : "+Math.floor(pr+260);
                        tf.setText(data2);
                    }

                    tf.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
                    tf.setEditable(false);
                }
            });
            f.add(l10);
            f.add(l11);
            f.add(b);f.add(tf);
            f.setLayout(new BorderLayout());
            JLabel background=new JLabel(new ImageIcon("src/predictimage.jpg"));
            f.add(background);
            f.setSize(400,400);
            f.setVisible(true);

        }
        if (e.getSource() == b) {
            Label l13,l14,l15;
            JFrame f=new JFrame("Go Sedon");

            l13 = new Label("Go Sedon");
            l13.setBounds(120, 50, 170, 40);
            l13.setFont(new Font("Arial", Font.PLAIN, 35));

            l14= new Label("PREDICTED FARE ");
            l14.setBounds(80, 150, 230, 40);
            l14.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

            l15 = new Label("Estimated km   : ");
            l15.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
            l15.setBounds(40, 110, 130, 20);

            JTextField t5 = new JTextField();
            t5.setBounds(190, 110, 150, 25);
            f.add(l15);
            f.add(t5);

            final JTextArea tf=new JTextArea();
            tf.setBounds(40,200, 300,70);
            tf.setLineWrap(true);

            JButton b=new JButton("Click Here");
            b.setBounds(140,290,95,30);
            b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String km = t5.getText();
                    double x[]={1.5,2.3,2.09,1.79,3.61,2.34,1.64,2.49,3.44,3.23,2.46,1.36,0.91,1.36,1.57,2.67,1.79,2.59,2.63,2.61,2.5,2.58,1.41,2.27,4.44,2.62,2.8,1.34,2.94,3.05,2.66,2.84,4.43,1.22,1.04,1.07,4.55,2.61,0.63,0.54,2.32,1.35,1.25,1.56,1.61,2.33,1.35,2.19,1.52,1.21,1.57,1.23,1.86,1.23,3.39,3.19,3.07,0.49,1.03,2.38,1.08,1.92,1.97,4.73,2.44,3.3,1.81,3.2,3.1,3.08,3.45,2,2.48,0.39,2.12,0.55,1.71,2.14,2.66,2.81,1.89,1.3,3.04,3.05,2.72,};
                    double y[]={18,12,19.5,26,10,16,19,24,28.5,10.5,10.5,28.5,18.5,18,26,27.5,18,26.5,18.5,28,31,13,23,27.5,12,15,11.5,29.5,25,26,29,30.5,24,18.5,28,37.5,28.5,18.5,39,29,27.5,37.5,33.5,17,10.5,14,17.5,17.5,11.5,6,15,19,9,15,41,10.5,31.5,34,35,12.5,11,37.5,28.5,26,19.5,13.5,29.5,28.5,28.5,34,27,36,28,30.5,37,35.5,37,39.5,37.5,48.5,39.5,48,35,47.5,35};
                    double n=85;
                    double sum=0,sum1=0,mean=0,mean1=0;
                    for(int i=0;i<n;i++)
                    {
                        sum=sum+x[i];
                    }
                    mean=sum/n;
                    for(int j=0;j<n;j++)
                    {
                        sum1=sum1+y[j];
                    }
                    mean1=sum1/n;
                    double s=0,s1=0;
                    double sd = 0,sd1=0;
                    for (int i=0;i<n;i++)
                    {
                        sd=x[i]-mean;
                        s=s+sd;
                    }
                    for (int i=0;i<n;i++)
                    {
                        sd1=y[i]-mean1;
                        s1=s1+sd1;
                    }
                    double m=(sd*sd1)/(sd*sd);
                    double c;
                    c=mean1-m*mean;
                    float x1 =Float.parseFloat(km);
                    double kms=(m*x1+c);
                    float pr;
                    pr = (float)(kms);
                    if(x1<3){
                        String caution = " Cabs are not available\n";
                        String range = " Min Km > 3 ";
                        tf.setText(caution+range);
                    }
                    else if((x1<=50) && (x1>3)){
                        String data2 = "  Fare : "+Math.floor(pr+150);
                        tf.setText(data2);
                    }
                    else{
                        String data2 = "  Fare : "+Math.floor(pr+200);
                        tf.setText(data2);
                    }

                    tf.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
                    tf.setEditable(false);
                }
            });
            f.add(l13);
            f.add(l14);
            f.add(b);f.add(tf);
            f.setLayout(new BorderLayout());
            JLabel background=new JLabel(new ImageIcon("src/predictimage.jpg"));
            f.add(background);
            f.setSize(400,400);
            //f.setLayout(null);
            f.setVisible(true);

        }
        if (e.getSource() == c) {
            //setVisible(false);
            Label l16,l17,l18;
            JFrame f=new JFrame("Uber Auto");

            l16 = new Label("Uber Auto");
            l16.setBounds(120, 50, 170, 40);
            l16.setFont(new Font("Arial", Font.PLAIN, 35));

            l17= new Label("PREDICTED FARE ");
            l17.setBounds(80, 150, 230, 40);
            l17.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));

            l18 = new Label("Estimated km   : ");
            l18.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
            l18.setBounds(40, 110, 130, 20);

            JTextField t7 = new JTextField();
            t7.setBounds(190, 110, 150, 25);
            f.add(l18);
            f.add(t7);

            final JTextArea tf=new JTextArea();
            tf.setBounds(40,200, 300,70);
            tf.setLineWrap(true);

            JButton b=new JButton("Click Here");
            b.setBounds(140,290,95,30);
            b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String km = t7.getText();
                    double x[]={1.5,2.3,2.09,1.79,3.61,2.34,1.64,2.49,3.44,3.23,2.46,1.36,0.91,1.36,1.57,2.67,1.79,2.59,2.63,2.61,2.5,2.58,1.41,2.27,4.44,2.62,2.8,1.34,2.94,3.05,2.66,2.84,4.43,1.22,1.04,1.07,4.55,2.61,0.63,0.54,2.32,1.35,1.25,1.56,1.61,2.33,1.35,2.19,1.52,1.21,1.57,1.23,1.86,1.23,3.39,3.19,3.07,0.49,1.03,2.38,1.08,1.92,1.97,4.73,2.44,3.3,1.81,3.2,3.1,3.08,3.45,2,2.48,0.39,2.12,0.55,1.71,2.14,2.66,2.81,1.89,1.3,3.04,3.05,2.72,};
                    double y[]={18,12,19.5,26,10,16,19,24,28.5,10.5,10.5,28.5,18.5,18,26,27.5,18,26.5,18.5,28,31,13,23,27.5,12,15,11.5,29.5,25,26,29,30.5,24,18.5,28,37.5,28.5,18.5,39,29,27.5,37.5,33.5,17,10.5,14,17.5,17.5,11.5,6,15,19,9,15,41,10.5,31.5,34,35,12.5,11,37.5,28.5,26,19.5,13.5,29.5,28.5,28.5,34,27,36,28,30.5,37,35.5,37,39.5,37.5,48.5,39.5,48,35,47.5,35};
                    double n=85;
                    double sum=0,sum1=0,mean=0,mean1=0;
                    for(int i=0;i<n;i++)
                    {
                        sum=sum+x[i];
                    }
                    mean=sum/n;
                    for(int j=0;j<n;j++)
                    {
                        sum1=sum1+y[j];
                    }
                    mean1=sum1/n;
                    double s=0,s1=0;
                    double sd = 0,sd1=0;
                    for (int i=0;i<n;i++)
                    {
                        sd=x[i]-mean;
                        s=s+sd;
                    }
                    for (int i=0;i<n;i++)
                    {
                        sd1=y[i]-mean1;
                        s1=s1+sd1;
                    }
                    double m=(sd*sd1)/(sd*sd);
                    double c;
                    c=mean1-m*mean;
                    float x1 =Float.parseFloat(km);
                    double kms=(m*x1+c);
                    float pr;
                    pr = (float)(kms);
                    if(x1<3){
                        String caution = " Cabs are not available\n";
                        String range = " Min Km > 3 ";
                        tf.setText(caution+range);
                    }
                    else if((x1<=50) && (x1>3)){
                        String data2 = "  Fare : "+Math.floor(pr+20);
                        tf.setText(data2);
                    }
                    else{
                        String data2 = "  Fare : "+Math.floor(pr+50);
                        tf.setText(data2);
                    }

                    tf.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
                    tf.setEditable(false);
                }
            });
            f.add(l16);
            f.add(l17);
            f.add(b);f.add(tf);
            f.setLayout(new BorderLayout());
            JLabel background=new JLabel(new ImageIcon("src/predictimage.jpg"));
            f.add(background);
            f.setSize(400,400);
            f.setVisible(true);
        }
    }


}
class veh {
    public static void main(String[] a) throws IOException {
        vehframe frame = new vehframe();
        frame.setTitle("Team Uber");
        frame.setVisible(true);
        frame.setBounds(10, 10, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

}
