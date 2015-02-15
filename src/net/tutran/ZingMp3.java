package net.tutran;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

/**
 * Created by Tu TV on 20/1/2015.
 */
public class ZingMp3 extends JFrame{
    private JTextField field;
    private JTextArea area;
    public ZingMp3() {
        super("Tool Get Link Mp3 Zing 320kbps - Code by TuTran.net");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 230);
        setResizable(false);
        setLocationRelativeTo(null);

        field = new JTextField(40);
        area = new JTextArea(5, 40);
        area.setEditable(false);

        JPanel panel = new JPanel();
        JLabel textHelp = new JLabel("Nhập link xuống ô bên dưới và nhấn Enter :)");
        JLabel textExa = new JLabel("Ví dụ: http://mp3.zing.vn/bai-hat/yen-binh-it-s-time/zwzbacfb.html");
        textExa.setFont(new Font("Consolas", Font.PLAIN, 11));
        JLabel textHis = new JLabel("Lịch sử tải về (Link download):");
        panel.add(textHelp);
        panel.add(textExa);
        panel.add(field);
        panel.add(textHis);
        panel.add(area);
        add(panel);
        JScrollPane scroll = new JScrollPane(area);
        panel.add(scroll);
        field.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String url = getLink(field.getText());
                        download(url);
                        area.setText(area.getText() + url + "\n");
                        field.selectAll();
                    }
                }
        );
    }

    public String getLink(String url) {
        url = url.replace('.', '/');
        String [] arrUrl = url.split("/");
        String id = arrUrl[arrUrl.length - 2];
        String urlDownload = "http://mp3.zing.vn/download/vip/song/" + id;
        return urlDownload;
    }

    public void download(String urlDownload) {
        try {
            Desktop d = Desktop.getDesktop();
            d.browse(new URI(urlDownload));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args) {
        ZingMp3 z = new ZingMp3();
        z.setVisible(true);
    }
}