package classes;

/**
 * Created by ABoK4Do on 14.03.17.
 */
public class test {
    public static void main(String[] args) {
        /*
        System.out.println("Test1:");
        ArrayList<ResultPOJO> list = searchByName("Piz");
        for (ResultPOJO s : list){
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getCat_name());
            System.out.println(s.getPrice());
        }*/
        String[] testArray = new String[4];
        testArray[0] = "0";
        testArray[1] = "1";
        testArray[2] = "2";
        testArray[3] = "3";
        String str = "(";
        str+=testArray[0]+","+testArray[1]+","+testArray[2]+","+testArray[3]+")";
        System.out.println(str);

    }


}
