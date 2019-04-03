class Nodes<T> {
    public Nodes(){}
    private Nodes<T> previousNode;
    private T currentNode;
    public Nodes(T object, Nodes<T> prevNode){
        this.currentNode = object;
        this.previousNode = prevNode;
    }

    public void setCurrentNode(T object){
        this.currentNode = object;
    }

    public void setPreviousNode(Nodes<T> object){
        this.previousNode = object;
    }

    public T getCurrentNode(){
        return currentNode;
    }

    public Nodes<T> getPreviousNode(){
        return previousNode;
    }
   
} //end of class Nodes

class Stos<T> {
    public Stos(){}
    Nodes<T> lastNode;
    public void push(T object){
        if(lastNode != null){
            Nodes<T> newNode = new Nodes<T>(object, lastNode);
            lastNode = newNode;
        }
        else{
            lastNode = new Nodes<T>();
            lastNode.setCurrentNode(object);
            lastNode.setPreviousNode(null);
        }
    }   

    public T pop(){
        Nodes<T> endNode = lastNode;
        lastNode = lastNode.getPreviousNode();
        return endNode.getCurrentNode();
    } 

    public String toString(){
        StringBuilder build = new StringBuilder();
        Nodes<T> addedNode = lastNode;
        while(addedNode != null){
            build.append("{" + addedNode.getCurrentNode() + "} ");
            addedNode = addedNode.getPreviousNode();
        }
        return build.toString();
    }

} //end of class Stos