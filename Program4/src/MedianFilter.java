import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;

/**
 *  Program #4
 *  Removes the llama from the pictures
 *  CS108-3
 *  March 15
 *  @author  Haley Coronado
 */

public class MedianFilter {
    private BufferedImage filteredImage;
    private BufferedImage[] images;
    private int index = 0;
    private int width;
    private int height;

    public MedianFilter(String[] imageInputFilenames) throws IOException{
        images = new BufferedImage[imageInputFilenames.length];
        for(String s : imageInputFilenames){
            File f = new File(s);
            images[index] = readImage(f);
            width = images[index].getWidth();
            height = images[index].getHeight();
            index++;
        }
        filteredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    // reads the images
    public BufferedImage readImage(File imageFile) throws IOException{
        try {
            return ImageIO.read(imageFile);
        } catch (IOException e){
            throw new IOException("error reading file");
        }
    }

    // takes the llama out and creates a new image
    public BufferedImage removeNoise(){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                ArrayList<Integer> pixelsFromImages = new ArrayList<>();
                for(BufferedImage bi : images){
                    pixelsFromImages.add(bi.getRGB(x, y));
                }
                filteredImage.setRGB(x, y, getMedianValue(pixelsFromImages));

            }
        }
        return filteredImage;
    }

    // finds the median value of the pixels from the images
    public int getMedianValue(ArrayList<Integer> pixels){
        Collections.sort(pixels);
        int mv = pixels.size() / 2;
        return pixels.get(mv);
    }

    // creates the new filtered image
    public int writeImage(String outputFilename){
        try{
            ImageIO.write(filteredImage, "jpg", new File(outputFilename));
            return 0;
        } catch (IOException e){
            return -1;
        }
    }

    // returns the height of the new filtered image
    public int getHeight(){
        return filteredImage.getHeight();
    }

    // returns the width of the new filtered image
    public int getWidth(){

        return filteredImage.getWidth();
    }
}
