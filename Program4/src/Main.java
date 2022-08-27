import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try{
            String[] pics = {"/Users/haley/dev/p4/veg1.jpg",
                    "/Users/haley/dev/p4/veg2.jpg",
                    "/Users/haley/dev/p4/veg3.jpg",
                    "/Users/haley/dev/p4/veg4.jpg",
                    "/Users/haley/dev/p4/veg5.jpg",
                    "/Users/haley/dev/p4/veg6.jpg",
                    "/Users/haley/dev/p4/veg7.jpg",
                    "/Users/haley/dev/p4/veg8.jpg"};
            MedianFilter mf = new MedianFilter(pics);

            mf.removeNoise();

            mf.writeImage("/Users/haley/dev/p4/filtered");
        }catch (IOException e){

        }
    }
}