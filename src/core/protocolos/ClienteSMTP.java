/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.protocolos;

import core.utilidades.Constantes;
import java.io.*;
import java.net.*;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author mauriballes
 */
public class ClienteSMTP {

    private static final int PORT = 25; // SMTP

    public static void sendMail(String toMail, String subject, String content) {
        // Estableciendo variables
        BufferedReader reader;
        DataOutputStream writer;
        String command;

        try {
            // Estableciendo Conexion Socket
            Socket socket = new Socket(Constantes.MAIL_SERVER_HOST, PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new DataOutputStream(socket.getOutputStream());

            if (socket != null && reader != null && writer != null) {
                reader.readLine();
                // Saludar al servidor
                command = "EHLO " + Constantes.MAIL_SERVER_HOST + "\r\n";
                writer.writeBytes(command);
                getMultiline(reader);

                command = "MAIL FROM : " + Constantes.MAIL_USERMAIL + "\r\n";
                writer.writeBytes(command);
                reader.readLine();

                command = "RCPT TO : " + toMail + "\r\n";
                writer.writeBytes(command);
                reader.readLine();

                // Escribir Mensaje
                command = "DATA\n";
                writer.writeBytes(command);
                getMultiline(reader);

                command = "Subject: " + subject + "\r\n" + content + "\n.\r\n";
                writer.writeBytes(command);
                reader.readLine();

                command = "QUIT\r\n";
                writer.writeBytes(command);
                reader.readLine();
            }

            // Cerrar Conexion
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static protected String getMultiline(BufferedReader in) throws IOException {
        String lines = "";
        while (true) {
            String line = in.readLine();
            if (line == null) {
                // Server closed connection
                throw new IOException(" S : Server unawares closed the connection.");
            }
            if (line.charAt(3) == ' ') {
                lines = lines + "\n" + line;
                // No more lines in the server response
                break;
            }
            // Add read line to the list of lines
            lines = lines + "\n" + line;
        }
        return lines;
    }
    
    public static void sendMailWithFile(String correoDestino,String path,String contenido,String subject) {
        String to = correoDestino;
        String from = "grupo08sa@ficct.uagrm.edu.bo";
        final String username = "grupo08sa";//change accordingly
        final String password = "grupo08grupo08";//change accordingly
        String host = "mail.ficct.uagrm.edu.bo";
        Properties props = new Properties();
        //props.put("mail.smtp.auth", "true");
        // props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject(subject);
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Now set the actual message
            messageBodyPart.setText(contenido);
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            //String filename = "archivos/imagenes/video.mkv";
            DataSource source = new FileDataSource(path);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(new File(path).getName());
            messageBodyPart.setDisposition(Part.ATTACHMENT);
            messageBodyPart.setHeader("Content-Transfer-Encoding", "base64");
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
