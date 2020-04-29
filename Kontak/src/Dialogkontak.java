package pkgJavaKontak;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class dialogKontak extends JDialog {

    private JPanel contentPanel = new ClGradientJPanel();
    private JLabel lblNo;
    private JTextField txtNo;
    private JLabel lblNama;
    private JTextField txtNama;
    private JTextField txtHp;
    private JLabel lblNohpTelp;
    @SuppressWarnings("rawtypes")
    private JComboBox cbKategori;
    private JLabel lblKategori;
    private JTextField txtEmail;
    private JLabel lblEmail;
    private JLabel lblSimpan;
    private JLabel lblUbah;
    private JLabel lblHapus;
    private JLabel lblRefresh;
    private JScrollPane scrollPane;
    private JTable table;
    private JLabel lblPencarian;
    private JTextField txtCari;
    DefaultTableModel tabelModel;
    String data[] = { "No", "Nama", "Telp", "Kategori", "Email" };

    /**
     * Create the dialog.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public dialogKontak() {
        setTitle("Tambah Kontak");
        setResizable(false);
        setBounds(100, 100, 751, 256);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        setLocationRelativeTo(null);

        lblNo = new JLabel("No : ");
        lblNo.setForeground(new Color(255, 255, 255));
        lblNo.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblNo.setBounds(12, 12, 46, 15);
        contentPanel.add(lblNo);

        txtNo = new JTextField();
        txtNo.setEditable(false);
        txtNo.setFont(new Font("Droid Sans", Font.BOLD, 12));
        txtNo.setBounds(120, 6, 93, 27);
        contentPanel.add(txtNo);
        txtNo.setColumns(10);

        lblNama = new JLabel("Nama : ");
        lblNama.setForeground(new Color(255, 255, 255));
        lblNama.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblNama.setBounds(12, 50, 60, 15);
        contentPanel.add(lblNama);

        txtNama = new JTextField();
        txtNama.setFont(new Font("Droid Sans", Font.BOLD, 12));
        txtNama.setBounds(120, 44, 205, 27);
        contentPanel.add(txtNama);
        txtNama.setColumns(10);

        lblNohpTelp = new JLabel("No.HP / Telp : ");
        lblNohpTelp.setForeground(new Color(255, 255, 255));
        lblNohpTelp.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblNohpTelp.setBounds(12, 83, 93, 15);
        contentPanel.add(lblNohpTelp);

        txtHp = new JTextField();
        txtHp.setFont(new Font("Droid Sans", Font.BOLD, 12));
        txtHp.setBounds(120, 77, 205, 27);
        contentPanel.add(txtHp);
        txtHp.setColumns(10);

        lblKategori = new JLabel("Kategori : ");
        lblKategori.setForeground(new Color(255, 255, 255));
        lblKategori.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblKategori.setBounds(12, 115, 81, 15);
        contentPanel.add(lblKategori);

        cbKategori = new JComboBox();
        cbKategori.setFont(new Font("Droid Sans", Font.BOLD, 12));
        cbKategori.setModel(new DefaultComboBoxModel(new String[] {
                "- Pilih -", "Keluarga", "Teman", "Sahabat" }));
        cbKategori.setBounds(120, 110, 205, 25);
        contentPanel.add(cbKategori);

        lblEmail = new JLabel("Email : ");
        lblEmail.setForeground(new Color(255, 255, 255));
        lblEmail.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblEmail.setBounds(12, 150, 60, 15);
        contentPanel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Droid Sans", Font.BOLD, 12));
        txtEmail.setBounds(120, 144, 205, 27);
        contentPanel.add(txtEmail);
        txtEmail.setColumns(10);

        lblSimpan = new JLabel("Simpan");
        lblSimpan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Connection konek = Koneksi.getKoneksi();
                    String sql = "INSERT INTO data VALUES (?,?,?,?,?)";
                    PreparedStatement prepare = konek.prepareStatement(sql);

                    prepare.setString(1, txtNo.getText());
                    prepare.setString(2, txtNama.getText());
                    prepare.setString(3, txtHp.getText());
                    prepare.setString(4, (String) cbKategori.getSelectedItem());
                    prepare.setString(5, txtEmail.getText());
                    prepare.executeUpdate();
                    JOptionPane.showMessageDialog(null,
                            "Data kontak berhasil ditambahkan");
                    prepare.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Data kontak gagal ditambahkan");
                    System.out.println(ex);
                } finally {
                    autonumber();
                    tampilDataTabel();
                    txtNama.setText("");
                    txtHp.setText("");
                    cbKategori.setSelectedIndex(0);
                    txtEmail.setText("");
                    txtNama.requestFocus();
                }
            }
        });
        lblSimpan.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblSimpan.setHorizontalTextPosition(SwingConstants.CENTER);
        lblSimpan.setHorizontalAlignment(SwingConstants.CENTER);
        lblSimpan.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblSimpan.setIcon(new ImageIcon(dialogKontak.class
                .getResource("/pkgJavaKontak/aptdaemon-add.png")));
        lblSimpan.setBounds(525, 172, 60, 51);
        contentPanel.add(lblSimpan);

        lblUbah = new JLabel("Ubah");
        lblUbah.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Connection konek = Koneksi.getKoneksi();
                    String sql = "UPDATE data SET nama = ?, hp = ?, kategori = ?, email = ?  WHERE no = ? ";
                    PreparedStatement prepare = konek.prepareStatement(sql);

                    prepare.setString(1, txtNama.getText());
                    prepare.setString(2, txtHp.getText());
                    prepare.setString(3, (String) cbKategori.getSelectedItem());
                    prepare.setString(4, txtEmail.getText());
                    prepare.setString(5, txtNo.getText());
                    prepare.executeUpdate();
                    JOptionPane.showMessageDialog(null,
                            "Data kontak berhasil diubah");
                    prepare.close();

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Data kontak gagal diubah");
                    System.out.println(e1);
                } finally {
                    autonumber();
                    tampilDataTabel();
                    txtNama.setText("");
                    txtHp.setText("");
                    cbKategori.setSelectedIndex(0);
                    txtEmail.setText("");
                    txtNama.requestFocus();
                }
            }
        });
        lblUbah.setIcon(new ImageIcon(dialogKontak.class
                .getResource("/pkgJavaKontak/aptdaemon-working.png")));
        lblUbah.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblUbah.setHorizontalTextPosition(SwingConstants.CENTER);
        lblUbah.setHorizontalAlignment(SwingConstants.CENTER);
        lblUbah.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblUbah.setBounds(578, 172, 60, 51);
        contentPanel.add(lblUbah);

        lblHapus = new JLabel("Hapus");
        lblHapus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Connection konek = Koneksi.getKoneksi();
                    String sql = "DELETE FROM data WHERE no = ?";
                    PreparedStatement prepare = konek.prepareStatement(sql);

                    prepare.setString(1, txtNo.getText());
                    prepare.executeUpdate();
                    JOptionPane.showMessageDialog(null,
                            "Data kontak berhasil dihapus");
                    prepare.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Data kontak gagal dihapus");
                    System.out.println(ex);
                } finally {
                    autonumber();
                    tampilDataTabel();
                    txtNama.setText("");
                    txtHp.setText("");
                    cbKategori.setSelectedIndex(0);
                    txtEmail.setText("");
                    txtNama.requestFocus();
                }
            }
        });
        lblHapus.setIcon(new ImageIcon(dialogKontak.class
                .getResource("/pkgJavaKontak/user-trash-full.png")));
        lblHapus.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblHapus.setHorizontalTextPosition(SwingConstants.CENTER);
        lblHapus.setHorizontalAlignment(SwingConstants.CENTER);
        lblHapus.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblHapus.setBounds(630, 172, 60, 51);
        contentPanel.add(lblHapus);

        lblRefresh = new JLabel("Refresh");
        lblRefresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                autonumber();
                tampilDataTabel();
                txtNama.setText("");
                txtHp.setText("");
                cbKategori.setSelectedIndex(0);
                txtEmail.setText("");
                txtCari.setText("");
                txtNama.requestFocus();
            }
        });
        lblRefresh.setIcon(new ImageIcon(dialogKontak.class
                .getResource("/pkgJavaKontak/appointment-soon.png")));
        lblRefresh.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblRefresh.setHorizontalTextPosition(SwingConstants.CENTER);
        lblRefresh.setHorizontalAlignment(SwingConstants.CENTER);
        lblRefresh.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblRefresh.setBounds(683, 172, 60, 51);
        contentPanel.add(lblRefresh);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(383, 44, 360, 121);
        contentPanel.add(scrollPane);

        tabelModel = new DefaultTableModel(null, data);
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pilih = table.getSelectedRow();
                if (pilih == -1) {
                    return;
                }

                String no = (String) table.getValueAt(pilih, 0);
                txtNo.setText(no);
                String nama = (String) table.getValueAt(pilih, 1);
                txtNama.setText(nama);
                String hp = (String) table.getValueAt(pilih, 2);
                txtHp.setText(hp);
                String kategori = (String) table.getValueAt(pilih, 3);
                cbKategori.setSelectedItem(kategori);
                String email = (String) table.getValueAt(pilih, 4);
                txtEmail.setText(email);

            }
        });
        table.setModel(tabelModel);
        scrollPane.setViewportView(table);

        lblPencarian = new JLabel("Pencarian : ");
        lblPencarian.setForeground(new Color(255, 255, 255));
        lblPencarian.setFont(new Font("Droid Sans", Font.BOLD, 12));
        lblPencarian.setBounds(473, 18, 69, 15);
        contentPanel.add(lblPencarian);

        txtCari = new JTextField();
        txtCari.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tabelModel.getDataVector().removeAllElements();
                tabelModel.fireTableDataChanged();
                try {
                    Connection konek = Koneksi.getKoneksi();
                    Statement state = konek.createStatement();
                    String query = "SELECT * FROM data WHERE nama LIKE '"
                            + txtCari.getText() + "%'";

                    ResultSet rs = state.executeQuery(query);
                    while (rs.next()) {
                        Object obj[] = new Object[5];
                        obj[0] = rs.getString(1);
                        obj[1] = rs.getString(2);
                        obj[2] = rs.getString(3);
                        obj[3] = rs.getString(4);
                        obj[4] = rs.getString(5);

                        tabelModel.addRow(obj);
                    }
                    rs.close();
                    state.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        txtCari.setBounds(554, 12, 189, 27);
        contentPanel.add(txtCari);
        txtCari.setColumns(10);
        tampilDataTabel();
        autonumber();
    }

    public void tampilDataTabel() {
        tabelModel.getDataVector().removeAllElements();
        tabelModel.fireTableDataChanged();
        try {
            Connection konek = Koneksi.getKoneksi();
            Statement state = konek.createStatement();
            String sql = "SELECT * FROM data";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Object obj[] = new Object[5];
                obj[0] = rs.getString(1);
                obj[1] = rs.getString(2);
                obj[2] = rs.getString(3);
                obj[3] = rs.getString(4);
                obj[4] = rs.getString(5);

                tabelModel.addRow(obj);
            }
            rs.close();
            state.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void autonumber() {
        try {
            Connection konek = Koneksi.getKoneksi();
            Statement state = konek.createStatement();
            String query = "SELECT MAX(no) FROM data"; // Mendapatkan nilai id
            // terakhir

            ResultSet rs = state.executeQuery(query);
            if (rs.next()) {
                int a = rs.getInt(1);
                txtNo.setText(Integer.toString(a + 1)); // Nilai input yang
                // terakhir
                // ditambahkan 1
            }
            rs.close();
            state.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
