public class ComplexParser {

    public Double[] ComplexSplit(String str){
        Double[] realImgPart = new Double[2];
        boolean firstPositive = true;
        boolean secondPositive = true;
        if (str.charAt(0) == '-')     // See if first expr is negative
            firstPositive = false;
        if (str.substring(1).contains("-"))
            secondPositive = false;
        String[] split = str.split("[+-]");
        if (split[0].equals("")) {  // Handle expr beginning with `-`
            split[0] = split[1];
            split[1] = split[2];
        }
        double realPart = 0;
        double imgPart = 0;
        if (split[0].contains("i")) // Assumes input is not empty
            imgPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0].substring(0,split[0].length() - 1));
        else
            realPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0]);
        if (split.length > 1) {     // Parse second part of expr if it exists
            if (split[1].contains("i"))
                imgPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1].substring(0,split[1].length() - 1));
            else
                realPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1]);
        }
// Use realPart and imgPart ...
        realImgPart[0] = realPart;
        realImgPart[1] = imgPart;
        //System.out.println(realPart + (imgPart < 0 ? "" : "+") + imgPart + "i");
        return realImgPart;
    }
}


