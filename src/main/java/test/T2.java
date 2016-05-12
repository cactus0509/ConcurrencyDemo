package test;
public class T2 {
	enum Signal {
        GREEN, YELLOW, RED
    }
	 
	public static void main (String args[]){
		  change(Signal.GREEN);
		  System.out.println(  String.valueOf(Code.OK.getNo()) );
	}
	
	 

      public static void change( Signal color) {
          switch (color) {
          case RED:
              color = Signal.GREEN;
              break;
          case YELLOW:
              color = Signal.RED;
              break;
          case GREEN:
              color = Signal.YELLOW;
              break;
          }
          System.out.println(color);
      }
	
	public static enum Code { 
		OK(1),
        ERROR(2),;

        private final int no;

		 private Code(int no) {
	            this.no = no;
	        }
		 public int getNo() {
	            return this.no;
	        }
	} 
}

