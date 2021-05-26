package FirstPackage;

public class Utils {
    public static String getFileExtension(String fileName){
        int indexOfDot = fileName.lastIndexOf('.');
        if (indexOfDot == -1)
            return null;
        if (indexOfDot == fileName.length()-1)
            return null;
        return fileName.substring(indexOfDot+1,fileName.length());
    }
}
