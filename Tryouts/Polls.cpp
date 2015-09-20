import java.util.Scanner;

public class Main{

  public String[] array;
  public String[] temp;
  public int length;

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int numVotes = input.nextInt();
    String[] votesArr = new String[numVotes];
    for(int i = 0; i < numVotes; i++){
      votesArr[i] = input.next();
    }
    sort(votesArr);

    
  }

  public void sort(String inputArr[]){
    array = inputArr;
    length = inputArr.length();
    tempMergArr = new String[length];
    doMergeSort(0, length - 1);
  }

  public void doMergeSort(int lowerIndex, int higherIndex){
    if(lowerIndex < higherIndex){
      int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
      doMergeSort(lowerIndex, middle);
      doMergeSort(middle+1, higherIndex);
      merge(lowerIndex, middle,higherIndex);
    }
  }

  public void merge(int lowerIndex, int middle, int higherIndex) {
    for(int i = lowerIndex; i <= higherIndex; i++){
      temp[i] = array[i];
    }
    int i = lowerIndex;
    int j = middle + 1;
    int k = lowerIndex;
    while(i <= middle && j <= higherIndex){
      boolean ifRun = false;
      for(int x = 0; x < temp[i].length() || x < temp[j].length(); x++){
        if(temp[i].charAt(x) < temp[j].charAt(x)){
          array[k] = temp[i];
          i++;
          ifRun = true;
          break;
        }
      }
      if(!ifRun && (temp[i].charAt(temp[i].length() - 1) == temp[j].charAt(temp[j].length() - 1))){
        array[k] = temp[i];
        i++;
      }
      else{
        array[k] = temp[j];
        j++;
      }
      k++;
    }
    while (i<=middle){
      array[k] = temp[i];
      k++;
      i++;
    }

  }
}
