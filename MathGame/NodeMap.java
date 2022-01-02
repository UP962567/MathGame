import java.io.FileNotFoundException;


public class NodeMap {

    private Node head;
    private Node currentNode;

/****************************************************/
/**************      NAVIGATE       *****************/
/****************************************************/
/****************************************************/
    public Node currentNode() { return currentNode;}

    public void noDecision(){
        currentNode = currentNode.getTrueNode();
    }

    public void decision(int decision) {
        switch (decision) {
            case 1:
                currentNode = currentNode.getTrueNode();
                break;
            case 2:
                currentNode = currentNode.getFalseNode();
                break;

        }
    }
/****************************************************/
/**************         BUILD      ******************/
/****************************************************/
/****************************************************/

    public NodeMap()  {
        NodeCollection nodeCollection;   //scope: constructor only, part of process, no requirement to keep;
        try {
            nodeCollection = new NodeCollection();
            head = nodeCollection.get(0);
        } catch (FileNotFoundException e) {
            //message
            return;
        }
        buildMap(nodeCollection);
        currentNode = head;
    }


    private void buildMap(NodeCollection nodeCollection)   {
        if (nodeCollection == null) {return;}
        for(Node source : nodeCollection.arrayList()){
            int TrueID = source.getTrueID();
            int FalseID = source.getFalseID();

            Node TrueNode = nodeCollection.locateNodeBy(TrueID);
            Node FalseNode = nodeCollection.locateNodeBy(FalseID);

            source.setTrueNode(TrueNode);
            source.setFalseNode(FalseNode);
        }
    }

    public String toString(){
        String string = "";
        string += TruePath() + "\n";
        string += FalsePath() + "\n";
        string += ActionPath() + "\n";
        return string;
    }

    public String TruePath(){
        Node node = head;
        String string = "True PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getTrueNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }

    public String FalsePath(){
        Node node = head;
        String string = "False PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getFalseNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }

    public String ActionPath(){
        Node node = head;
        String string = "Action PATH\n";
        while(node != null) {
            string += node.toString() + "\n";
            node = node.getFalseNode();
            if (node.getID() == 0) { node = null;}
        }
        return string;
    }


}