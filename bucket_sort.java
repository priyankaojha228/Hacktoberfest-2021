public class bucket_sort {
  public static void main(String[] args) {
    int[] intArr = {47, 85, 10, 45, 16, 34, 67, 80, 34, 4, 0, 99};
    System.out.println("Original array: " + Arrays.toString(intArr));
    bucketSort(intArr, 10);
    System.out.println("Sorted array after bucket sort: " + Arrays.toString(intArr));
  }
    
  private static void bucketSort(int[] intArr, int noOfBuckets){
    // Create bucket array
    List<Integer>[] buckets = new List[noOfBuckets];
    // Associate a list with each index in the array       
    for(int i = 0; i < noOfBuckets; i++){
      buckets[i] = new LinkedList<>();
    }
    // Assign numbers from array to the proper bucket by using hashing function
    for(int num : intArr){
      buckets[hash(num)].add(num);
    }
    // sort buckets
    for(List<Integer> bucket : buckets){
      Collections.sort(bucket);
    }
    int i = 0;
    // Merge buckets to get sorted array
    for(List<Integer> bucket : buckets){
      for(int num : bucket){
        intArr[i++] = num;
      }
    }
  }
    
  // Hash function
  private static int hash(int num){
    return num/10;
  }
}