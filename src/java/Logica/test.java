package Logica;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class test {
    
    public static void main(String[] args) {
        ApaHabla("sentadillas, movimiento de piernas en el aire");
    }

    public static void ApaHabla(String mensaje){
        VoiceManager manager = VoiceManager.getInstance();
        Voice voz = manager.getVoice("kevin16");
        voz.allocate();
        voz.speak(mensaje);
        voz.deallocate();
    }
}

