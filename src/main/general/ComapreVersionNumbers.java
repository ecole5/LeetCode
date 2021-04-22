package general;

/*

4:15



 */

public class ComapreVersionNumbers {
    public int compareVersion(String version1, String version2) {


        //Split up
        String [] revision1, revision2;
        revision1 = version1.split("\\.");
        revision2 = version2.split("\\.");

        int i = 0;
        while (i < Math.max(revision1.length,revision2.length)){


            //* note how it removes trailing zeros for us *//

            int r1T = i < revision1.length ? Integer.parseInt(revision1[i]) : 0;
            int r2T = i < revision2.length ? Integer.parseInt(revision2[i]) : 0;

            if (r1T - r2T != 0){
                return r1T > r2T ? 1 : -1;
            }

            i++;
        }

        return 0; //default case equal

    }





}
