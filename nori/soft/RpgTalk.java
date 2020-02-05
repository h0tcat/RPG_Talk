package nori.soft;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import nori.soft.util.AudioHelper;

public class RpgTalk {
    public static void main(String[] args) {
        if (!(args.length == 3)) {
            System.out.println("Usage: RpgTalk talkWord delay neiro");
        } else {
            // コマンドライン引数を取得
            String talkWord = args[0];
            int delaySpeed = Integer.parseInt(args[1]);
            String wavFilePath = args[2];

            try {
                AudioHelper audioHelper = new AudioHelper(wavFilePath);
                for (int talkLoop = 0, wordLen = talkWord.length(); talkLoop < wordLen; talkLoop++) {
                    System.out.print(talkWord.charAt(talkLoop));
                    
                    if(!(talkWord.charAt(talkLoop)==' ') || (!(talkWord.charAt(talkLoop)==' ')))audioHelper.PlayClip(delaySpeed);
                    Thread.sleep(delaySpeed);
                }
                System.out.println();
            } catch (IOException IOE) {
                // TODO Auto-generated catch block
                IOE.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}