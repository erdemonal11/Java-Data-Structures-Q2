package comp2112_project1_q2;

public class StackArray {

    String data[]; // array to hold items
    int top; // the top most item index

    public StackArray(int N) {
        data = new String[N];
        top = -1;
    }

    public void push(String element) {
        if (!isFull()) {
            top++;
            data[top] = element;
        }
    }

    public String pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        } else {
            top--;
            return data[top + 1];
        }
    }

    public boolean isFull() {
        if (top == data.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top == - 1) {
            return true;
        }
        return false;
    }
    
    public void resize(){
        String[] temp;
        if(this.data.length==top+1){
            temp= new String[data.length*2];
            for(int i=0;i<this.data.length;i++){
                temp[i]=this.data[i];
            }
            
            this.data=temp;
        }
        
        
    }

    public String toString() {
        String str = "";
        for (int i = 0; i <= top; i++) {
            str += data[i] + " ";

        }
        return str;
    }

    public boolean deleteMiddle() {
        if (top % 2 != 0) {
            
            return false;
        } else {

            int middleIndex = (top / 2);
            String[] temp = new String[top / 2];
            int count = 0;
            while (top != middleIndex) {
                
                temp[count] = (pop());
                count++;

            }
            
            top--;

            
            for (int i = temp.length - 1; i >= 0; i--) {
                push(temp[i]);
            }

        }
        return true;

    }

    public boolean isPalindrome() {
        int temptop=top;
        int middleIndex = top / 2;
        String tempMiddleElement=null;
        String[] temp = new String[top - middleIndex];

        if (top % 2 == 0) {
            for (int i = 0; i < middleIndex; i++) {
                temp[i] = this.pop();

            }
            tempMiddleElement = this.pop(); // if the size of array is odd then there's one middle element on the list
        } 
        else {
            for (int k = 0; k < middleIndex+1; k++) {
                temp[k] = this.pop();
            }
        }
        boolean b =false;
        for(int j=0;j<temp.length;j++){
            if(this.data[j].equals(temp[j])){
                b=true;
            }
        }
            if(tempMiddleElement==null){
                for(int a=temp.length;a>0;a--){
                    this.push(temp[a-1]);
                }
                
                
            }
            else{
                this.push(tempMiddleElement);
                for(int a=temp.length;a>0;a--){
                    this.push(temp[a-1]);
                }
            }
        
        return b;

    }
    
    
}
