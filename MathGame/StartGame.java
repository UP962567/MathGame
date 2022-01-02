import java.io.FileNotFoundException;

public class StartGame {

    public static void main(String[] args) throws FileNotFoundException {
        NodeMap map = new NodeMap();
        if(map.currentNode() == null) { return;}

        new Game();
    }
}
