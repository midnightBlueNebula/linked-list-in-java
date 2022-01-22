class LinkedList {
  LinkedList head;
  LinkedList tail;
  LinkedList next;
  int val;

  public LinkedList(int _val){
    val = _val;
    head = this;
    tail = head;
  }

  public LinkedList(int _val, LinkedList _next){
    val = _val;
    next = _next;
    head = this;
    tail = next;
  }

  public void append(int _val){
    if(head == null){
      val = _val;
      head = this;
      tail = head;
    } else {
      tail.next = new LinkedList(_val);
      tail = tail.next;
    }
  }

  public void prepend(int _val){
    if(head == null){
      val = _val;
      head = this;
      tail = head;
    } else {
      if(next == null){
        next = new LinkedList(val);
        tail = next;
        val = _val;
      } else {
        next = new LinkedList(val, next);
        val = _val;
      }
    }
  }

  public LinkedList pop(){
    LinkedList current = this;
    if(current.next == null){
      return current;
    }
    while(current.next != tail){
      current = current.next;
    }
    LinkedList oldTail = current.next;
    current.next = null;
    tail = current;
    return oldTail;
  }

  public LinkedList shift(){
    if(next == null){
      return head;
    } else {
      LinkedList oldHead = new LinkedList(head.val);
      val = next.val;
      if(next.next != null){
        next = new LinkedList(next.next.val, next.next.next);  
      } else {
        tail = this;
        next = null;
      }
      return oldHead;
    }
  }

  public void print(){
    LinkedList current = this;
    while(current != null){
      System.out.printf("%d ", current.val);
      if(current.next != null){
        System.out.printf("-> ");
      } else {
        System.out.println("");
      }
      current = current.next;
    }
  }
}

class Main {
  public static void main(String args[]) { 
    LinkedList list = new LinkedList(1);
    
    list.append(2);
    list.append(3);
    list.prepend(0);
    list.append(4);
    list.append(5);
    
    System.out.println(list.pop().val);
    System.out.println(list.shift().val);
    
    list.print();
    
    System.out.printf("head: %d%n", list.head.val);
    System.out.printf("tail: %d%n", list.tail.val);
  } 
}
