import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    GraphFrame gf = new GraphFrame();
    static int[] arr = new int[100];
    Thread curThread;
    public void shuffle(final int[] arr) {

        (curThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < arr.length; i++) {
                    int temp = (int) (Math.random() * arr.length);
                    int shuffleNum = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = shuffleNum;

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        }).start();
    }
    public void bubbleSort(final int[] a) {
        (curThread = new Thread() {
            @Override
            public void run() {
                int b;
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a.length - i - 1; j++) {
                        if (a[j] > a[j + 1]) {
                            b = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = b;
                        }

                        try {
                            sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        repaint();
                    }
                }
            }
        }).start();

    }
    public void insertionSort(int[] data){
        (curThread = new Thread(){
            @Override
            public void run(){
                for(int i = 1; i < data.length; i++) {
                    int target = data[i];
                    int j = i - 1;
                    while(j >= 0 && target < data[j]) {
                        data[j + 1] = data[j];
                        j--;
                        try {
                            sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        repaint();
                    }
                    data[j + 1] = target;
                }
            }
        }).start();
    }
    public void selectionSort(int[] data){
        (curThread = new Thread(){
            @Override
            public void run(){
                int size = data.length;
                int min;
                int temp;

                for(int i=0; i<size-1; i++){
                    min = i;
                    for(int j=i+1; j<size; j++){
                        if(data[min] > data[j]){
                            min = j;
                        }
                        try {
                            sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        repaint();
                    }
                    temp = data[min];
                    data[min] = data[i];
                    data[i] = temp;
                }
            }
        }).start();

    }

    public Main() {
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        setTitle("Sorting Graph Project");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(gf, BorderLayout.CENTER);
        JButton btn = new JButton("Shuffle");
        JButton bubble = new JButton("Bubble");
        JButton selection = new JButton("Selection");
        JButton insertion = new JButton("Insertion");
        JPanel sortButtons = new JPanel();
        sortButtons.setLayout(new FlowLayout());

        sortButtons.add(bubble);
        sortButtons.add(selection);
        sortButtons.add(insertion);
        c.add(sortButtons, BorderLayout.NORTH);
        c.add(btn, BorderLayout.SOUTH);
        class ButtonEventListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if(curThread != null && curThread.isAlive())
                    return;

                JButton b = (JButton) e.getSource();
                if (b.getText().equals("Shuffle")) {
                    shuffle(arr);
                }
                if (b.getText().equals("Bubble")) {
                    bubbleSort(arr);
                }
                if (b.getText().equals("Selection")) {
                    selectionSort(arr);
                }
                if (b.getText().equals("Insertion")) {
                    insertionSort(arr);
                }
            }
        }
        btn.addActionListener(new ButtonEventListener());
        selection.addActionListener(new ButtonEventListener());
        bubble.addActionListener(new ButtonEventListener());
        insertion.addActionListener(new ButtonEventListener());
        sortButtons.setSize(500,50);
        btn.setSize(500, 50);
        setSize(515, 590);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
