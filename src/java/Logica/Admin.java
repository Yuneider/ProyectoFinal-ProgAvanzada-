package Logica;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Admin {
    
    public void EnviarCorreo(String correo,String mensaje, String asunto){
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "cgpmedicineplus@gmail.com";
        String contrasena = "CGPMedicine";
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }

    public void ApaHabla(String mensaje){
        VoiceManager manager = VoiceManager.getInstance();
        Voice voz = manager.getVoice("kevin16");
        voz.allocate();
        voz.speak(mensaje);
        voz.deallocate();
    }
}
