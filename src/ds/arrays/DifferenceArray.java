package ds.arrays;

/*
    D[0] = a[0]
    D[i] = a[i] - a[i-1] ---> gives difference array

    to construct original array back,

    a[0] = D[0]
    a[i] = D[i] + a[i-1]

    original array, a
*/
public class DifferenceArray {
    public static void main(String []args) {

        int a[] = { 10, 5, 20, 40, 50, 100 };


        updateArray(a,0,4, 10);
        updateArray(a,2,3, 5);

        // updateArray(a,4,5, 20);


        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }

        System.out.println("");


        int A[] = { 10, 5, 20, 40, 50, 100 };

        int D[] = new int[A.length+1];


        /* initialize difference array */

        D[0]=A[0];
        D[A.length] = 0;
        for(int i=1; i<A.length; i++) {
            D[i] = A[i] - A[i-1];
        }

        /* */

        updateWithDifferenceArray(D,0,4, 10);
        updateWithDifferenceArray(D,2,3, 5);


        A[0]=D[0];
        System.out.print(A[0]+" ");
        for(int i=1; i< A.length; i++) {
            A[i] = D[i] + A[i-1];
            System.out.print(A[i]+" ");
        }

        System.out.println("");

        /* Array with empty values */

        int[] Z = new int[6];
        int[] ZDiffArray = new int[7];


        updateWithDifferenceArray(ZDiffArray,0,4, 10);
        updateWithDifferenceArray(ZDiffArray,2,3, 5);

        Z[0] = ZDiffArray[0];
        System.out.print(Z[0]+" ");

        for(int i=1; i<Z.length; i++) {
            Z[i] = ZDiffArray[i] + Z[i-1];
            System.out.print(Z[i]+" ");
        }
    }

    private static void updateWithDifferenceArray(int[] D, int startIndex, int endIndex, int valueToAdd) {

        D[startIndex]+=valueToAdd;
        D[endIndex+1]-=valueToAdd;
    }

    private static void updateArray(int[] a,int startIndex, int endIndex, int valueToAdd) {

        for(int i=startIndex; i<=endIndex; i++) { // --> o(n)
            a[i]+=valueToAdd;
        }
    }
}
