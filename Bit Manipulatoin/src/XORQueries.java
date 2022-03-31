
public class XORQueries {

	public int[] xorQueries(int[] arr, int[][] queries) 
    {
        int[] prefixArray = new int[arr.length];
        prefixArray[0] = arr[0];
        
        for(int i=1; i<arr.length; i++)
        {
            prefixArray[i] = prefixArray[i-1] ^ arr[i];
        }
        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++)
        {
            if(queries[i][0]==0)
                res[i]=prefixArray[queries[i][1]];
            else
                res[i]=prefixArray[queries[i][0]-1]^prefixArray[queries[i][1]];
        }
        return res;
    }
}
