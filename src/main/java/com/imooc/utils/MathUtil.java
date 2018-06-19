<<<<<<< HEAD
package com.imooc.utils;


public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 比较2个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        }else {
            return false;
        }
    }
}
=======
package com.imooc.utils;

public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2){
        Double resule = Math.abs(d1 - d2);
        if(resule < MONEY_RANGE){
            return true;
        }else {
            return false;
        }
    }
}
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
