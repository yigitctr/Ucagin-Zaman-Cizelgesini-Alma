import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UcakZamanCizelgesi extends JFrame {
    private final Event[] events = {
            new Event("Kalkış", "2023-12-01T08:00:00"),
            new Event("Yemek Servisi", "2023-12-01T12:00:00"),
            new Event("Varış", "2023-12-01T16:30:00")
    };

    private static class Event {
        String label;
        String time;

        public Event(String label, String time) {
            this.label = label;
            this.time = time;
        }
    }

    public UcakZamanCizelgesi() {
        setTitle("Uçak Zaman Çizelgesi");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel timelinePanel = new TimelinePanel(events);
        add(timelinePanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class TimelinePanel extends JPanel {
        private final Event[] events;

        public TimelinePanel(Event[] events) {
            this.events = events;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Event event : events) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    Date eventTime = dateFormat.parse(event.time);
                    int xPosition = (int) ((double) eventTime.getHours() * getWidth() / 24);
                    g.setColor(Color.BLUE);
                    g.fillOval(xPosition - 10, getHeight() / 2 - 10, 20, 20);
                    g.drawString(event.label, xPosition - 10, getHeight() / 2 - 15);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UcakZamanCizelgesi::new);
    }
}
