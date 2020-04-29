package pkgJavaKontak;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import eu.hansolo.clock.AnalogClock;

@SuppressWarnings("serial")
public class FrmJavaKontak extends JFrame {

    private JPanel contentPane;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel lblWall;
    private JPanel panelAtas;
    private JLabel label_1;
    private AnalogClock analogClock;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JLabel label_7;
    private JLabel label_2;
    private JLabel label_8;
    private JLabel label_9;
    private JLabel label_10;

    /**
     * Create the frame.
     */
    public FrmJavaKontak() {
        setTitle("Java Kontak App");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 329, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panelAtas = new JPanel();
        panelAtas.setBounds(0, -11, 327, 34);
        panelAtas.setBackground(new Color(0, 0, 0, 185));
        contentPane.add(panelAtas);
        panelAtas.setLayout(null);

        label_1 = new JLabel("");
        label_1.setBounds(253, 12, 37, 24);
        panelAtas.add(label_1);
        label_1.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/gpm-primary-000.png")));
        label_1.setToolTipText("Tentang");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label_3 = new JLabel("");
        label_3.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/dialog-information.png")));
        label_3.setToolTipText("Tentang");
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        label_3.setBounds(290, 12, 25, 24);
        panelAtas.add(label_3);

        panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 145));
        panel.setBounds(0, 23, 66, 490);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel = new JLabel("");
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Aplikasi Java Kontak + Ubuntu Phone Style",
                        "Informasi", JOptionPane.PLAIN_MESSAGE);
            }
        });
        lblNewLabel.setToolTipText("Tentang");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/ubuntuone.png")));
        lblNewLabel.setBounds(0, 0, 66, 48);
        panel.add(lblNewLabel);

        label = new JLabel("");
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dialogKontak dk = new dialogKontak();
                dk.setVisible(true);
            }
        });
        label.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/gnome-contacts.png")));
        label.setToolTipText("Kontak");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 60, 66, 48);
        panel.add(label);

        label_6 = new JLabel("");
        label_6.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/eclipse.png")));
        label_6.setToolTipText("Eclipse");
        label_6.setHorizontalAlignment(SwingConstants.CENTER);
        label_6.setBounds(0, 120, 66, 48);
        panel.add(label_6);

        label_7 = new JLabel("");
        label_7.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/file-roller.png")));
        label_7.setToolTipText("File Roller");
        label_7.setHorizontalAlignment(SwingConstants.CENTER);
        label_7.setBounds(0, 182, 66, 48);
        panel.add(label_7);

        label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/preferences-desktop-theme.png")));
        label_2.setToolTipText("Theme Desktop");
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setBounds(0, 242, 66, 48);
        panel.add(label_2);

        label_8 = new JLabel("");
        label_8.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/system-file-manager.png")));
        label_8.setToolTipText("File Manager");
        label_8.setHorizontalAlignment(SwingConstants.CENTER);
        label_8.setBounds(0, 303, 66, 48);
        panel.add(label_8);

        label_9 = new JLabel("");
        label_9.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/system-switch-java.png")));
        label_9.setToolTipText("Java");
        label_9.setHorizontalAlignment(SwingConstants.CENTER);
        label_9.setBounds(0, 363, 66, 48);
        panel.add(label_9);

        label_10 = new JLabel("");
        label_10.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/terminator.png")));
        label_10.setToolTipText("Terminal");
        label_10.setHorizontalAlignment(SwingConstants.CENTER);
        label_10.setBounds(0, 423, 66, 48);
        panel.add(label_10);

        analogClock = new AnalogClock();
        analogClock.setBounds(135, 59, 113, 93);
        contentPane.add(analogClock);

        label_4 = new JLabel("");
        label_4.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/document-encrypt.png")));
        label_4.setToolTipText("Kontak");
        label_4.setHorizontalAlignment(SwingConstants.CENTER);
        label_4.setBounds(84, 343, 78, 72);
        contentPane.add(label_4);

        label_5 = new JLabel("");
        label_5.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/document-decrypt.png")));
        label_5.setToolTipText("Kontak");
        label_5.setHorizontalAlignment(SwingConstants.CENTER);
        label_5.setBounds(222, 343, 78, 72);
        contentPane.add(label_5);

        lblWall = new JLabel("");
        lblWall.setBounds(0, 0, 327, 513);
        contentPane.add(lblWall);
        lblWall.setIcon(new ImageIcon(FrmJavaKontak.class
                .getResource("/pkgJavaKontak/wall.jpg")));
        setLocationRelativeTo(null);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    try {
                        UIManager
                                .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    } catch (UnsupportedLookAndFeelException e) {
                    } catch (ClassNotFoundException e) {
                    } catch (InstantiationException e) {
                    } catch (IllegalAccessException e) {
                    }
                    FrmJavaKontak frame = new FrmJavaKontak();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
