package backGroundProcesses;

/**
 * 
 */

/**
 * @author chrisubuntu
 *
 */
   public interface Stack<E>{
   
      void push(PlayerNode newNode) throws EmptyCompleteStackException;
   
      PlayerNode pop() throws EmptyCompleteStackException;
   
      PlayerNode peek() throws EmptyCompleteStackException;
   
      boolean isEmpty();
   
      int size();
   }
