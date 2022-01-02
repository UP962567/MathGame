public class Node {

    private int ID;
    private int TrueID;
    private int FalseID;
    private String ActionID;
    private String description;
    private String question;

    private Node TrueNode;
    private Node FalseNode;
    private Node ActionNode;

    public Node(int ID, int trueID, int falseID, String description, String question, String actionID, Node trueNode,
                Node falseNode, Node actionNode) {
        this.ID = ID;
        TrueID = trueID;
        FalseID = falseID;
        ActionID = actionID;
        this.description = description;
        this.question = question;
        TrueNode = trueNode;
        FalseNode = falseNode;
        ActionNode = actionNode;
    }

    public Node() {}

    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}

    public int getTrueID() {return TrueID;}
    public void setTrueID(int trueID) {TrueID = trueID;}
    public int getFalseID() {return FalseID;}
    public void setFalseID(int falseID) {FalseID = falseID;}
    public String getActionID() {return ActionID;}
    public void setActionID(String actionID) {ActionID = actionID;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public String getQuestion() {return question;}
    public void setQuestion(String question) {this.question = question;}

    public Node getTrueNode() {return TrueNode;}
    public void setTrueNode(Node trueNode) {TrueNode = trueNode;}
    public Node getFalseNode() {return FalseNode;}
    public void setFalseNode(Node falseNode) {FalseNode = falseNode;}

    public Node getActionNode() {return ActionNode;}
    public void setActionNode(Node actionNode) {ActionNode = actionNode;}



    @Override
    public String toString() {
        return "Node{" +
                "ID=" + ID +
                ", TrueID=" + TrueID +
                ", FalseID=" + FalseID +
                ", description='" + description + '\'' +
                ", question='" + question + '\'' +
                ", action='" + ActionID + '\'' +
                '}';
    }
}
