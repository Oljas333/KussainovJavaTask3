import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Task3 extends JFrame {
    public static void main(String[] args) {
        Task3 app = new Task3();
        app.setVisible(true);
    }

    public JButton button1 = new JButton("Ответ");
    public JButton button2 = new JButton("Создать");
    public JTextField input = new JTextField("", 3);
    public JTextField output = new JTextField("", 3);
    public JLabel labelInput = new JLabel("Массив данных");
    public JLabel labelOutput = new JLabel("Массив ответа");
    public static int[] array = new int[15];


    public Task3(GraphicsConfiguration gc) {
        super(gc);
    }

    Task3() {
        super("Task3");
        {
            this.setBounds(700, 450, 250, 200);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container container = this.getContentPane();
            container.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
            container.add(this.labelInput);
            container.add(this.input);
            container.add(this.labelOutput);
            container.add(this.output);
            container.add(this.button2);
            container.add(this.button1);
            button1.addActionListener(new MyClass());
            button2.addActionListener(new MyClass());
            ArrLi();
            input.setText(Arrays.toString(array));
        }
    }

    public static void ArrLi() {

        int[] nums = new int[15];

        for (int i = 0; i < nums.length; i++) {
            array[i] = (int) ((Math.random() * 1000) + 1);
        }
    }

    public class MyClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button1) {
                ArrayList<Integer> list = result(array);
                Integer[] nums2 = list.toArray(new Integer[list.size()]);
                output.setText(Arrays.toString(nums2));

            } else if (e.getSource() == button2) {
                input.setText(null);
                ArrLi();
                input.setText(Arrays.toString(array));
            }

        }

        public ArrayList<Integer> result(int[] nums) {
            ArrayList<Integer> str = new ArrayList<>();

            for (int a : nums) {

                if (a % 3 == 0) {
                    str.add(a);
                }
            }
            return str;
        }

    }
}