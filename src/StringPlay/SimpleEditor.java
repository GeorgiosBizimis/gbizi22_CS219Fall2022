package StringPlay;

import java.lang.*;
import java.io.*;

public final class SimpleEditor
{
    public static void main (String[] args) throws java.lang.Exception
    {
        final StringBuilder sb = new StringBuilder();
        final StringBuilder outputStringBuilder = new StringBuilder();

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int queries = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < queries; i++){
            final String[] query = bufferedReader.readLine().split(" ");

            if(query[0].equals("+")) {
                final int start = Integer.parseInt(query[1]);
                sb.insert(start, query[2]);
            } else if(query[0].equals("?")){
                final int start = Integer.parseInt(query[1]) - 1;
                final int end = Integer.parseInt(query[2]) - 1;

                outputStringBuilder.append(sb.substring(start, start + end + 1)).append('\n');
                System.out.println("String is:" + outputStringBuilder);
            } else {
                throw new Exception("Error: Invalid Operation.");
            }
        }
    }
}