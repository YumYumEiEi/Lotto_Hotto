package Frontend;

import javafx.scene.Node;
import javafx.scene.Parent;

public class NodeFinder {
    public static Node findeNode(Parent parent, String id){
        Node foundNode = null;
        for(Node node : parent.getChildrenUnmodifiable()){
            if(node.getId() != null){
                if(node.getId().equals(id)){
                    foundNode = node;
                }
            }
        }
        return foundNode;
    }
}
