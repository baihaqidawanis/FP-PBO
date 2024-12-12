import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainClass {
    private static JTextArea bookingDetailsTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
        // Create the frame
        JFrame frame = new JFrame("Sistem Pemesanan Taksi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the Taxi options
        Taxi taxiA = new Taxi("A1", "Taksi Online", 8000);
        Taxi taxiB = new Taxi("B1", "Bluebird", 10000);
        Taxi taxiC = new Taxi("C1", "Silverbrd", 15000);

        // ComboBox for taxi selection
        JComboBox<Taxi> taxiComboBox = new JComboBox<>();
        taxiComboBox.addItem(taxiA);
        taxiComboBox.addItem(taxiB);
        taxiComboBox.addItem(taxiC);

        // TextField for distance input
        JTextField jarakTextField = new JTextField();
        jarakTextField.setToolTipText("Masukkan Jarak (Km)");

        // Button to make the booking
        JButton bookButton = new JButton("Pesan Taksi");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double jarak = Double.parseDouble(jarakTextField.getText());
                    Taxi selectedTaxi = (Taxi) taxiComboBox.getSelectedItem();
                    if (selectedTaxi != null && jarak > 0) {
                        Booking booking = new Booking(selectedTaxi, jarak);
                        bookingDetailsTextArea.setText(booking.getBookingDetails());
                    } else {
                        bookingDetailsTextArea.setText("Harap pilih taksi dan masukkan jarak yang valid.");
                    }
                } catch (NumberFormatException ex) {
                    bookingDetailsTextArea.setText("Masukkan jarak dengan benar.");
                }
            }
        });

        // TextArea to show booking details
        bookingDetailsTextArea = new JTextArea();
        bookingDetailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookingDetailsTextArea);

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Pilih Taksi:"));
        panel.add(taxiComboBox);
        panel.add(new JLabel("Masukkan Jarak (Km):"));
        panel.add(jarakTextField);
        panel.add(bookButton);
        panel.add(scrollPane);

        // Add panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
