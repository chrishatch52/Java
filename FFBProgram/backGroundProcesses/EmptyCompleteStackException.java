package backGroundProcesses;
/**
 * 
 */

/**
 * @author chrisubuntu
 *
 */
   public class EmptyCompleteStackException extends Exception {
   
   /**
    * 
    */
      private static final long serialVersionUID = -5996544887971371030L;
   
   /**
    * 
    */
      public EmptyCompleteStackException() {
      // TODO Auto-generated constructor stub
         super("This stack is currently empty");
      }
   
   /**
    * @param message
    */
      public EmptyCompleteStackException(String message) {
         super(message);
      // TODO Auto-generated constructor stub
      }
   
   /**
    * @param cause
    */
      public EmptyCompleteStackException(Throwable cause) {
         super(cause);
      // TODO Auto-generated constructor stub
      }
   
   /**
    * @param message
    * @param cause
    */
      public EmptyCompleteStackException(String message, Throwable cause) {
         super(message, cause);
      // TODO Auto-generated constructor stub
      }
   
   /**
    * @param message
    * @param cause
    * @param enableSuppression
    * @param writableStackTrace
    */
      public EmptyCompleteStackException(String message, Throwable cause,
      	boolean enableSuppression, boolean writableStackTrace) {
         super(message, cause, enableSuppression, writableStackTrace);
      // TODO Auto-generated constructor stub
      }
   
   }
