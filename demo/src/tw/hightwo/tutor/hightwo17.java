package tw.hightwo.tutor;

import java.util.HashMap;
import java.util.Map;
import tw.hightwo.js.TWId;

public class hightwo17 {

    // 定義一個靜態的 Map 存儲區域字符和名稱的映射
    private static final Map<Character, String> areaMap = new HashMap<>();

    static {
        // 靜態初始化塊，初始化區域映射
        areaMap.put('A', "台北市");
        areaMap.put('B', "台中市");
        areaMap.put('C', "基隆市");
        areaMap.put('D', "台南市");
        areaMap.put('E', "高雄市");
        areaMap.put('F', "新北市");
        areaMap.put('G', "宜蘭縣");
        areaMap.put('H', "桃園市");
        areaMap.put('J', "新竹縣");
        areaMap.put('K', "苗栗縣");
        areaMap.put('L', "台中縣");
        areaMap.put('M', "南投縣");
        areaMap.put('P', "雲林縣");
        areaMap.put('Q', "嘉義縣");
        areaMap.put('R', "台南縣");
        areaMap.put('S', "高雄縣");
        areaMap.put('T', "屏東縣");
        areaMap.put('U', "花蓮縣");
        areaMap.put('V', "台東縣");
        areaMap.put('X', "澎湖縣");
        areaMap.put('Y', "陽明山");
        areaMap.put('W', "金門縣");
        areaMap.put('Z', "連江縣");
        areaMap.put('I', "嘉義市");
        areaMap.put('O', "新竹市");
    }

    // 根據身分證號碼輸出區域名稱
    public static void printArea(TWId id) {
        String areaName = areaMap.get(id.whichArea());
        if (areaName != null) {
            System.out.println(areaName);
        } else {
            System.out.println("未知地區");
        }
    }

    public static void main(String[] args) {
        TWId id1 = new TWId();
//        TWId id2 = new TWId(false);
//        TWId id3 = new TWId('B');
//        TWId id4 = new TWId(true, 'Y');
//        TWId id5 = TWId.newTWId("P123837722");

        System.out.println(id1.getId());
//        System.out.println(id2.getId());
//        System.out.println(id3.getId());
//        System.out.println(id4.getId());
//        System.out.println(id5.getId());
//        System.out.println(id5.isMale());

        // 調用 printArea 方法展示區域名稱
//        printArea(id1); // 假設 id1.whichArea() 返回的字符存在於 areaMap 中
//        printArea(id3); // 例如，這裡會輸出 "台中市"
//        printArea(id5); // 依賴於 id5 的 whichArea() 返回值
    }
}