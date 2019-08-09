/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaunoteoria.resources;


import java.util.LinkedList;

/**
 *
 * @author Juan Gutierrez
 */
public class QueueFA {
    
    LinkedList q = new LinkedList();

    public QueueFA() {
    }
    
    public boolean isEmpty(){
        return q.isEmpty();
    }
    
    public Object dequeue(){
        return q.removeFirst();
    }
    
    public void enqueue(Object o){
        q.add(o);
    }
    
    
    
}
