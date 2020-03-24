package multiplication;

/*
 Need to revisit, doesn't work for all inputs
 */
public class Karatsuba_multiplication {

    public static void main(String[] args) {

        int x = 1234;
        int y = 5678;

        int product = karasuba(x, y);


        System.out.println("product via karasuba:"+ product);
        System.out.println("product via * operator:"+ x*y);
    }

     private static int karasuba(int x, int y) {

        System.out.println("numbers:"+ x +" "+y);
        if( x < 10 || y < 10)
            return x * y;

        int len_x = (int)(Math.log10(x)+1); // calculate length

        int len_y = (int)(Math.log10(y)+1);

        double min_len = (double) Math.min(len_x, len_y);

        System.out.println("length:"+ len_x +" "+len_y);

        System.out.println("min length: "+ min_len);

        int split_at = (int) Math.ceil(min_len/2);

        System.out.println("split at: "+split_at);

        int divisor = (int) Math.ceil(Math.pow(10, split_at));

        int a = x / divisor;
        int b = x % divisor;
        int c = y / divisor;
        int d = y % divisor;


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        System.out.println("recursion--------------");
        int ac = karasuba(a, c);
        System.out.println("ac: "+ac);
        int bd = karasuba(b, d);
         System.out.println("bd: "+bd);

        int intermediate_step = karasuba((a+b),(c+d)); // ac + ad + bc + bd
         System.out.println("intermediate_step: "+intermediate_step);

         /*
         *  intermediate step avoids one more recusive call
         *  ac, ad, bc, bd - 4 recursive calls
         *
         *  with intermediate step - only 3 recursive calls
         *
         *  ac , (a+b)(c+d), bd
         *
         * */

        int ad_plus_bc = intermediate_step - bd - ac; // gives ad + bc
         System.out.println("ad_plus_bc: "+ad_plus_bc);

        int n = (int) min_len;
        System.out.println("n value: "+ n);
        int n_divide_by_2 = n/2;

        int results = (int) (Math.pow(10, n) * ac + Math.pow(10, n_divide_by_2) * ad_plus_bc + bd);
        //int results = (10 ^ (n*n) * ac + 10 ^ (n/2) * ad_plus_bc + bd);
        System.out.println("FINAL RESULTS: "+results);

        return results;
    }
}
