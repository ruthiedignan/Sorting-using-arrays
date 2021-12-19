
/**
 * This is the tester class for the Items class.
 *
 * @author Ruthie Dignan
 * @version 4/19/21
 */
public class Tester
{
    public static void main(String[] args)
    {
        Items[] item = new Items[10];
        
        item[0] = new Items("Apples", 2003, 2.99, 4);
        item[1] = new Items("Coffee", 2009, 3.99, 2);
        item[2] = new Items("Laundry Detergent", 2060, 5.99, 9);
        item[3] = new Items("Ointment", 2300, 12.99, 6);
        item[4] = new Items("Desk", 2041, 29.99, 1);
        item[5] = new Items("Puzzle", 2800, 1.99, 10);
        item[6] = new Items("Sweatshirt", 2031, 15.99, 3);
        item[7] = new Items("Blanket", 2010, 8.99, 5);
        item[8] = new Items("Movies", 2021, 11.99, 11);
        item[9] = new Items("Books", 2024, 13.99, 12);
        
        //precedence
        System.out.println("    <<<< Before Sorting >>>> \n");
        for(int i = 0; i < item.length; i++)
            System.out.println( item[i] );
            
        //merge sort product number
        mergeSortNum(item, 0, item.length-1);
        System.out.println();
        System.out.println("\n     <<<< After Sorting >>>>");
        System.out.println("<<<< by product number in ascending order >>>>\n");
        for(int i = 0; i < item.length; i++)
            System.out.println(item[i] );
            
        //insertion sort product name
        item = insertionName(item);
        System.out.println();
        System.out.println("<<<< by product name in ASCENDING order >>>>\n");
        for(int i = 0; i < item.length; i++)
            System.out.println(item[i] ); 
        item = insertionTitle2(item);
        System.out.println();
        System.out.println("<<<< by product name in DESCENDING order >>>>\n");
        for(int i = 0; i < item.length; i++)
            System.out.println(item[i] );  
            
        //selection sort price
        selectionSortPrice1(item);
        System.out.println("\n     <<<< After Sorting >>>>");
        System.out.println("<<<< by price in ASCENDING order - passing two arrays >>>>\n");  
        for(int i = 0; i < item.length; i++)
            System.out.println(item[i] );
        
        selectionSortPrice2(item);
        System.out.println();
        System.out.println("<<<< by price in DESCENDING order - passing two arrays >>>>\n");  
        for(int i = 0; i < item.length; i++)
            System.out.println(item[i] ); 
            
        //merge sort by quantity
        mergeSortQuantity(item, 0, item.length-1);
        System.out.println();
        System.out.println("\n     <<<< After Sorting >>>>");
        System.out.println("<<<< by quantity in ascending order >>>>\n");
        for(int i = 0; i < item.length; i++)
            System.out.println(item[i] );
    }
    
    public static void mergeSortNum(Items[] a, int low, int high)
    {
        if( low == high )
            return;

        int mid = ( low + high ) / 2;

        mergeSortNum( a, low, mid );       
        mergeSortNum( a, mid + 1, high);  
     
        mergeNum( a, low, mid, high);
    }
    
    public static void mergeNum(Items[] a, int low, int mid, int high)
    {
        Items[] temp = new Items[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while( i <= mid || j <= high )
        {
            if( i > mid )
            {
                temp[ n ] = a[ j ];
                j++;
            }
            else if( j > high )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else if( a[ i ].getProductNum() < a[ j ].getProductNum() )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else
            {
                temp[ n ] = a[ j ];
                j++;
            }
            n++;
        }

        for( int k = low ; k <= high ; k++ )
            a[ k ] = temp[ k - low ];
    }
    
    public static Items[] insertionName(Items[] source)
    {
        Items[] dest = new Items[ source.length ];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Items next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if( next.getItem().compareTo( dest[k-1].getItem() ) > 0 )
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
            
            
            System.out.println("\nPass # " + i);
            for(Items h : dest)  
                if( h != null) System.out.printf("%-15s \n", h.getItem() );
        } 
        return dest;
    }
    
    public static Items[] insertionTitle2(Items[] source)
    {
        Items[] dest = new Items[ source.length ];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Items next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if( next.getItem().compareTo( dest[k-1].getItem() ) < 0 )
                {
                    insertIndex = k;
                }
                else
                {
                    dest[ k ] = dest[ k - 1 ];
                }
                k--;
            }

            dest[ insertIndex ] = next;
            
            
            System.out.println("\nPass # " + i);
            for(Items h : dest)  
                if( h != null) System.out.printf("%-15s \n", h.getItem() );
        } 
        return dest;
    }
    
    public static void selectionSortPrice1(Items[] source)
    {
        int i;
        int k;
        int posMax;
        Items temp;

        for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            
            posMax = 0;
            for ( k = 0 ; k <= i ; k++ )
            {
                if ( source[ k ].getPrice() > source[ posMax ].getPrice() )
                    posMax = k;
            }
            
            temp = source[ i ];
            source[ i ] = source[posMax ];
            source[ posMax ] = temp;
            
            
            System.out.println("\nPass # " + i);
            for(Items m : source)  
                if( m != null) System.out.printf("$%10.2f \n", m.getPrice() );
        }
    }
    
    public static void selectionSortPrice2(Items[] source)
    {
        int i;
        int k;
        int posMax;
        Items temp;

        for ( i = source.length - 1 ; i >= 0 ; i-- )
        {
            
            posMax = 0;
            for ( k = 0 ; k <= i ; k++ )
            {
                if ( source[ k ].getPrice() < source[ posMax ].getPrice() )
                    posMax = k;
            }
            
            temp = source[ i ];
            source[ i ] = source[posMax ];
            source[ posMax ] = temp;
            
            
            System.out.println("\nPass # " + i);
            for(Items m : source)  
                if( m != null) System.out.printf("%10.2f \n", m.getPrice() );
        }
    }
    
    
    public static void mergeSortQuantity(Items[] a, int low, int high)
    {
        if( low == high )
            return;

        int mid = ( low + high ) / 2;

        mergeSortQuantity( a, low, mid );       
        mergeSortQuantity( a, mid + 1, high);  
     
        mergeQuantity( a, low, mid, high);
    }
    
    public static void mergeQuantity(Items[] a, int low, int mid, int high)
    {
        Items[] temp = new Items[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while( i <= mid || j <= high )
        {
            if( i > mid )
            {
                temp[ n ] = a[ j ];
                j++;
            }
            else if( j > high )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else if( a[ i ].getQuantity() < a[ j ].getQuantity() )
            {
                temp[ n ] = a[ i ];
                i++;
            }
            else
            {
                temp[ n ] = a[ j ];
                j++;
            }
            n++;
        }

        for( int k = low ; k <= high ; k++ )
            a[ k ] = temp[ k - low ];
    }
}
