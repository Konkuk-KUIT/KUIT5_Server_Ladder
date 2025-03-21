import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ;
        System.out.println("-----Ladder Game-----");
        System.out.print("Input ladder rows: ");
        Number rows = new Number(Integer.parseInt(br.readLine()));
        System.out.print("Input numberOfPerson : ");
        Number numberOfPerson = new Number(Integer.parseInt(br.readLine()));
        Ladder ladder = new Ladder(rows, numberOfPerson);
        while (true) {
            System.out.println("Select Menu.");
            System.out.println("1. Game start");
            System.out.println("2. Add Ladder");
            System.out.println("3.Game Over");
            int select = Integer.parseInt(br.readLine());
            if(select_menu(br, ladder, select)==true){
                break;
            };
        }
    }
    public static boolean select_menu(BufferedReader br, Ladder ladder, int select) throws IOException {
        boolean powerOff = false;
        switch(select){
            case 1:
                System.out.print("Select Number : ");
                Number user = new Number(Integer.parseInt(br.readLine()));
                System.out.println("result : "+ladder.run(user));
                break;
            case 2:
                for(int i=0; i<2; i++){
                    System.out.print("input ladder point x : ");
                    int x= Integer.parseInt(br.readLine());
                    System.out.print("input ladder point y : ");
                    int y= Integer.parseInt(br.readLine());
                    Position position = new Position(x,y);
                    ladder.drawLine(position);
                }
                break;
            case 3:
                System.out.println("Power Off.");
                powerOff = true;
                break;
        }
        return powerOff;
    }
}
