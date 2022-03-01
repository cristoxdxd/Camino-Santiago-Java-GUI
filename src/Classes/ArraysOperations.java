package Classes;

import java.util.*;

/**
 *
 * @author Cristopher Herrera
 */
public class ArraysOperations {
    public void printArray(int[] intArray){
        for(int value : intArray){
            System.out.printf("%d ",value);
        }
        System.out.println();
    }
    
    public void printArray(double[] doubleArray){
        for(double value : doubleArray){
            System.out.printf("%f ",value);
        }
        System.out.println();
    }
    
    public void printArray(String[] strArray){
        for(String str : strArray){
            System.out.printf("%s ",str);
        }
        System.out.print("|");
        System.out.println();
    }
    
    public void fillArrayConstant(int[] intArray, int value){
        Arrays.fill(intArray, value);
    }
    
    public void copyArray(int[] intArray, int[] intArraycopy){
        System.arraycopy(intArray, 0, intArraycopy, 0, intArray.length);
    }
    
    public int searchAnInt(int[] intArray, int search){
        return Arrays.binarySearch(intArray, search);
    }
    
    public void ArraysEquality(int[] intArray1, int[] intArray2){
        boolean equality = Arrays.equals(intArray1, intArray2);
        System.out.printf("Array 1 %s Array 2\n",
                (equality ? "is equal to" : "is different from"));
    }
    
    public ArrayList<String> ArraytoArrayList(String array[]){
        ArrayList<String> list  = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        return list;
    }
    
    public void printArrayList(Collection<String> collection){
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
    public void removeRepeatedStringAtList(Collection<String> collection1,Collection<String> collection2){
        Iterator<String> iterator = collection1.iterator();
        while(iterator.hasNext()){
            if(collection2.contains(iterator.next())){
                iterator.remove();
            }
        }
    }
}
