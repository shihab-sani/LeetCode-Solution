class Baseball_Game {
    public int calPoints(String[] operations) {

        int[] arr = new int[operations.length];
        int size = 0;
        for (String op : operations){
            if (op.equals("C")){
                size--;
            }
            else if (op.equals("D")){
                arr[size] = arr[size-1]*2;
                size++;
            }
            else if (op.equals("+")){
                arr[size] = arr[size-1] + arr[size-2];
                size++;
            }
            else{
                arr[size] = Integer.parseInt(op);
                size++;
            }
        }
        int count = 0;
        for (int j = 0; j<size; j++){
            count += arr[j];
        }
        return count;
    }
}