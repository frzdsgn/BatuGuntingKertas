import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BatuGuntingKertasGUI extends JFrame implements ActionListener {

    JButton batuButton, guntingButton, kertasButton;
    JLabel hasilLabel, komputerLabel, skorLabel;
    Random random = new Random();
    String[] pilihan = {"batu", "gunting", "kertas"};
    int skorPemain = 0;
    int skorKomputer = 0;

    public BatuGuntingKertasGUI() {
        // Mengatur judul jendela
        setTitle("Batu Gunting Kertas");
        // Mengatur ukuran jendela
        setSize(400, 300);
        // Mengatur agar aplikasi keluar saat jendela ditutup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Mengatur layout
        setLayout(new FlowLayout());

        // Membuat tombol
        batuButton = new JButton("Batu");
        guntingButton = new JButton("Gunting");
        kertasButton = new JButton("Kertas");

        // Menambahkan action listener ke tombol
        batuButton.addActionListener(this);
        guntingButton.addActionListener(this);
        kertasButton.addActionListener(this);

        // Membuat label
        hasilLabel = new JLabel("Hasil: ");
        komputerLabel = new JLabel("Komputer memilih: ");
        skorLabel = new JLabel("Skor Anda: 0 | Skor Komputer: 0");

        // Menambahkan komponen ke jendela
        add(batuButton);
        add(guntingButton);
        add(kertasButton);
        add(hasilLabel);
        add(komputerLabel);
        add(skorLabel);

        // Membuat jendela terlihat
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pilihanPemain = e.getActionCommand().toLowerCase();
        int pilihanKomputerIndex = random.nextInt(pilihan.length);
        String pilihanKomputer = pilihan[pilihanKomputerIndex];

        komputerLabel.setText("Komputer memilih: " + pilihanKomputer);

        String hasil = "";
        if (pilihanPemain.equals(pilihanKomputer)) {
            hasil = "Seri!";
        } else if ((pilihanPemain.equals("batu") && pilihanKomputer.equals("gunting")) ||
                   (pilihanPemain.equals("gunting") && pilihanKomputer.equals("kertas")) ||
                   (pilihanPemain.equals("kertas") && pilihanKomputer.equals("batu"))) {
            hasil = "Anda menang!";
            skorPemain++;
        } else {
            hasil = "Komputer menang!";
            skorKomputer++;
        }

        hasilLabel.setText("Hasil: " + hasil);
        skorLabel.setText("Skor Anda: " + skorPemain + " | Skor Komputer: " + skorKomputer);
    }

    public static void main(String[] args) {
        // Membuat instance dari GUI
        SwingUtilities.invokeLater(() -> new BatuGuntingKertasGUI());
    }
}