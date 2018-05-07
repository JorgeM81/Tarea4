package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 4; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Standing"+imgNum+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        while (true) {
            try {
                Thread.sleep(1800);
                this.imgNum=1;
                setImage(new Image(new FileInputStream("src/Assets/Standing"+this.imgNum+".png")));
                Thread.sleep(65);
                this.imgNum=2;
                setImage(new Image(new FileInputStream("src/Assets/Standing"+this.imgNum+".png")));
                Thread.sleep(65);
                this.imgNum=3;
                setImage(new Image(new FileInputStream("src/Assets/Standing"+this.imgNum+".png")));
                Thread.sleep(65);
                imgNum=0;
                setImage(new Image(new FileInputStream("src/Assets/Standing"+this.imgNum+".png")));
            } 
            catch (InterruptedException ex) { } catch (FileNotFoundException ex) {
                Logger.getLogger(StandingCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
