import java.util.Scanner;
import java.util.ArrayList;

class Main{

  private static String[] votesArr;

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int numVotes = input.nextInt();
    votesArr = new String[numVotes];
    Main mergesort = new Main();
    for(int i = 0; i < numVotes; i++){
      votesArr[i] = input.next();
    }
    //mergesort.sort(votesArr);
    sort();

    //System.out.println("     Sorted:");
    //for(int i = 0; i < votesArr.length; i++)
        //System.out.println(votesArr[i]);

    ArrayList<Integer> countVotes = new ArrayList<>();
    ArrayList<String> votedFor = new ArrayList<>();
    int counter = 0;
    ArrayList<String> winners = new ArrayList<>();
    int max = 0;
    int candidCount = 0;

    for(int i = 0; i < votesArr.length-1; i++){
      if(!(votesArr[i].equals(votesArr[i+1]))){
        if(counter+1 > max){
          winners.clear();
          max = counter+1;
          winners.add(votesArr[i]);
          //countVotes.add(counter+1);
        }
        else if(counter+1 == max){
          max = counter+1;
          winners.add(votesArr[i]);
          //countVotes.add(counter+1);
        }
        countVotes.add(counter+1);
        counter = 0;
      }
      else
        counter++;
      candidCount++;
      //System.out.println(max);
    }
    if(counter+1 > max){
      winners.clear();
      max = counter+1;
      winners.add(votesArr[candidCount]);
      countVotes.add(counter+1);
    }
    else if(counter+1 == max){
      max = counter+1;
      winners.add(votesArr[candidCount]);
      countVotes.add(counter+1);
    }
    countVotes.add(counter+1);

    //countVotes.add(counter+1);
    votedFor.add(votesArr[votesArr.length-1]);

    //System.out.println();
    //System.out.println("Winner:");
    for(int i = 0; i < winners.size(); i++){
      System.out.println(winners.get(i));
      //System.out.println(countVotes);
    }

  }

  public static void sort(){
    int left = 0;
    int right = votesArr.length-1;
    quickSort(left,right);
  }

  public static void quickSort(int left, int right){
    if(left >= right) return;
    String pivot = getMedian(left, right);
    int partition = partition(left, right, pivot);

    quickSort(0, partition-1);
    quickSort(partition+1, right);
  }

  private static int partition(int left, int right, String pivot){
    int leftCur = left-1;
    int rightCur = right;
    while(leftCur < rightCur){
      while(((Comparable<String>)votesArr[++leftCur]).compareTo(pivot) < 0);
      while(rightCur > 0 && ((Comparable<String>)votesArr[--rightCur]).compareTo(pivot) > 0);
        if(leftCur >= rightCur)
          break;
        else
          swap(leftCur, rightCur);
    }
    swap(leftCur, right);
    return leftCur;
  }

  public static String getMedian(int left, int right){
    int center = (left+right)/2;

    if(((Comparable<String>)votesArr[left]).compareTo(votesArr[center]) > 0)
      swap(left,center);

    if(((Comparable<String>)votesArr[left]).compareTo(votesArr[right]) > 0)
      swap(left,right);

    if(((Comparable<String>)votesArr[center]).compareTo(votesArr[right]) > 0)
      swap(center,right);

    swap(center, right);
    return votesArr[right];
  }

  public static void swap(int left, int right){
    String temp = votesArr[left];
    votesArr[left] = votesArr[right];
    votesArr[right] = temp;
  }

/*
  public void sort(String inputArr[]){
    this.array = inputArr;
    this.length = inputArr.length;
    this.temp = new String[length];
    doMergeSort(0, length - 1);

  }

  private void doMergeSort(int lowerIndex, int higherIndex){
    if(lowerIndex < higherIndex){
      int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
      doMergeSort(lowerIndex, middle);
      doMergeSort(middle+1, higherIndex);
      merge(lowerIndex, middle,higherIndex);
    }
  }

  private void merge(int lowerIndex, int middle, int higherIndex) {
    for(int i = lowerIndex; i <= higherIndex; i++){
      temp[i] = array[i];
    }
    int i = lowerIndex;
    int j = middle + 1;
    int k = lowerIndex;
    while(i <= middle && j <= higherIndex){
      boolean ifRun = false;
      if(temp[i].equals(temp[j])){
        array[k] = temp[i];
        i++;
      }
      else{
        for(int x = 0; x < temp[i].length() && x < temp[j].length(); x++){
          if(temp[i].charAt(x) < temp[j].charAt(x)){
            array[k] = temp[i];
            i++;
            ifRun = true;
            break;
          }
        }
        if(!ifRun){
          array[k] = temp[j];
          j++;
        }
      }
      k++;

    }
    while (i<=middle){
      array[k] = temp[i];
      k++;
      i++;
    }

    //System.out.println("Hey");
    for(int cat = 0; cat < array.length; cat++){
      //System.out.println(array[cat]);
    }

  }
  */
}
