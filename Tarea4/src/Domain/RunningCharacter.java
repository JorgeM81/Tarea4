package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 8; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+imgNum+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int x2=-60;
        while (true) {
            try {
                super.setX(x2);
                x2=x2+11;
                if(imgNum<8){
                    imgNum=imgNum+1;
                    setImage(new Image(new FileInputStream("src/Assets/Running"+imgNum+".png")));
                }else{
                    Thread.sleep(105);
                    imgNum=0;
                    setImage(new Image(new FileInputStream("src/Assets/Running"+imgNum+".png")));
                }
                if(x2>=830){
                    x2=-60;
                }
                Thread.sleep(105);
            }  catch (FileNotFoundException ex) {
                Logger.getLogger(RunningCharacter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunningCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
