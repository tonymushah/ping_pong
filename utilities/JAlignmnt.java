package utilities;

public class JAlignmnt {
    int[][] align;
    private static int UP = 0;
    private static int UP_RIGHT = 1;
    private static int RIGHT = 2;
    private static int DOWN_RIGHT = 3;
    /*
        We have 4 simple alignement 
        [0] : up
        [1] : up right
        [2] : right
        [3] : buttom right
        [][0] = x
        [][1] = y 
    */
    public static int getDOWN_RIGHT() {
        return DOWN_RIGHT;
    }
    public static int getRIGHT() {
        return RIGHT;
    }
    public static int getUP() {
        return UP;
    }
    public static int getUP_RIGHT() {
        return UP_RIGHT;
    }
    public JAlignmnt(){
        this.align = new int[4][2];

        this.align[0][0] = 0;   // x
        this.align[0][1] = 1;   // y

        this.align[1][0] = 1;   // x
        this.align[1][1] = 1;   // y

        this.align[2][0] = 1;   // x
        this.align[2][1] = 0;   // y

        this.align[3][0] = 1;   // x
        this.align[3][1] = -1;  // y
    }
    public int[] getinv_Align(int priority){
        return align[priority % align.length];
    }
    public int[] getAlign(int priority){
        int returns[] = new int[2];

        returns[0] = this.align[priority % align.length][0] * -1;
        returns[1] = this.align[priority % align.length][1] * -1;

        return returns;
    }
    public int alignmnt_length(){
        return this.align.length;
    }
    public int[] bounce_WLR(int priority, int inverse){
        int[] returns = new int[2];
        /* NOTE
            [0] = align priority
            [1] = inverse bool
        */
        switch (priority) {
            case 1:
                returns[0] = priority + 2;
                returns[1] = (inverse + 1) % 2;
                break;
            case 3:
                returns[0] = priority - 2;
                returns[1] = (inverse + 1) % 2;
                break;
            
            default:
                break;
        }
        return returns;
    }
    public int[] bounce_WUD(int priority, int inverse){
        int[] returns = new int[2];
        /* NOTE
            [0] = align priority
            [1] = inverse bool
        */
        switch (priority) {
            case 1:
                returns[0] = (priority + 2) % 4;
                returns[1] = (inverse) % 2;
                break;
            case 3:
                returns[0] = (priority - 2) % 4;
                returns[1] = (inverse) % 2;
                break;
            
            default:
                break;
        }
        return returns;
    }
}