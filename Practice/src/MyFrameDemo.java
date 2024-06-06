import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

class MyFrames extends JFrame implements ActionListener {
    JTextField txt;
    JButton btn;

    MyFrames() {
        this.setSize(320, 320);
        this.setVisible(true);
        this.setTitle("My Name Finder");
        Container contentpane = this.getContentPane();
        this.setLayout(new FlowLayout());
        txt = new JTextField(10);
        contentpane.add(txt);
        btn = new JButton("Find");
        contentpane.add(btn);
        btn.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String str;
        str = ae.getActionCommand();
        if (str.equals("Find")) {
            txt.setText("Hello Coder");
        }
    }
}

public class MyFrameDemo {
    public static void main(String[] args) {
        MyFrames mf = new MyFrames();
    }
}
