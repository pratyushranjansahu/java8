package parallelstream;

public class Sum {

    int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int performSum(int input){
        total += input;
        return total;
    }


}
