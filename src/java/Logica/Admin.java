package Logica;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Admin {
    
    public void ApaHabla(String mensaje) {
        VoiceManager manager = VoiceManager.getInstance();
        Voice voz = manager.getVoice("kevin16");
        voz.allocate();
        voz.speak(mensaje);
        voz.deallocate();
    }
}
